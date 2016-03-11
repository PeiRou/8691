package _09_Image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import _09_Image.model.UploadService;
import _09_Image.model.UploadVO;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport implements RequestAware, ServletRequestAware {
	// ServletRequestAware
	private int id;
	private File photo;
	private String production;
	private HttpServletRequest Request;
	private String userImageFileName;
	byte[] imageInByte = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	// 驗證資料
	@Override
	public void validate() {
		if ("Insert".equals(production) || "Update".equals(production)) {
			if (id == 0) {
				this.addFieldError("id", "id不可以輸入空白");
			}
			if (photo == null) {
				this.addFieldError("photo", "請選擇一個圖片");
			}
		}
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	private UploadVO bean = new UploadVO();
	private UploadService uploadService = new UploadService();

	@Override
	public String execute() throws Exception {
		bean.setId(id);
		if ("Select".equals(production)) {
			List<UploadVO> result = uploadService.select(bean);
			if (result == null) {
				return Action.INPUT;
			} else {
				request.put("select", result);
				return Action.SUCCESS;
			}
		} else if ("Insert".equals(production) && photo != null) {
			System.out.println("photo:"+photo);
			String Servletpath = Request.getServletContext().getRealPath("/");
			System.out.println("Servletpath:"+Servletpath);
			
			String photopath = "/image/store/"+ id +".png";
			File fin2 = new File(Servletpath+photopath);
			System.out.println("fin2:"+fin2);
			//toGIF(photo, fin2);
//			FileInputStream fin = new FileInputStream(photo);
			byte[] inputBytes = photopath.getBytes();
			bean.setPhoto(inputBytes);
			UploadVO result = null;
			//UploadVO result = uploadService.insert(bean);			
			if (result == null) {
				this.addFieldError("product.action", this.getText("prodact.failed"));
			} else {
				request.put("insert", result);
			}
			return Action.INPUT;
		} else if ("Update".equals(production) && photo != null) {
			toSaveRoot(photo, photo);
			FileInputStream fin = new FileInputStream(photo);
			byte[] inputBytes = IOUtils.toByteArray(fin);
			bean.setPhoto(inputBytes);

			UploadVO result = uploadService.update(bean);
			if (result == null) {
				this.addFieldError("product.action", this.getText("prodact.failed"));
			} else {
				request.put("update", result);
			}
			return Action.INPUT;
		} else {
			this.addFieldError("product.action", this.getText("prodact.Unknown"));
			return Action.INPUT;
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.Request = servletRequest;
	}

	public static void toSaveRoot(File img, File save) throws IOException {
		
		ImageIO.write((BufferedImage) getRoundedImage(img), "png", save);
	}

	private static Image getRoundedImage(File F) throws IOException {
		BufferedImage Bi = ImageIO.read(F);
		int BiWidth = Bi.getWidth();
		int BiHeight = Bi.getHeight();

		//2015/03/02修改成不壓縮
		/*double size = 146840.0; //超過此標準的圖將被壓縮
		if (BiWidth*BiHeight>size){
			double proportion = Math.sqrt(size / BiWidth / BiHeight);
			BiWidth = (int) (BiWidth * proportion);
			BiHeight = (int) (BiHeight * proportion);
		}*/
		
		BufferedImage resizedImage = new BufferedImage(BiWidth, BiHeight, Bi.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(Bi, 0, 0, BiWidth, BiHeight, null);
		g.dispose();

		return resizedImage;
	}
}
