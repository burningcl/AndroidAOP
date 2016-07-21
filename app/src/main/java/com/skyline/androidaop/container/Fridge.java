package com.skyline.androidaop.container;

import android.util.Log;

/**
 * Created by jairus on 16/7/19.
 */
public class Fridge implements Container {

	public static final String LOG_TAG = "Fridge";

	@Override
	public void put(Putalble obj) {
		Log.i(LOG_TAG, "把" + obj + "放进" + this);
	}

	@Override
	public String toString() {
		return "冰箱";
	}

}
