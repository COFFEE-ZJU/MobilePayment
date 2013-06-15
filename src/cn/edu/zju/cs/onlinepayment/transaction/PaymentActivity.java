package cn.edu.zju.cs.onlinepayment.transaction;


import cn.edu.zju.cs.onlinepayment.transaction.data.DummyContent;

import com.pclee.onlinebooking.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends Activity {

	private TextView balance_info;
	private Button pay_button;
	private DummyContent.DummyItem mItem;
	private double balance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        String trans_id = bundle.getString("trans_id");
        
		setContentView(R.layout.activity_payment);
		balance_info = (TextView)findViewById(R.id.payment_balance_info);
		
		if(trans_id != null) mItem = DummyContent.ITEM_MAP.get(trans_id);
		else errorGetBack();
		
		/* TODO: get the balance */
		balance = 5000;
		balance_info.setText(String.format(getResources().getString(R.string.show_balance)+"%.2f", balance));
		pay_button = (Button)findViewById(R.id.pay_button);
		
		pay_button.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO test whether the pay is success
						Toast.makeText(PaymentActivity.this, "Pay succeed!", Toast.LENGTH_SHORT).show();
					}
				});
		
		if(Double.parseDouble(mItem.price) > balance){
			balance_info.setText(balance_info.getText()+
					"   "+getResources().getString(R.string.not_enought_money));
			pay_button.setEnabled(false);
		}
	}
	
	public void errorGetBack(){
		Log.d("Debug", "Error!!!");
		this.finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payment, menu);
		return true;
	}

}
