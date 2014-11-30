package com.example.guess;

public class ContactsManager {

	private Contact[] mContacts;
	private int mPosition;

	private Contact[] mSelectedContacts;
	private int mContactMask = 0;

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

	public void setContactMask(int mask, final Contact contact) {
		mContactMask = mask;

		int count = 0;
		for (Contact oneContact : mContacts) {
			if (oneContact.equals(contact, mask) {
				count ++;
			}
		}

		mSelectedContacts = new Contact[count];

		count = 0;
		for (Contact oneContact : mContacts) {
			if (oneContact.equals(contact, mask) {
				mSelectedContacts[count ++] = oneContact;
			}
		}
	}

	public final int getSelectedContactsNumber() {
		return null == mSelectedContacts ? 0 : mSelectedContacts.length;
	}

	public Contact getSelectedContact(int index) {
		return mSelectedContacts[index];
	}

	public final static ContactsManager createRandom(int num) {
		ContactsManager manager = new ContactsManager(num);

		for (int i = 0; i < num; i ++) {
			manager.mContacts[i] = Contact.createRandom();
		}

		return manager;
	}
}
