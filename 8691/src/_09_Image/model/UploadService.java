package _09_Image.model;

import java.util.ArrayList;
import java.util.List;

import _09_Image.model.dao.UploadDAO;
import _09_Image.model.dao.Uploadjdbc;

public class UploadService {
	private UploadDAO uploadDAO = new Uploadjdbc();
	
	public UploadVO insert(UploadVO bean) {
		UploadVO result = null;
		if(bean!=null) {
			result = uploadDAO.insert(bean);
		}
		return result;
	}
	
	public List<UploadVO> select(UploadVO bean) {
		List<UploadVO> result = null;
		if(bean!=null && bean.getId()!=0) {
			UploadVO temp = uploadDAO.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<UploadVO>();
				result.add(temp);
			}
		} else {
			result = uploadDAO.select(); 
		}
		return result;
	}
	
	public UploadVO update(UploadVO bean) {
		UploadVO result = null;
		
		if(bean != null) {
			result = uploadDAO.update(bean);
		}
		
		return result;
	}
	
}
