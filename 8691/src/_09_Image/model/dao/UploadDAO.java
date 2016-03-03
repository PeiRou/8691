package _09_Image.model.dao;

import java.sql.Blob;
import java.util.List;

import _09_Image.model.UploadVO;

public interface UploadDAO {

	List<UploadVO> select();

	UploadVO select(int id);

	UploadVO update(UploadVO bean);

	UploadVO insert(UploadVO bean);

}