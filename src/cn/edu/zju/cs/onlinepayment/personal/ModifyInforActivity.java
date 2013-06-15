package cn.edu.zju.cs.onlinepayment.personal;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.zju.cs.onlinepayment.R;
import cn.edu.zju.cs.onlinepayment.booking.MainActivity;


public class ModifyInforActivity extends Activity {

	String[] keys = { "user_name", "real_name", "gender", "address",
			"mobile_phone", "ID", "Email" };

	String UserName;
	String RealName;
	String Gender;
	String Address;
	String MobilePhone;
	String ID;
	String Email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modify_infor);
		HashMap<String, String> hashMap = getData();
		UserName = hashMap.get("user_name");
		RealName = hashMap.get("real_name");
		Address = hashMap.get("address");
		MobilePhone = hashMap.get("mobile_phone");
		ID = hashMap.get("ID");
		Email = hashMap.get("Email");
		Gender = hashMap.get("gender");

		TextView mUserName = (TextView) findViewById(R.id.textView_user_name_content);
		mUserName.setText(UserName);

		EditText mRealName = (EditText) findViewById(R.id.editText_real_name);
		mRealName.setHint(RealName);

		EditText mAddress = (EditText) findViewById(R.id.editText_address);
		mAddress.setHint(Address);

		EditText mMobilePhone = (EditText) findViewById(R.id.editText_mobile_phone);
		mMobilePhone.setHint(MobilePhone);

		EditText mID = (EditText) findViewById(R.id.editText_ID);
		mID.setHint(ID);

		EditText mEmail = (EditText) findViewById(R.id.editText_Email);
		mEmail.setHint(Email);

		EditText mGender = (EditText) findViewById(R.id.EditText_gender);
		mGender.setHint(Gender);

		Button btnModify = (Button) findViewById(R.id.button_modify);
		btnModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				postModify();
				Toast.makeText(ModifyInforActivity.this, "修改成功",
						Toast.LENGTH_SHORT).show();
				Intent personalIntent = new Intent(ModifyInforActivity.this,
						PersonalInforActivity.class);
				startActivity(personalIntent);
				finish();
			}

		});

	}

	protected HashMap<String, String> getData() {
		HashMap<String, String> hashMap = new HashMap<String, String>();

		String[] values = { "mayun", "马云", "男", "阿里集团", "15068888888",
				"441900197012135331", "mayun@alibaba.com" };

		for (int i = 0; i < keys.length; ++i) {
			hashMap.put(keys[i], values[i]);
		}
		return hashMap;
	}

	protected boolean postModify() {
		String[] values = { UserName, RealName, Gender, Address, MobilePhone,
				ID, Email };
		JSONEasy jsonEasy = new JSONEasy(keys, values);
		return true;
	}
}
