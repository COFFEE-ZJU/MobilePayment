package cn.edu.zju.cs.onlinepayment.booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.edu.zju.cs.onlinepayment.transaction.TransactionListActivity;

import com.pclee.onlinebooking.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
/********************************
 * 
 * 负责航班查询的activity
 * @author pclee
 *
 */
public class FlightActivity extends Activity{
	
	private ImageButton search_btn ;
	private TextView date;
	private int year;
	private int month;
	private int day;
	private ListView lv;
	private ImageButton comfirm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_flight);
        date = (TextView) findViewById(R.id.textView_show);		//获得设置时间的输入框
        //为输入框添加事件响应，点击时可以通过时间选择器来选择时间
        date.setOnClickListener(new OnClickListener(){
        	
			@Override
			public void onClick(View arg0) {
				// 重写onclick函数
				//获得系统的时间，来初始化时间选择器
				Calendar c = Calendar.getInstance();
				new DatePickerDialog(FlightActivity.this, new DatePickerDialog.OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						date.setText(year+"-"+monthOfYear+"-"+dayOfMonth);	//设置时间选择器的初始值
					}
				}
				,c.get(Calendar.YEAR)	//获取时间按选择器的初始年，月，日
				,c.get(Calendar.MONTH)
				,c.get(Calendar.DAY_OF_MONTH)).show();
			}
        	
        });
        
        search_btn = (ImageButton)findViewById(R.id.search_btn);
        //为点击按钮添加事件响应
        search_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//测试的数据
				String[] com = new String[]{"国航","华泰","泛美","联合","国航","华泰","泛美","联合"};
				String[] flightNo = new String[]{"gh1320","ht1239","fm9094","lh8493","gh93029","ht89894","lh10203","lh10203"};
				String[] leavetime = new String[]{"12:30","1:30","2:30","3:30","4:30","5:30","6:30","7:30","8:30",};
				List<Map<String,String>> data = new ArrayList<Map<String, String>>();
				//用map来存储显示的数据
				for( int i=0; i<com.length; i++){
					Map<String, String> item = new HashMap<String, String>();
					item.put("com",com[i]);
					item.put("flightNo",flightNo[i]);
					item.put("leavetime",leavetime[i]);
					data.add(item);
				}
				//SimpleAdapter用来在listview中显示数据
				SimpleAdapter simpleAdapter = new SimpleAdapter(
						FlightActivity.this,
						data,
						R.layout.flight_item,
						new String[]{"com","flightNo","leavetime"},		//根据key来提取map中的数据来显示
						new int[]{R.id.tv_com,R.id.tv_fn,R.id.tv_leavetiem}
						);
				//跳到显示航班信息的页面
				setContentView(R.layout.flight_info);
				lv =(ListView)findViewById(R.id.lv_flight_info);
				lv.setAdapter(simpleAdapter);
				//为ListView添加事件响应，获取被点击的行的信息
				lv.setOnItemClickListener(new OnItemClickListener(){
						
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Map<String, String> item =( HashMap<String, String>)lv.getItemAtPosition(arg2); 
		                String com=item.get("com"); 	//航空公司
		                String flightNo=item.get("flightNo"); //航班号码
		                String leavetime=item.get("leavetime"); //起飞时间
		                Log.i("pclee",com+" : "+flightNo);
		                setContentView(R.layout.flight_order);
		                TextView odcom = (TextView)findViewById(R.id.tv_od_com);
		                TextView odflno = (TextView)findViewById(R.id.tv_od_flno);
		                TextView odtime = (TextView)findViewById(R.id.tv_od_time);
		                TextView price = (TextView)findViewById(R.id.tv_price);
		                odcom.setText(com);	//设置odcom的内容为航空公司
		                odflno.setText(flightNo);	//设置odflno的值为班机号
		                odtime.setText(leavetime);
		                price.setText("1234.80");	//机票的价格
		                
		                comfirm = (ImageButton)findViewById(R.id.imgBtn_comfirm);
		                //为确认按钮添加事件响应
		                comfirm.setOnClickListener(new OnClickListener(){
		        			@Override
		        			public void onClick(View arg0) {
		        				Intent intent = new Intent();    
					            intent.setClass(FlightActivity.this, TransactionListActivity.class);   
					            FlightActivity.this.startActivity(intent);  
		        			}
		                });
					}
					
				}); 
				
				
			}
        });
       
    }
	
}
