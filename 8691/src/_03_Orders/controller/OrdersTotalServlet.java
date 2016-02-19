package _03_Orders.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03_Orders.model.OrdersTotalService;


@WebServlet(urlPatterns={"_03_Orders/OrdersTotalServlet"})
public class OrdersTotalServlet extends HttpServlet {
	private OrdersTotalService ordersTotalService = new OrdersTotalService();
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//接收資料
			String temp1 = request.getParameter("Orders_total_UID");
			String name = request.getParameter("Member_UID");
			String temp2 = request.getParameter("Orders_ID");
			String temp3 = request.getParameter("status");
			String temp4 = request.getParameter("name");
			String temp1 = request.getParameter("cel");
			String name = request.getParameter("GUAR_CT");
			String temp2 = request.getParameter("GUAR_AR");
			String temp3 = request.getParameter("GUAR_ROAD");
			String temp4 = request.getParameter("GUAR_NO");
			String temp1 = request.getParameter("pay_metho");
			String name = request.getParameter("insdate");
			String temp2 = request.getParameter("ship_price");
			String temp3 = request.getParameter("food_price");
			String temp4 = request.getParameter("total_amount");
			
			
			String prodaction = request.getParameter("prodaction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
