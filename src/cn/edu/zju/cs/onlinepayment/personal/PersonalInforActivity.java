package cn.edu.zju.cs.onlinepayment.personal;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import cn.edu.zju.cs.onlinepayment.R;
import cn.edu.zju.cs.onlinepayment.booking.MainActivity;


public class PersonalInforActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_infor);

		ListView list = (ListView) findViewById(R.id.personal_infor_listview);

		SimpleAdapter listItemAdapter = new SimpleAdapter(this, getData(),
				R.layout.key_value_item, new String[] { "key", "value" },
				new int[] { R.id.key_item, R.id.value_item });
		list.setAdapter(listItemAdapter);

		Button btnModifyInfor = (Button) findViewById(R.id.button_modify);
		btnModifyInfor.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent modifyInforIntent = new Intent(
						PersonalInforActivity.this, ModifyInforActivity.class);
				startActivity(modifyInforIntent);
				finish();
			}
		});

		Button btnModifyPasswordButton = (Button) findViewById(R.id.button_modify_password);
		btnModifyPasswordButton
				.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						Intent modifyPasswordIntent = new Intent(
								PersonalInforActivity.this,
								ModifyPasswordActivity.class);
						startActivity(modifyPasswordIntent);
						finish();
					}
				});

		Button btnChargeButton = (Button) findViewById(R.id.button_charge);
		btnChargeButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent chargeIntent = new Intent(PersonalInforActivity.this,
						ChargeActivity.class);
				startActivity(chargeIntent);
				finish();
			}
		});

		Button btnBack = (Button) findViewById(R.id.button_back);
		btnBack.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent mainIntent = new Intent(PersonalInforActivity.this,
						MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		});

		Button btnStatement = (Button) findViewById(R.id.button_statement);
		btnStatement.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent statementIntent = new Intent(PersonalInforActivity.this,
						StatementActivity.class);
				startActivity(statementIntent);
				finish();
			}
		});
	}

	public ArrayList<HashMap<String, String>> getData() {
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		String[] keyNames = { "用户名  ：", "真实姓名：", "性别   ：", "Email ：", "电话   ：",
				"地址   ：", "身份证：", "余额  ：" };

		String[] valueNames = { "mayun", "马云", "男", "ma@alibaba.com",
				"15068888888", "阿里巴巴", "441900197012135331", "10000" };
		for (int i = 0; i < keyNames.length; ++i) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", keyNames[i]);
			map.put("value", valueNames[i]);
			listItem.add(map);
		}
		return listItem;
	}
}
