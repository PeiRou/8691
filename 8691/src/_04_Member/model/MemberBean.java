package _04_Member.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class MemberBean {
	private String Member_UID;
	private String Member_ID;
	private String name;
	private String acc_email;
	private String psd;
	private Blob Member_photo;
	private String gender;
	private String tel;
	private String GUAR_CT;
	private String GUAR_AR;
	private String GUAR_ROAD;
	private String GUAR_NO;
	private String email2;
	private String cel;
	private java.util.Date insdate;

	
	public MemberBean(){};

	
	public MemberBean(String name, String acc_email, String psd,
			String gender, String tel, String gUAR_CT, String gUAR_AR, String gUAR_ROAD, String gUAR_NO, String email2,
			String cel, java.util.Date insdate) {
		super();
		
		this.name = name;
		this.acc_email = acc_email;
		this.psd = psd;
		this.gender = gender;
		this.tel = tel;
		GUAR_CT = gUAR_CT;
		GUAR_AR = gUAR_AR;
		GUAR_ROAD = gUAR_ROAD;
		GUAR_NO = gUAR_NO;
		this.email2 = email2;
		this.cel = cel;
		this.insdate=insdate;
	}
	
	

	@Override
	public String toString() {
		return "MemberBean [Member_UID=" + Member_UID + ", Member_ID=" + Member_ID + ", name=" + name + ", acc_email="
				+ acc_email + ", psd=" + psd + ", Member_photo=" + Member_photo + ", gender=" + gender + ", tel=" + tel
				+ ", GUAR_CT=" + GUAR_CT + ", GUAR_AR=" + GUAR_AR + ", GUAR_ROAD=" + GUAR_ROAD + ", GUAR_NO=" + GUAR_NO
				+ ", email2=" + email2 + ", cel=" + cel + ", insdate=" + insdate + "]";
	}

	public String getMember_UID() {
		return Member_UID;
	}
	public void setMember_UID(String member_UID) {
		Member_UID = member_UID;
	}
	public String getMember_ID() {
		return Member_ID;
	}
	public void setMember_ID(String member_ID) {
		Member_ID = member_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcc_email() {
		return acc_email;
	}
	public void setAcc_email(String acc_email) {
		this.acc_email = acc_email;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public Blob getMember_photo() {
		return Member_photo;
	}
	public void setMember_photo(Blob member_photo) {
		Member_photo = member_photo;
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


	public java.util.Date getInsdate() {
		return insdate;
	}


	public void setInsdate(java.util.Date insdate) {
		this.insdate = insdate;
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