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

	public final int getContactsNumber() {
		return null == mContacts ? 0 : mContacts.length;
	}

	public Contact getContact(int index) {
		return mContacts[index];
	}

	public void setContacts(Contact[] contacts) {
		mContacts = contacts;
	}

	public final static ContactsManager createRandom(int num) {
		ContactsManager manager = new ContactsManager(num);

		for (int i = 0; i < num; i ++) {
			manager.mContacts[i] = Contact.createRandom();
		}

		return manager;
	}
}
