package dao;  //DAO= Data Access Object =DB를 사용해 데이터를 조작하거나 조회하는 기능을 전담하도록 만든 오브젝트

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.DBManager;
import vo.ManagerVo;

public class ManagerDao {

	private ManagerDao() {

	}

	private static ManagerDao instance = new ManagerDao();

	public static ManagerDao getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}

	// 입력된 정보로 회원 가입을 인서트 하는 부분
	public int insertMember(ManagerVo mVo) {

//		System.out.println("================ 인서트 dao 도착 ================");

		Connection conn = null;
		Statement stmt = null;

		int result = -1;

		try {

			conn = getConnection();

			System.out.println("===== db 연결 성공 =====");
			System.out.println(mVo.getManagerid());
			System.out.println(mVo.getPassword());
			System.out.println(mVo.getName());
			System.out.println(mVo.getBirthdate());
			System.out.println(mVo.getBuildingname());

			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					"insert into managertbl (classnum, managerid, password, managername, birthdate, buildingname) values(buildseq.nextval, '"
							+ mVo.getManagerid() + "','" + mVo.getPassword() + "','" + mVo.getName() + "','"
							+ mVo.getBirthdate() + "','" + mVo.getBuildingname() + "')");

			if (result == 1) {
				System.out.println("======= 회원 가입 성공 ========");
				result = 1;
			} else {
				System.out.println("======= 회원 가입 실패 ========");
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 입력된 정보로 로그인 하는 부분
	public int userCheck(String managerid, String password) {

//		System.out.println("================ userCheck dao 도착 ================");

		Connection conn = null;
		Statement stmt = null;

		int result = -1;

		try {

			conn = getConnection();

			System.out.println("===== db 연결 성공 =====");
//			System.out.println(managerid);
//			System.out.println(password);

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select MANAGERID, PASSWORD from managertbl where MANAGERID = '"
					+ managerid + "' and PASSWORD = '" + password + "'");

			if (rs.next()) {
				if (rs.getString("managerid") != null && rs.getString("password") != null) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				System.out.println("======= 회원 로그인 실패 ========");
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 아이디 중복 체크하는 부분
	public int confirmId(String managerid) {
		int result = -1;
		String sql = "select managerid from managertbl where managerid= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ManagerVo getManager(String managerid) {
		ManagerVo mVo = null;
		String sql = "select CLASSNUM, MANAGERID, PASSWORD, MANAGERNAME, BIRTHDATE, BUILDINGNAME from managertbl where managerid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new ManagerVo();
				mVo.setClassnum(rs.getInt("classnum"));
				mVo.setManagerid(rs.getString("managerid"));
				mVo.setPassword(rs.getString("password"));
				mVo.setName(rs.getString("managername"));
				mVo.setBirthdate(rs.getString("birthdate").substring(0, 10));
				mVo.setBuildingname(rs.getString("buildingname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}

	public void deleteManager(int classnum, String buildingname) { // 관리인과 그가 소유한 임대인들 모두 삭제하는 메소드

		String sql = "delete lessortbl where buildingname='" + buildingname + "'";
		String sql2 = "delete managertbl where classnum ='" + classnum + "'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			pstmt = null;
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
