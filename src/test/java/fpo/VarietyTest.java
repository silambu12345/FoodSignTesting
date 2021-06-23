package fpo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class VarietyTest extends SetUp {
	@Test(priority=1)
	public void addCropTest() throws InterruptedException, AWTException
	{
		addCrop();
	}
	@Test(priority=2)
	public void cloneVarietyTest() throws InterruptedException {
		cloneVariety("Carrot");
	}

	@Test(priority=3)
	public void EditVarietyTest() throws InterruptedException, AWTException
	{
		editVariety("Carrot");
	}
	private void addCrop() throws InterruptedException, AWTException
	{
		Robot robot = new Robot();
		d.manage().timeouts().implicitlyWait(190,TimeUnit.SECONDS);
		WebElement Settings=d.findElement(By.xpath(property.getProperty("csetting_xpath")));
		Settings.click();
		WebElement ip=d.findElement(By.xpath(property.getProperty("ip_xpath")));
		ip.click();
		WebElement addcrop=d.findElement(By.xpath(property.getProperty("addcrop_xpath")));
		addcrop.click();
		Thread.sleep(10000);
		
		WebElement cropname=d.findElement(By.xpath(property.getProperty("cropname_xpath")));
		cropname.click();
		robot.delay(6000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
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
		evf.executeScript("document.querySelector('#mat-dialog-0 > app-variety-form > mat-dialog-content').scrollTop=500");
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
		evg.executeScript("document.querySelector('#mat-dialog-0 > app-variety-form > mat-dialog-content').scrollTop=500");
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
		robot.delay(3000);
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
	
		WebElement y4=d.findElement(By.xpath(property.getProperty("y4_xpath")));
		y4.click();
		
		WebElement y5=d.findElement(By.xpath(property.getProperty("y5_xpath")));
		y5.click();



	}

	private void cloneVariety(String pname) throws InterruptedException
	{
		
		Thread.sleep(5000);
	

		List<WebElement> row=d.findElements(By.xpath(property.getProperty("crow_xpath")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("ccol_xpath")));

		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/app-crops-config/div/div/app-crops-table/mat-table/mat-row["+i+"]/mat-cell[1]"));
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(pname))
			{
			
				WebElement clonev=d.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/app-crops-config/div/div/app-crops-table/mat-table/mat-row["+i+"]/mat-cell[9]/div/button[3]"));
				clonev.click();
			}


		}

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
	
	private void editVariety(String pname) throws InterruptedException, AWTException
	{
		Thread.sleep(5000);
		

		List<WebElement> row=d.findElements(By.xpath(property.getProperty("crow_xpath")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("ccol_xpath")));

		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/app-crops-config/div/div/app-crops-table/mat-table/mat-row["+i+"]/mat-cell[1]"));
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(pname))
			{
			
				WebElement editv=d.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/app-crops-config/div/div/app-crops-table/mat-table/mat-row["+i+"]/mat-cell[9]/div/button[1]"));
				editv.click();
			}


		}
		Thread.sleep(4000);
		WebElement v1=d.findElement(By.xpath(property.getProperty("v1_xpath")));
		v1.click();
		WebElement lang=d.findElement(By.xpath(property.getProperty("lang_xpath")));
		lang.click();
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		WebElement v2=d.findElement(By.xpath(property.getProperty("v2_xpath")));
		v2.click();
		WebElement v3=d.findElement(By.xpath(property.getProperty("v3_xpath")));
		v3.click();
		WebElement v4=d.findElement(By.xpath(property.getProperty("v4_xpath")));
		v4.click();
		WebElement v5=d.findElement(By.xpath(property.getProperty("v5_xpath")));
		v5.click();
	}

}
