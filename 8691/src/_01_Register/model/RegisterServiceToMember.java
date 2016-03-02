package _01_Register.model;

import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;
import _04_Member.model.MemberDAOjdbc;

public class RegisterServiceToMember{
	
	private MemberDAOjdbc memberDao = new MemberDAOjdbc();
	public MemberBean insertMember(MemberBean bean1) {
		MemberBean result = null;
		
		if(bean1!=null) {
			result = memberDao.insert(bean1);
		}
		return result;
	}
	

	}

