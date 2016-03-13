package _12_UpdateInfo;

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

import _00_Account.model.AccountBean;
import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAOjdbc;

@WebServlet("/AddrUpdate")
public class UpdateAddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
//    	request.getAttribute("LoginOK");
    	
    	//接收資料	
    	String  aaa = (String) session.getAttribute("LoginOK");
    			

    			String GUAR_CT = request.getParameter("GUAR_CT");
    			String GUAR_AR = request.getParameter("GUAR_AR");
    			String GUAR_ROAD = request.getParameter("GUAR_ROAD");
    			String GUAR_NO = request.getParameter("GUAR_NO");

    			//System.out.println(aaa.getAccount_UID());
    			
    			
    			//String account_UID = (String)request.getAttribute("LoginOK");
    	//驗證資料// 轉型態
    			Map<String, String> error = new HashMap<String, String>();
    			request.setAttribute("error", error);

    			if(GUAR_CT==null || GUAR_CT.trim().length()==0) {
    				error.put("GUAR_CT", "請輸入您的地址");
    			}System.out.println(GUAR_CT);
    			
    			if(GUAR_AR==null || GUAR_AR.trim().length()==0) {
    				error.put("GUAR_AR", "請輸入您的地址");
    			}System.out.println(GUAR_AR);
    			
    			if(GUAR_ROAD==null || GUAR_ROAD.trim().length()==0) {
    				error.put("GUAR_ROAD", "請輸入您的地址");
    			}System.out.println(GUAR_ROAD);
    			
    			if(GUAR_NO==null || GUAR_NO.trim().length()==0) {
    				error.put("GUAR_NO", "請輸入您的地址");
    			}System.out.println(GUAR_NO);

    			
    			//處理前面的資料驗證，有錯就先return
    			if (error!= null&&!error.isEmpty()) {
    				error.put("action", "修改失敗");
    				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/InfoUpdate.jsp");
    				rd.forward(request, response);	
    				return;
    			}
	
    			//呼叫member update by uid方法
    			AddrUpdateDAOjdbc updateAddr = new AddrUpdateDAOjdbc();
    			
    			updateAddr.AddrUpdate(GUAR_CT, GUAR_AR, GUAR_ROAD,GUAR_NO, aaa);
    				//bean1.setAccount_UID(bean.getAccount_UID());

//    				bean2.setGUAR_CT(GUAR_CT);
//    				bean2.setGUAR_AR(GUAR_AR);
//    				bean2.setGUAR_ROAD(GUAR_ROAD);
//    				bean2.setGUAR_NO(GUAR_NO);

    				
    				if (aaa!= null) {
        				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/UpdateSuccess.jsp");
        				rd.forward(request, response);}else{
        					RequestDispatcher rd = request.getRequestDispatcher("/_02_Login/Login.jsp");
        				rd.forward(request, response);
        			
        				}	
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
