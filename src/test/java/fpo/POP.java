package fpo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class POP extends SetUp{
	
	@Test(priority=701)
	public void addPOPTest() throws AWTException, InterruptedException
	{
		addPOP();
	}
	
	private void addPOP () throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		WebElement popclick=d.findElement(By.xpath(property.getProperty("popclick_xpath")));
		popclick.click();
		WebElement addpop=d.findElement(By.xpath(property.getProperty("addpop_xpath")));
		addpop.click();
		Thread.sleep(3000);
		WebElement yearpop=d.findElement(By.xpath(property.getProperty("yearpop_xpath")));
		yearpop.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement sespop=d.findElement(By.xpath(property.getProperty("sespop_xpath")));
		sespop.click();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement croppop=d.findElement(By.xpath(property.getProperty("croppop_xpath")));
		croppop.click();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		WebElement flood=d.findElement(By.xpath(property.getProperty("floodp_xpath")));
		flood.click();
		WebElement cont1=d.findElement(By.xpath(property.getProperty("cont1_xpath")));
		cont1.click();
		Thread.sleep(5000);
		WebElement addrow=d.findElement(By.xpath(property.getProperty("addrow_xpath")));
		addrow.click();
		WebElement passpop=d.findElement(By.xpath(property.getProperty("passpop_xpath")));
		passpop.click();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement fromp=d.findElement(By.xpath(property.getProperty("fromp_xpath")));
		fromp.sendKeys("12");
		WebElement popplan=d.findElement(By.xpath(property.getProperty("popplan_xpath")));
		popplan.click();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement cont2=d.findElement(By.xpath(property.getProperty("cont2_xpath")));
		cont2.click();
		WebElement cont3=d.findElement(By.xpath(property.getProperty("cont3_xpath")));
		cont3.click();
		
		
		
	}

}
