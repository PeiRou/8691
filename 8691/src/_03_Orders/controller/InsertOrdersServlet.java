package _03_Orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _00_Account.model.AccountBean;
import _03_Orders.model.OrdersDetailBean;
import _03_Orders.model.OrdersDetailService;
import _03_Orders.model.OrdersTotalBean;
import _03_Orders.model.OrdersTotalService;

@WebServlet(urlPatterns={"/_03_Orders/InsertOrdersServlet"})
public class InsertOrdersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doGet(request, response);
		OrdersDetailService ordersDetailService = new OrdersDetailService();
		OrdersTotalService ordersTotalService = new OrdersTotalService();
		
		//接收資料
				String account_UID = (String)request.getSession().getAttribute("LoginOK");
				String seller_UID = request.getParameter("seller_UID");
				String name = request.getParameter("name");
				String temp0 = request.getParameter("ordersID");
				String cel = request.getParameter("cel");
				String GUAR_CT = request.getParameter("GUAR_CT");
				String GUAR_AR = request.getParameter("GUAR_AR");
				String GUAR_ROAD = request.getParameter("GUAR_ROAD");
				String GUAR_NO = request.getParameter("GUAR_NO");
				String pay_metho = request.getParameter("pay_metho");
				String temp1 = request.getParameter("ship_price");
				String temp2 = request.getParameter("food_price");
				String temp3 = request.getParameter("total_amount");
				String temp4 = request.getParameter("Food_ID");
				String Drink_name = request.getParameter("drink_name");
				String temp5 = request.getParameter("quantity");
				String temp6 = request.getParameter("originalPrice");
				String note = request.getParameter("note");
				
		//轉換資料
				Map<String, String> error = new HashMap<String, String>();
				request.setAttribute("error", error);
				if(name==null || name.trim().length()==0) {
					error.put("name", "請輸入您的姓名");
				}
				if(cel==null || cel.trim().length()==0) {
					error.put("cel", "請輸入您的電話");
				}
				if(GUAR_CT==null || GUAR_CT.trim().length()==0) {
					error.put("GUAR_CT", "請選擇城市");
				}
				if(GUAR_AR==null || GUAR_AR.trim().length()==0) {
					error.put("GUAR_AR", "請選擇行政區");
				}
				if(GUAR_ROAD==null || GUAR_ROAD.trim().length()==0) {
					error.put("GUAR_ROAD", "請輸入您的地址(路)");
				}
				if(GUAR_NO==null || GUAR_NO.trim().length()==0) {
					error.put("GUAR_NO", "請輸入您的地址(號)");
				}
				if(pay_metho==null || pay_metho.trim().length()==0) {
					error.put("pay_metho", "請選擇付款方式");
				}
				if(Drink_name==null || Drink_name.trim().length()==0) {
					error.put("Drink_name", "請輸入品名");
				}
				
				int ordersID = 0;
				if(temp0!=null && temp0.length()!=0) {
					try {
						ordersID = Integer.parseInt(temp0);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("ordersID", "ordersID必須為整數!");
					}
				}
				
				int ship_price = 0;
				if(temp1!=null && temp1.length()!=0) {
					try {
						ship_price = Integer.parseInt(temp1);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("ship_price", "運費必須為整數!");
					}
				}
				
				int food_price = 0;
				if(temp2!=null && temp2.length()!=0) {
					try {
						food_price = Integer.parseInt(temp2);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("food_price", "食物金額必須為整數!");
					}
				}
				
				int total_amount = 0;
				if(temp3!=null && temp3.length()!=0) {
					try {
						total_amount = Integer.parseInt(temp3);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("total_amount", "總金額必須為整數!");
					}
				}
				
				int Food_ID = 0;
				if(temp4!=null && temp4.length()!=0) {
					try {
						Food_ID = Integer.parseInt(temp4);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("Food_ID", "食物編號必須為整數!");
					}
				}
				
				int quantity = 0;
				if(temp5!=null && temp5.length()!=0) {
					try {
						quantity = Integer.parseInt(temp5);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("quantity", "數量必須為整數!");
					}
				}
				
				int originalPrice = 0;
				if(temp6!=null && temp6.length()!=0) {
					try {
						originalPrice = Integer.parseInt(temp6);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("originalPrice", "價格必須為整數!");
					}
				}
				

				
		//呼叫model 1
				OrdersDetailBean ordersDetailBean = new OrdersDetailBean();
				ordersDetailBean.setOrdersID(ordersID);
				ordersDetailBean.setFood_ID(Food_ID);
				ordersDetailBean.setDrink_name(Drink_name);
				ordersDetailBean.setQuantity(quantity);
				ordersDetailBean.setOriginalPrice(originalPrice);
				ordersDetailBean.setNote(note);
				OrdersDetailBean resultDetail = ordersDetailService.insert(ordersDetailBean);
				
		//呼叫model 2
				OrdersTotalBean ordersTotalBean = new OrdersTotalBean();
				//if (resultDetail.getOrdersID() != 0) {
					ordersTotalBean.setOrdersID(ordersID);	
					ordersTotalBean.setAccount_UID(account_UID);
					ordersTotalBean.setSeller_UID(seller_UID);
					ordersTotalBean.setName(name);
					ordersTotalBean.setCel(cel);
					ordersTotalBean.setGUAR_CT(GUAR_CT);
					ordersTotalBean.setGUAR_AR(GUAR_AR);
					ordersTotalBean.setGUAR_ROAD(GUAR_ROAD);
					ordersTotalBean.setGUAR_NO(GUAR_NO);
					ordersTotalBean.setPay_metho(pay_metho);
					ordersTotalBean.setShip_price(ship_price);
					ordersTotalBean.setFood_price(food_price);
					ordersTotalBean.setTotal_amount(total_amount);
				OrdersTotalBean resultTotal = ordersTotalService.insert(ordersTotalBean);
				
				
		//根據model執行結果顯示view
				if (error!= null&&!error.isEmpty()) {
					error.put("action", "購買失敗");
					RequestDispatcher rd = request.getRequestDispatcher("/_03_Orders/InsertOrders.jsp");
					rd.forward(request, response);	
					return;
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/_03_Orders/PurchaseOK.jsp");
					rd.forward(request, response);
				}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
