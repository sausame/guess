package com.example.guess;

public class Contact {

	public static final int MALE = 0;
	public static final int FEMALE = 1;

	public int gender;

	public static final int VERY_NEAR = 1;	// < 1km
	public static final int NEAR = 2;		// < 5km
	public static final int FAR = 3;        // < 50km
	public static final int VERY_FAR = 4;   // < 100km
	public static final int INFINITE = 5;   // > 100km

	public int distance;

	public String name;
}

