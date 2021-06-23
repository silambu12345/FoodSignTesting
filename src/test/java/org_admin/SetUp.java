package org_admin;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
public class SetUp {
		static Properties property;
		static WebDriver d;
		static FileInputStream fs;

		@BeforeSuite
		public static void setup() throws IOException {
			//driver setup
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			d=new ChromeDriver();
			fs=new FileInputStream(System.getProperty("user.dir")+"\\TestingFoodSign.properties");
			property=new Properties();
			property.load(fs);
			String baseurl=property.getProperty("baseurl");
			d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
			d.get(baseurl);
			login("9988776699","test123");
		}

		
		private static void login(String username,String pwd) throws IOException 
		{
			//login to the web application
			d.manage().window().maximize();
			d.navigate().refresh();
			WebElement  Username=d.findElement(By.id(property.getProperty("Username_id")));
			WebElement  Password=d.findElement(By.xpath(property.getProperty("Password_xpath")));
			Username.sendKeys(username);
			Password.sendKeys(pwd);
			WebElement login=d.findElement(By.xpath(property.getProperty("login_xpath")));
			login.click();
		
		}

	}



