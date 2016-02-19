package _02_Login.model;

import _04_Member.model.memberDAOjdbc;
import _04_Member.model.MemberBean;

public class loginService {
	
	memberDAOjdbc dao= new memberDAOjdbc();
	
	public MemberBean login(String acc_mail, String psd) {
		MemberBean bean = dao.select(acc_mail);
			if (bean != null && psd.equals(bean.getPsd())) {
	        	 return bean;
	        }
	     
		return null;
	}

//public static void main(String[] args) {
//	loginService service = new loginService();
//	MemberBean bean = service.login("Marcuslo@Foodmail.com", "111111");
//	System.out.println(bean);
//	
//service.changePassword("Ellen", "EEE", "E");
//}
}