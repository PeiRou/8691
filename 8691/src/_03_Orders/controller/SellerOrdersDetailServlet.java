package _03_Orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03_Orders.model.OrdersDetailBean;
import _03_Orders.model.OrdersDetailService;
import _03_Orders.model.OrdersTotalBean;



@WebServlet(urlPatterns={"/_03_Orders/SellerOrdersDetailServlet"})
public class SellerOrdersDetailServlet extends HttpServlet {	
	private OrdersDetailService ordersDeatilService = new OrdersDetailService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		String temp0 = request.getParameter("ordersID");
		System.out.println("ordersID:"+temp0);
		String Orders_detail_UID = request.getParameter("Orders_detail_UID");
		String temp1 = request.getParameter("Food_ID");
		String Drink_name = request.getParameter("drink_name");
		String temp2 = request.getParameter("quantity");
		String temp3 = request.getParameter("originalPrice");
		String note = request.getParameter("note");
		String action = request.getParameter("action");
		
		
		//轉換資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		int ordersID = 0;
		if (temp0 != null && temp0.length() != 0) {
			try {
				ordersID = Integer.parseInt(temp0);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("ordersID", "OrdersID must be an number");
			}
		}
		int Food_ID = 0;
		if (temp1 != null && temp1.length() != 0) {
			try {
				Food_ID = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("Food_ID", "Food_ID must be an number");
			}
		}
		int quantity = 0;
		if (temp2 != null && temp2.length() != 0) {
			try {
				quantity = Integer.parseInt(temp2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("quantity", "數量必須為整數");
			}
		}
		int originalPrice = 0;
		if (temp3 != null && temp3.length() != 0) {
			try {
				originalPrice = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("originalPrice", "價格必須為整數");
			}
		}
		
		
		
		//呼叫model
		OrdersDetailBean bean = new OrdersDetailBean();
		bean.setOrders_detail_UID(Orders_detail_UID);
		bean.setOrdersID(ordersID);
		bean.setFood_ID(Food_ID);
		bean.setDrink_name(Drink_name);
		bean.setQuantity(quantity);
		bean.setOriginalPrice(originalPrice);
		bean.setNote(note);
		
		//根據model執行結果顯示view
		if("訂單明細".equals(action)) {
			List<OrdersDetailBean> result = ordersDeatilService.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/_03_Orders/SellerOrdersDetailDisplay.jsp").forward(request, response);
		} else {
			error.put("action", "Unknown action: "+action);
			request.getRequestDispatcher(
					"/_03_Orders/OrdersTotalDisplay.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
