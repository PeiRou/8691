package _10_Menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import _11_ProdClass.dao._11_FoodClassjdbc;
import _11_ProdClass.dao._11_Foodjdbc;
@WebServlet(
		urlPatterns={"/_10_Menu/GetMenu.controller"}
		)
public class _10_GetMenuServlet extends HttpServlet {
	private _11_Foodjdbc foodjdbc = new _11_Foodjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		System.out.println("accountUID:"+accountUID);
		List result = null;
		
		try {
			result = foodjdbc.select(accountUID);
			System.out.println("result:"+result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		request.setAttribute("select", result);
		request.setAttribute("StoresCount", result.size());
		request.getRequestDispatcher(
				"/_09_Menu/Menu.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
