package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.loginService;

@WebServlet(
		urlPatterns={"/page/login.controller"}
)
public class LoginServlet extends HttpServlet {
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
			error.put("acc_email", "Please enter email to login");
		}
		if(psd==null || psd.trim().length()==0) {
			error.put("psd", "Please enter password to login");
		}
		
		if(error!=null && !error.isEmpty()){
			request.getRequestDispatcher(
					"/page/login.jsp").forward(request, response);
			return;
		}
//呼叫model
		MemberBean bean = MemberService.login(acc_email, psd);
		
//根據model執行結果顯示view
		if(bean==null) {
			error.put("password", "Login failed, please try again");
			request.getRequestDispatcher(
					"/page/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);

			String path = request.getContextPath();
			response.sendRedirect(path+"/page/index.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
