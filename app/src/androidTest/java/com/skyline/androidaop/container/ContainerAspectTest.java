package com.skyline.androidaop.container;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.skyline.androidaop.container.aop.FridgeWidthAop;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jairus on 16/7/19.
 */
@RunWith(AndroidJUnit4.class)
public class ContainerAspectTest {

	public static final String LOG_TAG = "ContainerAspectTest";

	@Test
	public void testWithoutAop() {
		Log.d(LOG_TAG, "testWithoutAop");
		Container container = new Fridge();
		Log.i(LOG_TAG, "打开" + container);
		container.put(new Putalble("猴子"));
		Log.i(LOG_TAG, "关上" + container);
	}

	@Test
	public void testWidthProxy() {
		Log.d(LOG_TAG, "testWidthProxy");
		Container containerProxy = new ContainerProxy(new Fridge());
		containerProxy.put(new Putalble("老虎"));
	}

	@Test
	public void testWidthAop() {
		Log.d(LOG_TAG, "testWidthAop");
		Container fridgeWidthAop = new FridgeWidthAop();
		fridgeWidthAop.put(new Putalble("大象"));
	}

}
