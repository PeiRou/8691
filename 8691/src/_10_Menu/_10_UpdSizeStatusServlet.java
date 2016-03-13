package _10_Menu;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import _11_ProdClass.dao._11_FoodStatusClassjdbc;
import _11_ProdClass.dao._11_ProdClass3jdbc;
import _11_ProdClass.dao._11_SizeStatusjdbc;
@WebServlet(
		urlPatterns={"/_10_Menu/UpdSizeStatus.controller"}
		)
public class _10_UpdSizeStatusServlet extends HttpServlet {
	private _11_SizeStatusjdbc sizeStatusjdbc= new _11_SizeStatusjdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		String prodaction = null;
		JSONObject jsonObj = null;
		String strTable = "";
		String strJsonData = "";
		
		try {
			jsonObj = new JSONObject(request.getParameter("jsonData"));
			prodaction = jsonObj.getString("action");
			strTable = jsonObj.getString("table");
			strJsonData = jsonObj.getString("status");	
		} catch (JSONException e1) {
			e1.printStackTrace();
		}	

		System.out.println("prodaction: "+prodaction);
		System.out.println("strTable: "+strTable);
		System.out.println("strJsonData: "+strJsonData);	
		
		if(strTable!="" && strJsonData!=""){
			if("".equals(accountUID)){
				String err ="";
				response.setHeader("Cache-control", "no-cache, no-store");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				response.getWriter().write(err);
			}else if ("Insert".equals(prodaction)) {
				JSONObject json = new JSONObject();
				try {
					JSONArray jsonArry = jsonObj.getJSONArray("status");
					int sizeStatusID = 0;					
					for (int i = 0; i < jsonArry.length(); i++) {
						if (i == 0) {							
							json.put("SizeName",jsonArry.getJSONObject(i).getString("SizeName"));							
							sizeStatusID = sizeStatusjdbc.insert(json);
							if (sizeStatusID == 0) {
								json.put("SizeStatusID", "");
							} else {								
								json.put("SizeStatusID", sizeStatusID);
							}
						}
					}					
				} catch (JSONException e) {
					e.printStackTrace();
				}				
				System.out.println(json.toString());
				response.setHeader("Cache-control", "no-cache, no-store");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				response.getWriter().write(json.toString());
			}else if("Update".equals(prodaction)){				
				List errJSONList = new LinkedList();		
				if("SizeStatus".equals(strTable)){
					try {
						JSONArray jsonArry = jsonObj.getJSONArray("status");
						for (int i = 0; i < jsonArry.length(); i++)
					      {
							JSONObject json = new JSONObject(); 
							json.put("SizeStatusID",jsonArry.getJSONObject(i).getString("SizeStatusID"));
							json.put("SizeName",jsonArry.getJSONObject(i).getString("SizeName"));
							int result = sizeStatusjdbc.update(json);
							if(result==0){
								json.put("table","SizeStatus");
								errJSONList.add(json);
							}
					      }
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				response.setHeader("Cache-control", "no-cache, no-store");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				response.getWriter().write(errJSONList.toString());
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
