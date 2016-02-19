package _06_Seller.model;

import java.sql.Blob;
import java.util.Date;

public class SellerVisitorBean {
	public SellerVisitorBean(String FEIN, String name, String acc_email, String psd, Blob Seller_photo,
			String tel, String GUAR_CT, String GUAR_AR, String GUAR_ROAD, String GUAR_NO,String email2, 
			String Con_name, String Con_cel,String receipts_metho, boolean IS_check, boolean IS_cooperation, Date insdate) {
		
		this.FEIN=FEIN;
		this.name=name;
		this.acc_email=acc_email;
		this.psd=psd;
		this.Seller_photo=Seller_photo;
		this.tel=tel;
		this.GUAR_CT=GUAR_CT;
		this.GUAR_AR=GUAR_AR;
		this.GUAR_ROAD=GUAR_ROAD;
		this.GUAR_NO=GUAR_NO;
		this.email2=email2;
		this.Con_name=Con_name;
		this.Con_cel=Con_cel;
		this.receipts_metho=receipts_metho;
		this.IS_check=IS_check;
		this.IS_cooperation=IS_cooperation;
		this.insdate=insdate;
	}
	
	private		String	FEIN;
	private		String	name;
	private		String	acc_email;
	private		String	psd;
	private		Blob	Seller_photo;
	private		String	tel;
	private		String	GUAR_CT;
	private		String	GUAR_AR;
	private		String	GUAR_ROAD;
	private		String	GUAR_NO;
	private		String	email2;
	private		String	Con_name;
	private		String	Con_cel;
	private		String	receipts_metho;
	private		boolean	IS_check;
	private		boolean	IS_cooperation;
	private		java.util.Date	insdate;
	
	public SellerVisitorBean(){
		
	}

	public String getFEIN() {
		return FEIN;
	}

	public void setFEIN(String fEIN) {
		FEIN = fEIN;
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

	public Blob getSeller_photo() {
		return Seller_photo;
	}

	public void setSeller_photo(Blob seller_photo) {
		Seller_photo = seller_photo;
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

	public String getCon_name() {
		return Con_name;
	}

	public void setCon_name(String con_name) {
		Con_name = con_name;
	}

	public String getCon_cel() {
		return Con_cel;
	}

	public void setCon_cel(String con_cel) {
		Con_cel = con_cel;
	}

	public String getReceipts_metho() {
		return receipts_metho;
	}

	public void setReceipts_metho(String receipts_metho) {
		this.receipts_metho = receipts_metho;
	}

	public boolean isIS_check() {
		return IS_check;
	}

	public void setIS_check(boolean iS_check) {
		IS_check = iS_check;
	}

	public boolean isIS_cooperation() {
		return IS_cooperation;
	}

	public void setIS_cooperation(boolean iS_cooperation) {
		IS_cooperation = iS_cooperation;
	}

	public java.util.Date getInsdate() {
		return insdate;
	}

	public void setInsdate(java.util.Date insdate) {
		this.insdate = insdate;
	}

	@Override
	public String toString() {
		return "Seller_visitorBean [FEIN=" + FEIN + ", name=" + name + ", acc_email=" + acc_email + ", psd=" + psd
				+ ", Seller_photo=" + Seller_photo + ", tel=" + tel + ", GUAR_CT=" + GUAR_CT + ", GUAR_AR=" + GUAR_AR
				+ ", GUAR_ROAD=" + GUAR_ROAD + ", GUAR_NO=" + GUAR_NO + ", email2=" + email2 + ", Con_name=" + Con_name
				+ ", Con_cel=" + Con_cel + ", receipts_metho=" + receipts_metho + ", IS_check=" + IS_check
				+ ", IS_cooperation=" + IS_cooperation + ", insdate=" + insdate + "]";
	}
	
	
	







}
