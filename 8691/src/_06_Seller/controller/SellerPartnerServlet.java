package _06_Seller.controller;

import java.io.*;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _06_Seller.model.SellerPartnerBean;
import _06_Seller.model.SellerPartnerService;

@WebServlet("/page/partner.controller")
public class SellerPartnerServlet extends HttpServlet {
	private static SimpleDateFormat mma = new SimpleDateFormat("yyyy-MM-dd");
	private SellerPartnerService sellerPartnerService = new SellerPartnerService();
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String Account_UID =request.getParameter("Account_UID");
		String Seller_ID =request.getParameter("Seller_ID");
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
		String Con_cel= request.getParameter("Con_cel");
		String receipts_metho= request.getParameter("receipts_metho");	
		String temp2= request.getParameter("Seller_status");
		String temp3= request.getParameter("IS_Food_Staple");
		String temp4= request.getParameter("IS_Food_Drink");
		String temp5 = request.getParameter("insdate");
		String prodaction = request.getParameter("prodaction");
		
		//轉換資料
				Map<String, String> error = new HashMap<String, String>();
				request.setAttribute("error", error);

//傳圖片有問題先註解	Blob Seller_photo = new Blob();
//				if(temp1!=null && temp1.length()!=0) {
//					try {
//						Seller_photo = Blob.parseBlob(temp1);
//						
//					} catch (NumberFormatException e) {
//						e.printStackTrace();
//						error.put("Seller_photo", "Id must be an integer");
//					}
//				}
				Boolean Seller_status = null;
				if(temp2!=null && temp2.length()!=0) {
					try {
						Seller_status = Boolean.parseBoolean(temp2);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("Seller_status", "Seller_status must true or flase");
					}
				}
				
				Boolean IS_Food_Staple = null;
				if(temp3!=null && temp3.length()!=0) {
					try {
						IS_Food_Staple = Boolean.parseBoolean(temp3);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("IS_Food_Staple", "IS_Food_Staple must true or flase");
					}
				}
				
				Boolean IS_Food_Drink = null;
				if(temp4!=null && temp4.length()!=0) {
					try {
						IS_Food_Drink = Boolean.parseBoolean(temp4);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("IS_Food_Drink", "IS_Food_Drink must true or flase");
					}
				}
				
				java.util.Date insdate = null;
				if(temp5!=null && temp5.length()!=0) {
					try {
						insdate = mma.parse(temp5);
					} catch (Exception e) {
						
						e.printStackTrace();
						error.put("insdate", "insdate must be a Date with yyyy-MM-dd");
					}
			
					}
				

				
				if(name==null || name.trim().length()==0) {
					error.put("name", "Please enter name to register");
				}
				if(acc_email==null || acc_email.trim().length()==0) {
					error.put("acc_email", "Please enter acc_email to register");
				}
				if(psd==null || psd.trim().length()==0) {
					error.put("psd", "Please enter password to login");
				}
				
				if(tel==null || tel.trim().length()==0) {
					error.put("tel", "Please enter tel to register");
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
				if(Con_name==null || Con_name.trim().length()==0) {
					error.put("Con_name", "Please enter Con_name to register");
				}
				if(Con_cel==null || Con_cel.trim().length()==0) {
					error.put("Con_cel", "Please enter Con_cel to register");
				}
				
				if(error!=null && !error.isEmpty()){
					request.getRequestDispatcher(
							"/page/partner.jsp").forward(request, response);
					return;
				}
				
		//驗證資料				
				if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
					if(name==null) {
						error.put("name", "Please enter Id for "+prodaction);
					}
				}
				if(error!=null && !error.isEmpty()){
					request.getRequestDispatcher(
							"/page/partner.jsp").forward(request, response);
					return;
				}		
		//呼叫model
				SellerPartnerBean bean = new SellerPartnerBean();
				bean.setAccount_UID("Account_UID");
				bean.setSeller_ID("Seller_ID");
				bean.setName("name");
				bean.setFEIN("FEIN");
				bean.setAcc_email("acc_email");
				bean.setPsd("psd");
//				bean.setSeller_photo("Seller_photo");
				bean.setTel("tel");
				bean.setGUAR_CT("GUAR_CT");
				bean.setGUAR_AR("GUAR_AR");
				bean.setGUAR_ROAD("GUAR_ROAD");
				bean.setGUAR_NO("GUAR_NO");				
				bean.setCon_name("Con_name");					
				bean.setCon_cel("Con_cel");
				bean.setReceipts_metho("receipts_metho");				
				bean.setSeller_status(Seller_status);
				bean.setIS_Food_Staple(IS_Food_Staple);
				bean.setIS_Food_Drink(IS_Food_Drink);
				bean.setInsdate(insdate);
				
		//根據model執行結果顯示view
				if("Select".equals(prodaction)) {
					List<SellerPartnerBean> result = sellerPartnerService.select(bean);
					request.setAttribute("select", result);
					request.getRequestDispatcher(
							"/page/partner.jsp").forward(request, response);
//				if(bean==null) {
//					error.put("password", "Login failed, please try again");
//					request.getRequestDispatcher(
//							"/page/login.jsp").forward(request, response);
//				} else {
//					HttpSession session = request.getSession();
//					session.setAttribute("user", bean);
//		
//					String path = request.getContextPath();
//					response.sendRedirect(path+"/index.jsp");
//				}
			}
	}
	
	
		private Date parse(String temp5) {
		return null;
	}
			@Override
			protected void doPost(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException, IOException {
				this.doGet(req, resp);
			}
		}
