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

@WebServlet("/lessorUpdate.do")
public class LessorUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LessorUpdateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
//		System.out.println(request.getParameter("lessor"));
		String cl = request.getParameter("lessor");
		int classnum = Integer.parseInt(cl);

		
		
		LessorDao lDao = LessorDao.getInstance();
		LessorVo lVo = lDao.selectLessorByclassnum(classnum);
		
		request.setAttribute("lessor", lVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("lessor/lessorUpdate.jsp");
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int classnum = Integer.parseInt(request.getParameter("classnum"));
		int roomnum = Integer.parseInt(request.getParameter("roomnum"));
		String lessor = request.getParameter("lessor");
		int rent = Integer.parseInt(request.getParameter("rent"));
		String leasedate = request.getParameter("leasedate");
		String expiration = request.getParameter("expiration");
		String payment = request.getParameter("payment");
		
//		System.out.println(classnum+"이 출력되었다요오오오오오옹");
		
		LessorVo lVo = new LessorVo();
		lVo.setRoomnum(roomnum);
		lVo.setLessor(lessor);
		lVo.setRent(rent);
		lVo.setLeasedate(leasedate);
		lVo.setExpiration(expiration);
		lVo.setPayment(payment);
		
		LessorDao lDao = LessorDao.getInstance();
		lDao.updateLessor(lVo, classnum);
		
		response.sendRedirect("/lessorList.do");
	}

}
