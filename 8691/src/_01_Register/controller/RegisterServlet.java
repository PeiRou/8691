package _01_Register.controller;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _04_Member.model.MemberBean;

@WebServlet(urlPatterns={"/page/register.controller"})


public class RegisterServlet extends HttpServlet {
	private RegisterServlet mmo = new RegisterServlet();
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String name = request.getParameter("name");
		String acc_email = request.getParameter("acc_email");
		String psd = request.getParameter("psd");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String GUAR_CT = request.getParameter("GUAR_CT");
		String GUAR_AR = request.getParameter("GUAR_AR");
		String GUAR_ROAD = request.getParameter("GUAR_ROAD");
		String GUAR_NO = request.getParameter("GUAR_NO");
		String email2 = request.getParameter("email2");
		String cel = request.getParameter("cel");
		
		
//驗證資料// 轉型態
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

		if(name==null || name.trim().length()==0) {
			error.put("name", "Please enter name to register");
		}
		if(acc_email==null || acc_email.trim().length()==0) {
			error.put("acc_email", "Please enter acc_email to register");
		}
		
//		byte[] temppsd = null;
//		if (psd != null && psd.trim().length() > 0) {
//			try {
//				byte[] bytes = psd.getBytes();
//				temppsd = byte[].getBytes(psd);
//			} catch (NumberFormatException e) {
//				error.put("weight","擃?甈???詨?);
//			}
//		}
		if(psd==null || psd.trim().length()==0) {
			error.put("psd", "Please enter password to register");
		}
		if(gender==null || gender.trim().length()==0) {
			error.put("gender", "Please enter gender to register");
		}
		if(tel==null || tel.trim().length()==0) {
			error.put("tel", "Please enter phone number to register");
		}
		if(GUAR_CT==null || GUAR_CT.trim().length()==0) {
			error.put("GUAR_CT", "Please enter GUAR_CT to register");
		}
		if(GUAR_AR==null || GUAR_AR.trim().length()==0) {
			error.put("GUAR_AR", "Please enter GUAR_AR to register");
		}
		if(GUAR_ROAD==null || GUAR_ROAD.trim().length()==0) {
			error.put("GUAR_ROAD", "Please enter GUAR_ROAD to register");
		}
		if(GUAR_NO==null || GUAR_NO.trim().length()==0) {
			error.put("GUAR_NO", "Please enter GUAR_NO to register");
		}
		if(email2==null || email2.trim().length()==0) {
			error.put("email2", "Please enter email2 to register");
		}
		if(cel==null || cel.trim().length()==0) {
			error.put("cel", "Please enter cel to register");
		}
		Timestamp insdate = new Timestamp(System.currentTimeMillis());
			
		if (!error.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/register.jsp");
			rd.forward(request, response);
			return;
		}
		
		if (error.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/login.jsp");
			rd.forward(request, response);
			return;
		}
		
//呼叫model
		MemberBean bean = new MemberBean(name, acc_email, psd, gender, tel, GUAR_CT, GUAR_AR, GUAR_ROAD, GUAR_NO, email2, cel, insdate);
		
		
//根據model執行結果顯示view
//		if(bean==null) {
//			error.put("password", "Login failed, please try again");
//			request.getRequestDispatcher(
//					"/secure/login.jsp").forward(request, response);
//		} else {
//			HttpSession session = request.getSession();
//			session.setAttribute("user", bean);
//
//			String path = request.getContextPath();
//			response.sendRedirect(path+"/index.jsp");
//		}
	}
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
