package _00_Account.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PsdUpdate")
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChangePsdDAOjdbc updatePsd = new ChangePsdDAOjdbc();
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
//    	request.getAttribute("LoginOK");
    	
    	//接收資料	
    	String  aaa = (String) session.getAttribute("LoginOK");
    			
    			String OldPsd = request.getParameter("OldPsd");
    			String NewPsd = request.getParameter("NewPsd");
    			String NewPsd1 = request.getParameter("NewPsd1");

    			//System.out.println(aaa);
    			
    			//String account_UID = (String)request.getAttribute("LoginOK");
    	//驗證資料// 轉型態
    			Map<String, String> error = new HashMap<String, String>();
    			request.setAttribute("error", error);

    			if(OldPsd==null || OldPsd.trim().length()==0) {
    				error.put("OldPsd", "請輸入舊密碼");
    			}System.out.println(OldPsd);
    			
    			if(NewPsd==null || NewPsd.trim().length()==0) {
    				error.put("NewPsd", "請輸入新密碼");
    			}System.out.println(NewPsd1);
    			
    			if(NewPsd1==null || NewPsd1.trim().length()==0) {
    				error.put("NewPsd1", "請再次輸入新密碼");
    			}System.out.println(NewPsd1);

    			System.out.println("newpsd: "+NewPsd+ "   newpsd1: "+NewPsd1);
    			
    			//處理前面的資料驗證，有錯就先return
    			if (error!= null&&!error.isEmpty()) {
    				error.put("action", "修改失敗");
    				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/updatePsd.jsp");
    				rd.forward(request, response);	
    				return;}
    			    else{
    					updatePsd.updatePsd(NewPsd, aaa);
    					RequestDispatcher rd = request.getRequestDispatcher("/_01_Register/PsdUpdateOK_toLogin2.jsp");
        				rd.forward(request, response);
    				}
    			
    			System.out.println("1");

    			
    			//    				} else if("Update".equals(orderaction)) {
//    				OrdersTotalBean result = ordersTotalService.update(bean);
//    				if(result==null) {
//    					error.put("action", "Update failed");
//    				} else {
//    					request.setAttribute("update", result);
//    				}
//    				request.getRequestDispatcher(
//    						"/_03_Orders/OrdersTotal.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
