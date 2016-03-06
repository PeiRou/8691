package _xxx_Maintenance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Account.model.AccountBean;
import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAOjdbc;

@WebServlet("/Maintenance")
public class MaintenanceServlet extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	String accountUID = (String) session.getAttribute("LoginOK");
    	String roleID = (String) session.getAttribute("roleID");
    	session.setAttribute("LoginOK", accountUID);
    	System.out.println("accountUID: "+accountUID);
    	System.out.println("roleID: "+roleID);
    	
    	
    	request.getRequestDispatcher(
    			"/_xxx_Maintenance/MaintenancePage.jsp").forward(request, response);
    	
    	}
    	
    	
    	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
