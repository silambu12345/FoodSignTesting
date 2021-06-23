package org_admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends SetUp {

	
	@Test(priority=100)
	public void addUserTest() throws IOException, InterruptedException, AWTException
	{
		//adding new user
		addUser("testgayitri2","test","test103@gmail.com","test123","9641885810");
		Assert.assertTrue(userExists("test103@gmail.com"));
		System.out.println("user added");

	}

	@Test(priority=200)
	public void editFName() throws InterruptedException
	{
		//Editing Existing user
		editFname("test103@gmail.com","testgayitri");
		Assert.assertTrue(Update("testgayitri"));
		System.out.println("user values updated");
	}

	@Test(priority=300)
	public void deleteUserTest() throws InterruptedException
	{
		//Deleting existing user
		deleteUser("test103@gmail.com");
		Assert.assertFalse(userExists("test103@gmail.com"));
		System.out.println("user Deleted");
	}






	//Actual Logic 


	public boolean userExists(String email) throws InterruptedException
	{
		Thread.sleep(9000);
		List<WebElement> row=d.findElements(By.xpath(property.getProperty("trow")));
		int r=row.size();
		boolean check=false;
		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("/html/body/app-root/app-settings/div/div/div[2]/div[2]/div/app-user-table/p-table/div/div[2]/table/tbody/tr["+i+"]/td[4]"));
			if(e.getText().equalsIgnoreCase(email))
			{
				check=true;

			}


		}
		return check;
	}



	public boolean Update(String fname) throws InterruptedException
	{
		Thread.sleep(9000);
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('body > app-root > app-settings > div > div > div.col-xs-7.col-sm-7.col-md-9.col-lg-9.centre-div.menuitm.giveleft.sideborder.centreHeight > div.container-fluid > div > app-user-table > p-table > div > div.ui-table-wrapper.ng-star-inserted').scrollRight=1500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		List<WebElement> row=d.findElements(By.xpath(property.getProperty("trow")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("tcol")));
		int c=col.size();
		boolean check=false;
		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("/html/body/app-root/app-settings/div/div/div[2]/div[2]/div/app-user-table/p-table/div/div[2]/table/tbody/tr["+i+"]/td[1]"));
			if(e.getText().equalsIgnoreCase(fname))
			{
				check=true;

			}


		}
		return check;
	}


	private void addUser(String fname,String lname,String mail,String passW,String mnum ) throws InterruptedException, AWTException
	{
		Thread.sleep(7000);
		d.manage().timeouts().implicitlyWait(260,TimeUnit.SECONDS);
		WebElement setting=d.findElement(By.xpath(property.getProperty("settings_xpath")));
		setting.click();	

		WebElement useradd=d.findElement(By.xpath(property.getProperty("userselect_xpath")));
		useradd.click();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement adding=d.findElement(By.xpath(property.getProperty("adduser_xpath")));
		adding.click();

		WebElement firstname=d.findElement(By.xpath(property.getProperty("ufname_xpath")));
		firstname.sendKeys(fname);

		WebElement lastname=d.findElement(By.xpath(property.getProperty("ulname_xpath")));
		lastname.sendKeys(lname);


		WebElement email=d.findElement(By.xpath(property.getProperty("uemail_xpath")));
		email.sendKeys(mail);


		WebElement pass=d.findElement(By.xpath(property.getProperty("upwd_xpath")));
		pass.sendKeys(passW);

		WebElement mobilenum=d.findElement(By.xpath(property.getProperty("umnum_xpath")));
		mobilenum.sendKeys(mnum);
		Robot robot = new Robot();
		robot.delay(8000);

		Thread.sleep(4000);
		WebElement useradding=d.findElement(By.xpath(property.getProperty("useradding_xpath")));
		useradding.click();

		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);

		WebElement roleuser=d.findElement(By.xpath(property.getProperty("roleuser_xpath")));
		roleuser.click();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);




		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-0 > app-user-form > div > mat-dialog-content').scrollTop=500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement add=d.findElement(By.xpath(property.getProperty("add_xpath")));
		add.click();

	



	}


	private void editFname(String oname,String fname) throws InterruptedException
	{
		Thread.sleep(9000);

		List<WebElement> row=d.findElements(By.xpath(property.getProperty("trow")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("tcol")));

		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("/html/body/app-root/app-settings/div/div/div[2]/div[2]/div/app-user-table/p-table/div/div[2]/table/tbody/tr["+i+"]/td[4]"));
			if(e.getText().equalsIgnoreCase(oname))
			{

				EventFiringWebDriver evf=new EventFiringWebDriver(d);
				evf.executeScript("document.querySelector('body > app-root > app-settings > div > div > div.col-xs-7.col-sm-7.col-md-9.col-lg-9.centre-div.menuitm.giveleft.sideborder.centreHeight > div.container-fluid > div > app-user-table > p-table > div > div.ui-table-wrapper.ng-star-inserted').scrollLeft=1500");
				d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
				WebElement cl=d.findElement(By.xpath("/html/body/app-root/app-settings/div/div/div[2]/div[2]/div/app-user-table/p-table/div/div[2]/table/tbody/tr["+i+"]/td[13]/div/button[2]"));
				cl.click();
			}


		}

		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement Firstname=d.findElement(By.xpath(property.getProperty("ufname_xpath")));
		Firstname.click();
		Firstname.clear();
		Firstname.sendKeys(fname);
		Thread.sleep(9000);
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		EventFiringWebDriver evf1=new EventFiringWebDriver(d);
		evf1.executeScript("document.querySelector('#mat-dialog-1 > app-user-form > div > mat-dialog-content').scrollTop=700");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		Thread.sleep(8000);
		WebElement add=d.findElement(By.xpath(property.getProperty("uesave_xpath")));
		add.click();

	}

	private void deleteUser(String email) throws InterruptedException
	{
		List<WebElement> row=d.findElements(By.xpath(property.getProperty("trow")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("tcol")));

		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("/html/body/app-root/app-settings/div/div/div[2]/div[2]/div/app-user-table/p-table/div/div[2]/table/tbody/tr["+i+"]/td[4]"));
			if(e.getText().equalsIgnoreCase(email))
			{

				EventFiringWebDriver evf=new EventFiringWebDriver(d);
				evf.executeScript("document.querySelector('body > app-root > app-settings > div > div > div.col-xs-7.col-sm-7.col-md-9.col-lg-9.centre-div.menuitm.giveleft.sideborder.centreHeight > div.container-fluid > div > app-user-table > p-table > div > div.ui-table-wrapper.ng-star-inserted').scrollLeft=1500");
				d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
				WebElement cl=d.findElement(By.xpath("/html/body/app-root/app-settings/div/div/div[2]/div[2]/div/app-user-table/p-table/div/div[2]/table/tbody/tr["+i+"]/td[13]/div/button[3]"));
				cl.click();
			}


		}


		d.manage().timeouts().implicitlyWait(190,TimeUnit.SECONDS);
		WebElement udltc=d.findElement(By.xpath(property.getProperty("udltc_xpath")));
		udltc.click();
		WebElement udlt=d.findElement(By.xpath(property.getProperty("udlt_xpath")));
		udlt.click();

	}

}
