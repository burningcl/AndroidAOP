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
public class ContainerAspectPerformanceTest {

	public static final String LOG_TAG = "ContainerAspectPerformanceTest";

	public void testWithoutAop() {
		Log.d(LOG_TAG, "testWithoutAop");
		Container container = new Fridge();
		Log.i(LOG_TAG, "打开" + container);
		container.put(new Putalble("猴子"));
		Log.i(LOG_TAG, "关上" + container);
	}

	public void testWidthAop() {
		Log.d(LOG_TAG, "testWidthAop");
		Container fridgeWidthAop = new FridgeWidthAop();
		fridgeWidthAop.put(new Putalble("大象"));
	}

	@Test
	public void test() {
		int total = 1000;
		long ms = 1000 * 1000;
		long t1 = System.nanoTime();
		for (int i = 0; i < total; i++) {
			testWithoutAop();
		}
		long t2 = System.nanoTime();
		for (int i = 0; i < total; i++) {
			testWidthAop();
		}
		long t3 = System.nanoTime();
		Log.w(LOG_TAG, "testWithoutAop, cost: " + (double) (t2 - t1) / ms + ", testWidthAop, cost: " + (double) (t3 - t2) / ms);
	}

}
