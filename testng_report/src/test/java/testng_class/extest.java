package testng_class;

import org.testng.annotations.Test;

import Commons.utilis;

public class extest extends  utilis {
	@Test
public void test1_vlaidate_functionality()
{
	
	test=extent.createTest("Launch browser");
	test.info("user launcged the browser sucessfully");
	test.pass("homepage launched");
}
	
	@Test
public void test1_vlaidate_functionality1()
{
	
	test=extent.createTest("open the url");
	test.info("url opened");
	test.fail("url launched");
}
	@Test
public void test1_vlaidate_functionality12()
{
	
	test=extent.createTest("click on the element url");
	test.info("click on the element opened");
	test.skip("url launched");
}
}
