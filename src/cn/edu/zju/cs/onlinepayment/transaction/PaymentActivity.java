package cn.edu.zju.cs.onlinepayment.transaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.edu.zju.cs.onlinepayment.R;
import cn.edu.zju.cs.onlinepayment.transaction.data.DummyContent;

public class PaymentActivity extends Activity {

	private TextView balance_info;
	private Button pay_button;
	private DummyContent.DummyItem mItem; // the object that stores the
											// transaction info
	private double balance; // the balance of the current user

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = new Bundle();
		bundle = this.getIntent().getExtras();
		String trans_id = bundle.getString("trans_id"); // get the transaction
														// id

		setContentView(R.layout.activity_payment);
		balance_info = (TextView) findViewById(R.id.payment_balance_info);

		if (trans_id != null)
			mItem = DummyContent.ITEM_MAP.get(trans_id); // get the object
															// according to the
															// id
		else
			errorGetBack(); // failed to get the object

		/* TODO: get the balance */
		balance = 5000;
		balance_info.setText(String.format(
				getResources().getString(R.string.show_balance) + "%.2f",
				balance)); // display the balance
		pay_button = (Button) findViewById(R.id.pay_button);

		pay_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO test whether the pay is success
				Toast.makeText(PaymentActivity.this, "Pay succeed!",
						Toast.LENGTH_SHORT).show();
			}
		});

		if (Double.parseDouble(mItem.price) > balance) { // check wether the
															// balance is enough
															// to pay the
															// transaction
			balance_info.setText(balance_info.getText() + "   "
					+ getResources().getString(R.string.not_enought_money)); // if
																				// not
																				// ,
																				// print
																				// info
			pay_button.setEnabled(false); // and disable the pay button
		}
	}

	public void errorGetBack() { // if failed to get the object , return to the
									// previous activity
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
