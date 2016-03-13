package _06_Seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _06_Seller.model._06_Sellerjdbc;
@WebServlet(
		urlPatterns={"/_06_Seller/Seller.controller"}
		)
public class _06_SellerServlet extends HttpServlet {
	private _06_Sellerjdbc sellerjdbc= new _06_Sellerjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		
		session.setAttribute("LoginOK", accountUID);
		System.out.println("accountUID:"+accountUID);
		
		
		
		List result = null;
		
		if(accountUID!=null){			
			result = sellerjdbc.select(accountUID);		
			System.out.println("resultVistor:"+result);
			
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/_06_Seller/SellerCenter.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}