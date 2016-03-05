package _10_Menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			if("Food".equals(strTable)){
				try {
					JSONArray jsonArry = jsonObj.getJSONArray("status");
					for (int i = 0; i < jsonArry.length(); i++)
				      {
						JSONObject json = new JSONObject(); 
						json.put("FoodID",jsonArry.getJSONObject(i).getString("FoodID"));
						json.put("FoodName",jsonArry.getJSONObject(i).getString("FoodName"));
						int result = foodjdbc.update(json);
						System.out.println("result: "+result);
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
				      }
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}
	

}
