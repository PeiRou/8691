package _04_Member.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _03_Orders.model.OrdersTotalBean;
import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;
import _04_Member.model.MemberDAOjdbc;
import _13_Maintenance.model.dao.MemberInfoDAOjdbc;

@WebServlet("/MemberServlet")

public class MemberServlet extends HttpServlet {	
	private MemberInfoDAOjdbc infodao = new MemberInfoDAOjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	String accountUID = (String) session.getAttribute("LoginOK");
	String RoleID = (String) session.getAttribute("RoleID");
	session.setAttribute("LoginOK", accountUID);
	System.out.println("accountUID: "+accountUID);
	System.out.println("RoleID: "+RoleID);
	
	List result = null;
	
	result = infodao.select(accountUID);
	
	System.out.println("From member servlet: "+result);			
	
	request.setAttribute("select", result);
	request.getRequestDispatcher(
			"/_04_Members/Members.jsp").forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
