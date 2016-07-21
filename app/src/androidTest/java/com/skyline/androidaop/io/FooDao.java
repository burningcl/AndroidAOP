package com.skyline.androidaop.io;

import android.support.annotation.NonNull;
import android.util.Log;

import com.skyline.androidaop.container.io.IoCallback;
import com.skyline.androidaop.container.io.RunOnIoThread;

/**
 * Created by jairus on 16/7/20.
 */
public class FooDao {
	public static final String LOG_TAG = "FooDao";

	@RunOnIoThread
	public void get0(@NonNull IoCallback<Object> callback) {
		Log.i(LOG_TAG, "get0, currentThread: " + Thread.currentThread());
		callback.success(null);
	}

	@RunOnIoThread
	public void get1(@NonNull IoCallback<Object> callback) {
		Log.i(LOG_TAG, "get1, currentThread: " + Thread.currentThread());
		throw new RuntimeException();
	}
}
