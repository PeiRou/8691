package _12_UpdateInfo;

import _04_Member.model.MemberBean;
import _04_Member.model.MemberDAO;
import _04_Member.model.MemberDAOjdbc;

public class UpdateInfoService {
	private MemberDAO dao = new MemberDAOjdbc();
	
	public MemberBean update(MemberBean bean2) {
		MemberBean result = null;
		if(bean2!=null) {
			result = dao.update(
			bean2.getName(), bean2.getGender(),bean2.getTel(),bean2.getGUAR_CT(), bean2.getGUAR_AR(), 
			bean2.getGUAR_ROAD(),bean2.getGUAR_NO(), bean2.getEmail2(), bean2.getCel(),bean2.getAccount_UID()	
					
					);
		}
		return result;
	}


	}



	
