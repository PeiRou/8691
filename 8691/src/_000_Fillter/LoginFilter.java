package _000_Fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import _00_Account.model.AccountBean;



//@WebFilter("/_04_Members/*")
public class LoginFilter implements Filter {

	private FilterConfig filterConfig;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest)req;
//		HttpServletResponse response = (HttpServletResponse)resp;
//		HttpSession session = request.getSession();
//		AccountBean bean = (AccountBean) session.getAttribute("role_ID");
//		if(bean!=null){
//			chain.doFilter(request, response);
//		}else{
//			String uri = request.getRequestURI();
//			session.setAttribute("dest", uri);
//			
//			String path = request.getContextPath();
//			response.sendRedirect(path+"/_02_Login/Login.jsp");
//		}
	}

	@Override
	public void destroy() {

	}

}
