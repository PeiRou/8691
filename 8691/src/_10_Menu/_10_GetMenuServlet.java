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
		urlPatterns={"/_10_Menu/GetMenu.controller"}
		)
public class _10_GetMenuServlet extends HttpServlet {
	private _11_Foodjdbc foodjdbc = new _11_Foodjdbc();
	private _11_GroupClass3jdbc groupClass3jdbc = new _11_GroupClass3jdbc();
	private _11_SizeStatusjdbc sizeStatusjdbc = new _11_SizeStatusjdbc();
	private _11_ProdClass1jdbc prodClass1jdbc = new _11_ProdClass1jdbc();
	private _11_ProdClass2jdbc prodClass2jdbc = new _11_ProdClass2jdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		session.setAttribute("LoginOK", accountUID);
		System.out.println("accountUID:"+accountUID);
		List result = null;
		List resultGroup = null;
		List resultSzSts = null;
		List resultPrCl1 = null;
		List resultPrCl2 = null;
		try {
			//result = foodjdbc.select(accountUID);
			resultGroup = groupClass3jdbc.selectGpFoodStatus(accountUID);
			resultSzSts = sizeStatusjdbc.select();
		    //resultPrCl1 = prodClass1jdbc.select();
			resultPrCl2 = prodClass2jdbc.select();
			System.out.println("result:"+result);
			System.out.println("resultGroup:"+resultGroup);
			System.out.println("resultSzSts:"+resultSzSts);
			System.out.println("resultPrClas1:"+resultPrCl1);
			System.out.println("resultPrClas2:"+resultPrCl2);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		request.setAttribute("select", result);
		request.setAttribute("selectGroup", resultGroup);
		request.setAttribute("selectSzSts",resultSzSts);
		request.setAttribute("selectPrCl1",resultPrCl1);
		request.setAttribute("selectPrCl2",resultPrCl2);
		request.getRequestDispatcher(
				"/_09_Menu/Menu.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
}