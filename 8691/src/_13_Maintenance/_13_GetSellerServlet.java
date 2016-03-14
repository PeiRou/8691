package _13_Maintenance;

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

import _13_Maintenance.model.dao._13_Accountjdbc;
import _13_Maintenance.model.dao._13_UpdateRoleDAOjdbc;
import _13_Maintenance.model.dao._13_UpdateStatusDAOjdbc;
@WebServlet(
		urlPatterns={"/_13_Maintenance/GetSeller.controller"}
		)
public class _13_GetSellerServlet extends HttpServlet {
	private _13_Accountjdbc accountjdbc = new _13_Accountjdbc();
	private _13_UpdateRoleDAOjdbc updateRole = new _13_UpdateRoleDAOjdbc();
	private _13_UpdateStatusDAOjdbc updateStatus = new _13_UpdateStatusDAOjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		//為了修改接收的值
		String sellerUID = request.getParameter("sellerUID"); 
		String sellerStatus = request.getParameter("sellerStatus");
		
		
		System.out.println("sellerUID: "+sellerUID);
		System.out.println("sellerStatus: "+sellerStatus);
		
		session.setAttribute("LoginOK", accountUID);
		System.out.println("accountUID:"+accountUID);
		
		
		//觸發修改
		if(sellerUID!=null && sellerStatus!=null){
			int json = 0;
			
			if("1".equals(sellerStatus))
			{
				json = updateRole.roleUpdate("1111",  sellerUID);
				updateStatus.statusUpdate(sellerStatus, sellerUID);
			}else if("2".equals(sellerStatus)){
				json = updateRole.roleUpdate("102",  sellerUID);
				updateStatus.statusUpdate(sellerStatus, sellerUID);
			}
			System.out.println("json:"+json);
			
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().write(Integer.toString(json));
		}
		
		List result = null;
		
		if(sellerUID==null && sellerStatus==null){			
			result = accountjdbc.select();		
			System.out.println("resultVistor:"+result);
			
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/_13_Maintenance/_13_Manager.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}