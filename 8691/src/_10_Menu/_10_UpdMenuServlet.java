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

import _11_ProdClass.dao._11_FoodPricejdbc;
import _11_ProdClass.dao._11_Foodjdbc;
@WebServlet(
		urlPatterns={"/_10_Menu/UpdMenu.controller"}
		)
public class _10_UpdMenuServlet extends HttpServlet {
	private _11_Foodjdbc foodjdbc= new _11_Foodjdbc();
	private _11_FoodPricejdbc foodPricejdbc = new _11_FoodPricejdbc();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accountUID = (String) session.getAttribute("LoginOK");
		String prodaction = null;
		String temp[] = {"","",""};
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
			if ("Insert".equals(prodaction)) {
				JSONObject json = new JSONObject();
				try {
					JSONArray jsonArry = jsonObj.getJSONArray("status");
					int rstFoodID = 0;
					List priceStatusList = new LinkedList();
					for (int i = 0; i < jsonArry.length(); i++) {
						if (i == 0) {
							json.put("AccountUID", accountUID);
							json.put("FoodName", jsonArry.getJSONObject(i).getString("FoodName"));
							// json.put("FoodPhoto",jsonArry.getJSONObject(i).getString("FoodPhoto"));
							json.put("GroupClass3ID", jsonArry.getJSONObject(i).getString("GroupClass3ID"));
							rstFoodID = foodjdbc.insert(json);
							if (rstFoodID == 0) {
								json.put("FoodID", "");
							} else {
								json.put("FoodID", rstFoodID);
							}
						} else {
							JSONObject jsonFoodPrice = new JSONObject();
							
							jsonFoodPrice.put("FoodID", rstFoodID);
							jsonFoodPrice.put("SizeStatusID", jsonArry.getJSONObject(i).getString("SizeStatusID"));
							jsonFoodPrice.put("FoodStatusPrice",jsonArry.getJSONObject(i).getString("FoodStatusPrice"));

							int result = foodPricejdbc.insert(jsonFoodPrice);
							System.out.println("result: " + result);
							if (result == 0) {
								jsonFoodPrice.put("FoodSizePriceID", "");
								priceStatusList.add(jsonFoodPrice);
							} else {
								jsonFoodPrice.put("FoodSizePriceID", result);								
								priceStatusList.add(jsonFoodPrice);
							}
						}
					}
					json.put("FoodPrice",priceStatusList);
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
				if("Food".equals(strTable)){
					try {
						JSONArray jsonArry = jsonObj.getJSONArray("status");
						for (int i = 0; i < jsonArry.length(); i++)
					      {
							JSONObject json = new JSONObject(); 
							json.put("FoodID",jsonArry.getJSONObject(i).getString("FoodID"));
							json.put("FoodName",jsonArry.getJSONObject(i).getString("FoodName"));
							int result = foodjdbc.update(json);
							if(result==0){
								json.put("table","Food");
								errJSONList.add(json);
							}
					      }
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}else if("FoodSizePrice".equals(strTable)){
					try {
						JSONArray jsonArry = jsonObj.getJSONArray("status");
						for (int i = 0; i < jsonArry.length(); i++)
					      {
							JSONObject json = new JSONObject(); 
							json.put("FoodSizePriceID",jsonArry.getJSONObject(i).getString("FoodSizePriceID"));
							json.put("SizeStatusID",jsonArry.getJSONObject(i).getString("SizeStatusID"));
							json.put("FoodStatusPrice",jsonArry.getJSONObject(i).getString("FoodStatusPrice"));
								
							int result = foodPricejdbc.update(json);
							System.out.println("result: "+result);
							if(result==0){
								json.put("table","FoodSizePrice");
								String OgnPrice =foodPricejdbc.select_SZPZ(jsonArry.getJSONObject(i).getString("FoodSizePriceID"));
								json.put("OgnPrice",OgnPrice);
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
