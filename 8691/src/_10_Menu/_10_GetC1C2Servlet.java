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
		urlPatterns={"/_10_Menu/GetC1C2.controller"}
		)
public class _10_GetC1C2Servlet extends HttpServlet {
	private _11_ProdClass2jdbc prodClass2jdbc = new _11_ProdClass2jdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", accountUID);
		
		String GroupID = request.getParameter("GroupID");
		System.out.println("GroupID:"+GroupID);
		//String GroupID = "1";
		List resultPrC1C2 = null;
		JSONObject json = new JSONObject();
		
		try {
			
			resultPrC1C2 = prodClass2jdbc.selectGp(GroupID);
			if(resultPrC1C2!=null){
				json.put("data",resultPrC1C2);
			}
			System.out.println("resultPrC1C2:"+resultPrC1C2);

		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		request.setAttribute("resultPrC1C2", resultPrC1C2);
		
		System.out.println(json.toString());
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