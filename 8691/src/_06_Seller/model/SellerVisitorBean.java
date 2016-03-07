package _06_Seller.model;

import java.sql.Blob;
import java.util.Date;

public class SellerVisitorBean {
	private 	String	Account_UID;
	private		String	FEIN;
	private		String	name;
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
	private 	boolean	Seller_status;
	private 	int	    ship_price;
	private 	int	    lowest_price;
	private 	String	insdate;
	public String getAccount_UID() {
		return Account_UID;
	}
	public void setAccount_UID(String account_UID) {
		Account_UID = account_UID;
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
	public boolean isSeller_status() {
		return Seller_status;
	}
	public void setSeller_status(boolean seller_status) {
		Seller_status = seller_status;
	}
	public int getShip_price() {
		return ship_price;
	}
	public void setShip_price(int ship_price) {
		this.ship_price = ship_price;
	}
	public int getLowest_price() {
		return lowest_price;
	}
	public void setLowest_price(int lowest_price) {
		this.lowest_price = lowest_price;
	}
	public String getInsdate() {
		return insdate;
	}
	public void setInsdate(String insdate) {
		this.insdate = insdate;
	}
	public SellerVisitorBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerVisitorBean(String account_UID, String fEIN, String name, Blob seller_photo, String tel,
			String gUAR_CT, String gUAR_AR, String gUAR_ROAD, String gUAR_NO, String email2, String con_name,
			String con_cel, String receipts_metho, boolean iS_check, boolean seller_status, int ship_price,
			int lowest_price, String insdate) {
		super();
		Account_UID = account_UID;
		FEIN = fEIN;
		this.name = name;
		Seller_photo = seller_photo;
		this.tel = tel;
		GUAR_CT = gUAR_CT;
		GUAR_AR = gUAR_AR;
		GUAR_ROAD = gUAR_ROAD;
		GUAR_NO = gUAR_NO;
		this.email2 = email2;
		Con_name = con_name;
		Con_cel = con_cel;
		this.receipts_metho = receipts_metho;
		IS_check = iS_check;
		Seller_status = seller_status;
		this.ship_price = ship_price;
		this.lowest_price = lowest_price;
		this.insdate = insdate;
	}
	@Override
	public String toString() {
		return "SellerVisitorBean [Account_UID=" + Account_UID + ", FEIN=" + FEIN + ", name=" + name + ", Seller_photo="
				+ Seller_photo + ", tel=" + tel + ", GUAR_CT=" + GUAR_CT + ", GUAR_AR=" + GUAR_AR + ", GUAR_ROAD="
				+ GUAR_ROAD + ", GUAR_NO=" + GUAR_NO + ", email2=" + email2 + ", Con_name=" + Con_name + ", Con_cel="
				+ Con_cel + ", receipts_metho=" + receipts_metho + ", IS_check=" + IS_check + ", Seller_status="
				+ Seller_status + ", ship_price=" + ship_price + ", lowest_price=" + lowest_price + ", insdate="
				+ insdate + "]";
	}
	
	

	
	
	







}
