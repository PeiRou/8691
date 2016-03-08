package _05_Forum.model;

import java.util.Date;

public class ForumBean {
	private	String	Forum_UID;
	private	String	account_UID;
	private	int rating;
	private	String comment;
	private String insdate;
	private int commentNum;
	

	public ForumBean() {
	}
	
	public ForumBean(String Forum_UID, String account_UID, int rating, String comment, String insdate, int commentNum) {
		super();
		this.Forum_UID = Forum_UID;
		this.account_UID = account_UID;
		this.rating = rating;
		this.comment = comment;
		this.insdate = insdate;
		this.commentNum = commentNum;
	}
	
	
	public String getForum_UID() {
		return Forum_UID;
	}
	public void setForum_UID(String forum_UID) {
		this.Forum_UID = forum_UID;
	}
	public String getAccount_UID() {
		return account_UID;
	}
	public void setAccount_UID(String account_UID) {
		this.account_UID = account_UID;
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
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	@Override
	public String toString() {
		return "ForumBean [Forum_UID=" + Forum_UID + ", account_UID=" + account_UID + ", rating=" + rating
				+ ", comment=" + comment + ", insdate=" + insdate + ", commentNum=" + commentNum + "]";
	}
	
}
