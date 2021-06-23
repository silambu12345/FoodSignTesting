package testpack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class Variety extends Setup {

	@Test(priority=1)
	public void addCropTest() throws InterruptedException, AWTException
	{
		addCrop();
	}
	@Test(priority=2)
	public void cloneVarietyTest() throws InterruptedException {
		cloneVariety();
	}

	private void addCrop() throws InterruptedException, AWTException
	{
		Robot robot = new Robot();
		Thread.sleep(5000);
		d.manage().timeouts().implicitlyWait(190,TimeUnit.SECONDS);
		WebElement Settings=d.findElement(By.xpath(property.getProperty("isettings_xpath")));
		Settings.click();
		WebElement ip=d.findElement(By.xpath(property.getProperty("ip_xpath")));
		ip.click();
		WebElement addcrop=d.findElement(By.xpath(property.getProperty("addcrop_xpath")));
		addcrop.click();
		Thread.sleep(8000);
		WebElement cropname=d.findElement(By.xpath(property.getProperty("cropname_xpath")));
		cropname.click();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		WebElement cvs=d.findElement(By.xpath(property.getProperty("cvs_xpath")));
		cvs.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		
		WebElement cropcat=d.findElement(By.xpath(property.getProperty("cropcat_xpath")));
		cropcat.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement ses=d.findElement(By.xpath(property.getProperty("ses_xpath")));
		ses.click();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-8 > app-variety-form > mat-dialog-content').scrollTop=500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement scc=d.findElement(By.xpath(property.getProperty("scc_xpath")));
		scc.click();
		WebElement y2=d.findElement(By.xpath(property.getProperty("y2_xpath")));
		y2.click();
		Thread.sleep(8000);
		WebElement cit=d.findElement(By.xpath(property.getProperty("cit_xpath")));
		cit.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement cpd=d.findElement(By.xpath(property.getProperty("cpd_xpath")));
		cpd.sendKeys("12");

		Thread.sleep(8000);

		EventFiringWebDriver evg=new EventFiringWebDriver(d);
		evg.executeScript("document.querySelector('#mat-dialog-8 > app-variety-form > mat-dialog-content').scrollTop=500");
		WebElement cot=d.findElement(By.xpath(property.getProperty("cot_xpath")));
		cot.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement cous=d.findElement(By.xpath(property.getProperty("cous_xpath")));
		cous.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement pu=d.findElement(By.xpath(property.getProperty("pu_xpath")));
		pu.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);

		WebElement us=d.findElement(By.xpath(property.getProperty("us_xpath")));
		us.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement we=d.findElement(By.xpath(property.getProperty("we_xpath")));
		we.sendKeys("12");

		WebElement y3=d.findElement(By.xpath(property.getProperty("y3_xpath")));
		y3.click();
		Thread.sleep(80000);
		WebElement y4=d.findElement(By.xpath(property.getProperty("y4_xpath")));
		y4.click();
		Thread.sleep(8000);
		WebElement y5=d.findElement(By.xpath(property.getProperty("y5_xpath")));
		y5.click();



	}

	private void cloneVariety() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement clonev=d.findElement(By.xpath(property.getProperty("clonev_xpath")));
		clonev.click();
		Thread.sleep(6000);
		WebElement t1=d.findElement(By.xpath(property.getProperty("t1_xpath")));
		t1.click();
		WebElement t2=d.findElement(By.xpath(property.getProperty("t2_xpath")));
		t2.click();
		WebElement t3=d.findElement(By.xpath(property.getProperty("t3_xpath")));
		t3.click();
		WebElement t4=d.findElement(By.xpath(property.getProperty("t4_xpath")));
		t4.click();
		WebElement t5=d.findElement(By.xpath(property.getProperty("t5_xpath")));
		t5.click();
	}

}
