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
	private Contact mContact = null;
	private int mContactMask = Contact.Mask.NONE;

	public ContactListAdapter(Context context, ContactsManager contactsManager) {
		mContext = context;
		mContactsManager = contactsManager;
	}

	public void setContact(Contact contact) {
		mContact = contact;
	}

	public void setContactMask(int mask) {
		mContactMask = mask;
		notifyDataSetChanged();
	}

	public void resetContact() {
		mContact = null;
		mContactMask = Contact.Mask.NONE;
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

		boolean enabled = mContact.equals(contact, mContactMask);
		convertView.setEnabled(enabled);

		vh.set(position, mContactsManager.getContact(position));

		return convertView;
	}

	private static class ViewHolder {
		private TextView index;
		private TextView gender;
		private TextView distance;
		private TextView name;

		private void set(int position, final Contact contact, boolean enabled) {

			index.setText("NO. " + position);
			index.setEnabled(enabled);

			gender.setText(contact.getGender());
			gender.setEnabled(enabled);

			distance.setText(contact.getDistance());
			distance.setEnabled(enabled);

			name.setText(contact.name);
			name.setEnabled(enabled);
		}
	}
}
