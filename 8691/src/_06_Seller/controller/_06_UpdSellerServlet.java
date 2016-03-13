package _06_Seller.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import _00_Account.model.AccountBean;
import _01_Register.model.RegisterServiceToAccount;
import _06_Seller.model.SellerVisitorBean;
import _06_Seller.model.SellerVisitorService;
import _06_Seller.model._06_Sellerjdbc;
import _11_ProdClass.dao._11_Imagejdbc;

@WebServlet(urlPatterns = { "/_06_Seller/_06_UpdSeller.controller" })
@MultipartConfig(location = "D:/workspace_proj/8691/WebContent/image/store/")
public class _06_UpdSellerServlet extends HttpServlet {
	private _06_Sellerjdbc sellerjdbc = new _06_Sellerjdbc();

	private SellerVisitorService sellerVisitorService = new SellerVisitorService();
	private RegisterServiceToAccount registerServiceToAccount = new RegisterServiceToAccount();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		String FEIN = request.getParameter("FEIN");
		String name = request.getParameter("name");
		String acc_email = request.getParameter("acc_email");
		String psd = request.getParameter("psd");
		String tel = request.getParameter("tel");
		String GUAR_CT = request.getParameter("GUAR_CT");
		String GUAR_AR = request.getParameter("GUAR_AR");
		String GUAR_ROAD = request.getParameter("GUAR_ROAD");
		String GUAR_NO = request.getParameter("GUAR_NO");
		String email2 = request.getParameter("email2");
		String Con_name = request.getParameter("Con_name");
		String Con_cel = request.getParameter("Con_cel");
		String receipts_metho = request.getParameter("receipts_metho");
		String Seller_status = request.getParameter("Seller_status");
		String temp4 = request.getParameter("Ship_price");
		String temp5 = request.getParameter("Lowest_price");
		String temp6 = request.getParameter("insdate");
		String action = request.getParameter("action");
		System.out.println("1");

		// 轉換資料
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);

		int Ship_price = 0;
		if (temp4 != null && temp4.length() != 0) {
			try {
				Ship_price = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("Ship_price", "Ship_price must true or flase");
			}
			System.out.println(temp4);
		}

		int Lowest_price = 0;
		if (temp5 != null && temp5.length() != 0) {
			try {
				Lowest_price = Integer.parseInt(temp5);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				error.put("Lowest_price", "Lowest_price must true or flase");
			}
			System.out.println(temp5);
		}

		if (FEIN == null || FEIN.trim().length() == 0) {
			error.put("FEIN", "請輸入您的統一編號!");
		}
		System.out.println(FEIN);
		if (name == null || name.trim().length() == 0) {
			error.put("name", "請輸入您的店家名稱!");
		}			
		if (tel == null || tel.trim().length() == 0) {
			error.put("tel", "請輸入您的連絡市話 !");
		}
		System.out.println(tel);
		if (GUAR_CT == null || GUAR_CT.trim().length() == 0) {
			error.put("GUAR_CT", "請輸入您的住址(縣/市)");
		}
		System.out.println(GUAR_CT);
		if (GUAR_AR == null || GUAR_AR.trim().length() == 0) {
			error.put("GUAR_AR", "請輸入您的住址(區/鄉/鎮/市)");
		}
		System.out.println(GUAR_AR);
		if (GUAR_ROAD == null || GUAR_ROAD.trim().length() == 0) {
			error.put("GUAR_ROAD", "請輸入您的住址(路/街/巷)");
		}
		System.out.println(GUAR_ROAD);
		if (GUAR_NO == null || GUAR_NO.trim().length() == 0) {
			error.put("GUAR_NO", "請輸入您的住址(號)");
		}
		System.out.println(GUAR_NO);
		if (email2 == null || email2.trim().length() == 0) {
			error.put("email2", "請輸入您的備用E-mail!");
		}
		System.out.println(email2);
		if (Con_name == null || Con_name.trim().length() == 0) {
			error.put("Con_name", "請輸入您的聯絡人姓名!");
		}
		System.out.println(Con_name);
		if (Con_cel == null || Con_cel.trim().length() == 0) {
			error.put("Con_cel", "請輸入您的輸入連絡人手機 !");
		}
		System.out.println(Con_cel);
		System.out.println("1");

		// 處理前面的資料驗證，有錯就先return
		if (error != null && !error.isEmpty()) {
			error.put("action", "修改失敗");
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/Seller.controller");
			rd.forward(request, response);
			return;
		}
		AccountBean bean = new AccountBean();
		bean.setAcc_email(acc_email);
		bean.setPsd(psd);
		bean.setRole_ID("101");

		String result = registerServiceToAccount.insertAccount(bean);

		// 呼叫model
		SellerVisitorBean bean1 = new SellerVisitorBean();
		if (result != null) {
			bean1.setAccount_UID(result);
			bean1.setFEIN(FEIN);
			bean1.setName(name);
			bean1.setTel(tel);
			bean1.setGUAR_CT(GUAR_CT);
			bean1.setGUAR_AR(GUAR_AR);
			bean1.setGUAR_ROAD(GUAR_ROAD);
			bean1.setGUAR_NO(GUAR_NO);
			bean1.setEmail2(email2);
			bean1.setCon_name(Con_name);
			bean1.setCon_cel(Con_cel);
			bean1.setReceipts_metho(receipts_metho);
			bean1.setSeller_status(Seller_status);
			bean1.setShip_price(Ship_price);
			bean1.setLowest_price(Lowest_price);
			bean1.setInsdate(dateFormat.format(date).toString());
		}

		SellerVisitorBean result1 = sellerVisitorService.update(bean1);

		System.out.println(result1);

		if (result1 == null && !error.isEmpty()) {
			error.put("action", "修改失敗了");
		}
		// 沒有錯誤
		if (error == null || error.isEmpty()) {
			System.out.println("error:"+error);
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/Seller.controller");
			rd.forward(request, response);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doGet(req, resp);
	}

}