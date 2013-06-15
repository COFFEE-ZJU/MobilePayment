package cn.edu.zju.cs.onlinepayment.transaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.edu.zju.cs.onlinepayment.R;
import cn.edu.zju.cs.onlinepayment.transaction.data.DummyContent;

public class ConfirmtActivity extends Activity {

	// private TextView confirm_info;
	private Button confirm_button;
	private DummyContent.DummyItem mItem; // the object that stores the
											// transaction info

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = new Bundle();
		bundle = this.getIntent().getExtras();
		String trans_id = bundle.getString("trans_id"); // get the transaction
														// id

		setContentView(R.layout.activity_confirm);
		// confirm_info = (TextView)findViewById(R.id.confirm_textview);
		// confirm_info.setText(getResources().getString(R.string.confirm_info));

		if (trans_id != null)
			mItem = DummyContent.ITEM_MAP.get(trans_id); // get the object
															// according to the
															// id
		else
			errorGetBack(); // failed to get the object

		/* TODO: get the balance */
		confirm_button = (Button) findViewById(R.id.confirm_button);

		confirm_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO test whether the confirmation is success
				Toast.makeText(ConfirmtActivity.this, "Confirm succeed!",
						Toast.LENGTH_SHORT).show();
			}
		});

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
