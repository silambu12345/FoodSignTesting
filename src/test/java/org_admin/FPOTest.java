package org_admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class FPOTest extends SetUp{


	@Test(priority=401)
	public void addFPOTest() throws AWTException, InterruptedException
	{

		addFPO("gfpotest","Delhi","South Delhi","trvc","nigdi","561103","gayitriTesting","Test","7801709099","test123","test123");
	}

	@Test(priority=402)
	public void EditFpo() throws InterruptedException
	{
		editFpo();
	}
	
	@Test(priority=403)
	public void ViewFpoTest() throws InterruptedException
	{
		viewFpo();
	}
	@Test(priority=403)
	public void dltFpo() throws InterruptedException
	{
		delFpo();
	}
	private void addFPO(String name,String state,String dist,String taluk,String village,String pin,String fname,String lname,String mnum,String pwd,String cpwd) throws AWTException, InterruptedException
	{	
		Robot robot=new Robot();
		Thread.sleep(8000);
		WebElement fpoclick=d.findElement(By.xpath(property.getProperty("fpoclick_xpath")));
		fpoclick.click();
		Thread.sleep(4000);
		WebElement addfpo=d.findElement(By.xpath(property.getProperty("addfpo_xpath")));
		addfpo.click();
		Thread.sleep(5000);
		WebElement okfpo=d.findElement(By.xpath(property.getProperty("okfpo_xpath")));
		okfpo.click();
		WebElement fponame=d.findElement(By.xpath(property.getProperty("fponame_xpath")));
		fponame.sendKeys(name);
		WebElement fpotype=d.findElement(By.xpath(property.getProperty("fpotype_xpath")));
		fpotype.click();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);

		WebElement fcertistat=d.findElement(By.xpath(property.getProperty("fcertistat_xpath")));
		fcertistat.click();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(9000);

		WebElement fpu_xpath=d.findElement(By.xpath(property.getProperty("fpu_xpath")));
		fpu_xpath.click();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement fpostate=d.findElement(By.xpath(property.getProperty("fpostate_xpath")));
		fpostate.sendKeys(state);
		WebElement fpodist=d.findElement(By.xpath(property.getProperty("fpodist_xpath")));
		fpodist.sendKeys(dist);
		WebElement fpotaluk=d.findElement(By.xpath(property.getProperty("fpotaluk_xpath")));
		fpotaluk.sendKeys(taluk);
		WebElement fpovill=d.findElement(By.xpath(property.getProperty("fpovill_xpath")));
		fpovill.sendKeys(village);
		WebElement fpopin=d.findElement(By.xpath(property.getProperty("fpopin_xpath")));
		fpopin.sendKeys(pin);
		WebElement fdc=d.findElement(By.xpath(property.getProperty("fdc_xpath")));
		fdc.click();

		WebElement call=d.findElement(By.xpath(property.getProperty("call_xpath")));
		call.click();
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-8 > app-fpo-form > div > mat-dialog-content').scrollTop=500");
		WebElement fpopname=d.findElement(By.xpath(property.getProperty("fpopname_xpath")));
		fpopname.sendKeys(fname);
		WebElement flname=d.findElement(By.xpath(property.getProperty("flname_xpath")));
		flname.sendKeys(lname);
		WebElement fmnum=d.findElement(By.xpath(property.getProperty("fmnum_xpath")));
		fmnum.sendKeys(mnum);
		WebElement fpwd=d.findElement(By.xpath(property.getProperty("fpwd_xpath")));
		fpwd.sendKeys(pwd);
		WebElement fcpwd=d.findElement(By.xpath(property.getProperty("fcpwd_xpath")));
		fcpwd.sendKeys(cpwd);

		Thread.sleep(6000);
		WebElement fposub=d.findElement(By.xpath(property.getProperty("fposub_xpath")));
		fposub.click();

	}
	private void delFpo() throws InterruptedException
	{

		Thread.sleep(4000);
		WebElement dltcc=d.findElement(By.xpath(property.getProperty("dfpo_xpath")));
		dltcc.click();
		Thread.sleep(3000);
		WebElement dyes=d.findElement(By.xpath(property.getProperty("dfyes_xpath")));
		dyes.click();

		d.close();
	}
	private void editFpo() throws InterruptedException
	{
		Thread.sleep(9000);
		WebElement csub=d.findElement(By.xpath(property.getProperty("convf_xpath")));
		csub.click();		
		WebElement editfpo=d.findElement(By.xpath(property.getProperty("editfpo_xpath")));
		editfpo.click();
		Thread.sleep(3000);
		WebElement fname=d.findElement(By.xpath(property.getProperty("fponame_xpath")));
		fname.clear();
		fname.sendKeys("checktest1");
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-10 > app-fpo-form > div > mat-dialog-content').scrollTop=3500");
	
		Thread.sleep(4000);
		//WebElement subef=d.findElement(By.xpath(property.getProperty("subef_xpath")));
		//subef.click();
	}
	
	private void viewFpo() throws InterruptedException
	{
		Thread.sleep(9000);
			
		WebElement viewf=d.findElement(By.xpath(property.getProperty("vfpo_xpath")));
		viewf.click();
		Thread.sleep(9000);
		d.navigate().back();
	}

}
