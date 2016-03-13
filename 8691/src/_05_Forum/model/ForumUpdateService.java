package _05_Forum.model;


public class ForumUpdateService {
	private ForumDAOJdbc forumDao = new ForumDAOJdbc();
	public void updateForum(ForumBean bean2) {
		if(bean2!=null) {
			forumDao.update(bean2.getStatus(), bean2.getForum_UID());
		}
	}
	
}
