package _06_Seller.model;

import java.util.ArrayList;
import java.util.List;

import _06_Seller.model.SellerPartnerBean;
import _06_Seller.model.SellerPartnerJDBC;


public class SellerPartnerService {
	private SellerPartnerJDBC sellerPartnerDao = new SellerPartnerJDBC();
	public List<SellerPartnerBean> select(SellerPartnerBean bean) {
		List<SellerPartnerBean> result = null;
		if(bean!=null && bean.getSeller_partner_UID().length()!=0) {
			SellerPartnerBean temp = sellerPartnerDao.select(bean.getSeller_partner_UID());
			if(temp!=null) {
				result = new ArrayList<SellerPartnerBean>();
				result.add(temp);
			}
		} else {
			result = sellerPartnerDao.select(); 
		}
		return result;
	}
	public SellerPartnerBean insert(SellerPartnerBean bean) {
		SellerPartnerBean result = null;
		if(bean!=null) {
			result = sellerPartnerDao.insert(bean);
		}
		return result;
	}
	public SellerPartnerBean update(SellerPartnerBean bean) {
		SellerPartnerBean result = null;
		if(bean!=null) {
			result = sellerPartnerDao.update(bean.getSeller_ID(), bean.getName(), bean.getFEIN(),
					bean.getAcc_email(), bean.getPsd(), bean.getSeller_photo(),
					bean.getTel(), bean.getGUAR_CT(),bean.getGUAR_AR(),bean.getGUAR_AR_name(),
					bean.getGUAR_NO(), bean.getCon_name(), bean.getCon_cel(), bean.getReceipts_metho(),
					bean.getSeller_status(), bean.getIS_Food_Staple(), bean.getIS_Food_Drink(),
					bean.getInsdate(), bean.getSeller_partner_UID());
		}
		return result;
	}
	public boolean delete(SellerPartnerBean bean) {
		if(bean!=null) {
			int i = sellerPartnerDao.delete(bean.getSeller_partner_UID());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		SellerPartnerService service = new SellerPartnerService();
		List<SellerPartnerBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
