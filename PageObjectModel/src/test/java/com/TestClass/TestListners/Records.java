package com.TestClass.TestListners;

import org.apache.poi.hpsf.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestClass.Utils.CommanUtils;


public class Records implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		CommanUtils.captureScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
	}
	

}
