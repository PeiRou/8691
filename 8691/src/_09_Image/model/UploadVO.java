package _09_Image.model;

import java.io.InputStream;

public class UploadVO {
	private int id;
	private byte[] photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
