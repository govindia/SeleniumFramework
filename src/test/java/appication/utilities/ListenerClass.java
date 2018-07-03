/*package appication.utilities;

import java.io.IOException;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import org.testng.IAlterSuiteListener;
import org.testng.IAnnotationTransformer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;


public class ListenerClass implements ITestListener, ISuiteListener , IAnnotationTransformer, IAlterSuiteListener  {
	
	CommonLib objCommonLib = new CommonLib();

	public void onFinish(ITestContext Result) {
				
		System.out.println("Test Cases on finish :"+Result.getName());
		
	}

	public void onStart(ITestContext Result) {
				
		System.out.println("Test Cases on start :"+Result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
				
		System.out.println("Test cases on test failed :"+Result.getName());
		
	}

	public void onTestFailure(ITestResult Result) {
			
		objCommonLib.captureScreenShot(application.test.ConfigTest.driver, Result.getInstanceName(), Result.getName());
		System.out.println("The name of the test Suite failed is :"+Result.getInstanceName());
		System.out.println("The name of the testcase failed is :"+Result.getName());
		
	}

	public void onTestSkipped(ITestResult Result) {
				
		System.out.println("The name of the testcase skipped is :"+Result.getName());
		
	}

	public void onTestStart(ITestResult Result) {
				
		System.out.println("Test case on test start :"+Result.getName());
		
	}

	public void onTestSuccess(ITestResult Result) {
				
		System.out.println("The name of the testcase passed is :"+Result.getName());
		
	}

	public void onFinish(ISuite Result) {
		
		System.out.println("The Test Suite execution has finished: "+Result.getName());
	}

	public void onStart(ISuite suite) {
		
		System.out.println("The Test Suite execution Begins");
	}


	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
			String methodName = testMethod.getName();
			//System.out.println("MethodName is: "+methodName);
			String p = ReadingPropertyFile.prop.getProperty(methodName);
			//System.out.println("Value of priority is: "+p);
			annotation.setPriority(Integer.parseInt(p));
			String e = ReadingPropertyFile.enabled.getProperty(methodName);
			//System.out.println("Value of enabled is: "+e);
			annotation.setEnabled(Boolean.parseBoolean(e));
	}

	public void alter(List<XmlSuite> suites) {
		// TODO Auto-generated method stub
		
		ReadingPropertyFile rp = new ReadingPropertyFile();
		try{
			
			rp.readPriorityPropertyFile();
			rp.readTestCaseEnablePropertyFile();
		}
		
		catch(IOException e){
			
			e.printStackTrace();			
		}
	}
	


}
*/