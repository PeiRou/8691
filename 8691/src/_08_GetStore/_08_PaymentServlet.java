package _08_GetStore;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.simple.JSONObject;

import _06_Seller.model.SellerVisitorBean;
import _06_Seller.model.SellerVisitorJDBC;
import _06_Seller.model._06_Sellerjdbc;
import _11_ProdClass.dao._11_Foodjdbc;
import _11_ProdClass.dao._11_SizeStatusjdbc;
@WebServlet(urlPatterns={"/_08_GetStore/Payment.controller"})
public class _08_PaymentServlet extends HttpServlet {
	private _11_SizeStatusjdbc sizeStatusjdbc = new _11_SizeStatusjdbc();
	private _06_Sellerjdbc sellerjdbc =new _06_Sellerjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String myserf = (String) session.getAttribute("LoginOK");
		String storeUID = request.getParameter("storeUID");
		
		String total = request.getParameter("total");
		
		String result = null;
		try {
			result = sellerjdbc.selectCatchName(storeUID);	
						
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("storeName", result);
		request.setAttribute("total", total);		
		
		request.getRequestDispatcher("/_03_Orders/InsertOrders.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
