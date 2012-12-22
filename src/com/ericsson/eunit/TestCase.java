package com.ericsson.eunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {

	public static int totalCaseNum = 0;
	public static int successCaseNum = 0;
	public static int failedCaseNum = 0;
	
	/*
	 * run test case
	 */
	public void runTest(String className) {
		Class<?> testClass = null;
		Method methods[] = null;
		if(className.isEmpty()) {
			System.out.println("Error when load test class: class name is empty!");
			return;
		}
		System.out.println("Begin to test class:" + className);
		try {
			testClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("Error when load test class: " + e.toString());
			return;
		}
		methods = testClass.getMethods();
		for(Method method : methods) {
			if(isTestMethod(method)) {
				try {
					Object testClassObject = testClass.newInstance();
					method.invoke(testClassObject, (Object[]) new Class[0]);
				} catch (IllegalAccessException | IllegalArgumentException
						| InstantiationException e) {
					System.out.println("Error when load test method: " + e.toString());
					return;
				} catch (InvocationTargetException e) {
					System.out.println("Error when load test method: " + e.getTargetException().toString());
					e.printStackTrace();
					return;
				}
			}
		}
		System.out.println("End to test class:" + className);
	}

	/*
	 * judge whether a method of the class is a test method or not
	 */
	private boolean isTestMethod(Method method) {
		if( method.getParameterTypes().length == 0 && method.getName().startsWith("test")) {
			totalCaseNum += 1;
			return true;
		}
		return false;
	}
	
}
