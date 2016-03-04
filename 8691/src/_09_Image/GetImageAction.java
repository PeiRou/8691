package _09_Image;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import _09_Image.model.UploadService;
import _09_Image.model.UploadVO;

public class GetImageAction extends ActionSupport {
	private UploadVO bean = new UploadVO();

	public UploadVO getBean() {
		return bean;
	}

	public void setBeans(UploadVO bean) {
		this.bean = bean;
	}

	private UploadService uploadService = new UploadService();

	@Override
	public String execute() throws Exception {
		List<UploadVO> result = uploadService.select(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		byte[] inputbyte = result.get(0).getPhoto();
		OutputStream os = null;
		InputStream is = null;
		try {
			os = response.getOutputStream();
			is = new ByteArrayInputStream(inputbyte);
			int count = 0;
			byte[] bytes = new byte[1024];
			while ((count = is.read(bytes)) != -1) {
				os.write(bytes, 0, count);
			}
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}
		return Action.SUCCESS;
	}
}