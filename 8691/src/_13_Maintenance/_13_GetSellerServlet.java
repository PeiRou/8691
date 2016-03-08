package _13_Maintenance;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _13_Maintenance.model.dao._13_Accountjdbc;
@WebServlet(
		urlPatterns={"/_13_Maintenance/GetSeller.controller"}
		)
public class _13_GetSellerServlet extends HttpServlet {
	private _13_Accountjdbc accountjdbc = new _13_Accountjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", accountUID);
		System.out.println("accountUID:"+accountUID);
		List result = null;
		
		result = accountjdbc.select();
		
		System.out.println("result:"+result);			
		
		request.setAttribute("select", result);
		request.getRequestDispatcher(
				"/_13_Maintenance/_13_Manager.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}