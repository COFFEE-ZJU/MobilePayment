package cn.edu.zju.cs.onlinepayment.personal;

import com.pclee.onlinebooking.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChargeActivity extends Activity {
	EditText chargeAmountEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charge);
		
		TextView currentBalanceTextView = (TextView) findViewById(R.id.textView_current_balance);
		currentBalanceTextView.setText(String.format("%.2f", getCurrentBalance()));
		
		
		chargeAmountEditText = (EditText) findViewById(R.id.editText_charge_amount);
		
		chargeAmountEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView textView, int id,
					KeyEvent keyEvent) {
				if (id == R.id.editText_charge_amount || id == EditorInfo.IME_NULL) {
					postCharge();
					Toast.makeText(ChargeActivity.this, "充值完成", Toast.LENGTH_SHORT).show();
					Intent personalIntent = new Intent(ChargeActivity.this, PersonalInforActivity.class);
					startActivity(personalIntent);
					finish();
					return true;
				}
				return false;
			} 
		});
		
		Button btnCharge = (Button) findViewById(R.id.button_charge);
		btnCharge.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				postCharge();
				Toast.makeText(ChargeActivity.this, "充值完成", Toast.LENGTH_SHORT).show();
				Intent personalIntent = new Intent(ChargeActivity.this, PersonalInforActivity.class);
				startActivity(personalIntent);
				finish();
			}
		});
	}

	private double getCurrentBalance(){
		//TODO get from the server
		return 10000.0;
	}
	
	private boolean postCharge(){
		double charge_amount = Double.parseDouble(chargeAmountEditText.getText().toString());
		String[] keys = {"charge_amount"};
		String[] values = {String.valueOf(charge_amount)};
		JSONEasy jsonEasy = new JSONEasy(keys, values);
		//TODO server
		return true;
	}

}
