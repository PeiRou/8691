package _04_Member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;
import _04_Member.model.MemberDAOjdbc;


@WebServlet("/MemberServlet")

public class MemberServlet extends HttpServlet {	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	String accountUID = (String) session.getAttribute("LoginOK");
	String RoleID = (String) session.getAttribute("RoleID");
	session.setAttribute("LoginOK", accountUID);
	System.out.println("accountUID: "+accountUID);
	System.out.println("RoleID: "+RoleID);
	
	
	
	
	if(RoleID.equals("201")){
		request.getRequestDispatcher(
				"/_04_Members/Members.jsp").forward(request, response);
		}else if(RoleID.equals("102")){
			request.getRequestDispatcher(
				"/_04_Members/SellerMembers.jsp").forward(request, response);	
		}	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
