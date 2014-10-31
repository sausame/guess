package com.example.guess;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private final static int CONTACT_NUM = 30;

	private ContactsManager mContactsManager = new ContactsManager(CONTACT_NUM);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
		initUIs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initUIs() {
		ListView listView = (ListView) this.findViewById(R.id.contact_list);
		listView.setAdapter(new ContactListAdapter(this));
		listView.setOnItemClickListener(mListener);
	}

	OnItemClickListener mListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Toast.makeText(getBaseContext(), "Send message to " + position,
					Toast.LENGTH_SHORT).show();
		}
	};

	private void initData() {

	}
}
