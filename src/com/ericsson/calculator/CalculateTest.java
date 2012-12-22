package com.ericsson.calculator;

import com.ericsson.eunit.Assert;

public class CalculateTest {

	int a = 1;
	int b = 2;
	float fa = (float)1;
	float fb = (float)2;
	
	Calculate cal = new Calculate();
	
	public void testIntAdd() {
		int result = cal.add(a, b);
		int expectedResult = 3;
		Assert.assertEquals("test int add", expectedResult, result);
	}
	
	public void testFloatAdd() {
		float result = cal.add(fa, fb);
		float expectedResult = (float)3;
		Assert.assertEquals("test float add", expectedResult, result, (float)0);
	}
}
