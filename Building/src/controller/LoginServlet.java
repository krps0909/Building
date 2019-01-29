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

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("========= LoginServlet doget 도착 ===============");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("========= LoginServlet dopost 도착 ===============");

		request.setCharacterEncoding("UTF-8");

		String managerid = request.getParameter("managerid");
		String password = request.getParameter("password");

		System.out.println(managerid);

		ManagerDao mDao = ManagerDao.getInstance();

		int result = mDao.userCheck(managerid, password);

		if (result == 1) {
			ManagerVo mVo = mDao.getManager(managerid);

			HttpSession session = request.getSession();
			String loguser = mVo.getManagerid();
			String buildname = mVo.getBuildingname();
			int classnum = mVo.getClassnum();
			String name = mVo.getName();
			session.setAttribute("loginuser", mVo);
			session.setAttribute("loguser", loguser);
			session.setAttribute("name", name);
			session.setAttribute("buildname", buildname);
			session.setAttribute("classnum", classnum);

			request.setAttribute("message", "로그인에 성공 했습니다.");
			System.out.println("========= 로그인에 성공 햇습니다. ===============");

			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);

		} else if (result == 0 || result == -1) {
			request.setAttribute("message", "로그인에 실패했습니다.");
			System.out.println("========= 로그인에 실패 햇습니다. ===============");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}