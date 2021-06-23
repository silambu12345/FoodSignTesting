package org_admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoleTest extends SetUp {
	
	@Test(priority=400)
	public void addRoleTest() throws InterruptedException, IOException, AWTException
	{
		addRole("xyz");
		Assert.assertTrue(RoleExists("xyz"));
		System.out.println("role added");
	}

	@Test(priority=500)
	public void editRoleTest() throws InterruptedException
	{
		changeRoleName("xyz","testedxyz");
		Assert.assertTrue(RoleExists("testedxyz"));
		System.out.println("role edited");
	}




	private void addRole(String fname) throws IOException, AWTException
	{
		d.manage().timeouts().implicitlyWait(260,TimeUnit.SECONDS);
		WebElement setting=d.findElement(By.xpath(property.getProperty("settings_xpath")));
		setting.click();	

		WebElement roleadd=d.findElement(By.xpath(property.getProperty("roleadd_xpath")));
		roleadd.click();
		WebElement adding=d.findElement(By.xpath(property.getProperty("adding_xpath")));
		adding.click();
		d.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		WebElement org=d.findElement(By.xpath(property.getProperty("org_xpath")));
		org.click();
	Robot r=new Robot();
	r.delay(5000);
	r.keyPress(KeyEvent.VK_DOWN);//org role creation
	//r.keyPress(KeyEvent.VK_DOWN);//fpo role creation
	//r.keyPress(KeyEvent.VK_DOWN);//coop role creation
	r.keyPress(KeyEvent.VK_ENTER);
	
		WebElement name=d.findElement(By.xpath(property.getProperty("name_xpath")));
		name.sendKeys(fname);
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,7000)");
		WebDriverWait wait3 = new WebDriverWait(d, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("save_xpath"))));
		WebElement save=d.findElement(By.xpath(property.getProperty("save_xpath")));
		save.click();
		WebElement page=d.findElement(By.xpath(property.getProperty("4_xpath")));
		page.click();
	}

	private void changeRoleName(String oname,String fname) throws InterruptedException
	{
		WebElement page=d.findElement(By.xpath(property.getProperty("4_xpath")));
		page.click();
		Thread.sleep(9000);
		List<WebElement> row=d.findElements(By.xpath(property.getProperty("rrow_xpath")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("rcol_xpath")));
		int c=col.size();

		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("/html/body/app-root/app-roles/app-roles-list/div/div/div[2]/div[2]/div[2]/p-table/div/div[2]/table/tbody//tr["+i+"]/td[2]"));
			if(e.getText().equalsIgnoreCase(oname))
			{
				d.findElement(By.xpath("/html/body/app-root/app-roles/app-roles-list/div/div/div[2]/div[2]/div[2]/p-table/div/div[2]/table/tbody/tr["+i+"]/td[4]/a/img")).click();

			}


		}



		WebElement rname=d.findElement(By.xpath(property.getProperty("rname")));
		rname.click();
		rname.clear();
		rname.sendKeys(fname);
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,70000)");
		WebDriverWait wait3 = new WebDriverWait(d, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("saveedit_xpath"))));
		WebElement save=d.findElement(By.xpath(property.getProperty("saveedit_xpath")));
		save.click();
		WebElement page1=d.findElement(By.xpath(property.getProperty("4_xpath")));
		page1.click();

	}
	public boolean RoleExists(String name) throws InterruptedException
	{
		WebElement page=d.findElement(By.xpath(property.getProperty("4_xpath")));
		page.click();
		Thread.sleep(19000);
		List<WebElement> row=d.findElements(By.xpath(property.getProperty("rrow_xpath")));
		int r=row.size();
		List<WebElement> col=d.findElements(By.xpath(property.getProperty("rcol_xpath")));

		boolean check=false;
		for(int i=1;i<=r;i++)
		{

			WebElement e=d.findElement(By.xpath("/html/body/app-root/app-roles/app-roles-list/div/div/div[2]/div[2]/div[2]/p-table/div/div[2]/table/tbody/tr["+i+"]/td[2]"));
			if(e.getText().equalsIgnoreCase(name))
			{
				check=true;

			}


		}
		return check;
	}

}
