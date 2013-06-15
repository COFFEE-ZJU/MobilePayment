package cn.edu.zju.cs.onlinepayment.booking;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import cn.edu.zju.cs.onlinepayment.personal.ApplicationHelper;
import cn.edu.zju.cs.onlinepayment.personal.LoginActivity;
import cn.edu.zju.cs.onlinepayment.transaction.TransactionListActivity;

import com.pclee.onlinebooking.R;

public class MainActivity extends Activity {

	private ImageButton flight_btn ;
	private ImageButton hotel_btn;
	private ImageButton order_btn;
	private ImageButton loggin_btn;
	private ImageButton payment_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ApplicationHelper helper = (ApplicationHelper)getApplicationContext();
        
        flight_btn = (ImageButton)findViewById(R.id.imageButton_flight);
        flight_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();    
	            intent.setClass(MainActivity.this, FlightActivity.class);   
	            MainActivity.this.startActivity(intent);   
			}
        	
        });
        
        hotel_btn = (ImageButton)findViewById(R.id.imageButton_hotel);
        hotel_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();    
	            intent.setClass(MainActivity.this, HotelActivity.class);   
	            MainActivity.this.startActivity(intent);   
			}
        	
        });
        
        order_btn = (ImageButton)findViewById(R.id.imageButton_orders);
        order_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if (helper.isLogin() == false){
					Toast.makeText(MainActivity.this, "请先登陆", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent();    
	            intent.setClass(MainActivity.this, OrderActivity.class);   
	            MainActivity.this.startActivity(intent);   
			}
        	
        });
        
        loggin_btn = (ImageButton)findViewById( R.id.imageButton_loggin);
        loggin_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();    
	            intent.setClass(MainActivity.this, LoginActivity.class);   
	            helper.makeLogin();
	            MainActivity.this.startActivity(intent);   
			}
        	
        });
        
        payment_btn = (ImageButton)findViewById( R.id.imageButton_payment);
        payment_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if (helper.isLogin() == false){
					
					Toast.makeText(MainActivity.this, "请先登陆", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent();    
	            intent.setClass(MainActivity.this, TransactionListActivity.class);   
	            MainActivity.this.startActivity(intent);   
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
 
}
