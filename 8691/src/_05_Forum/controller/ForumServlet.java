package _05_Forum.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Account.model.AccountBean;
import _05_Forum.model.ForumBean;
import _05_Forum.model.ForumService;

@WebServlet(urlPatterns={"/forum.controller"})
public class ForumServlet extends HttpServlet {
	private ForumService ForumService = new ForumService();
	//String RD = UUID.randomUUID().toString();
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String accountbean = (String) session.getAttribute("LoginOK");
			
		//接收資料		
				String comment = request.getParameter("comment");
				String seller = request.getParameter("seller");
				
		//驗證資料// 轉型態
				Map<String, String> error = new HashMap<String, String>();
				request.setAttribute("error", error);

				if(comment !=null && accountbean==null) {
					error.put("comment", "對不起，請先登入");
				}else if(comment==null || comment.trim().length()==0){
					error.put("comment", "請輸入留言");
				}else if(seller==null){
					error.put("seller", "請選擇店家");
				}
				
				//處理前面的資料驗證，有錯就先return
				if (error!= null&&!error.isEmpty()) {
					RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/Forum.jsp");
					rd.forward(request, response);
					return;
				
				}
				
		//呼叫model	
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				ForumBean bean = new ForumBean();
				//bean.setForum_UID(RD);
				bean.setAccount_UID(accountbean);
				bean.setSeller_UID(seller);
				bean.setComment(comment);
				bean.setRating(3);
				bean.setInsdate(dateFormat.format(date).toString());
				ForumService.insertForum(bean);
				System.out.println(dateFormat.format(date).toString());
				if (error!= null&&!error.isEmpty()) {
					RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/Forum.jsp");
					rd.forward(request, response);	
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/Forum.jsp");
					rd.forward(request, response);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
