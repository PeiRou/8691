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

import _11_ProdClass.dao._11_Foodjdbc;
import _11_ProdClass.dao._11_GroupClass3jdbc;
import _11_ProdClass.dao._11_ProdClass1jdbc;
import _11_ProdClass.dao._11_ProdClass2jdbc;
import _11_ProdClass.dao._11_ProdClass3jdbc;
import _11_ProdClass.dao._11_SizeStatusjdbc;
@WebServlet(
		urlPatterns={"/_10_Menu/InsMenu.controller"}
		)
public class _10_InsMenuServlet extends HttpServlet {	
	private _11_GroupClass3jdbc groupClass3jdbc = new _11_GroupClass3jdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", accountUID);
		
		String prodStatusClass1ID = request.getParameter("prodStatusClass1ID");
		String groupClass3Name = request.getParameter("groupClass3Name");
		
		int result = 0;
		if(accountUID!=null){			
			try {
				System.out.println("LoginOK:"+accountUID);
				System.out.println("prodStatusClass1ID:"+prodStatusClass1ID);
				System.out.println("groupClass3Name:"+groupClass3Name);
				result = groupClass3jdbc.insert(accountUID,prodStatusClass1ID, groupClass3Name);
				System.out.println("resultInsMenu:"+result);
			} catch (JSONException e) {
				e.printStackTrace();
			}		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
}