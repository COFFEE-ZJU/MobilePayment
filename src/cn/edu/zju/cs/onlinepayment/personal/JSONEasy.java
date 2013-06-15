package cn.edu.zju.cs.onlinepayment.personal;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONEasy extends JSONObject {
	JSONObject jsonObject;
	public JSONEasy(HashMap<String, String> hashMap){
		jsonObject = new JSONObject();
		try{
			for (Entry<String, String> entry : hashMap.entrySet()) {
			    jsonObject.put(entry.getKey(), entry.getValue());
			}
		}catch (JSONException e){
			    e.printStackTrace();
			}	
	}
	
	public JSONEasy(String[] keys, String[] values){
		assert(keys.length == values.length);
		jsonObject = new JSONObject();
		try{
			for(int i = 0;i < keys.length; ++i){
				jsonObject.put(keys[i],  values[i]);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
	}
}
