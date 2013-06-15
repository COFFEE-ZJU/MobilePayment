package cn.edu.zju.cs.onlinepayment.personal;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;
/*
JSON Easy class, which extends JSONObject
and for easy usage

especially for HashMap
*/
public class JSONEasy extends JSONObject {
	//JSON object in the class
	JSONObject jsonObject;
	public JSONEasy(HashMap<String, String> hashMap){
		jsonObject = new JSONObject();
		try{
			//iterate all entries in the hashMap
			for (Entry<String, String> entry : hashMap.entrySet()) {
			    //put the key and value into the JSON object
			    jsonObject.put(entry.getKey(), entry.getValue());
			}
		}catch (JSONException e){
			    e.printStackTrace();
			}	
	}
	
	public JSONEasy(String[] keys, String[] values){
		//asser the length of keys array and the length of values array
		assert(keys.length == values.length);
		
		jsonObject = new JSONObject();
		try{
			//put all keys and values into the object
			for(int i = 0;i < keys.length; ++i){
				jsonObject.put(keys[i],  values[i]);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
	}
}
