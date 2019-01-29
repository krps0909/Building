package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDao;
import vo.ManagerVo;

//회원가입화면 중복체크 여부 확인하기 페이지 492페이지

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("잘 찾아왔습니다");

		request.setCharacterEncoding("UTF-8");
		String managerid = request.getParameter("managerid").trim();
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthdate");
		String buildingname = request.getParameter("buildingname");

		System.out.println(managerid + password + name + birthdate + buildingname);

		ManagerVo mVo = new ManagerVo();
		mVo.setManagerid(managerid);
		mVo.setPassword(password);
		mVo.setName(name);
		mVo.setBirthdate(birthdate);
		mVo.setBuildingname(buildingname);

		ManagerDao mDao = ManagerDao.getInstance();

		int result = mDao.insertMember(mVo);

		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("managerid", mVo.getManagerid());
			request.setAttribute("message", "회원 가입에 성공 했습니다.");
		} else {
			request.setAttribute("message", "회원 가입에 실패 했습니다.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

	}

}
