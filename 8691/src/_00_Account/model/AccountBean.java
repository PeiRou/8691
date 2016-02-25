package _00_Account.model;


public class AccountBean {
		private String account_UID;
		private String acc_email;
		private String psd;
		private String role_ID;

		public AccountBean(){}

		public AccountBean(String account_UID,
				String acc_email, String psd, String role_ID) {
			super();
			this.account_UID= account_UID;
			this.acc_email = acc_email;
			this.psd = psd;
			this.role_ID = role_ID;
		}

		@Override
		public String toString() {
			return "AccountBean [account_UID=" + account_UID + ", acc_email=" + acc_email + ", psd=" + psd + ", role_ID="
					+ role_ID + "]";
		}

		public String getAccount_UID() {
			return account_UID;
		}

		public void setAccount_UID(String account_UID) {
			this.account_UID = account_UID;
		}

		public String getAcc_email() {
			return acc_email;
		}

		public void setAcc_email(String acc_email) {
			this.acc_email = acc_email;
		}

		public String getPsd() {
			return psd;
		}

		public void setPsd(String psd) {
			this.psd = psd;
		}

		public String getRole_ID() {
			return role_ID;
		}

		public void setRole_ID(String role_ID) {
			this.role_ID = role_ID;
		}

}
