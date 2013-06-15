package cn.edu.zju.cs.onlinepayment.transaction;

import com.pclee.onlinebooking.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/**
 * An activity representing a list of Transactions. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link TransactionDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link TransactionListFragment} and the item details (if present) is a
 * {@link TransactionDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link TransactionListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class TransactionListActivity extends FragmentActivity implements
		TransactionListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction_list);

		if (findViewById(R.id.transaction_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((TransactionListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.transaction_list))
					.setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link TransactionListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		Log.d("Debug", "onItemSelected");
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(TransactionDetailFragment.ARG_ITEM_ID, id);
			TransactionDetailFragment fragment = new TransactionDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.transaction_detail_container, fragment)
					.commit();

		} else {
			Log.d("Debug", "onItemSelected_one_pane");
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this,
					TransactionDetailActivity.class);
			detailIntent.putExtra(TransactionDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
