package _05_Forum.model;

import java.util.Date;

public class ForumBean {
	private	String	Forum_UID;
	private	String	account_UID;
	private	String seller_Name;
	private	String comment;
	private String insdate;
	private int commentNum;
	

	public ForumBean() {
	}
	
	public ForumBean(String Forum_UID, String account_UID, String seller_Name, String comment, String insdate, int commentNum) {
		super();
		this.Forum_UID = Forum_UID;
		this.account_UID = account_UID;
		this.seller_Name = seller_Name;
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
	public String getSeller_Name() {
		return seller_Name;
	}
	public void setSeller_Name(String seller_Name) {
		this.seller_Name = seller_Name;
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
		return "ForumBean [Forum_UID=" + Forum_UID + ", account_UID=" + account_UID + ", seller_Name=" + seller_Name
				+ ", comment=" + comment + ", insdate=" + insdate + ", commentNum=" + commentNum + "]";
	}
	
}
