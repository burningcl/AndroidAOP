package com.skyline.androidaop.container;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.skyline.androidaop.container.aop.FridgeThrowException;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jairus on 16/7/19.
 */
@RunWith(AndroidJUnit4.class)
public class ContainerAspectExceptionTest {

	public static final String LOG_TAG = "ContainerAspectTest";

	@Test
	public void testWidthAop() {
		Log.d(LOG_TAG, "testWidthAop");
		Container fridgeWidthAop = new FridgeThrowException();
		fridgeWidthAop.put(new Putalble("大象"));
	}

}
