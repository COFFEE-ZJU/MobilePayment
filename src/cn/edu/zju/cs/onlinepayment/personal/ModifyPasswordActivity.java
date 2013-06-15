package cn.edu.zju.cs.onlinepayment.personal;

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

import cn.edu.zju.cs.onlinepayment.R;

public class ModifyPasswordActivity extends Activity {

	EditText currentPasswordEditText;
	EditText modifiedPasswordEditText;
	EditText confirmedModifiedPasswordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modify_password);

		currentPasswordEditText = (EditText) findViewById(R.id.EditText_current_password);
		modifiedPasswordEditText = (EditText) findViewById(R.id.EditText_modified_password);
		confirmedModifiedPasswordEditText = (EditText) findViewById(R.id.EditText_confirmed_modified_password);
		confirmedModifiedPasswordEditText
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.EditText_confirmed_modified_password
								|| id == EditorInfo.IME_NULL) {
							postModifiedPassword();
							Toast.makeText(ModifyPasswordActivity.this,
									"修改密码完成", Toast.LENGTH_SHORT).show();
							Intent personalIntent = new Intent(
									ModifyPasswordActivity.this,
									PersonalInforActivity.class);
							startActivity(personalIntent);
							finish();
							return true;
						}
						return false;
					}
				});

		Button modifyButton = (Button) findViewById(R.id.button_change_password);
		modifyButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				postModifiedPassword();
				Toast.makeText(ModifyPasswordActivity.this, "修改密码完成",
						Toast.LENGTH_SHORT).show();
				Intent personalIntent = new Intent(ModifyPasswordActivity.this,
						PersonalInforActivity.class);
				startActivity(personalIntent);
				finish();
			}
		});
	}

	protected boolean postModifiedPassword() {
		String currentPassword = currentPasswordEditText.getText().toString();
		String modifiedPassword = modifiedPasswordEditText.getText().toString();
		String confirmedModifiedPassword = confirmedModifiedPasswordEditText
				.getText().toString();
		String[] keys = { "current_password", "modified_password",
				"confirmed_modified_password" };
		String[] values = { currentPassword, modifiedPassword,
				confirmedModifiedPassword };
		JSONEasy jsonEasy = new JSONEasy(keys, values);
		// TODO server
		return true;
	}

}
