package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LessorDao;
import vo.LessorVo;
import vo.ManagerVo;
import dao.ManagerDao;

@WebServlet("/lessorList.do")
public class LessorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
		  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String buildingname = (String)session.getAttribute("buildname");
//		String loguser = (String)session.getAttribute("loguser");
		int classnum = (int)session.getAttribute("classnum");
		String name = (String)session.getAttribute("name");
		
//		System.out.println("로그인 유저: "+loguser);
		System.out.println("건물 이름: "+buildingname);
		System.out.println("분류 번호: " + classnum);
		System.out.println("관리자 이름: " + name);
		System.out.println();
		
		
		LessorDao lDao = LessorDao.getInstance();
		
		List<LessorVo> lessorList = lDao.selectAllLessors(buildingname, classnum);
		request.setAttribute("lessorList", lessorList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("lessor/lessorList.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
