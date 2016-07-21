package com.skyline.androidaop.container.aop;

import com.skyline.androidaop.container.Fridge;
import com.skyline.androidaop.container.Putalble;

/**
 * Created by jairus on 16/7/19.
 */
public class FridgeThrowException extends Fridge {

	@ContainerAction
	public void put(Putalble putalble){
		super.put(putalble);
		throw new RuntimeException();
	}

}
