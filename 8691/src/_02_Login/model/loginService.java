package _02_Login.model;
import _00_Account.model.AccountBean;
import _00_Account.model.AccountDAOjdbc;

public class loginService {
	
	AccountDAOjdbc dao= new AccountDAOjdbc();
	
	public AccountBean login(String acc_mail, String psd) {
		AccountBean bean = dao.select(acc_mail);
			if (bean != null && psd.equals(bean.getPsd())) {
	        	 return bean;
	        }else{System.out.println("error");}
	     
		return null;
	}

public static void main(String[] args) {
	loginService service = new loginService();
	AccountBean bean = service.login("Marcuslo@Foodmail.com", "6666");
	System.out.println(bean);
   }
//	
//service.changePassword("Ellen", "EEE", "E");
//}
}