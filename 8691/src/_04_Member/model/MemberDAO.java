package _04_Member.model;

import java.sql.Blob;
import java.util.List;

public interface MemberDAO {

	MemberBean select(String acc_email);

	List<MemberBean> select();

	MemberBean update(
			//String member_ID,
			String name,
			//Blob member_photo,
			String gender,
			String tel,
			String GUAR_CT,
			String GUAR_AR,
			String GUAR_ROAD,
			String GUAR_NO,
			String email2,
			String cel,
			//java.util.Date insdate,
			String account_UID);

	MemberBean insert(MemberBean bean);

	int delete(String acc_email);

//	MemberBean selectName(String name);

}