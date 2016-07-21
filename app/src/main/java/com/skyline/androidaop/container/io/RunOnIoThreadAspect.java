package com.skyline.androidaop.container.io;

import android.os.AsyncTask;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jairus on 16/7/19.
 */
@Aspect
public class RunOnIoThreadAspect {

	public static final String LOG_TAG = "RunOnIoThreadAspect";

	private static final String POINTCUT_METHOD =
			"execution(@com.skyline.androidaop.container.io.RunOnIoThread * *(..))";

	@Pointcut(POINTCUT_METHOD)
	public void pointCut() {
	}

	@Around("pointCut()")
	public Object runOnIoThread(final ProceedingJoinPoint joinPoint) throws Throwable {
		AsyncTask.execute(new Runnable() {
			@Override
			public void run() {
				Object[] args = joinPoint.getArgs();
				IoCallback callback = null;
				if (args != null)
					for (Object arg : args) {
						if (arg instanceof IoCallback) {
							callback = (IoCallback) arg;
							break;
						}
					}
				try {
					joinPoint.proceed();
				} catch (Throwable throwable) {
					if (callback != null) {
						callback.fail(throwable);
					} else {
						Log.w(LOG_TAG, "joinPoint.proceed(), fail", throwable);
					}
				}
			}
		});
		return null;
	}

}
