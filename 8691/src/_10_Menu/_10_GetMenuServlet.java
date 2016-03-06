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
@WebServlet(
		urlPatterns={"/_10_Menu/GetMenu.controller"}
		)
public class _10_GetMenuServlet extends HttpServlet {
	private _11_Foodjdbc foodjdbc = new _11_Foodjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		String roleID = (String) session.getAttribute("roleID");
		session.setAttribute("LoginOK", accountUID);
		System.out.println("accountUID: "+accountUID);
		System.out.println("roleID: "+roleID);
		List result = null;
		
//		try {
//			result = foodjdbc.select(accountUID);
//			System.out.println("result:"+result);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}		
		
		request.setAttribute("select", result);
		request.getRequestDispatcher(
				"/_09_Menu/Menu.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
