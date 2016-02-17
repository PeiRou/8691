package _03_Orders.model;

import java.util.ArrayList;
import java.util.List;
import _03_Orders.model.OrdersTotalJDBC;

public class OrdersTotalService {
	private OrdersTotalJDBC ordersTotalDao = new OrdersTotalJDBC();
	public List<OrdersTotalBean> select(OrdersTotalBean bean) {
		List<OrdersTotalBean> result = null;
		if(bean!=null && bean.getFood_price()!=0) {  //Food_price為INT型態，此地方必須要判斷INT型態
			OrdersTotalBean temp = ordersTotalDao.select(bean.getOrders_total_UID());
			if(temp!=null) {
				result = new ArrayList<OrdersTotalBean>();
				result.add(temp);
			}
		} else {
			result = ordersTotalDao.select(); 
		}
		return result;
	}
	public OrdersTotalBean insert(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		if(bean!=null) {
			result = ordersTotalDao.insert(bean);
		}
		return result;
	}
	public OrdersTotalBean update(OrdersTotalBean bean) {
		OrdersTotalBean result = null;
		if(bean!=null) {
			result = ordersTotalDao.update(bean.getOrders_ID(), bean.getFood_ID(),
					bean.getDrink_name(), bean.getFood_count(), bean.getFood_original_price(),
					bean.getNote(), bean.getOrders_detail_UID());
		}
		return result;
	}
	public boolean delete(OrdersTotalBean bean) {
		if(bean!=null) {
			int i = ordersTotalDao.delete(bean.getOrders_ID());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		OrdersDetailService service = new OrdersDetailService();
		List<OrdersTotalBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
