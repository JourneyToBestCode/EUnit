package com.ericsson.eunit;

import com.ericsson.eunit.TestCase;

public class MainClass {

	public static void main(String args[]) {
		
		TestCase myTestCase = new TestCase();
		for (int i=0; i<args.length; i++)
			myTestCase.runTest(args[i]);
		System.out.println("Total case: " + TestCase.totalCaseNum);
		System.out.println("Seccuss case: " + (TestCase.totalCaseNum - TestCase.failedCaseNum));
		System.out.println("Failed case: " + TestCase.failedCaseNum);
	}
}
