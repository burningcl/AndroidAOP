package com.skyline.androidaop.container.aop;

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
public class ContainerAspect {

	public static final String LOG_TAG = "ContainerAspect";

	private static final String POINTCUT_METHOD =
			"execution(@com.skyline.androidaop.container.aop.ContainerAction * *(..))";

	//Pointcut（切入点）
	@Pointcut(POINTCUT_METHOD)
	public void containerAction() {
	}

	/**
	 * Weaving（织入）
	 * @param joinPoint Joint point（连接点）
	 * @throws Throwable
	 */
	//Advice（通知）及Aspect（切面）
	@Before("containerAction()")
	public void before(JoinPoint joinPoint) throws Throwable {
		Container container = (Container) joinPoint.getTarget();
		Log.i(LOG_TAG, "打开" + container);
	}

	@After("containerAction()")
	public void after(JoinPoint joinPoint) throws Throwable {
		Container container = (Container) joinPoint.getTarget();
		Log.i(LOG_TAG, "关上" + container);
	}
}
