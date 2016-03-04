package _05_Forum.model;

import java.util.Date;

public class ForumBean {
	private	String	Forum_UID;
	private	String	Orders_total_UID;
	private	String	Member_UID;
	private	int rating;
	private	String comment;
	private String insdate;
	
	public ForumBean() {
	}
	
	public ForumBean(String Forum_UID, String Orders_total_UID, String Member_UID, 
			int rating, String comment, String insdate) {
		super();
		this.Forum_UID = Forum_UID;
		this.Orders_total_UID = Orders_total_UID;
		this.Member_UID = Member_UID;
		this.rating = rating;
		this.comment = comment;
		this.insdate = insdate;
	}
	
//	public ForumBean(String comment, String insdate) {
//		super();
//		this.comment = comment;
//		this.insdate = insdate;
//	}
	
	
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getInsdate() {
		return insdate;
	}
	public void setInsdate(String insdate) {
		this.insdate = insdate;
	}
	
	
	@Override
	public String toString() {
		return "ForumBean [Forum_UID=" + Forum_UID + ", Orders_total_UID=" + Orders_total_UID + ", Member_UID=" + Member_UID + ", rating=" + rating
				+ ", comment=" + comment + ", insdate=" + insdate + "]";
	}
	
	
}
