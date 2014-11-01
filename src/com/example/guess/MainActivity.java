package com.example.guess;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private final static int CONTACT_NUM = 10;

	private ContactsManager mContactsManager = null;
	private ContactStateMachine mContactStateMachine = null;
	private int mPosition = -1;
	
	private Button mButton;
	private ListView mListView;
	private TextView mTextView;

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
		mListView = (ListView) findViewById(R.id.contact_list);
		mListView.setAdapter(new ContactListAdapter(this, mContactsManager));
		mListView.setOnItemClickListener(mOnItemClickListener);
		
		mButton = (Button) findViewById(R.id.button);
		mButton.setOnClickListener(mOnClickListener);
		
		mTextView = (TextView) findViewById(R.id.infor);
	}

	OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (null == mContactStateMachine) return;

			final Contact contact = mContactsManager.getContact(position);
			if (mContactStateMachine.isFound(contact)) {
				mTextView.setText("Found!!!");
				mContactStateMachine = null;
				mButton.setEnabled(true);
				return;
			}

			mTextView.setText(mContactStateMachine.getHint(contact));

			if (mContactStateMachine.isTimeout()) {
				mContactStateMachine = null;
				mButton.setEnabled(true);
			}
		}
	};

	OnClickListener mOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			String message = "";
			if (mPosition >= 0) {
				message = "Last choosed: " + mPosition + "\n";
			}

			mPosition = (new Random()).nextInt(CONTACT_NUM);
			mContactStateMachine = new ContactStateMachine(
					mContactsManager.getContact(mPosition));
			
			view.setEnabled(false);

			mTextView.setText(message + "Please start to guess");
		}
	};

	private void initData() {
		mContactsManager = ContactsManager.createRandom(CONTACT_NUM);
	}

}
