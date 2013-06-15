package cn.edu.zju.cs.onlinepayment.personal;

import cn.edu.zju.cs.onlinepayment.R;
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

/* 
 ChargeActivity

 Charge some monkey into the account
 */
public class ChargeActivity extends Activity {
	// EditText View for chargeAmount
	EditText chargeAmountEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_charge);

		// TextView for showing current balance
		TextView currentBalanceTextView = (TextView) findViewById(R.id.textView_current_balance);
		// get current balance and show it in the TextView
		currentBalanceTextView.setText(String.format("%.2f",
				getCurrentBalance()));

		// EditText for entering the charge amount
		chargeAmountEditText = (EditText) findViewById(R.id.editText_charge_amount);
		// When the edit provess ends and press ENTER, trigger the charge
		// process
		chargeAmountEditText
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.editText_charge_amount
								|| id == EditorInfo.IME_NULL) {
							// post charge request to the server
							postCharge();
							// Toast to notice the sucess of the charge process
							Toast.makeText(ChargeActivity.this, "充值完成",
									Toast.LENGTH_SHORT).show();
							// change to the personal management activity
							Intent personalIntent = new Intent(
									ChargeActivity.this,
									PersonalInforActivity.class);
							startActivity(personalIntent);
							finish();
							return true;
						}
						return false;
					}
				});
		// Button for charge
		Button btnCharge = (Button) findViewById(R.id.button_charge);
		// Button on click listener
		btnCharge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// post the charge request to the server
				postCharge();
				// Make toast to notice the success
				Toast.makeText(ChargeActivity.this, "充值完成", Toast.LENGTH_SHORT)
						.show();
				// change into personal management activity
				Intent personalIntent = new Intent(ChargeActivity.this,
						PersonalInforActivity.class);
				startActivity(personalIntent);
				finish();
			}
		});
	}

	private double getCurrentBalance() {
		// to get the current balance
		// TODO get from the server
		return 10000.0;
	}

	private boolean postCharge() {
		// to post the charge amount to the server by JSON
		double charge_amount = Double.parseDouble(chargeAmountEditText
				.getText().toString());
		// key in the JSON data
		String[] keys = { "charge_amount" };
		// value in the JSON data
		String[] values = { String.valueOf(charge_amount) };
		JSONEasy jsonEasy = new JSONEasy(keys, values);
		// TODO server
		return true;
	}

}
