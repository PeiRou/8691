package _02_Login.model;

import _04_Member.model.MemberBean;
import _04_Member.model.memberDAOjdbc;

public class loginService {
	
	memberDAOjdbc dao= new memberDAOjdbc();
	public MemberBean login(String acc_mail, String psd) {
		MemberBean bean = dao.select(acc_mail);
		if(bean!=null && psd.equals(bean.getPsd())) {
//			if(psd!=null && psd.trim().length()!=0) {
//				String pass = bean.getPsd();	
//				String temp = psd.toString();	
//				if(Arrays.equals(pass, temp)) {
					return bean;
				}
			
		return null;}
	
		
	public static void main(String[] args) {
		loginService service = new loginService();
		MemberBean bean = service.login("Marcuslo@Foodmail.com", "111111");
		System.out.println(bean);
		
		//service.changePassword("Ellen", "EEE", "E");
	}
}

