package _01_Register.model;

import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;
import _04_Member.model.MemberDAOjdbc;

public class RegisterServiceToMember{
	
	private MemberDAO memberDao = new MemberDAOjdbc();
	public MemberBean insertMember(MemberBean bean) {
		MemberBean result = null;
		
		if(bean!=null) {
			result = memberDao.insert(bean);
		}
		return result;
	}
	

	}

