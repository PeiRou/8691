package _03_Orders.model;

import java.util.ArrayList;
import java.util.List;
import _03_Orders.model.OrdersTotalJDBC;

public class OrdersTotalService {
	private OrdersTotalJDBC ordersTotalDao = new OrdersTotalJDBC();
	public List<OrdersTotalBean> select(OrdersTotalBean bean) {
		List<OrdersTotalBean> result = null;
		if(bean!=null && bean.getOrdersID()!=0) {
			OrdersTotalBean temp = ordersTotalDao.select(bean.getOrdersID());
			System.out.println(bean);
			if(temp!=null) {
				result = new ArrayList<OrdersTotalBean>();
				result.add(temp);
			}
		} else {
			result = ordersTotalDao.select(); 
			System.out.println(bean);
		}
		return result;
	}
	public OrdersTotalBean insert(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		if(bean!=null) {
			result = ordersTotalDao.insert(bean);
			return result;
		}
		return null;
	}
	public OrdersTotalBean update(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		if(bean!=null) {
			result = ordersTotalDao.update(bean.getAccount_UID(), bean.getOrdersID() ,
					bean.getStatus(), bean.getName(), bean.getCel(), bean.getGUAR_CT(), bean.getGUAR_AR(),
					bean.getGUAR_ROAD(), bean.getGUAR_NO(), bean.getPay_metho(), bean.getInsdate(),
					bean.getShip_price(),bean.getFood_price(),bean.getTotal_amount(), bean.getOrders_total_UID());
		}
		return result;
	}
	public boolean delete(OrdersTotalBean bean) {
		if(bean!=null) {
			int i = ordersTotalDao.delete(bean.getOrdersID());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		OrdersTotalService service = new OrdersTotalService();
		List<OrdersTotalBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
