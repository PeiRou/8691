package _xxx_Maintenance;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Account.model.AccountBean;

@WebFilter(
		urlPatterns = {"/_xxx_Maintenance/*"} 
//		initParams = { 
//				@WebInitParam(name = "Forum", value = "/_05_Forum/*"), 
//				@WebInitParam(name = "member", value = "/_04_Members/*"),
//				@WebInitParam(name = "Maintenance", value = "/_xxx_Maintenance/*")
//			
//		}
		)
public class MaintenanceEntryFilter implements Filter {
	private FilterConfig filterConfig;
@Override
public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

@Override
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
       HttpServletRequest request = (HttpServletRequest) req;
       HttpServletResponse response = (HttpServletResponse) resp;

HttpSession session = request.getSession();
String bean= (String) session.getAttribute("roleID");
System.out.println(bean);
		if(!bean.equals(0000)){
			chain.doFilter(request, response);
			}else{
		    String path = request.getContextPath();
			response.sendRedirect(path+"/_xxx_Maintenance/MaintenancePage.jsp");
			} 
		}
@Override
public void destroy() {
		
	}

}

