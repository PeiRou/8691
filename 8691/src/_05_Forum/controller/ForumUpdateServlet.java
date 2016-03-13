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
import _04_Member.model.MemberBean;
import _05_Forum.model.ForumBean;
import _05_Forum.model.ForumDAOJdbc;
import _05_Forum.model.ForumInsService;

@WebServlet(urlPatterns={"/forumUpdate.controller"})
public class ForumUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			
		//接收資料		
				String aa = request.getParameter("aa");
				System.out.println(aa);
				
				//String Forum_UID = request.getParameter("Forum_UID");
				//System.out.println(Forum_UID);
				
		//驗證資料// 轉型態
				
		//處理前面的資料驗證，有錯就先return
				
		//呼叫model	
//				ForumUpdateService forumUpdateService = new ForumUpdateService();
//				ForumBean bean2 = new ForumBean();
//				bean2.setStatus(1);
//				bean2.setForum_UID(Forum_UID);
//				forumUpdateService.update(bean2);
				
				ForumDAOJdbc forumDAOJdbc = new ForumDAOJdbc();
				forumDAOJdbc.update(1, aa);
				response.sendRedirect("/8691/_05_Forum/reportSuccess.jsp");  //localhost下的絕對路徑 (會改寫URL)
				
				//相對於servlet的路徑
//				RequestDispatcher rd = request.getRequestDispatcher("/_05_Forum/Forum.jsp");
//				rd.forward(request, response);

				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
