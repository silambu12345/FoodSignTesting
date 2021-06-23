package testpack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InputPlan extends Setup {
	@Test(priority=1)
	public void addInputPlanTest() throws InterruptedException, AWTException
	{
		addInputPlan();
	}

	@Test(priority=3)
	public void viewTest() throws InterruptedException
	{
		viewInputPlan();
	}
	@Test(priority=2)
	public void deleteTest() throws InterruptedException
	{
		deleteInputPlan();
	}
	@Test(priority=5)
	public void cloneInputPlanTest() throws InterruptedException
	{
		cloneInputPlan();
	}
	@Test(priority=5)
	public void editInputPlanTest() throws InterruptedException {
		editInputPlan();
	}
	private void addInputPlan() throws InterruptedException, AWTException
	{
		d.manage().timeouts().implicitlyWait(190,TimeUnit.SECONDS);
		Robot robot = new Robot();
		WebElement ip=d.findElement(By.xpath(property.getProperty("isettings_xpath")));
		ip.click();
		WebElement ipc=d.findElement(By.xpath(property.getProperty("ip_xpath")));
		ipc.click();
		WebElement ip1=d.findElement(By.xpath(property.getProperty("iplanclick")));
		ip1.click();
		WebElement addip=d.findElement(By.xpath(property.getProperty("addip_xpath")));
		addip.click();
		Thread.sleep(8000);
		WebElement yearip=d.findElement(By.xpath(property.getProperty("yearip")));
		yearip.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
		WebElement seasons=d.findElement(By.xpath(property.getProperty("season_xpath")));
		seasons.click(); 
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement cvip=d.findElement(By.xpath(property.getProperty("cvip_xpath")));
		cvip.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		WebElement applntype=d.findElement(By.xpath(property.getProperty("applntype_xpath")));
		applntype.click(); 
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement inputcategory=d.findElement(By.xpath(property.getProperty("inputcategory_xpath")));
		inputcategory.click(); 
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER); 
		WebElement activitytype=d.findElement(By.xpath(property.getProperty("activitytype_xpath")));
		activitytype.click(); 
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement flood=d.findElement(By.xpath(property.getProperty("flood_xpath")));
		flood.click(); 
		Thread.sleep(6000);
		WebElement c1=d.findElement(By.xpath(property.getProperty("c1_xpath")));
		c1.click(); 
		Thread.sleep(6000);
		WebElement sp=d.findElement(By.xpath(property.getProperty("s&p_xpath")));
		sp.click(); 
		WebElement yes=d.findElement(By.xpath(property.getProperty("yes_xpath")));
		yes.click(); 


	}

	private void viewInputPlan() throws InterruptedException {
	Thread.sleep(8000);
		WebElement view=d.findElement(By.xpath(property.getProperty("view_xpath")));
		view.click();
		Thread.sleep(3000);
		WebElement close=d.findElement(By.xpath(property.getProperty("close_xpath")));
		close.click();
	}

	private void deleteInputPlan() throws InterruptedException
	{
		Thread.sleep(6000);
		

		WebElement sy=d.findElement(By.xpath(property.getProperty("sy_xpath")));
		sy.click(); 
		WebElement rc=d.findElement(By.xpath(property.getProperty("rc_xpath")));
		rc.click();
		WebElement dip=d.findElement(By.xpath(property.getProperty("dip_xpath")));
		dip.click();
		WebElement dlting=d.findElement(By.xpath(property.getProperty("dlting_xpath")));
		dlting.click();
		d.manage().timeouts().implicitlyWait(190, TimeUnit.SECONDS);
		WebElement dltip=d.findElement(By.xpath(property.getProperty("dltip_xpath")));
		dltip.click();
		
	}

	private void cloneInputPlan() throws InterruptedException
	{
		Thread.sleep(6000);
		WebElement clone=d.findElement(By.xpath(property.getProperty("clone_xpath")));
		clone.click();
		Thread.sleep(2000);
		WebElement c5=d.findElement(By.xpath(property.getProperty("c5_xpath")));
		c5.click();
		WebElement c6=d.findElement(By.xpath(property.getProperty("c6_xpath")));
		c6.click();
		WebElement c7=d.findElement(By.xpath(property.getProperty("c7_xpath")));
		c7.click();
		WebElement c8=d.findElement(By.xpath(property.getProperty("c8_xpath")));
		c8.click();
	}

	private void editInputPlan() throws InterruptedException
	{
		Thread.sleep(9000);
		WebElement editip=d.findElement(By.xpath(property.getProperty("editip_xpath")));
		editip.click();
		WebElement c9=d.findElement(By.xpath(property.getProperty("c9_xpath")));
		c9.click();
		WebElement ferti=d.findElement(By.xpath(property.getProperty("ferti_xpath")));
		ferti.click();
		WebElement c10=d.findElement(By.xpath(property.getProperty("c10_xpath")));
		c10.click();
		WebElement c11=d.findElement(By.xpath(property.getProperty("c11_xpath")));
		c11.click();
		WebElement c12=d.findElement(By.xpath(property.getProperty("c12_xpath")));
		c12.click();
	}
}

