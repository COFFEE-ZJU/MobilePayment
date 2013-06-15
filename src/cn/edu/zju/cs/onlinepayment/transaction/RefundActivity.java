package cn.edu.zju.cs.onlinepayment.transaction;


import cn.edu.zju.cs.onlinepayment.transaction.data.DummyContent;

import com.pclee.onlinebooking.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RefundActivity extends Activity {
	
	private Button refund_button;
	private DummyContent.DummyItem mItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        String trans_id = bundle.getString("trans_id");
        
		setContentView(R.layout.activity_refund);
		
		if(trans_id != null) mItem = DummyContent.ITEM_MAP.get(trans_id);
		else errorGetBack();
		
		/* TODO: get the balance */
		refund_button = (Button)findViewById(R.id.refund_button);
		
		refund_button.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO test whether the pay is success
						Toast.makeText(RefundActivity.this, "Refund succeed!", Toast.LENGTH_SHORT).show();
					}
				});
		
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
