package _03_Orders.model;

import java.util.ArrayList;
import java.util.List;
import _03_Orders.model.OrdersDetailJDBC;

public class OrdersDetailService {
	private OrdersDetailJDBC ordersDetaiDao = new OrdersDetailJDBC();
	public List<OrdersDetailBean> select(OrdersDetailBean bean) {
		List<OrdersDetailBean> result = null;
		if(bean!=null && bean.getFood_ID()!=0) {//此地方需要INT型態，故選擇Food_ID
			OrdersDetailBean temp = ordersDetaiDao.select(bean.getOrders_ID());
			if(temp!=null) {
				result = new ArrayList<OrdersDetailBean>();
				result.add(temp);
			}
		} else {
			result = ordersDetaiDao.select(); 
		}
		return result;
	}
	public OrdersDetailBean insert(OrdersDetailBean bean) {
		OrdersDetailBean result = null;
		if(bean!=null) {
			result = ordersDetaiDao.insert(bean);
		}
		return result;
	}
	public OrdersDetailBean update(OrdersDetailBean bean) {
		OrdersDetailBean result = null;
		if(bean!=null) {
			result = ordersDetaiDao.update(bean.getOrders_ID(), bean.getFood_ID(),
					bean.getDrink_name(), bean.getFood_count(), bean.getFood_original_price(),
					bean.getNote(), bean.getOrders_detail_UID());
		}
		return result;
	}
	public boolean delete(OrdersDetailBean bean) {
		if(bean!=null) {
			int i = ordersDetaiDao.delete(bean.getOrders_ID());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		OrdersDetailService service = new OrdersDetailService();
		List<OrdersDetailBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
