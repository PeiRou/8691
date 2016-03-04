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
	String RD = UUID.randomUUID().toString();
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String accountbean = (String) session.getAttribute("LoginOK");
			
		//接收資料		
				String comment = request.getParameter("comment");
				
		//驗證資料// 轉型態
				Map<String, String> error = new HashMap<String, String>();
				request.setAttribute("error", error);

				if(comment==null || comment.trim().length()==0) {
					error.put("comment", "請輸入您的留言,3秒後重新導入");
				}
				
				//處理前面的資料驗證，有錯就先return
				if (error!= null&&!error.isEmpty()) {
					//error.put("action", "註冊失敗");
					RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/testForum.jsp");
					rd.forward(request, response);
					return;
				
				}
				
		//呼叫model	
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				ForumBean bean = new ForumBean();
				bean.setForum_UID(RD);
				bean.setOrders_total_UID("521BA174-51A2-401F-A336-323FD0BB941C");
				bean.setMember_UID(accountbean);
				bean.setRating(1);
				bean.setComment(comment);
				bean.setInsdate(dateFormat.format(date).toString());
				ForumService.insertForum(bean);
				
				if (error!= null&&!error.isEmpty()) {
					RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/testForum.jsp");
					rd.forward(request, response);	
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/testForum.jsp");
					rd.forward(request, response);}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
