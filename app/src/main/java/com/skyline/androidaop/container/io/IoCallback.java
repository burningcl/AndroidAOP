package com.skyline.androidaop.container.io;

/**
 * Created by jairus on 16/7/20.
 */
public interface IoCallback<T> {
	void success(T t);
	void fail(Throwable t);
}
