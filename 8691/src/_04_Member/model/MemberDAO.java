package _04_Member.model;

import java.sql.Blob;
import java.util.List;

public interface MemberDAO {

	MemberBean select(String acc_email);

	List<MemberBean> select();

	MemberBean update(
			String name,
			String acc_email,
			String psd,
			Blob Member_photo,
			String gender,
			String tel,
			String GUAR_CT,
			String GUAR_AR,
			String GUAR_ROAD,
			String GUAR_NO,
			String email2,
			String cel,
			java.util.Date insdate,
			String Member_ID);

	MemberBean insert(MemberBean bean);

	int delete(String Member_ID);

}