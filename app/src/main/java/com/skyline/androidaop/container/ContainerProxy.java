package com.skyline.androidaop.container;

import android.util.Log;

/**
 * 容器的静态代理类
 * Created by jairus on 16/7/19.
 */
public class ContainerProxy implements Container {

	public static final String LOG_TAG = "ContainerProxy";

	public Container container;

	public ContainerProxy(Container container) {
		this.container = container;
	}

	@Override
	public void put(Putalble obj) {
		Log.i(LOG_TAG, "打开" + container);
		container.put(obj);
		Log.i(LOG_TAG, "关上" + container);
	}
}
