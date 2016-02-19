package _05_Forum.model;

import java.util.Date;

public class ForumBean {
	private	String	Forum_UID;
	private	String	Orders_total_UID;
	private	String	Member_UID;
	private	int ratting;
	private	String comment;
	private java.util.Date insdate;
	
	public String getForum_UID() {
		return Forum_UID;
	}
	public void setForum_UID(String forum_UID) {
		Forum_UID = forum_UID;
	}
	public String getOrders_total_UID() {
		return Orders_total_UID;
	}
	public void setOrders_total_UID(String orders_total_UID) {
		Orders_total_UID = orders_total_UID;
	}
	public String getMember_UID() {
		return Member_UID;
	}
	public void setMember_UID(String member_UID) {
		Member_UID = member_UID;
	}
	public int getRatting() {
		return ratting;
	}
	public void setRatting(int ratting) {
		this.ratting = ratting;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public java.util.Date getInsdate() {
		return insdate;
	}
	public void setInsdate(java.util.Date insdate) {
		this.insdate = insdate;
	}
	
	public ForumBean(String Forum_UID, String Orders_total_UID, String Member_UID, 
			int ratting, String comment, Date insdate) {
		super();
		this.Forum_UID = Forum_UID;
		this.Orders_total_UID = Orders_total_UID;
		this.Member_UID = Member_UID;
		this.ratting = ratting;
		this.comment = comment;
		this.insdate = insdate;
		
	}
	public ForumBean() {
		super();
	}
	
	@Override
	public String toString() {
		return "ForumBean [Forum_UID=" + Forum_UID + ", Orders_total_UID=" + Orders_total_UID + ", Member_UID=" + Member_UID + ", ratting=" + ratting
				+ ", comment=" + comment + ", insdate=" + insdate + "]";
	}
	
	
	
	
	
	
	
	
}
