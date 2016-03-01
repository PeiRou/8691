package _01_Register.controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _00_Account.model.AccountBean;
import _01_Register.model.RegisterServiceToAccount;
import _01_Register.model.RegisterServiceToMember;
import _04_Member.model.MemberBean;

@WebServlet(urlPatterns={"/register.controller"})

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterServiceToMember RegisterServiceToMember = new RegisterServiceToMember();
	private RegisterServiceToAccount RegisterServiceToAccount = new RegisterServiceToAccount();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
			error.put("name", "請輸入您的姓名");
		}System.out.println(name);
		
		if(acc_email==null || acc_email.trim().length()==0) {
			error.put("acc_email", "請輸入您的e-mail");
		}System.out.println(acc_email);
		
		if(psd==null || psd.trim().length()==0) {
			error.put("psd", "請輸入您的密碼");
		}System.out.println(psd);
		
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
		
		System.out.println("1");
		//處理前面的資料驗證，有錯就先return
		if (error!= null&&!error.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/_01_Register/Register.jsp");
			rd.forward(request, response);
			return;
		}
		
		System.out.println("2");
		AccountBean bean1 = new AccountBean();
		bean1.setAcc_email(acc_email);
		bean1.setPsd(psd);
		bean1.setRole_ID("201");
		System.out.println("3");
		String accresult = RegisterServiceToAccount.insertAccount(bean1);
		System.out.println(accresult);
		MemberBean bean = null;                      
//呼叫model
		if (accresult != null&& !accresult.isEmpty()) {
			bean = new MemberBean();
			bean.setAccount_UID(accresult);
			bean.setName(name);
			bean.setGender(gender);
			bean.setTel(tel);
			bean.setGUAR_CT(GUAR_CT);
			bean.setGUAR_AR(GUAR_AR);
			bean.setGUAR_ROAD(GUAR_ROAD);
			bean.setGUAR_NO(GUAR_NO);
			bean.setEmail2(email2);
			bean.setCel(cel);
			//bean.setInsdate(insdate);
		}else{
			error.put("UUID", "恭喜您中了大獎!!");
		}
		System.out.println("4");
//根據model執行結果顯示view
//		RegisterServiceToMember rs = new RegisterServiceToMember();
//		RegisterServiceToAccount rs1 = new RegisterServiceToAccount();
		MemberBean Memresult = RegisterServiceToMember.insertMember(bean);
		if(Memresult==null) {
			error.put("action", "註冊失敗");
		}
		// 有錯誤
		
				
		if (error== null&& error.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("/_01_Register/RegisterOK_toLogin.jsp");
			rd.forward(request, response);
			
			}
		}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
