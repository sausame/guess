package com.example.guess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactListAdapter extends BaseAdapter {

	private Context mContext = null;
	private ContactsManager mContactsManager = null;

	public ContactListAdapter(Context context, ContactsManager contactsManager) {
		mContext = context;
		mContactsManager = contactsManager;
	}

	@Override
	public int getCount() {
		return mContactsManager.getContactsNumber();
	}

	@Override
	public Object getItem(int position) {
		return mContactsManager.getContact(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;

		if (convertView == null) {
			vh = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.list_view_item, null);
			vh.index = (TextView) convertView.findViewById(R.id.index);
			vh.gender = (TextView) convertView.findViewById(R.id.gender);
			vh.distance = (TextView) convertView.findViewById(R.id.distance);
			vh.name = (TextView) convertView.findViewById(R.id.name);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		vh.set(position, mContactsManager.getContact(position));

		return convertView;
	}

	private static class ViewHolder {
		private TextView index;
		private TextView gender;
		private TextView distance;
		private TextView name;

		private void set(int position, final Contact contact) {
			index.setText("NO. " + position);
			gender.setText(contact.getGender());
			distance.setText(contact.getDistance());
			name.setText(contact.name);
		}
	}
}
