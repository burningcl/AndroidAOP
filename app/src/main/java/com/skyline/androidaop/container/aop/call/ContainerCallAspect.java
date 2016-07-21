package com.skyline.androidaop.container.aop.call;

import android.util.Log;

import com.skyline.androidaop.container.Container;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jairus on 16/7/19.
 */
@Aspect
public class ContainerCallAspect {

	public static final String LOG_TAG = "ContainerCallAspect";

	private static final String POINTCUT_METHOD =
			"call(@com.skyline.androidaop.container.aop.call.ContainerCallAction * *(..))";


	@Pointcut(POINTCUT_METHOD)
	public void containerCallAction() {
	}

	@Before("containerCallAction()")
	public void beforeCall(JoinPoint joinPoint) throws Throwable {
		FridgeOnCall container = (FridgeOnCall) joinPoint.getTarget();
		Log.i(LOG_TAG, "打开" + container);
	}

	@After("containerCallAction()")
	public void afterCall(JoinPoint joinPoint) throws Throwable {
		Container container = (Container) joinPoint.getTarget();
		Log.i(LOG_TAG, "关上" + container);
	}
}
