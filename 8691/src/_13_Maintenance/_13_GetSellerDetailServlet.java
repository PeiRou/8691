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
import _13_Maintenance.model.dao._13_SellerVistorjdbc;
@WebServlet(
		urlPatterns={"/_13_Maintenance/GetSellerDetail.controller"}
		)
public class _13_GetSellerDetailServlet extends HttpServlet {
	private _13_SellerVistorjdbc sellerVistorjdbc = new _13_SellerVistorjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String selfUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", selfUID);
//		String accountUID = (String) request.getAttribute("sellerUID");
		String accountUID = request.getParameter("sellerUID");
		System.out.println("accountUID:"+accountUID);
		List result = null;
		
		result = sellerVistorjdbc.select(accountUID);
		
		System.out.println("result:"+result);			
		
		request.setAttribute("select", result);
		request.getRequestDispatcher(
				"/_13_Maintenance/_13_SellerInfor.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}