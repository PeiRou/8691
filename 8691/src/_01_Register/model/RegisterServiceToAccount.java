package _01_Register.model;

import _00_Account.model.AccountBean;
import _00_Account.model.AccountDAO;
import _00_Account.model.AccountDAOjdbc;

public class RegisterServiceToAccount {

	private AccountDAO accountDao = new AccountDAOjdbc();
	public String insertAccount(AccountBean bean1) {
		String result = null;
		
		if(bean1!=null) {
			result = accountDao.insert(bean1);
		}
		return result;
	}
	

	}

