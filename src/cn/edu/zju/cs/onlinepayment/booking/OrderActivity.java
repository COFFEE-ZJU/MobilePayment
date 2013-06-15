package cn.edu.zju.cs.onlinepayment.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pclee.onlinebooking.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class OrderActivity extends Activity{
	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders);
        //测试数据
        String[] orderid = new String[]{"ht1203","ht4567","ht9890","ht4815","ht2488","ht8895","ht1233","ht3567"};
		String[] seller = new String[]{"国航","泛美","国航","华泰","宜家酒店","四季酒店","杭州西湖酒店","天津凤凰宾馆"};
		String[] time = new String[]{"2012-07-08","2012-08-18","2012-08-28","2012-09-12","2013-01-02","2012-05-04",
				"2013-05-12","2012-05-20"};
		String[] price = new String[]{"1230.00","630.00","650.00","89.00","1330.00","230.00","630.00","540.00","199.00",};
		//map种存放订单的数据
		//每个map都是listview中的一行数据
		List<Map<String,String>> data = new ArrayList<Map<String, String>>();
		//生成map
		for( int i=0; i<orderid.length; i++){
			Map<String, String> item = new HashMap<String, String>();
			item.put("orderid",orderid[i]);
			item.put("seller",seller[i]);
			item.put("time",time[i]);
			item.put("price", price[i]);
			data.add(item);
		}
		//simpleadapter用来显示数据
		SimpleAdapter simpleAdapter = new SimpleAdapter(
				OrderActivity.this,
				data,
				R.layout.order_item,
				new String[]{"orderid","seller","time","price"},
				new int[]{R.id.tv_order_id,R.id.tv_seller,R.id.tv_order_time,R.id.tv_orde_price}
				);
		//跳转到订单列表的页面
		setContentView(R.layout.orders);
		lv =(ListView)findViewById(R.id.orders);
		lv.setAdapter(simpleAdapter);
		//为订单页面添加时间响应，获取被点击的行的数据
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				//item是被点击的行
				Map<String, String> item =( HashMap<String, String>)lv.getItemAtPosition(arg2); 
                String orderid=item.get("orderid"); 
                //被点击的行的seller属性
                String seller=item.get("seller"); 
                String time=item.get("time"); 
                String price=item.get("price");
                //跳转到评论的页面
                setContentView(R.layout.comment);
                //评论页面中显示订单的详细
                TextView tvoderid = (TextView)findViewById(R.id.tv_orderid);
                TextView tvseller = (TextView)findViewById(R.id.tv_seller);
                TextView tvtime = (TextView)findViewById(R.id.tv_time);
                TextView tvprice = (TextView)findViewById(R.id.tv_price);
                tvoderid.setText(orderid);
                tvseller.setText(seller);
                tvtime.setText(time);
                tvprice.setText(price);
			}
			
		}); 
	}
}
