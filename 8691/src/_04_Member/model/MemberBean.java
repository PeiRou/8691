package _04_Member.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class MemberBean {
	private String account_UID;
	private String name;
	private String member_photo;
	private String gender;
	private String tel;
	private String GUAR_CT;
	private String GUAR_AR;
	private String GUAR_ROAD;
	private String GUAR_NO;
	private String email2;
	private String cel;
    private String insdate;
	
	public MemberBean(){};

	//未加入blob


	

	public MemberBean(String account_UID, String name, String member_photo, String gender, String tel, String gUAR_CT,
			String gUAR_AR, String gUAR_ROAD, String gUAR_NO, String email2, String cel, String insdate) {
		super();
		this.account_UID = account_UID;
		this.name = name;
		this.member_photo = member_photo;
		this.gender = gender;
		this.tel = tel;
		GUAR_CT = gUAR_CT;
		GUAR_AR = gUAR_AR;
		GUAR_ROAD = gUAR_ROAD;
		GUAR_NO = gUAR_NO;
		this.email2 = email2;
		this.cel = cel;
		this.insdate = insdate;
	}

	@Override
	public String toString() {
		return "MemberBean [account_UID=" + account_UID + ", name=" + name + ", member_photo=" + member_photo
				+ ", gender=" + gender + ", tel=" + tel + ", GUAR_CT=" + GUAR_CT + ", GUAR_AR=" + GUAR_AR
				+ ", GUAR_ROAD=" + GUAR_ROAD + ", GUAR_NO=" + GUAR_NO + ", email2=" + email2 + ", cel=" + cel
				+ ", insdate=" + insdate + "]";
	}

	public String getAccount_UID() {
		return account_UID;
	}

	public void setAccount_UID(String account_UID) {
		this.account_UID = account_UID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGUAR_CT() {
		return GUAR_CT;
	}

	public void setGUAR_CT(String gUAR_CT) {
		GUAR_CT = gUAR_CT;
	}

	public String getGUAR_AR() {
		return GUAR_AR;
	}

	public void setGUAR_AR(String gUAR_AR) {
		GUAR_AR = gUAR_AR;
	}

	public String getGUAR_ROAD() {
		return GUAR_ROAD;
	}

	public void setGUAR_ROAD(String gUAR_ROAD) {
		GUAR_ROAD = gUAR_ROAD;
	}

	public String getGUAR_NO() {
		return GUAR_NO;
	}

	public void setGUAR_NO(String gUAR_NO) {
		GUAR_NO = gUAR_NO;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getInsdate() {
		return insdate;
	}

	public void setInsdate(String insdate) {
		this.insdate = insdate;
	}

	public String getMember_photo() {
		return member_photo;
	}

	public void setMember_photo(String member_photo) {
		this.member_photo = member_photo;
	}


	

}


	

	
	
	/*public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//select
			MemberBean bean = (MemberBean) session.get(MemberBean.class, "Alex");
			System.out.println(bean);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
*/