package _02_Login.controller;

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
import _02_Login.model.loginService;

@WebServlet(
		urlPatterns={"/_02_Login/login.controller"}
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private loginService MemberService = new loginService();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//接收資料
		String acc_email = request.getParameter("acc_email");
		String psd = request.getParameter("psd");
		
//驗證資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

		if(acc_email==null || acc_email.trim().length()==0) {
			error.put("acc_email", "請輸入您的e-mail登入");
		}
		if(psd==null || psd.trim().length()==0) {
			error.put("psd", "請輸入您的密碼登入");
		}
		//有錯誤
		if(error!=null && !error.isEmpty()){
			request.getRequestDispatcher("/_02_Login/Login.jsp").forward(request, response);
			return;
		}
//呼叫model
		AccountBean bean = MemberService.login(acc_email, psd);
		
//根據model顯示view
		if(bean==null) {
			error.put("loginfail", "登入失敗");
			request.getRequestDispatcher("/_02_Login/Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("LoginOK", bean.getAccount_UID());
			
			System.out.println("LoginOK= "+ bean.getAccount_UID());
			
			session.setAttribute("RoleID", bean.getRole_ID());
			
			System.out.println("RoleID= "+ bean.getRole_ID());
			
			request.setAttribute("", bean.getAccount_UID());
			
			String  roleid = (String) session.getAttribute("RoleID");
			
			
//			String dest = (String)session.getAttribute("dest");
//			if(dest!=null && dest.length()!=0){
//				session.removeAttribute("dest");
//				response.sendRedirect(dest);
//			}else{			
			
			if(roleid.equals("101")){
				RequestDispatcher rd = request.getRequestDispatcher("/_02_Login/NotYet.jsp");
				rd.forward(request, response);	
			}else{
					String path = request.getContextPath();
					response.sendRedirect(path+"/index.jsp");}
//			}
		}	
	}
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
