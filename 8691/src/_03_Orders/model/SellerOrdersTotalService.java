package _03_Orders.model;

import java.util.ArrayList;
import java.util.List;
import _03_Orders.model.SellerOrdersTotalJDBC;

public class SellerOrdersTotalService {
	private SellerOrdersTotalJDBC sellerordersTotalDao = new SellerOrdersTotalJDBC();
	public List<OrdersTotalBean> select(OrdersTotalBean bean) {
		List<OrdersTotalBean> result = null;
		if(bean!=null && bean.getSeller_UID().length()!=0) {
			List<OrdersTotalBean> temp = sellerordersTotalDao.select(bean.getSeller_UID());
			if(temp!=null) {
				result = new ArrayList<OrdersTotalBean>();
				result.addAll(temp);
			}
		} else {
			//result = ordersTotalDao.select(); 
		}
		return result;
	}
//	public OrdersTotalBean insert(OrdersTotalBean bean) {
//		OrdersTotalBean result = null;
//		if(bean!=null) {
//			result = ordersTotalDao.insert(bean);
//			return result;
//		}
//		return null;
//	}
	public OrdersTotalBean update(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		if(bean!=null) {
			result = sellerordersTotalDao.update(bean.getStatus(), bean.getShip_price(),bean.getFood_price(),bean.getTotal_amount(), bean.getOrdersID());
		}
		return result;
	}
	public boolean delete(OrdersTotalBean bean) {
		if(bean!=null) {
			int i = sellerordersTotalDao.delete(bean.getOrdersID());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		SellerOrdersTotalService service = new SellerOrdersTotalService();
		List<OrdersTotalBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
