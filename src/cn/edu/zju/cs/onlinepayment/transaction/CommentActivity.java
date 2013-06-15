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

public class CommentActivity extends Activity {

	private Button comment_button;
	private DummyContent.DummyItem mItem; // the object that stores the
											// transaction info

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = new Bundle();
		bundle = this.getIntent().getExtras();
		String trans_id = bundle.getString("trans_id"); // get the transaction
														// id

		setContentView(R.layout.activity_comment);

		if (trans_id != null)
			mItem = DummyContent.ITEM_MAP.get(trans_id); // get the object
															// according to the
															// id
		else
			errorGetBack(); // failed to get the object

		/* TODO: get the balance */
		comment_button = (Button) findViewById(R.id.comment_button);

		comment_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO test whether the comment is success
				Toast.makeText(CommentActivity.this, "Comment succeed!",
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
