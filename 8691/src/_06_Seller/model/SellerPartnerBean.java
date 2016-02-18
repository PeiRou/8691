package _06_Seller.model;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Date;

public class SellerPartnerBean {
	private 	String	Seller_partner_UID;
	private 	String	Seller_ID;
	private 	String	name;
	private 	String	FEIN;
	private 	String	acc_email;
	private 	Byte[]	psd;
	private 	Blob	Seller_photo;
	private 	String	tel;
	private 	String	GUAR_CT;
	private 	String	GUAR_AR;
	private 	String	NB_CODE;
	private 	String	GUAR_NO;
	private 	String	Con_name;
	private 	String	Con_cel;
	private 	String	receipts_metho;
	private 	String	Seller_status;
	private 	String	IS_Food_Staple;
	private 	String	IS_Food_Drink;
	private 	java.util.Date	insdate;
	
	public SellerPartnerBean(String seller_partner_UID, String seller_ID, String name, String fEIN, String acc_email,
			Byte[] psd, Blob seller_photo, String tel, String gUAR_CT, String gUAR_AR, String nB_CODE, String gUAR_NO,
			String con_name, String con_cel, String receipts_metho, String seller_status, String iS_Food_Staple,
			String iS_Food_Drink, Date insdate) {
		super();
		Seller_partner_UID = seller_partner_UID;
		Seller_ID = seller_ID;
		this.name = name;
		FEIN = fEIN;
		this.acc_email = acc_email;
		this.psd = psd;
		Seller_photo = seller_photo;
		this.tel = tel;
		GUAR_CT = gUAR_CT;
		GUAR_AR = gUAR_AR;
		NB_CODE = nB_CODE;
		GUAR_NO = gUAR_NO;
		Con_name = con_name;
		Con_cel = con_cel;
		this.receipts_metho = receipts_metho;
		Seller_status = seller_status;
		IS_Food_Staple = iS_Food_Staple;
		IS_Food_Drink = iS_Food_Drink;
		this.insdate = insdate;
	}
	public SellerPartnerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SellerPartnerBean [Seller_partner_UID=" + Seller_partner_UID + ", Seller_ID=" + Seller_ID + ", name="
				+ name + ", FEIN=" + FEIN + ", acc_email=" + acc_email + ", psd=" + Arrays.toString(psd)
				+ ", Seller_photo=" + Seller_photo + ", tel=" + tel + ", GUAR_CT=" + GUAR_CT + ", GUAR_AR=" + GUAR_AR
				+ ", NB_CODE=" + NB_CODE + ", GUAR_NO=" + GUAR_NO + ", Con_name=" + Con_name + ", Con_cel=" + Con_cel
				+ ", receipts_metho=" + receipts_metho + ", Seller_status=" + Seller_status + ", IS_Food_Staple="
				+ IS_Food_Staple + ", IS_Food_Drink=" + IS_Food_Drink + ", insdate=" + insdate + "]";
	}

	
}
