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

import _03_Orders.model.OrdersTotalBean;
import _06_Seller.model.SellerVisitorBean;
import _06_Seller.model.SellerVisitorService;

@WebServlet("/page/visitor.controller")
public class SellerVisitorServlet extends HttpServlet {
	private static SimpleDateFormat mma = new SimpleDateFormat("yyyy-MM-dd");
	private SellerVisitorService sellerVisitorService = new SellerVisitorService();
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
//	System.out.println("!");
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String Account_UID =request.getParameter("Account_UID");
		String FEIN = request.getParameter("FEIN");
		String name = request.getParameter("name");
		
		String temp1 = request.getParameter("Seller_photo");
		String tel = request.getParameter("tel");
		String GUAR_CT = request.getParameter("GUAR_CT");
		String GUAR_AR = request.getParameter("GUAR_AR");
		String GUAR_ROAD = request.getParameter("GUAR_ROAD");
		String GUAR_NO = request.getParameter("GUAR_NO");
		String email2 = request.getParameter("email2");
		String Con_name = request.getParameter("Con_name");
		String Con_cel= request.getParameter("Con_cel");
		String receipts_metho= request.getParameter("receipts_metho");
		String temp2= request.getParameter("IS_check");
		String temp3= request.getParameter("IS_cooperation");
		String temp4 = request.getParameter("insdate");
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
				Boolean IS_check = null;
				if(temp2!=null && temp2.length()!=0) {
					try {
						IS_check = Boolean.parseBoolean(temp2);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("IS_check", "IS_check must true or flase");
					}
				}
				
				Boolean IS_cooperation = null;
				if(temp3!=null && temp3.length()!=0) {
					try {
						IS_cooperation = Boolean.parseBoolean(temp3);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						error.put("IS_cooperation", "IS_check must true or flase");
					}
				}
				
				java.util.Date insdate = null;
				if(temp4!=null && temp4.length()!=0) {
					try {
						insdate = mma.parse(temp4);
					} catch (Exception e) {
						
						e.printStackTrace();
						error.put("insdate", "insdate must be a Date with yyyy-MM-dd");
					}
			
					}
				
				if(name==null || name.trim().length()==0) {
					error.put("name", "Please enter name to register");
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
				if(email2==null || email2.trim().length()==0) {
					error.put("email2", "Please enter email2 to register");
				}
				if(Con_name==null || Con_name.trim().length()==0) {
					error.put("Con_name", "Please enter Con_name to register");
				}
				if(Con_cel==null || Con_cel.trim().length()==0) {
					error.put("Con_cel", "Please enter Con_cel to register");
				}
				
				if(error!=null && !error.isEmpty()){
					request.getRequestDispatcher(
							"/page/visitor.jsp").forward(request, response);
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
							"/page/visitor.jsp").forward(request, response);
					return;
				}		
		//呼叫model
				SellerVisitorBean bean = new SellerVisitorBean();
				bean.setAccount_UID("Account_UID");
				bean.setFEIN("FEIN");
				bean.setName("name");

//傳圖片有問題先註解	bean.setSeller_photo("Seller_photo");
				bean.setTel("tel");
				bean.setGUAR_CT("GUAR_CT");
				bean.setGUAR_AR("GUAR_AR");
				bean.setGUAR_ROAD("GUAR_ROAD");
				bean.setGUAR_NO("GUAR_NO");				
				bean.setEmail2("email2");
				bean.setCon_name("Con_name");					
				bean.setCon_cel("Con_cel");
				bean.setReceipts_metho("receipts_metho");				
				bean.setIS_check(IS_check);
				bean.setIS_cooperation(IS_cooperation);
				bean.setInsdate(insdate);
				
		//根據model執行結果顯示view
				if("Select".equals(prodaction)) {
					List<SellerVisitorBean> result = sellerVisitorService.select(bean);
					request.setAttribute("select", result);
					request.getRequestDispatcher(
							"/page/visitor.jsp").forward(request, response);
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
	
	
		private Date parse(String temp4) {
		return null;
	}
			@Override
			protected void doPost(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException, IOException {
				this.doGet(req, resp);
			}
		}
