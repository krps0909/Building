package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerDao;
import vo.ManagerVo;


@WebServlet("/managerDelete.do")
public class ManagerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerDeleteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String managerid = request.getParameter("userid");
		
		ManagerDao mDao = ManagerDao.getInstance();
		ManagerVo mVo = mDao.getManager(managerid);
		
		System.out.println(managerid);
		
		request.setAttribute("manager", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int classnum = Integer.parseInt(request.getParameter("classnum"));
		String buildingname = request.getParameter("buildingname");
		
		
		
		ManagerDao mDao = ManagerDao.getInstance();
		mDao.deleteManager(classnum, buildingname);
		response.sendRedirect("/login.do");
		
		
	
	}

}
