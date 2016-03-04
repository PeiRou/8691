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

@WebServlet("/InfoUpdate")
public class InfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAOjdbc dao = new MemberDAOjdbc();
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
//    	request.getAttribute("LoginOK");
    	  	
    	//接收資料	
    	String  aaa = (String) session.getAttribute("LoginOK");
    			
    			String name = request.getParameter("name");
    			String gender = request.getParameter("gender");
    			String tel = request.getParameter("tel");
    			String GUAR_CT = request.getParameter("GUAR_CT");
    			String GUAR_AR = request.getParameter("GUAR_AR");
    			String GUAR_ROAD = request.getParameter("GUAR_ROAD");
    			String GUAR_NO = request.getParameter("GUAR_NO");
    			String email2 = request.getParameter("email2");
    			String cel = request.getParameter("cel");
    			//System.out.println(aaa.getAccount_UID());
    			
    			
    			//String account_UID = (String)request.getAttribute("LoginOK");
    	//驗證資料// 轉型態
    			Map<String, String> error = new HashMap<String, String>();
    			request.setAttribute("error", error);

    			if(name==null || name.trim().length()==0) {
    				error.put("name", "請輸入您的姓名");
    			}System.out.println(name);
    			
    			if(gender==null || gender.trim().length()==0) {
    				error.put("gender", "請輸入您的性別");
    			}System.out.println(gender);
    			
    			if(tel==null || tel.trim().length()==0) {
    				error.put("tel", "請輸入您的電話號碼");
    			}System.out.println(tel);
    			
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
    			
    			if(email2==null || email2.trim().length()==0) {
    				error.put("email2", "請輸入您的備用e-mail");
    			}System.out.println(email2);
    			
    			if(cel==null || cel.trim().length()==0) {
    				error.put("cel", "請輸入您的手機號碼");
    			}System.out.println(cel);
    			
    			//處理前面的資料驗證，有錯就先return
    			if (error!= null&&!error.isEmpty()) {
    				error.put("action", "修改失敗");
    				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/InfoUpdate.jsp");
    				rd.forward(request, response);	
    				return;
    			}
	
    			//呼叫member update by uid方法
    			UpdateInfoService updateInfoService = new UpdateInfoService();
    			
    			MemberBean bean2 = new MemberBean();
    			
    				//bean1.setAccount_UID(bean.getAccount_UID());
    				bean2.setName(name);
    				bean2.setGender(gender);
    				bean2.setTel(tel);
    				bean2.setGUAR_CT(GUAR_CT);
    				bean2.setGUAR_AR(GUAR_AR);
    				bean2.setGUAR_ROAD(GUAR_ROAD);
    				bean2.setGUAR_NO(GUAR_NO);
    				bean2.setEmail2(email2);
    				bean2.setCel(cel);
    				bean2.setAccount_UID(aaa);
    				System.out.println(bean2);
    				
    				updateInfoService.update(bean2);
    				
    				if (aaa == null) {
        				error.put("action", "修改失敗");
        				
        				System.out.println(bean2);
        				
        				
//    				} else if("Update".equals(orderaction)) {
//    				OrdersTotalBean result = ordersTotalService.update(bean);
//    				if(result==null) {
//    					error.put("action", "Update failed");
//    				} else {
//    					request.setAttribute("update", result);
//    				}
//    				request.getRequestDispatcher(
//    						"/_03_Orders/OrdersTotal.jsp").forward(request, response);
    				
    				
    			    if (bean2== null || !error.isEmpty()) {
        				error.put("action", "修改失敗");
        				RequestDispatcher rd = request.getRequestDispatcher("/_04_Members/InfoUpdate.jsp");
        				rd.forward(request, response);	
        				return;
        			}else{RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
    				rd.forward(request, response);	}
        			   
    				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
