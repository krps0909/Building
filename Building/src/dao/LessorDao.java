package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import util.DBManager;

import vo.LessorVo;
import vo.ManagerVo;

public class LessorDao { // 임대인 테이블 엑세스를 위한 클래스

	private LessorDao() {
	}

	private static LessorDao instance = new LessorDao();

	public static LessorDao getInstance() {
		return instance;
	}

	public List<LessorVo> selectAllLessors(String buildingname, int classnum) {
		String sql = "select * from lessortbl where buildingname = ?";
		List<LessorVo> list = new ArrayList<LessorVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buildingname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				LessorVo lVo = new LessorVo();
				lVo.setClassnum(rs.getInt("classnum"));
				lVo.setBuildingname(buildingname);
				lVo.setRoomnum(rs.getInt("roomnum"));
				lVo.setLessor(rs.getString("lessor"));
				lVo.setRent(rs.getInt("rent"));

				if (rs.getString("leasedate") == null) {
					lVo.setLeasedate(rs.getString("leasedate"));
				} else {
					lVo.setLeasedate(rs.getString("leasedate").substring(0, 10));
				}

				if (rs.getString("expiration") == null) {
					lVo.setExpiration(rs.getString("expiration"));
				} else {
					lVo.setExpiration(rs.getString("expiration").substring(0, 10));
				}

				lVo.setManager(rs.getString("manager"));
				lVo.setPayment(rs.getString("payment"));
				list.add(lVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public void insertLessor(LessorVo lVo, String buildingname) { // 임대인 등록 메소드

		String selsql = "select max(CLASSNUM)from lessortbl where buildingname='" + buildingname + "'";

		String sql = "insert into lessortbl values(?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int real = 0;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(selsql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int cnum = rs.getInt("max(CLASSNUM)");
				real = cnum; // 임대인 리스트안에 분류번호의 최댓값이 real;
			}
			pstmt = null;

			pstmt = conn.prepareStatement(sql);

			if (real == 0) {
				pstmt.setInt(1, lVo.getClassnum());
			} else {
				pstmt.setInt(1, real + 1);
			}
			pstmt.setString(2, lVo.getBuildingname());
			pstmt.setInt(3, lVo.getRoomnum());
			pstmt.setString(4, lVo.getLessor());
			pstmt.setInt(5, lVo.getRent());
			pstmt.setString(6, lVo.getLeasedate());
			pstmt.setString(7, lVo.getExpiration());
			pstmt.setString(8, lVo.getManager());
			pstmt.setString(9, lVo.getPayment());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}
	}

	public LessorVo selectLessorByclassnum(int classnum) { // 임대인 수정을 위해 임대인 정보를 읽어오는 메소드
		String sql = "select * from lessortbl where classnum=?";
		LessorVo lVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classnum);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					lVo = new LessorVo();
					lVo.setClassnum(rs.getInt("classnum"));
					lVo.setBuildingname(rs.getString("buildingname"));
					lVo.setRoomnum(rs.getInt("roomnum"));
					lVo.setLessor(rs.getString("lessor"));
					lVo.setRent(rs.getInt("rent"));
					lVo.setLeasedate(rs.getString("leasedate").substring(0, 10));
					lVo.setExpiration(rs.getString("expiration").substring(0, 10));
					lVo.setManager(rs.getString("manager"));
					lVo.setPayment(rs.getString("payment"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lVo;

	}

	public void updateLessor(LessorVo lVo, int classnum) { // 수정 입력된 정보를 업데이트 하는 메소드
		String sql = "update lessortbl set roomnum=?, lessor=?, rent=?, leasedate=?, expiration=?, payment=? where classnum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lVo.getRoomnum());
			pstmt.setString(2, lVo.getLessor());
			pstmt.setInt(3, lVo.getRent());
			pstmt.setString(4, lVo.getLeasedate());
			pstmt.setString(5, lVo.getExpiration());
			pstmt.setString(6, lVo.getPayment());
			pstmt.setInt(7, classnum);
			pstmt.executeQuery();

//			System.out.println(lVo.getLessor());
//			System.out.println(classnum);
//			System.out.println("실행완료하였슴");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteLessor(int classnum) { // 임대인들 삭제하는 메소드
		String sql = "delete lessortbl where classnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classnum);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
