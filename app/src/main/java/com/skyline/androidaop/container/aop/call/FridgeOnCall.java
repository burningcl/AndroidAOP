package com.skyline.androidaop.container.aop.call;

import com.skyline.androidaop.container.Fridge;
import com.skyline.androidaop.container.Putalble;

/**
 * Created by jairus on 16/7/19.
 */
public class FridgeOnCall extends Fridge {

	@ContainerCallAction
	public void put(Putalble putalble){
		super.put(putalble);
	}

}
