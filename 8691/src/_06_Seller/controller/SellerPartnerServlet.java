package _06_Seller.controller;

import java.io.*;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import _06_Seller.model.SellerPartnerBean;
import _06_Seller.model.SellerPartnerService;

@WebServlet("/page/partner.controller")
public class SellerPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static SimpleDateFormat mma = new SimpleDateFormat("yyyy-MM-dd");
	private SellerPartnerService sellerPartnerService = new SellerPartnerService();
	private RegisterServiceToAccount registerServiceToAccount = new RegisterServiceToAccount();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 接收資料
		String Account_UID = request.getParameter("Account_UID");
		String name = request.getParameter("name");
		String FEIN = request.getParameter("FEIN");
		String acc_email = request.getParameter("acc_email");
		String psd = request.getParameter("psd");
		String temp1 = request.getParameter("Seller_photo");
		String tel = request.getParameter("tel");
		String GUAR_CT = request.getParameter("GUAR_CT");
		String GUAR_AR = request.getParameter("GUAR_AR");
		String GUAR_ROAD = request.getParameter("GUAR_ROAD");
		String GUAR_NO = request.getParameter("GUAR_NO");
		String Con_name = request.getParameter("Con_name");
		String Con_cel = request.getParameter("Con_cel");
		String receipts_metho = request.getParameter("receipts_metho");
		String temp2 = request.getParameter("Seller_status");
		String temp3 = request.getParameter("Ship_price");
		String temp4 = request.getParameter("Lowest_price");
		String temp5 = request.getParameter("insdate");
		String prodaction = request.getParameter("prodaction");

		// 轉換資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

		Boolean Seller_status = null;
		if (temp2 != null && temp2.length() != 0) {
			try {
				Seller_status = Boolean.parseBoolean(temp2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("Seller_status", "Seller_status must true or flase");
			}
		}

		int Ship_price = 0;
		if (temp3 != null && temp3.length() != 0) {
			try {
				Ship_price = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("Ship_price", "Ship_price must true or flase");
			}
		}

		int Lowest_price = 0;
		if (temp4 != null && temp4.length() != 0) {
			try {
				Lowest_price = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("Lowest_price", "Lowest_price must true or flase");
			}
		}

		java.util.Date insdate = null;
		if (temp5 != null && temp5.length() != 0) {
			try {
				insdate = mma.parse(temp5);
			} catch (Exception e) {

				e.printStackTrace();
				error.put("insdate", "insdate must be a Date with yyyy-MM-dd");
			}

		}

		if (name == null || name.trim().length() == 0) {
			error.put("name", "請輸入您的店家名稱!");
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
		if (Con_name == null || Con_name.trim().length() == 0) {
			error.put("Con_name", "請輸入您的聯絡人姓名!");
		}
		if (Con_cel == null || Con_cel.trim().length() == 0) {
			error.put("Con_cel", "請輸入您的輸入連絡人手機 !");
		}


		// 驗證資料
		// if("Insert".equals(prodaction) || "Update".equals(prodaction) ||
		// "Delete".equals(prodaction)) {
		// 有錯誤
		if (!error.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/SellerPartner.jsp");
			rd.forward(request, response);
			return;
		}

		// 呼叫model
		// 要先能新增帳號到table
		AccountBean bean1 = new AccountBean();
		bean1.setAcc_email("acc_email");
		bean1.setPsd("psd");
		String result1 = registerServiceToAccount.insertAccount(bean1);

		SellerPartnerBean bean = null;
		//如果無法新增到帳號的table,則就不新增到店家的table裡
		if (result1 != null) {
			bean = new SellerPartnerBean();
			bean.setAccount_UID(result1);
			bean.setName(name);
			bean.setFEIN(FEIN);
			// 傳圖片有問題先註解 bean.setSeller_photo("Seller_photo");
			bean.setTel(tel);
			bean.setGUAR_CT(GUAR_CT);
			bean.setGUAR_AR(GUAR_AR);
			bean.setGUAR_ROAD(GUAR_ROAD);
			bean.setGUAR_NO(GUAR_NO);
			bean.setCon_name(Con_name);
			bean.setCon_cel(Con_cel);
			bean.setReceipts_metho(receipts_metho);
			bean.setSeller_status(Seller_status);
			bean.setShip_price(Ship_price);
			bean.setLowest_price(Lowest_price);
			bean.setInsdate(insdate);
		}else{
			error.put("UUID", "恭喜您中大獎了!!");
		}		
		
		SellerPartnerBean result = sellerPartnerService.insert(bean);
	
		//最後有error則回到原本填資料的頁面告訴使用者錯誤，然後重新操作
		if (error != null && !error.isEmpty()) {
			request.getRequestDispatcher("/_06_Seller/SellerPartner.jsp")
					.forward(request, response);
			return;
		}else{
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/SellerPartner.jsp");
			rd.forward(request, response);
			return;
		}
	}

	private Date parse(String temp5) {
		return null;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
