package _03_Orders.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _03_Orders.model.OrdersTotalBean;
import _03_Orders.model.OrdersTotalService;
import _07_Address.model.Address_AR_Bean;
import _07_Address.model.Address_CT_Bean;
import _07_Address.model.Address_ROAD_Bean;


@WebServlet(urlPatterns={"/_03_Orders/OrdersTotalServlet"})
public class OrdersTotalServlet extends HttpServlet {
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	private OrdersTotalService ordersTotalService = new OrdersTotalService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//接收資料
		String Orders_total_UID = request.getParameter("Orders_total_UID");
		String account_UID = (String)request.getSession().getAttribute("LoginOK");
		String seller_UID = request.getParameter("seller_UID");
		String temp0 = request.getParameter("ordersID");
		String status = request.getParameter("status");
		String name = request.getParameter("name");
		String cel = request.getParameter("cel");
		String GUAR_CT = request.getParameter("GUAR_CT");
		String GUAR_AR = request.getParameter("GUAR_AR");
		String GUAR_ROAD = request.getParameter("GUAR_ROAD");
		String GUAR_NO = request.getParameter("GUAR_NO");
		String pay_metho = request.getParameter("pay_metho");
		String temp1 = request.getParameter("insdate");
		String temp2 = request.getParameter("ship_price");
		String temp3 = request.getParameter("food_price");
		String temp4 = request.getParameter("total_amount");
		String orderaction = request.getParameter("orderaction");


	//轉換資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

			
//			if(name==null || name.length()==0) {				
//				  error.put("name", "訂購人姓名為必填");				
//				}
//			
//			if(cel==null || cel.length()==0) {				
//			  error.put("cel", "訂購人手機為必填");				
//			}
//			
//			if(GUAR_CT==null || GUAR_CT.length()==0) {				
//				  error.put("GUAR_CT", "住址(縣/市)為必填");				
//			}
//			
//			if(GUAR_AR==null || GUAR_AR.length()==0) {				
//				  error.put("GUAR_AR", "住址(區/鄉/鎮/市)為必填");				
//			}
//			
//			if(GUAR_ROAD==null || GUAR_ROAD.length()==0) {				
//				  error.put("GUAR_ROAD", "住址(路/街/巷)為必填");				
//			}
//			
//			if(GUAR_NO==null || GUAR_NO.length()==0) {				
//				  error.put("GUAR_NO", "住址(號)為必填");				
//			}
//			
//			if(pay_metho==null || pay_metho.length()==0) {				
//				  error.put("pay_metho", "付款方式為必填");				
//			}
			
		int ordersID = 0;
		if (temp0 != null && temp0.length() != 0) {
			try {
				ordersID = Integer.parseInt(temp0);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("ordersID", "OrdersID must be an number");
			}
		}
			
			
			java.util.Date insdate = null;
			if(temp1!=null && temp1.length()!=0) {
				try {
					insdate = sFormat.parse(temp1);
				} catch (ParseException e) {
					e.printStackTrace();
					error.put("insdate", "日期格式必須為 yyyy-MM-dd");
				}
			}

			int ship_price = 0;
			if(temp2!=null && temp2.length()!=0) {
				try {
					ship_price = Integer.parseInt(temp2);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					error.put("ship_price", "Ship_price must be an number");
				}
			}
			
			int food_price = 0;
			if(temp3!=null && temp3.length()!=0) {
				try {
					food_price = Integer.parseInt(temp3);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					error.put("food_price", "Food_price must be a number");
				}
			}
			
			int total_amount = 0;
			if(temp4!=null && temp4.length()!=0) {
				try {
					total_amount = Integer.parseInt(temp4);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					error.put("total_amount", "Total_amount must be a number");
				}
			}
			
	//驗證資料
//			if("Insert".equals(orderaction) || "Update".equals(orderaction) || "Delete".equals(orderaction)) {
//				if(cel.length()==0) {
//					error.put("cel", "Please enter PhoneNumber for "+orderaction);
//				}
//			}
			if(error!=null && !error.isEmpty()){
				request.getRequestDispatcher(
						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
				return;
			}
			
	//呼叫model
			OrdersTotalBean bean = new OrdersTotalBean();
			bean.setOrders_total_UID(Orders_total_UID);
			bean.setAccount_UID(account_UID);
			bean.setSeller_UID(seller_UID);
			bean.setOrdersID(ordersID);			
			bean.setStatus(status);
			bean.setName(name);
			bean.setCel(cel);
			bean.setGUAR_CT(GUAR_CT);
			bean.setGUAR_AR(GUAR_AR);
			bean.setGUAR_ROAD(GUAR_ROAD);
			bean.setGUAR_NO(GUAR_NO);
			bean.setPay_metho(pay_metho);
			bean.setInsdate(insdate);
			bean.setShip_price(ship_price);
			bean.setFood_price(food_price);
			bean.setTotal_amount(total_amount);	
			
			
			
			
	//根據model執行結果顯示view
			if("查看我的訂單".equals(orderaction)) {
				List<OrdersTotalBean> result = ordersTotalService.select(bean);
				HttpSession session = request.getSession();
				session.setAttribute("ordersID", result.get(ordersID));
				request.setAttribute("select", result);
				request.getRequestDispatcher(
						"/_03_Orders/OrdersTotalDisplay.jsp").forward(request, response);
			} else if("Insert".equals(orderaction)) {
				OrdersTotalBean result = ordersTotalService.insert(bean);
				if(result==null) {
					error.put("action", "Insert failed");
				} else {
					request.setAttribute("insert", result);
				}
				request.getRequestDispatcher(
						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
//			} else if("Update".equals(orderaction)) {
//				OrdersTotalBean result = ordersTotalService.update(bean);
//				if(result==null) {
//					error.put("action", "Update failed");
//				} else {
//					request.setAttribute("update", result);
//				}
//				request.getRequestDispatcher(
//						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
//			} else if("Delete".equals(orderaction)) {
//				boolean result = ordersTotalService.delete(bean);
//				if(result) {
//					request.setAttribute("delete", result);
//				} else {
//					error.put("action", "Delete failed");
//				}
//				request.getRequestDispatcher(
//						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
			} else {
				error.put("action", "Unknown action: "+orderaction);
				request.getRequestDispatcher(
						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
			}
		}

			
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
