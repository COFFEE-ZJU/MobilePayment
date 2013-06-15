package cn.edu.zju.cs.onlinepayment.personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.zju.cs.onlinepayment.R;
import cn.edu.zju.cs.onlinepayment.booking.MainActivity;


public class RegisterActivity extends Activity {

	EditText mUserName;
	EditText mRealName;
	EditText mPassword;
	EditText mConfirmedPassword;
	EditText mAddress;
	EditText mMobilePhone;
	EditText mID;
	EditText mEmail;
	EditText mGender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		mUserName = (EditText) findViewById(R.id.editText_user_name);
		mRealName = (EditText) findViewById(R.id.editText_real_name);
		mPassword = (EditText) findViewById(R.id.EditText_password);
		mConfirmedPassword = (EditText) findViewById(R.id.EditText_confirmed_password);
		mAddress = (EditText) findViewById(R.id.editText_address);
		mMobilePhone = (EditText) findViewById(R.id.editText_mobile_phone);
		mID = (EditText) findViewById(R.id.editText_ID);
		mEmail = (EditText) findViewById(R.id.editText_Email);
		mGender = (EditText) findViewById(R.id.EditText_gender);
		Button btnSubmit = (Button) findViewById(R.id.button_register);

		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				postRegister();
				Toast.makeText(RegisterActivity.this, "注册成功",
						Toast.LENGTH_SHORT).show();
				Intent mainIntent = new Intent(RegisterActivity.this,
						MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		});
	}

	protected boolean postRegister() {
		String UserName, RealName, Password, ConfirmedPassword, Address, MobilePhone, ID, Email, Gender;
		UserName = mUserName.getText().toString();
		RealName = mRealName.getText().toString();
		Password = mPassword.getText().toString();
		ConfirmedPassword = mConfirmedPassword.getText().toString();
		Address = mAddress.getText().toString();
		MobilePhone = mMobilePhone.getText().toString();
		ID = mID.getText().toString();
		Email = mEmail.getText().toString();
		Gender = mGender.getText().toString();
		String[] keys = { "user_name", "real_name", "password",
				"confirmed_password", "address", "mobile_phone", "ID", "Email",
				"gender" };
		String[] values = { UserName, RealName, Password, ConfirmedPassword,
				Address, MobilePhone, ID, Email, Gender };
		JSONEasy jsonEasy = new JSONEasy(keys, values);
		// TODO server
		return true;
	}
}
