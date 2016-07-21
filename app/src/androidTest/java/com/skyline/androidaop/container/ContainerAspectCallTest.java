package com.skyline.androidaop.container;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.skyline.androidaop.container.aop.FridgeWidthAop;
import com.skyline.androidaop.container.aop.call.FridgeOnCall;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jairus on 16/7/19.
 */
@RunWith(AndroidJUnit4.class)
public class ContainerAspectCallTest {

	public static final String LOG_TAG = "ContainerAspectTest";

	@Test
	 public void testOnExecution() {
		Log.d(LOG_TAG, "testOnExecution");
		Container fridgeOnExecution = new FridgeWidthAop();
		fridgeOnExecution.put(new Putalble("大象"));
	}

	@Test
	public void testOnCall() {
		Log.d(LOG_TAG, "testOnCall");
		FridgeOnCall fridgeOnCall = new FridgeOnCall();
		fridgeOnCall.put(new Putalble("大象"));
	}

}
