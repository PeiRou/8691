package _05_Forum.model;


public class ForumUpdateService {
	private ForumDAOJdbc dao = new ForumDAOJdbc();
	
	public ForumBean update(ForumBean bean2) {
		ForumBean result = null;
		if(bean2!=null) {
			result = dao.update(
					bean2.getStatus(), bean2.getForum_UID()	
				);
		}
		return result;
	}
	
}
