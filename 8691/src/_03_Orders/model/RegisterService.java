package model;

import DAO.memberDAOjdbc;


public class RegisterService{
	private MemberDAO memberDao = new memberDAOjdbc();
		
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		if(bean!=null) {
			result = memberDao.insert(bean);
		}
		return result;
	}
	

	}

