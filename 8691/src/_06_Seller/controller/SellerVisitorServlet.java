package _06_Seller.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import _01_Register.model.RegisterServiceToAccount;
import _03_Orders.model.OrdersTotalBean;
import _06_Seller.model.SellerVisitorBean;
import _06_Seller.model.SellerVisitorService;

@WebServlet("/page/visitor.controller")
public class SellerVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static SimpleDateFormat mma = new SimpleDateFormat("yyyy-MM-dd");
	private SellerVisitorService sellerVisitorService = new SellerVisitorService();
	private RegisterServiceToAccount registerServiceToAccount = new RegisterServiceToAccount();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("!");

		// 接收資料
		String Account_UID = request.getParameter("Account_UID");
		String FEIN = request.getParameter("FEIN");
		String name = request.getParameter("name");
		String acc_email = request.getParameter("acc_email");
		String psd = request.getParameter("psd");
		String temp1 = request.getParameter("Seller_photo");
		String tel = request.getParameter("tel");
		String GUAR_CT = request.getParameter("GUAR_CT");
		String GUAR_AR = request.getParameter("GUAR_AR");
		String GUAR_ROAD = request.getParameter("GUAR_ROAD");
		String GUAR_NO = request.getParameter("GUAR_NO");
		String email2 = request.getParameter("email2");
		String Con_name = request.getParameter("Con_name");
		String Con_cel = request.getParameter("Con_cel");
		String receipts_metho = request.getParameter("receipts_metho");
		String temp2 = request.getParameter("IS_check");
		String temp3 = request.getParameter("IS_cooperation");
		String temp4 = request.getParameter("insdate");
		String prodaction = request.getParameter("prodaction");

		// 轉換資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

		// 傳圖片有問題先註解 Blob Seller_photo = new Blob();
		// if(temp1!=null && temp1.length()!=0) {
		// try {
		// Seller_photo = Blob.parseBlob(temp1);
		//
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// error.put("Seller_photo", "Id must be an integer");
		// }
		// }
		Boolean IS_check = null;
		if (temp2 != null && temp2.length() != 0) {
			try {
				IS_check = Boolean.parseBoolean(temp2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("IS_check", "IS_check must true or flase");
			}
		}

		Boolean IS_cooperation = null;
		if (temp3 != null && temp3.length() != 0) {
			try {
				IS_cooperation = Boolean.parseBoolean(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("IS_cooperation", "IS_check must true or flase");
			}
		}

		java.util.Date insdate = null;
		if (temp4 != null && temp4.length() != 0) {
			try {
				insdate = mma.parse(temp4);
			} catch (Exception e) {

				e.printStackTrace();
				error.put("insdate", "insdate must be a Date with yyyy-MM-dd");
			}

		}

		if (name == null || name.trim().length() == 0) {
			error.put("name", "請輸入您的店家名稱!");
		}
		if (acc_email == null || acc_email.trim().length() == 0) {
			error.put("acc_email", "請輸入您的帳號 或 email!");
		}
		if (psd == null || psd.trim().length() == 0) {
			error.put("psd", "請輸入您的密碼!");
		}
		if (tel == null || tel.trim().length() == 0) {
			error.put("tel", "請輸入您的連絡市話 !");
		}
		if (GUAR_CT == null || GUAR_CT.trim().length() == 0) {
			error.put("GUAR_CT", "請輸入您的住址(縣/市)");
		}
		if (GUAR_AR == null || GUAR_AR.trim().length() == 0) {
			error.put("GUAR_AR", "請輸入您的住址(區/鄉/鎮/市)");
		}
		if (GUAR_ROAD == null || GUAR_ROAD.trim().length() == 0) {
			error.put("GUAR_ROAD", "請輸入您的住址(路/街/巷)");
		}
		if (GUAR_NO == null || GUAR_NO.trim().length() == 0) {
			error.put("GUAR_NO", "請輸入您的住址(號)");
		}
		if (email2 == null || email2.trim().length() == 0) {
			error.put("email2", "請輸入您的備用email!");
		}
		if (Con_name == null || Con_name.trim().length() == 0) {
			error.put("Con_name", "請輸入您的聯絡人姓名!");
		}
		if (Con_cel == null || Con_cel.trim().length() == 0) {
			error.put("Con_cel", "請輸入您的輸入連絡人手機 !");
		}

		if (error != null && !error.isEmpty()) {
			request.getRequestDispatcher("/_06_Seller/SellerVisitor.jsp")
					.forward(request, response);
			return;
		}

		// 驗證資料
		// 按鈕 if("Insert".equals(prodaction) || "Update".equals(prodaction) ||
		// "Delete".equals(prodaction)) {

		// 有錯誤
		if (!error.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/SellerVisitor.jsp");
			rd.forward(request, response);
			return;
		}
		// 沒錯誤
		if (error.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/RegisterOK_toLogin.jsp");
			rd.forward(request, response);
			return;
		}

		// 呼叫model
		SellerVisitorBean bean = new SellerVisitorBean();
		bean.setAccount_UID(Account_UID);
		bean.setFEIN(FEIN);
		bean.setName(name);
		// 傳圖片有問題先註解 bean.setSeller_photo("Seller_photo");
		bean.setTel(tel);
		bean.setGUAR_CT(GUAR_CT);
		bean.setGUAR_AR(GUAR_AR);
		bean.setGUAR_ROAD(GUAR_ROAD);
		bean.setGUAR_NO(GUAR_NO);
		bean.setEmail2(email2);
		bean.setCon_name(Con_name);
		bean.setCon_cel(Con_cel);
		bean.setReceipts_metho(receipts_metho);
		bean.setIS_check(IS_check);
		bean.setIS_cooperation(IS_cooperation);
		bean.setInsdate(insdate);

		AccountBean bean1 = new AccountBean();
		bean1.setAcc_email("acc_email");
		bean1.setPsd("psd");

		// 根據model執行結果顯示view
		// if("Select".equals(prodaction)) {
		// List<SellerVisitorBean> result = sellerVisitorService.select(bean);
		// request.setAttribute("select", result);
		// request.getRequestDispatcher(
		// "/_06_Seller/SellerVisitor.jsp").forward(request, response);

		SellerVisitorBean result = sellerVisitorService.insert(bean);
		String result1 = registerServiceToAccount.insertAccount(bean1);

		// if(bean==null) {
		// error.put("password", "Login failed, please try again");
		// request.getRequestDispatcher(
		// "/page/login.jsp").forward(request, response);
		// } else {
		// HttpSession session = request.getSession();
		// session.setAttribute("user", bean);
		//
		// String path = request.getContextPath();
		// response.sendRedirect(path+"/index.jsp");
		// }
	}

	private Date parse(String temp4) {
		return null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
