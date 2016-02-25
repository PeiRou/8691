package _00_Account.model;

public class ChangePsdService {

		private AccountDAO Dao = new AccountDAOjdbc();
		
		public boolean changePassword(String acc_email, String psd, String newPassword) {
			AccountBean bean = this.login(acc_email, psd);
			
			if(bean!=null) {
				if(newPassword!=null && newPassword.length()!=0) {
					Dao.update(bean.getAccount_UID(), newPassword, bean.getRole_ID(), acc_email);				
				}
			}
			return false;
		
			}

		public AccountBean login(String acc_mail, String psd) {
			AccountBean bean = Dao.select(acc_mail);
				if (bean != null && psd.equals(bean.getPsd())) {
		        	 return bean;
		        }
		     
			return null;
		}
//		public MemberBean login1(String acc_mail, String psd) {
//			MemberBean bean1 = Dao1.select(acc_mail);
//				if (bean1 != null && psd.equals(bean1.getPsd())) {
//		        	 return bean1;
//		        }
//		     
//			return null;
//		}
		
		public static void main(String[] args) {
			ChangePsdService service = new ChangePsdService();
			//AccountBean bean = service.login("Marcuslo@Foodmail.com", "111111");
			//System.out.println(bean);
			//service.changePassword("Marcuslo@Foodmail.com", "888888", "111111");
			service.changePassword("Marcuslo@Foodmail.com", "8888", "6666");
		}
	}
	

