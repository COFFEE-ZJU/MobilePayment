package cn.edu.zju.cs.onlinepayment.transaction.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zju.cs.onlinepayment.transaction.data.Constants.STATE_TYPE;
import cn.edu.zju.cs.onlinepayment.transaction.data.Constants.TRANS_TYPE;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		TransDetailItem[] tdi = new TransDetailItem[4];
		tdi[0] = new TransDetailItem("1", "TID1001", TRANS_TYPE.HOTEL,
				STATE_TYPE.UNPAID, "2013-06-13", "Hilton", "10000", "yibo",
				"13888888888", "399111199201018888", null, null, null,
				"Hilton Chicago", "XXX Ave., Chicago, USA", "+1-12345678",
				"Single Room", "2013-08-11", "2013-08-14", null, null, null,
				null, null, null, null, null, false);
		tdi[1] = new TransDetailItem("2", "TID1002", TRANS_TYPE.HOTEL,
				STATE_TYPE.PAID, "2013-06-11", "xx hotel", "600", "yibo",
				"13888888888", "399111199201018888", "2013-06-12 12:01", null,
				null, "xx hotel Shanghai", "XXX Ave., Shanghai, PRC",
				"+86-12345678", "Single Room", "2013-08-11", "2013-08-14",
				null, null, null, null, null, null, null, null, false);
		tdi[2] = new TransDetailItem("3", "TID1003", TRANS_TYPE.FLIGHT,
				STATE_TYPE.CONFIRMED, "2013-06-10", "xx air", "6000", "yibo",
				"13888888888", "399111199201018888", "2013-06-12 12:01",
				"2013-06-12 12:21", "2013-06-12 12:31", null, null, null, null,
				null, null, "CA1234", "xx air", "Shanghai", "Pudong Airport",
				"Chicago", "xxx Airport", "2013-08-10 17:00",
				"2013-08-11 10:00", false);
		tdi[3] = new TransDetailItem("4", "TID1004", TRANS_TYPE.FLIGHT,
				STATE_TYPE.SHIPPED, "2013-06-10", "xx air", "6000", "yibo",
				"13888888888", "399111199201018888", "2013-06-12 12:01",
				"2013-06-12 12:21", "2013-06-12 12:31", null, null, null, null,
				null, null, "CA1234", "xx air", "Shanghai", "Pudong Airport",
				"Chicago", "xxx Airport", "2013-08-10 17:00",
				"2013-08-11 10:00", false);

		for (int i = 0; i < tdi.length; i++)
			addItem(new DummyItem(tdi[i].id, tdi[i].getTitle(), tdi[i].price,
					tdi[i].orderTime, "state: " + tdi[i].state, tdi[i]));
		// addItem(new DummyItem("3",
		// "Hotel in Shanghai","��500","6-01","state: confirmed","date ,status, etc."));
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String title;
		public String price;
		public String time;
		public String state;
		public TransDetailItem details;

		public DummyItem(String id, String title, String price, String time,
				String state, TransDetailItem details) {
			this.id = id;
			this.title = title;
			this.price = price;
			this.time = time;
			this.state = state;
			this.details = details;
		}

		@Override
		public String toString() {
			return title;
		}
	}

	public static class TransDetailItem {

		public String id;
		public String transID;
		public TRANS_TYPE type;
		public STATE_TYPE state;
		public String orderTime;
		public String seller;
		public String price;
		public String customerName;
		public String customerPhone;
		public String customerIDNumber;

		public String payTime;
		public String deliveryTime;
		public String confirmTime;

		public String hotelName;
		public String hotelAddress;
		public String hotelPhone;
		public String roomType;
		public String checkinDate;
		public String checkoutDate;

		public String flightNumber;
		public String flightCompany;
		public String originCity;
		public String originAirport;
		public String destCity;
		public String destAirport;
		public String takeoffTime;
		public String arrivalTime;

		public boolean isCommented;

		public TransDetailItem(String id, String transID, TRANS_TYPE type,
				STATE_TYPE state, String orderTime, String seller,
				String price, String customerName, String customerPhone,
				String customerIDNumber,

				String payTime, String deliveryTime, String confirmTime,

				String hotelName, String hotelAddress, String hotelPhone,
				String roomType, String checkinDate, String checkoutDate,

				String flightNumber, String flightCompany, String originCity,
				String originAirport, String destCity, String destAirport,
				String takeoffTime, String arrivalTime, boolean isCommented) {

			this.id = id;
			this.transID = transID;
			this.type = type;
			this.state = state;
			this.orderTime = orderTime;
			this.seller = seller;
			this.price = price;
			this.customerName = customerName;
			this.customerPhone = customerPhone;
			this.customerIDNumber = customerIDNumber;

			this.payTime = payTime;
			this.deliveryTime = deliveryTime;
			this.confirmTime = confirmTime;

			this.hotelName = hotelName;
			this.hotelAddress = hotelAddress;
			this.hotelPhone = hotelPhone;
			this.roomType = roomType;
			this.checkinDate = checkinDate;
			this.checkoutDate = checkoutDate;

			this.flightNumber = flightNumber;
			this.flightCompany = flightCompany;
			this.originCity = originCity;
			this.originAirport = originAirport;
			this.destCity = destCity;
			this.destAirport = destAirport;
			this.takeoffTime = takeoffTime;
			this.arrivalTime = arrivalTime;

			this.isCommented = isCommented;
		}

		public String getTitle() {
			if (type == TRANS_TYPE.FLIGHT)
				return ("Flight: " + originCity + " to " + destCity);
			else if (type == TRANS_TYPE.HOTEL)
				return ("Hotel: " + checkinDate + " to " + checkoutDate);
			else
				return "error!";
		}

	}
}
