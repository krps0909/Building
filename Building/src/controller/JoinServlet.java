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

//ȸ������ȭ�� �ߺ�üũ ���� Ȯ���ϱ� ������ 492������

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
		System.out.println("�� ã�ƿԽ��ϴ�");

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
			request.setAttribute("message", "ȸ�� ���Կ� ���� �߽��ϴ�.");
		} else {
			request.setAttribute("message", "ȸ�� ���Կ� ���� �߽��ϴ�.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

	}

}
