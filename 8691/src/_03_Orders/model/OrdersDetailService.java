package _03_Orders.model;

import java.util.ArrayList;
import java.util.List;
import _03_Orders.model.OrdersDetailJDBC;

public class OrdersDetailService {
	private OrdersDetailJDBC ordersDetaiDao = new OrdersDetailJDBC();
	public List<OrdersDetailBean> select(OrdersDetailBean bean) {
		List<OrdersDetailBean> result = null;
		if(bean!=null && bean.getOrdersID().length()!=0) {
			List<OrdersDetailBean> temp = ordersDetaiDao.select(bean.getOrdersID());
			if(temp!=null) {
				result = new ArrayList<OrdersDetailBean>();
				result.addAll(temp);
			}
		} 
		return result;
	}
//	public OrdersDetailBean insert(OrdersDetailBean bean) {
//		OrdersDetailBean result = null;
//		if(bean!=null) {
//			result = ordersDetaiDao.insert(bean);
//		}
//		return result;
//	}
//	public OrdersDetailBean update(OrdersDetailBean bean) {
//		OrdersDetailBean result = null;
//		if(bean!=null) {
//			result = ordersDetaiDao.update(bean.getOrders_ID(), bean.getFood_ID(),
//					bean.getDrink_name(), bean.getFood_count(), bean.getFood_original_price(),
//					bean.getNote(), bean.getOrders_detail_UID());
//		}
//		return result;
//	}
//	public boolean delete(OrdersDetailBean bean) {
//		if(bean!=null) {
//			int i = ordersDetaiDao.delete(bean.getOrders_ID());
//			if(i==1) {
//				return true;
//			}
//		}
//		return false;
//	}
	public static void main(String[] args) {
		OrdersDetailService service = new OrdersDetailService();
		List<OrdersDetailBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
