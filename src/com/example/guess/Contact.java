package com.example.guess;

import java.util.Random;

public class Contact {

	public static class Mask {
		public static final int NONE = 0;
		public static final int GENDER = 1;
		public static final int DISTANCE = 2;
		public static final int NAME = 4;
	}

	public static final int MALE = 0;
	public static final int FEMALE = 1;

	public int gender;

	public static final int VERY_NEAR = 0;	// < 1km
	public static final int NEAR = 1;		// < 5km
	public static final int FAR = 2;        // < 50km
	public static final int VERY_FAR = 3;   // < 100km
	public static final int INFINITE = 4;   // > 100km

	public int distance;

	public String name;

	public final boolean equals(final Contact contact) {
		if (null == contact) return false;

		if (contact.gender != gender) return false;
		if (contact.distance != distance) return false;

		if (name == null || name.isEmpty()) return false;
		return name.equals(contact.name);
	}

	public final boolean equals(final Contact contact, final int mask) {
		if (null == contact) return false;

		if ((mask & Mask.GENDER == Mask.GENDER) && contact.gender != gender) return false;
		if ((mask & Mask.DISTANCE == Mask.DISTANCE) && contact.distance != distance) return false;

		if (mask & Mask.NAME == Mask.NAME) {
			if (name == null || name.isEmpty()) return false;
			return name.equals(contact.name);
		}

		return true;
	}

	public final String getGender() {
		switch (gender) {
			case MALE:
			   	return "male";
			case FEMALE:
			   	return "female";

			default:
				return null;
		}
	}

	public final String getDistance() {
		switch (distance) {
			case VERY_NEAR:
				return "< 1km";
			case NEAR:
				return "< 5km";
			case FAR:
				return "< 50km";
			case VERY_FAR:
				return "< 100km";
			case INFINITE:
				return "> 100km";

			default:
				return null;
		}
	}

	public final String getMidName() {
		if (name == null || name.isEmpty()) return null;
		int mid = name.length() / 2;
		return name.substring(mid, mid + 1);
	}

	public final static Contact createRandom() {
		Contact contact = new Contact();
		
		Random random = new Random();

		contact.gender = random.nextInt(2);
		contact.distance = random.nextInt(5);
		contact.name = "";

		int length = 1 + random.nextInt(10);
		for (; length > 0; length --) {
			contact.name += "" + random.nextInt(10);
		}

		return contact;
	}
}

