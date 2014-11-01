package com.example.guess;

import java.util.Random;

public class Contact {

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
		if (name == null || name.isEmpty()) return false;
		return name.equals(contact.name);
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

