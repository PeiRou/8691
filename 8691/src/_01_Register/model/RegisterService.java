package _01_Register.model;

import _04_Member.controller.memberDAOjdbc;
import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;


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

