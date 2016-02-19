package _05_Forum.model;

import java.util.ArrayList;
import java.util.List;

public class ForumService {
	private ForumDAOJdbc forumDao = new ForumDAOJdbc();
	
	public List<ForumBean> select(ForumBean bean) {
		List<ForumBean> result = null;
		if(bean!=null && bean.getForum_UID().length()!=0) {
			ForumBean temp = forumDao.select(bean.getForum_UID());
			if(temp!=null) {
				result = new ArrayList<ForumBean>();
				result.add(temp);
			}
		} else {
			result = forumDao.select(); 
		}
		return result;
	}
	
	public ForumBean insert(ForumBean bean) {
		ForumBean result = null;
		if(bean!=null) {
			result = forumDao.insert(bean);
		}
		return result;
	}
	
	public ForumBean update(ForumBean bean) {
		ForumBean result = null;
		if(bean!=null) {
			result = forumDao.update(bean.getForum_UID(), bean.getOrders_total_UID(), 
					bean.getRatting(), bean.getComment(), bean.getInsdate(), bean.getMember_UID());
		}
		return result;
	}
	
	public boolean delete(ForumBean bean) {
		if(bean!=null) {
			int i = forumDao.delete(bean.getForum_UID());
			if(i==1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ForumService service = new ForumService();
		List<ForumBean> beans = service.select(null);
		System.out.println("beans=" + beans);
	}
}
