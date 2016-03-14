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

import org.json.JSONException;
import org.json.simple.JSONObject;

import _06_Seller.model.SellerVisitorBean;
import _06_Seller.model.SellerVisitorJDBC;
import _11_ProdClass.dao._11_Foodjdbc;
import _11_ProdClass.dao._11_SizeStatusjdbc;
@WebServlet(urlPatterns={"/_07_Shops/Shops.controller"})
public class _08_GetProdServlet extends HttpServlet {
	private _11_SizeStatusjdbc sizeStatusjdbc = new _11_SizeStatusjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StoreUID = request.getParameter("AccountUID");

		System.out.println("StoreUID:"+StoreUID);
		if (StoreUID != null && !StoreUID.isEmpty()) {
			_11_Foodjdbc foodJdbc = new _11_Foodjdbc();
			SellerVisitorJDBC sellerJdbc = new SellerVisitorJDBC();
			
			SellerVisitorBean sellerBean = sellerJdbc.select(StoreUID);
			
			if(null != sellerBean) {
				JSONObject obj = new JSONObject();
				List jsonList = new LinkedList();
				
				obj.put("FEIN", sellerBean.getFEIN());
				obj.put("Email2", sellerBean.getEmail2());
				obj.put("Tel", sellerBean.getTel());
				obj.put("Con_cel", sellerBean.getCon_cel());
				
				jsonList.add(obj);
				
				request.setAttribute("SellerInfo", jsonList);
				request.setAttribute("SellerName", sellerBean.getName());
			} else {
				request.setAttribute("SellerInfo", "");
				request.setAttribute("SellerName", "");
			}
			List resultSzSts = null;
			
			try {				
				resultSzSts = sizeStatusjdbc.select();			    
				System.out.println("resultSzSts:"+resultSzSts);				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			List prodInfo = foodJdbc.select(StoreUID);
			System.out.println("prodInfo:"+prodInfo);
			request.setAttribute("StoreUID", StoreUID);
			request.setAttribute("prodInfo", prodInfo);
			request.setAttribute("selectSzSts",resultSzSts);
		}
		
		request.getRequestDispatcher("/_07_Shops/Shops.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
