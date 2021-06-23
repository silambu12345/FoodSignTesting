package testpack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class Coop extends Setup {
	@Test(priority=1)
	public void addcoopTest() throws InterruptedException, AWTException
	{
		addCoop("Delhi","South Delhi","trvc","nigdi","561103","gayitriTesting","Test","7801709099","test123","test123");
	}
	@Test(priority=4)
	public void DltcoopTest() throws InterruptedException
	{
		delCoop();
	}
	@Test(priority=3)
	public void ViewCoopTest() throws InterruptedException
	{
		viewCoop();
	}
	@Test(priority=2)
	public void editCooopTest() throws InterruptedException {
		editCoop();
	}
	private void addCoop(String state,String dist,String taluk,String vill,String pin,String fname,String lname,String mnum,String pwd,String cpwd) throws InterruptedException, AWTException
	{
		Robot robot =new Robot();
		Thread.sleep(4000);
		WebElement onboardc=d.findElement(By.xpath(property.getProperty("onboardc_xpath")));
		onboardc.click();
		Thread.sleep(4000);
		WebElement co_op=d.findElement(By.xpath(property.getProperty("co_op_xpath")));
		co_op.click();	
		Thread.sleep(3000);
		WebElement addcoop=d.findElement(By.xpath(property.getProperty("addcoop_xpath")));
		addcoop.click();
		Thread.sleep(3000);
		WebElement okc=d.findElement(By.xpath(property.getProperty("okc_xpath")));
		okc.click();
		WebElement coopname=d.findElement(By.xpath(property.getProperty("coopname_xpath")));
		coopname.sendKeys("checktest");
		WebElement ccertistat=d.findElement(By.xpath(property.getProperty("ccertistat_xpath")));
		ccertistat.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement coopm=d.findElement(By.xpath(property.getProperty("coopm_xpath")));
		coopm.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		WebElement pucc=d.findElement(By.xpath(property.getProperty("pucc_xpath")));
		pucc.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement cstate=d.findElement(By.xpath(property.getProperty("cstate_xpath")));
		cstate.sendKeys(state);
		WebElement cdist=d.findElement(By.xpath(property.getProperty("cdist_xpath")));
		cdist.sendKeys(dist);
		WebElement ctaluk=d.findElement(By.xpath(property.getProperty("ctaluk_xpath")));
		ctaluk.sendKeys(taluk);
		WebElement cvill=d.findElement(By.xpath(property.getProperty("cvill_xpath")));
		cvill.sendKeys(vill);
		WebElement cpin=d.findElement(By.xpath(property.getProperty("cpin_xpath")));
		cpin.sendKeys(pin);
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-4 > app-cooperative-form > div > mat-dialog-content').scrollTop=3500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement cfname=d.findElement(By.xpath(property.getProperty("cfname_xpath")));
		cfname.sendKeys(fname);
		WebElement clname=d.findElement(By.xpath(property.getProperty("clname_xpath")));
		clname.sendKeys(lname);
		WebElement cmnum=d.findElement(By.xpath(property.getProperty("cmnum_xpath")));
		cmnum.sendKeys(mnum);
		WebElement c_pwd=d.findElement(By.xpath(property.getProperty("cpwd_xpath")));
		c_pwd.sendKeys(pwd);
		WebElement ccpwd=d.findElement(By.xpath(property.getProperty("ccpwd_xpath")));
		ccpwd.sendKeys(cpwd);
		Thread.sleep(10000);
		//WebElement csub=d.findElement(By.xpath(property.getProperty("csub_xpath")));
		//csub.click();
	}
	
	private void delCoop() throws InterruptedException
	{
	
		Thread.sleep(4000);
		WebElement dltcc=d.findElement(By.xpath(property.getProperty("dltcc_xpath")));
		dltcc.click();
		Thread.sleep(3000);
		WebElement dyes=d.findElement(By.xpath(property.getProperty("dyes_xpath")));
		dyes.click();
		
	}

	private void viewCoop() throws InterruptedException
	{
		Thread.sleep(9000);
			
		WebElement viewd=d.findElement(By.xpath(property.getProperty("viewd_xpath")));
		viewd.click();
		Thread.sleep(9000);
		d.navigate().back();
	}
	
	private void editCoop() throws InterruptedException
	{
		Thread.sleep(9000);
		WebElement csub=d.findElement(By.xpath(property.getProperty("conv_xpath")));
		csub.click();		
		WebElement editcoop=d.findElement(By.xpath(property.getProperty("editcoop_xpath")));
		editcoop.click();
		Thread.sleep(3000);
		WebElement coopname=d.findElement(By.xpath(property.getProperty("coopname_xpath")));
		coopname.clear();
		coopname.sendKeys("checktest1");
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-6 > app-cooperative-form > div > mat-dialog-content').scrollTop=3500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebElement subec=d.findElement(By.xpath(property.getProperty("subec_xpath")));
		subec.click();
	}
}
