package _05_Forum.model;


public class ForumService {
	private ForumDAOJdbc forumDao = new ForumDAOJdbc();
	public void insertForum(ForumBean bean) {
		if(bean!=null) {
			forumDao.insert(bean);
		}
	}
	
}
