package _00_Account.model;

public interface AccountDAO {

	AccountBean select(String acc_email);

	AccountBean selectRoleID(String acc_email);
	
	AccountBean update(
			String account_UID,
			String psd,
			String role_ID,
				//java.util.Date insdate,
			String acc_email);

	AccountBean insert(AccountBean bean);

	}