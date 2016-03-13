package _10_Menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import _11_ProdClass.dao._11_ProdClass2jdbc;
@WebServlet(
		urlPatterns={"/_10_Menu/InsClass2.controller"}
		)
public class _10_InsClass2Servlet extends HttpServlet {	
	private _11_ProdClass2jdbc prodClass2jdbc = new _11_ProdClass2jdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", accountUID);
		
		String prodStatusClass2Name = request.getParameter("ProdStatusClass2Name");
		String prodStatusClass1ID = request.getParameter("ProdStatusClass1ID");
		
		JSONObject json = new JSONObject();
		int result = 0;
		if(accountUID!=null){			
			try {
				System.out.println("LoginOK:"+accountUID);
				System.out.println("ProdStatusClass1ID:"+prodStatusClass1ID);
				System.out.println("ProdStatusClass2Name:"+prodStatusClass2Name);
				result = prodClass2jdbc.insert(prodStatusClass1ID,prodStatusClass2Name);
				json.put("ProdStatusClass2ID", result);
								
				System.out.println("resultInsC2:"+result);
			} catch (JSONException e) {
				e.printStackTrace();
			}		
		}
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