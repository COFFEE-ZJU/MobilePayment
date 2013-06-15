package cn.edu.zju.cs.onlinepayment.booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;

import cn.edu.zju.cs.onlinepayment.transaction.TransactionListActivity;
import cn.edu.zju.cs.onlinepayment.utils.ImageDownloadTask;

import com.pclee.onlinebooking.R;
/*****************************
 * 
 * 酒店查询的页面
 * @author pclee
 *
 */
public class HotelActivity extends Activity {

	private TextView checkin;
	private TextView checkout;
	private ImageButton htSearch_btn;
	private ListView lv;
	private TextView odcheckin;
	private TextView odcheckout;
	private String scheckin;
	private String scheckout;
	private String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel);
		//入住时间输入框
		checkin = (TextView) findViewById(R.id.et_checkin);		
		//退房时间输入框
		checkout = (TextView) findViewById(R.id.et_checkout);	
		htSearch_btn = (ImageButton) findViewById(R.id.hotel_search_btn);	
		//查询按钮添加事件响应
		checkin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//获得系统的时间
				Calendar c = Calendar.getInstance();
				//选择入住的时间
				new DatePickerDialog(HotelActivity.this,
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								//设置输入框里的时间为用户的输入
								checkin.setText(year + "-" + monthOfYear + "-"
										+ dayOfMonth);
							}

						}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
								.get(Calendar.DAY_OF_MONTH)).show();
			}

		});
		//设置退房的时间，输入框被点击时跳出设置时间的对话框
		checkout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//获取系统的时间
				Calendar c = Calendar.getInstance();
				//时间选择器
				new DatePickerDialog(HotelActivity.this,
						new DatePickerDialog.OnDateSetListener() {
							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								// checkout输入框设置为用户的输入
								checkout.setText(year + "-" + monthOfYear + "-"
										+ dayOfMonth);
							}
						}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
								.get(Calendar.DAY_OF_MONTH)).show();
			}

		});
		
		//搜索的按钮
		htSearch_btn = (ImageButton) findViewById(R.id.hotel_search_btn);
		htSearch_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//测试用的数据
				String[] img = new String[] {
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/41201313/17_cf31e9d8-2309-4501-bbbd-ca95f2557927.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/51201119/17_55a0c6e3-29a3-4c26-bb36-16c31256f97a.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/50101464/17_90ca94e4-69fe-431f-bd42-ad75f04b2a15.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/31201074/17_c3907641-14b4-4990-8eed-2280408df9b0.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/41201382/17_fc1f4a94-8076-4c26-a45f-e7fa4233bd44.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/41201077/17_24b7497c-8c3e-40f8-9065-41c8b0c5c9f2.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/31201669/17_d185c7d4-78e0-4c62-94a2-f132d5f699ea.jpg",
						"http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/91201002/17_5839c91e-f803-4e4e-99a0-0520c3614e3c.jpg" };
				String[] flightNo = new String[] { " 杭州新开元大酒店（西湖店）",
						" 浙江维多利亚丽嘉酒店", "杭州大酒店", "浙旅名庭酒店", "杭州香溢浣纱宾馆",
						"杭州伊美大酒店", "杭州索菲亚大酒店", "杭州环岛宾馆" };
				String[] leavetime = new String[] { "480", "580", "680", "780",
						"450", "320", "190", "199", "240", };
				List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
				//data是显示到listview中的数据
				for (int i = 0; i < img.length; i++) {
					Map<String, Object> item = new HashMap<String, Object>();
					Bitmap bmp = null;
					 new ImageDownloadTask().execute(img[i], bmp);
					// 每一行显示3个对象，图片，名称，价格
					item.put("img", bmp);
					item.put("name", flightNo[i]);
					item.put("price", leavetime[i]);
					data.add(item);
				}
				//simpleadapter用来显示数据
				SimpleAdapter simpleAdapter = new SimpleAdapter(
						HotelActivity.this, data, R.layout.hotel_item,
						new String[] { "img", "name", "price" }, new int[] {
								R.id.hotel_photo, R.id.tv_htname,
								R.id.tv_htprice });
				//绑定view的属性，设置第一个view显示图片
				simpleAdapter.setViewBinder(new ViewBinder() {
					
					@Override
					public boolean setViewValue(View view, Object data,
							String arg2) {
						// TODO Auto-generated method stub
						if (view instanceof ImageView && data instanceof Bitmap) {
							//如果输入是imageview，对应的内容是bmp图像
							ImageView iv = (ImageView) view;
							//imageview的内容为bmp
							iv.setImageBitmap((Bitmap) data);
							return true;
						} else
							return false;
					}

				});
				//跳转到酒店信息
				setContentView(R.layout.hotel_info);
				lv = (ListView) findViewById(R.id.lv_hotel_info);
				lv.setAdapter(simpleAdapter);
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						Map<String, String> hotel =( HashMap<String, String>)lv.getItemAtPosition(arg2); 
						name = hotel.get("name");
						
						//data是显示到listview中的数据
						List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
						String[] room = new String[]{"标间","套房","豪华双人房"};
						String[] price = new String[]{"￥300", "￥500","￥700"};
						for (int i = 0; i < room.length; i++) {
							Map<String, Object> item = new HashMap<String, Object>();
							// 每一行显示2个对象,房型,价格
							item.put("room", room[i]);
							item.put("price", price[i]);
							data.add(item);
						}
						//simpleadapter用来显示数据
						SimpleAdapter simpleAdapter = new SimpleAdapter(
								HotelActivity.this, data, R.layout.roomtype,
								new String[] {"room", "price" }, new int[] {
										R.id.tv_roomtype, R.id.tv_room_price});
						setContentView(R.layout.hotel_detail);
						
						
						odcheckin = (TextView) findViewById(R.id.et_od_chkin);		
						//退房时间输入框
						odcheckout = (TextView) findViewById(R.id.et_od_chkout);	
						//查询按钮添加事件响应
						odcheckin.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								//获得系统的时间
								Calendar c = Calendar.getInstance();
								//选择入住的时间
								new DatePickerDialog(HotelActivity.this,
										new DatePickerDialog.OnDateSetListener() {

											@Override
											public void onDateSet(DatePicker view, int year,
													int monthOfYear, int dayOfMonth) {
												scheckin = year + "-" + monthOfYear + "-"
														+ dayOfMonth ; 
												//设置输入框里的时间为用户的输入
												odcheckin.setText(scheckin);
											}

										}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
												.get(Calendar.DAY_OF_MONTH)).show();
							}

						});
						//设置退房的时间，输入框被点击时跳出设置时间的对话框
						odcheckout.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View arg0) {
								//获取系统的时间
								Calendar c = Calendar.getInstance();
								//时间选择器
								new DatePickerDialog(HotelActivity.this,
										new DatePickerDialog.OnDateSetListener() {
											@Override
											public void onDateSet(DatePicker view, int year,
													int monthOfYear, int dayOfMonth) {
												// checkout输入框设置为用户的输入
												scheckout = year + "-" + monthOfYear + "-"
														+ dayOfMonth;
												odcheckout.setText(scheckout);
											}
										}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
												.get(Calendar.DAY_OF_MONTH)).show();
							}

						});
						
						TextView tv = (TextView)findViewById(R.id.tv_htdt_name);
						tv.setText(name);
						lv = (ListView) findViewById(R.id.roomlist);
						lv.setAdapter(simpleAdapter);
						lv.setOnItemClickListener(new OnItemClickListener(){

							@Override
							public void onItemClick(AdapterView<?> arg0,
									View arg1, int arg2, long arg3) {
								setContentView(R.layout.hotel_order);
								TextView tv = (TextView)findViewById(R.id.tv_od_hname);
								tv.setText(name);
								Map<String, String> oder =( HashMap<String, String>)lv.getItemAtPosition(arg2); 
				                String room=oder.get("room"); 	//房型
				                TextView tv_room = (TextView)findViewById(R.id.tv_roomtype);
				                tv_room.setText(room);
				                TextView periord = (TextView)findViewById(R.id.tv_chekin_checkout);
				                periord.setText(scheckin+" ~ "+scheckout);
				                
				                ImageButton confirm = (ImageButton)findViewById(R.id.order_confirm);
				                confirm.setOnClickListener(new OnClickListener(){

				        			@Override
				        			public void onClick(View arg0) {
				        				Intent intent = new Intent();    
				        				//启动新的activity来负责交易管理
				        	            intent.setClass(HotelActivity.this, TransactionListActivity.class);   
				        	            HotelActivity.this.startActivity(intent);   
				        			}
				                	
				                });
							}
							
						});
					}

				});

			}

		});
	}
}
