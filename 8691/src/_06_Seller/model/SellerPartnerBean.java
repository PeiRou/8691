package _06_Seller.model;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Date;

public class SellerPartnerBean {
	private 	String	Account_UID;
	private 	String	Seller_ID;
	private 	String	name;
	private 	String	FEIN;
	private 	String	acc_email;
	private 	String	psd;    //有時間再改為Byte[]
	private 	Blob	Seller_photo;
	private 	String	tel;
	private 	String	GUAR_CT;
	private 	String	GUAR_AR;
	private 	String	GUAR_ROAD;
	private 	String	GUAR_NO;
	private 	String	Con_name;
	private 	String	Con_cel;
	private 	String	receipts_metho;
	private 	boolean	Seller_status;
	private 	boolean	IS_Food_Staple;
	private 	boolean	IS_Food_Drink;
	private 	java.util.Date	insdate;
	
	
	public String getAccount_UID() {
		return Account_UID;
	}
	public void setAccount_UID(String account_UID) {
		Account_UID = account_UID;
	}
	public String getSeller_ID() {
		return Seller_ID;
	}
	public void setSeller_ID(String seller_ID) {
		Seller_ID = seller_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFEIN() {
		return FEIN;
	}
	public void setFEIN(String fEIN) {
		FEIN = fEIN;
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
	public boolean getSeller_status() {
		return Seller_status;
	}
	public void setSeller_status(boolean seller_status) {
		Seller_status = seller_status;
	}
	public boolean getIS_Food_Staple() {
		return IS_Food_Staple;
	}
	public void setIS_Food_Staple(boolean iS_Food_Staple) {
		IS_Food_Staple = iS_Food_Staple;
	}
	public boolean getIS_Food_Drink() {
		return IS_Food_Drink;
	}
	public void setIS_Food_Drink(boolean iS_Food_Drink) {
		IS_Food_Drink = iS_Food_Drink;
	}
	public java.util.Date getInsdate() {
		return insdate;
	}
	public void setInsdate(java.util.Date insdate) {
		this.insdate = insdate;
	}
	public SellerPartnerBean(String Account_UID, String Seller_ID, String name, String FEIN, String acc_email,
			String psd, Blob Seller_photo, String tel, String GUAR_CT, String GUAR_AR, String GUAR_ROAD,
			String GUAR_NO, String Con_name, String Con_cel, String receipts_metho, boolean Seller_status,
			boolean IS_Food_Staple, boolean IS_Food_Drink, Date insdate) {
		super();		
		this.Seller_ID = Seller_ID;
		this.name = name;
		this.FEIN = FEIN;
		this.acc_email = acc_email;
		this.psd = psd;
		this.Seller_photo = Seller_photo;
		this.tel = tel;
		this.GUAR_CT = GUAR_CT;
		this.GUAR_AR = GUAR_AR;
		this.GUAR_ROAD = GUAR_ROAD;
		this.GUAR_NO = GUAR_NO;
		this.Con_name = Con_name;
		this.Con_cel = Con_cel;
		this.receipts_metho = receipts_metho;
		this.Seller_status = Seller_status;
		this.IS_Food_Staple = IS_Food_Staple;
		this.IS_Food_Drink = IS_Food_Drink;
		this.insdate = insdate;
		this.Account_UID = Account_UID;
	}
	public SellerPartnerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SellerPartnerBean [account_UID=" + Account_UID + ", Seller_ID=" + Seller_ID + ", name="
				+ name + ", FEIN=" + FEIN + ", acc_email=" + acc_email + ", psd=" + psd + ", Seller_photo="
				+ Seller_photo + ", tel=" + tel + ", GUAR_CT=" + GUAR_CT + ", GUAR_AR=" + GUAR_AR + ", GUAR_ROAD="
				+ GUAR_ROAD + ", GUAR_NO=" + GUAR_NO + ", Con_name=" + Con_name + ", Con_cel=" + Con_cel
				+ ", receipts_metho=" + receipts_metho + ", Seller_status=" + Seller_status + ", IS_Food_Staple="
				+ IS_Food_Staple + ", IS_Food_Drink=" + IS_Food_Drink + ", insdate=" + insdate + "]";
	}
	
	
	
	
	
	
	
	
}
