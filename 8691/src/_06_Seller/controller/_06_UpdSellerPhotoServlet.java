package _06_Seller.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import _06_Seller.model._06_Sellerjdbc;
import _11_ProdClass.dao._11_Imagejdbc;
@WebServlet(
		urlPatterns={"/_06_Seller/_06_UpdSellerPhoto.controller"}
		)
@MultipartConfig(location = "D:/workspace_proj/8691/WebContent/image/store/")
public class _06_UpdSellerPhotoServlet extends HttpServlet {
	private _06_Sellerjdbc sellerjdbc= new _06_Sellerjdbc();
	private _11_Imagejdbc imagejdbc = new _11_Imagejdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		
		session.setAttribute("LoginOK", accountUID);
		System.out.println("accountUID:"+accountUID);
		
		//接收資料
		Part photoPar = request.getPart("upl");
		String sellerPhoto = request.getParameter("hidPhotoID");
		
		//裝錯誤的袋子
		Map<String, String> error = new HashMap<String, String>();
		request.setAttribute("error", error);
		
		//驗證資料
		String rs = "";
		// ------上傳圖片---------
		try {
			String id = sellerPhoto; // 搜尋出目前要接下去的流水號ID
			System.out.println("id:"+id);
			String sFilename = getFilename(photoPar); // 檔名由Header取出
			// 在不同的code page啟動API時有時需要轉碼，因為設計上編碼不同
			sFilename = new String(sFilename.getBytes("ISO8859_1"), "UTF-8");
			System.out.println("Uploaded filename=" + sFilename); // debug
			String photopath = "/image/store/" + id + ".png";
			File oFile = new File("D:/workspace_proj/8691/WebContent/" + photopath);
			if (oFile.exists())
				oFile.delete(); // 檔案已存在時先刪除
			photoPar.write(id + ".png"); // saving the uploaded file.
			rs = Integer.toString(imagejdbc.update(id,sFilename, photopath));
			System.out.println("rs:"+rs);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		}
		// ------上傳圖片---------
		
		// 處理前面的資料驗證，有錯就先return
		if (error != null && !error.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/_06_Seller/SellerCenter.jsp");
			rd.forward(request, response);
			return;
		}

		List result = null;
		
		if(accountUID!=null){			
			result = sellerjdbc.select(accountUID);		
			System.out.println("resultVistor:"+result);
			
			request.setAttribute("error", "");
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/_06_Seller/Seller.controller").forward(request, response);
		}
	}
	
	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1)
						.substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
			}
		}
		return null;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}