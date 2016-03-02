package _01_Register.model;

import _00_Account.model.AccountBean;
import _00_Account.model.AccountDAO;
import _00_Account.model.AccountDAOjdbc;

public class RegisterServiceToAccount {

	private AccountDAOjdbc accountDao = new AccountDAOjdbc();
	public String insertAccount(AccountBean bean) {
		String result1 = null;
		
		if(bean!=null) {
			result1 = accountDao.insert(bean);
		}
		return result1;
	}
	

	}

