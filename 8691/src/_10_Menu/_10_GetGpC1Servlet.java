package _10_Menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import _11_ProdClass.dao._11_Foodjdbc;
import _11_ProdClass.dao._11_GroupClass3jdbc;
import _11_ProdClass.dao._11_ProdClass1jdbc;
import _11_ProdClass.dao._11_ProdClass2jdbc;
import _11_ProdClass.dao._11_ProdClass3jdbc;
import _11_ProdClass.dao._11_SizeStatusjdbc;
@WebServlet(
		urlPatterns={"/_10_Menu/GetGpC1.controller"}
		)
public class _10_GetGpC1Servlet extends HttpServlet {
	private _11_GroupClass3jdbc groupClass3jdbc = new _11_GroupClass3jdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", accountUID);
		System.out.println("groupClass3jdbc_LoginOK:"+accountUID);
		
		List resultGpC1 = null;
		JSONObject json = new JSONObject();
		
		try {
			
			resultGpC1 = groupClass3jdbc.selectGpC1(accountUID);
			System.out.println("resultGpC1:"+resultGpC1);
			if(resultGpC1!=null){
				json.put("data",resultGpC1);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		request.setAttribute("resultGpC1", resultGpC1);
		
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().write(json.toString());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
}