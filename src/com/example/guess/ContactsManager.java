package com.example.guess;

public class ContactsManager {

	private Contact[] mContacts;
	private int mPosition;

	public ContactsManager(int num) {
		setContacts(new Contact[num]);
	}

	public void setPosition(int position) {
		mPosition = position;
	}

	public final int getPosition() {
		return mPosition;
	}

	public Contact[] getContacts() {
		return mContacts;
	}

	public void setContacts(Contact[] contacts) {
		mContacts = contacts;
	}
}
