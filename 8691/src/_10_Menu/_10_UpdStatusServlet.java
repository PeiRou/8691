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
@WebServlet(
		urlPatterns={"/_10_Menu/UpdStatus.controller"}
		)
public class _10_UpdStatusServlet extends HttpServlet {
	private _11_ProdClass3jdbc prodClass3jdbc= new _11_ProdClass3jdbc();
	private _11_FoodStatusClassjdbc foodStatusClassjdbc = new _11_FoodStatusClassjdbc();
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
					int prodStatusClass3ID = 0;					
					for (int i = 0; i < jsonArry.length(); i++) {
						if (i == 0) {
							json.put("theTr",jsonArry.getJSONObject(i).getString("theTr"));
							json.put("ProdStatusClass2ID",jsonArry.getJSONObject(i).getString("ProdStatusClass2ID"));
							json.put("ProdStatusClass3Name",jsonArry.getJSONObject(i).getString("ProdStatusClass3Name"));
							json.put("ProdStatusClass3Price",jsonArry.getJSONObject(i).getString("ProdStatusClass3Price"));
							prodStatusClass3ID = prodClass3jdbc.insert(json);
							if (prodStatusClass3ID == 0) {
								json.put("ProdStatusClass3ID", "");
							} else {								
								json.put("ProdStatusClass3ID", prodStatusClass3ID);
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
				if("ProdStatusClass3".equals(strTable)){
					try {
						JSONArray jsonArry = jsonObj.getJSONArray("status");
						for (int i = 0; i < jsonArry.length(); i++)
					      {
							JSONObject json = new JSONObject(); 
							json.put("ProdStatusClass3ID",jsonArry.getJSONObject(i).getString("ProdStatusClass2ID"));
							json.put("ProdStatusClass3Name",jsonArry.getJSONObject(i).getString("ProdStatusClass3Name"));
							json.put("ProdStatusClass3Price",jsonArry.getJSONObject(i).getString("ProdStatusClass3Price"));
							int result = prodClass3jdbc.update(json);
							if(result==0){
								json.put("table","ProdStatusClass3");
								errJSONList.add(json);
							}
					      }
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}else if("FoodStatusClass3".equals(strTable)){
					try {
						
						JSONArray jsonArry = jsonObj.getJSONArray("status");
						for (int i = 0; i < jsonArry.length(); i++)
					      {
							if(i==0){
								//先清除再新增
								int rs = foodStatusClassjdbc.delete(jsonArry.getJSONObject(i).getString("GroupClass3ID"));
							}
							JSONObject json = new JSONObject(); 
							json.put("GroupClass3ID",jsonArry.getJSONObject(i).getString("GroupClass3ID"));
							json.put("ProdStatusClass3ID",jsonArry.getJSONObject(i).getString("ProdStatusClass3ID"));
								
							int result = foodStatusClassjdbc.insert(json);
							System.out.println("result: "+result);
							if(result==0){
								json.put("table","FoodSizePrice");								
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
