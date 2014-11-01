package com.example.guess;

public class ContactStateMachine {

	private final static int MAX_TRYING_TIMES = 3;

	private int mTryingTime = 0;

	private Contact mContact;

	public ContactStateMachine(Contact contact) {
		mContact = contact;
	}

	public final boolean isFound(final Contact contact) {
		return mContact.equals(contact);
	}

	public final boolean isTimeout() {
		return mTryingTime > MAX_TRYING_TIMES;
	}

	public final String getHint(final Contact contact) {
		if (++ mTryingTime > MAX_TRYING_TIMES)
		   	return "Timeout!!! " + mContact.getGender()
			   	+ ", " + mContact.getDistance() 
			   	+ ", " + mContact.getMidName();

		String hint = "NO. " + mTryingTime + " hint: ";
		switch (mTryingTime) {
			case 1:
				hint += mContact.getGender();
				break;
			case 2:
				hint += mContact.getDistance();
				break;
			case 3:
				hint += "Mid name is " + mContact.getMidName();
				break;

			default:
				break;
		}

		return hint;
	}

}

