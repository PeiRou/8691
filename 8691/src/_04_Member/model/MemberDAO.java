package _04_Member.model;

import java.sql.Blob;
import java.util.List;

public interface MemberDAO {

	MemberBean select(String account_UID);

	List<MemberBean> select();

	MemberBean update(
			//String member_ID,
			String name,
			String member_photo,
			String tel,
			String email2,
			String cel,
			//java.util.Date insdate,
			String account_UID);

	MemberBean insert(MemberBean bean);

	int delete(String acc_email);

}