package cn.edu.zju.cs.onlinepayment.personal;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.pclee.onlinebooking.R;

public class StatementActivity extends Activity {
	
	boolean monthly_or_yearly;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statement);
		String[] selectStatement = {"按月", "按年"}; 
		Spinner spinner = (Spinner)findViewById(R.id.spinner_statement);
				
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, selectStatement);  
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        
        spinner.setAdapter(adapter);  
        
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());   

        spinner.setVisibility(View.VISIBLE);  
        
        ListView listView = (ListView)findViewById(R.id.listView_statement);
        
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        
        listView.setAdapter(adapter2);
	}
	
	class SpinnerSelectedListener implements OnItemSelectedListener{  
		  
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
                long arg3) {  
           if (arg2 == 1){
        	   monthly_or_yearly = true;
           }else{
        	   monthly_or_yearly = false;
        }  
        }
        public void onNothingSelected(AdapterView<?> arg0) {  
        }  
    }  
	
	protected ArrayList<String> getData() {
		ArrayList<String> arrayList =  new ArrayList<String>();
		for(int i=0; i < 10; ++i){
			arrayList.add("2013-05-31  布丁");
		}
		return arrayList;
	}
}  

	
	
