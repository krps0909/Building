package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.LessorDao;
import vo.LessorVo;

@WebServlet("/lessorWrite.do")
public class LessorWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LessorWriteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("lessor/lessorWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		String buildingname = (String)session.getAttribute("buildname");
		String name = (String)session.getAttribute("name");
		int classnum = (int)session.getAttribute("classnum");

		
		
		int roomnum = Integer.parseInt(request.getParameter("roomnum"));
		String lessor = request.getParameter("lessor");
		int rent = Integer.parseInt(request.getParameter("rent"));
		String leasedate = request.getParameter("leasedate");
		String expiration = request.getParameter("expiration");
		String payment = request.getParameter("payment");
		
//		System.out.println(classnum + buildingname + roomnum + lessor + rent +leasedate +expiration +name+payment );

		
		LessorVo lVo = new LessorVo();
		lVo.setClassnum(classnum);
		lVo.setBuildingname(buildingname);
		lVo.setRoomnum(roomnum);
		lVo.setLessor(lessor);
		lVo.setRent(rent);
		lVo.setLeasedate(leasedate);
		lVo.setExpiration(expiration);
		lVo.setManager(name);
		lVo.setPayment(payment);
		
		LessorDao lDao = LessorDao.getInstance();
		lDao.insertLessor(lVo, buildingname);
		
		response.sendRedirect("/lessorList.do");
		
	}

}
