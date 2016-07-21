package com.skyline.androidaop.io;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.skyline.androidaop.container.io.IoCallback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by jairus on 16/7/20.
 */
@RunWith(AndroidJUnit4.class)
public class FooDaoTest {
	public static final String LOG_TAG = "FooDaoTest";

	FooDao dao;

	@Before
	public void before() {
		dao = new FooDao();
	}

	@Test
	public void test() {
		Log.i(LOG_TAG, "test, currentThread: " + Thread.currentThread());
		IoCallback<Object> callback = new IoCallback<Object>() {
			@Override
			public void success(Object o) {
				Log.i(LOG_TAG, "success, o: " + o);
			}

			@Override
			public void fail(Throwable t) {
				Log.w(LOG_TAG, "fail", t);
			}
		};
		dao.get0(callback);
		dao.get1(callback);
	}
}
