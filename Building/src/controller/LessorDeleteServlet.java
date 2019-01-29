package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LessorDao;
import vo.LessorVo;

@WebServlet("/lessorDelete.do")
public class LessorDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LessorDeleteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cl = request.getParameter("lessor");
		int classnum = Integer.parseInt(cl);

		LessorDao lDao = LessorDao.getInstance();
		LessorVo lVo = lDao.selectLessorByclassnum(classnum);

		request.setAttribute("lessor", lVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("lessor/lessorDelete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int classnum = Integer.parseInt(request.getParameter("classnum"));
		
		LessorDao lDao = LessorDao.getInstance();
		lDao.deleteLessor(classnum);
		
		response.sendRedirect("/lessorList.do");

	}

}
