package _08_GetStore;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		urlPatterns={"/_07_Shops/Shops.controller"}
		)
public class _08_GetProdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp1 = request.getParameter("AccountUID");

		System.out.println("temp1:"+temp1);
		if (temp1 != null && !temp1.isEmpty()) {
			request.setAttribute("StoreUID", temp1);
		}
		request.getRequestDispatcher(
				"/_07_Shops/Shops.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
