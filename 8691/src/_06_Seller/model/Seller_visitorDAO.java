package _06_Seller.model;

	import java.sql.Blob;
import java.util.List;

	public interface Seller_visitorDAO {

		Seller_visitorBean select(String FEIN);

		List<Seller_visitorBean> select();

		boolean update(String	FEIN, String name,String acc_email,String psd,Blob Seller_photo,String	tel,String	GUAR_CT,String	GUAR_AR,String	GUAR_AR_name,String	GUAR_NO,String	email2,String Con_name,String	Con_cel,String	receipts_metho,boolean IS_check,boolean IS_cooperation,java.util.Date insdate);

		Seller_visitorBean insert(Seller_visitorBean bean);

		int delete(String FEIN);

	}