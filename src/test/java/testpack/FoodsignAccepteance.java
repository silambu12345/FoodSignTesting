package testpack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FoodsignAccepteance {

	static Properties property;
	static WebDriver d;
	static FileInputStream fs;

	@BeforeTest
	public static void setup() throws IOException {
		//driver setup
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		d=new ChromeDriver();
		fs=new FileInputStream(System.getProperty("user.dir")+"\\foodsign.properties");
		property=new Properties();
		property.load(fs);
		String baseurl=property.getProperty("baseurl");
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);

		d.get(baseurl);
	}
	
	
	@Test(priority=100)
	public void loginTest() throws IOException
	{
		login("9988776699","test123");
	}
	
	
	@Test(enabled=false)
	public void addroleTest() throws IOException
	{
		addRole("GayitriTestDemo14");
	}
	
	
	@Test(enabled=false)
	public void adduserTest() throws IOException, InterruptedException
	{
		addUser("Gayitri","J","gayitritest@gmail.com","test123","8986929659");
	}
	
	@Test(priority=300)
	public void buyerTest() throws IOException
	{
		addBuyer("gayitriest21","3/19/2021","India","Delhi","gayitriTest","Test","9678838123","test3280@gmail.com","test123","test123");
	}
	
	@Test(priority=400)
	public void retailerTest()throws IOException, InterruptedException
	{
		addRetailer("gayitritest11","3/19/2021","India","Delhi","gayitriTest","Test","9990999459","test1@gmail.com","test123","test123");

	}
	
	
	@Test(priority=500)
	public void warehouseTest()
	{
		addWarehouse("test113","9676387806","9496929459","test@gmail.com","3/17/2021","3","2","India","Delhi","South Delhi","xyz","xxx","583230");
	}
	
	
	@Test(enabled=false)
	public void logoutTest() throws IOException
	{
		logout();
	}
	
	
	@Test(enabled=false)
	public void cropTest() throws IOException{
		addcrop("LOCAL");
	}
	
	
	//Actual logic of the code
	//
	//
	//
	//
	//
	//
	//
	//
	//main code

	private void login(String username,String pwd) throws IOException 
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
	//adding role
//
	//
	//
	//
	//
	private void addRole(String fname) throws IOException
	{
		//adding new org roles
		WebDriverWait wait2 = new WebDriverWait(d, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("setting_xpath"))));
		WebElement setting=d.findElement(By.xpath(property.getProperty("setting_xpath")));
		setting.click();	
		WebElement roleadd=d.findElement(By.xpath(property.getProperty("roleadd_xpath")));
		roleadd.click();
		WebElement adding=d.findElement(By.xpath(property.getProperty("adding_xpath")));
		adding.click();
		d.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		WebElement org=d.findElement(By.xpath(property.getProperty("org_xpath")));
		org.click();
		WebElement orgc=d.findElement(By.xpath(property.getProperty("orgc_xpath")));
		orgc.click();
		WebElement name=d.findElement(By.xpath(property.getProperty("name_xpath")));
		name.sendKeys(fname);
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,7000)");
		WebDriverWait wait3 = new WebDriverWait(d, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("save_xpath"))));
		WebElement save=d.findElement(By.xpath(property.getProperty("save_xpath")));
		save.click();
	}

	//
	//
	//
	//
	//
	//adding user
	private void addUser(String fname,String lname,String mail,String passW,String mnum ) throws IOException, InterruptedException
	{

		//adding org user
		d.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
		WebElement setting=d.findElement(By.xpath(property.getProperty("setting_xpath")));
		setting.click();	

		WebElement useradd=d.findElement(By.xpath(property.getProperty("useradd_xpath")));
		useradd.click();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement adding=d.findElement(By.xpath(property.getProperty("addinguser_xpath")));
		adding.click();

		WebElement firstname=d.findElement(By.xpath(property.getProperty("firstname_xpath")));
		firstname.sendKeys(fname);

		WebElement lastname=d.findElement(By.xpath(property.getProperty("lastname_xpath")));
		lastname.sendKeys(lname);


		WebElement email=d.findElement(By.xpath(property.getProperty("email_xpath")));
		email.sendKeys(mail);


		WebElement pass=d.findElement(By.xpath(property.getProperty("pass_xpath")));
		pass.sendKeys(passW);

		WebElement mobilenum=d.findElement(By.xpath(property.getProperty("mobilenum_xpath")));
		mobilenum.sendKeys(mnum);


		WebDriverWait wait3 = new WebDriverWait(d,20);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("useradding_xpath"))));
		WebElement useradding=d.findElement(By.xpath(property.getProperty("useradding_xpath")));
		useradding.click();
		WebDriverWait wait4 = new WebDriverWait(d,20);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("addorgpath"))));
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement addorg=d.findElement(By.xpath(property.getProperty("addorgpath")));
		addorg.click();
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement roleuser=d.findElement(By.xpath(property.getProperty("roleuser_xpath")));
		roleuser.click();
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement pfa=d.findElement(By.xpath(property.getProperty("pfa_xpath")));
		pfa.click();
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);

		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-0 > app-user-form > div > mat-dialog-content').scrollTop=500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement add=d.findElement(By.xpath(property.getProperty("add_xpath")));
		add.click();
	}
	//adding Buyer
	//
	//
	//
	//
	
	private void addBuyer(String bname,String date,String Country,String State,String fname,String lname,String mnum,String email,String pwd,String Cpwd)
	{
		WebDriverWait wait2 = new WebDriverWait(d,30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("s_xpath"))));
		d.manage().timeouts().implicitlyWait(170, TimeUnit.SECONDS);
		WebElement setting=d.findElement(By.xpath(property.getProperty("s_xpath")));
		setting.click();	
		WebElement buyeradd=d.findElement(By.xpath(property.getProperty("buyeradd_xpath")));
		buyeradd.click();
		WebElement newadd=d.findElement(By.xpath(property.getProperty("newadd_xpath")));
		newadd.click();
		WebElement Bname=d.findElement(By.xpath(property.getProperty("Bname_xpath")));
		Bname.sendKeys(bname);
		WebElement Date=d.findElement(By.xpath(property.getProperty("dates_xpath")));
		Date.sendKeys(date);
		WebElement country=d.findElement(By.xpath(property.getProperty("country_xpath")));
		country.sendKeys(Country);
		WebElement state=d.findElement(By.xpath(property.getProperty("state_xpath")));
		state.sendKeys(State);
		d.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-0 > app-buyer-form > div > mat-dialog-content').scrollTop=500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);

		WebElement Fname=d.findElement(By.xpath(property.getProperty("Fname_xpath")));
		Fname.sendKeys(fname);
		WebElement Lname=d.findElement(By.xpath(property.getProperty("Lname_xpath")));
		Lname.sendKeys(lname);
		WebElement MNum=d.findElement(By.xpath(property.getProperty("MNum_xpath")));
		MNum.sendKeys(mnum);
		WebElement Email=d.findElement(By.xpath(property.getProperty("Emails_xpath")));
		Email.sendKeys(email);
		WebElement Pwd=d.findElement(By.xpath(property.getProperty("Pwd_xpath")));
		Pwd.sendKeys(pwd);
		WebElement CPwd=d.findElement(By.xpath(property.getProperty("CPwd_xpath")));
		CPwd.sendKeys(Cpwd);
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement badd=d.findElement(By.xpath(property.getProperty("badd_xpath")));
		badd.click();



	}
	//
	//
	//
	//
	//adding Retailer
	private void addRetailer(String rName,String rDate,String rCountry,String rState,String rFname,String rLname,String rMnum,String rEmail,String rPwd,String rCpwd ) throws InterruptedException {

		WebDriverWait wait2 = new WebDriverWait(d,30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("bs_xpath"))));
		Thread.sleep(9000);
		WebElement setting=d.findElement(By.xpath(property.getProperty("bs_xpath")));
		setting.click();
		WebElement retailer=d.findElement(By.xpath(property.getProperty("retailer_xpath")));
		retailer.click();
		WebElement addretailer=d.findElement(By.xpath(property.getProperty("addr_xpath")));
		addretailer.click();
		WebElement rname=d.findElement(By.xpath(property.getProperty("rname_xpath")));
		rname.sendKeys(rName);
		WebElement rdate=d.findElement(By.xpath(property.getProperty("rdate_xpath")));
		rdate.sendKeys(rDate);
		WebElement rcountry=d.findElement(By.xpath(property.getProperty("rcountry_xpath")));
		rcountry.sendKeys(rCountry);
		WebElement rstate=d.findElement(By.xpath(property.getProperty("rstate_xpath")));
		rstate.sendKeys(rState);
		//WebElement rclick=d.findElement(By.xpath(property.getProperty("rclick_xpath")));
		//rclick.click();
		//rclick.click();
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-1 > app-retail-stores-form > div > mat-dialog-content').scrollTop=9500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);

		WebElement rfname=d.findElement(By.xpath(property.getProperty("rfname_xpath")));
		rfname.sendKeys(rFname);
		WebElement rlname=d.findElement(By.xpath(property.getProperty("rlname_xpath")));
		rlname.sendKeys(rLname);
		WebElement rmnum=d.findElement(By.xpath(property.getProperty("rmnum_xpath")));
		rmnum.sendKeys(rMnum);
		WebElement remail=d.findElement(By.xpath(property.getProperty("remail_xpath")));
		remail.sendKeys(rEmail);
		WebElement rpwd=d.findElement(By.xpath(property.getProperty("rpwd_xpath")));
		rpwd.sendKeys(rPwd);
		WebElement rcpwd=d.findElement(By.xpath(property.getProperty("rcpwd_xpath")));
		rcpwd.sendKeys(rCpwd);
		//WebElement rclick=d.findElement(By.xpath(property.getProperty("rclick_xpath")));
		//rclick.click();
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebDriverWait wait3 = new WebDriverWait(d,30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("radding_xpath"))));
		Thread.sleep(10000);
		WebElement radding=d.findElement(By.xpath(property.getProperty("radding_xpath")));
		radding.click();
	}
	//Adds Warehouse
	//
	//
	//
	//
	//
	//
	private void addWarehouse(String wName,String wPrimary,String wMnum,String wEmail,String wDate,String wCap,String wSqft,String wCountry,String wState,String wDist,String wTaluk,String wVillage,String wPin)
	{
		WebDriverWait wait2 = new WebDriverWait(d,30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("ws_xpath"))));
		WebElement setting=d.findElement(By.xpath(property.getProperty("ws_xpath")));
		setting.click();
		WebElement warehouse=d.findElement(By.xpath(property.getProperty("warehouse_xpath")));
		warehouse.click();
		WebElement wadd=d.findElement(By.xpath(property.getProperty("wadd_xpath")));
		wadd.click();
		WebDriverWait wait3 = new WebDriverWait(d,30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("wf_xpath"))));
		WebElement wf=d.findElement(By.xpath(property.getProperty("wf_xpath")));
		wf.click();
		WebElement wselect=d.findElement(By.xpath(property.getProperty("wselect_xpath")));
		wselect.click();
		WebElement wname=d.findElement(By.xpath(property.getProperty("wname_xpath")));
		wname.sendKeys(wName);
		WebElement wprimary=d.findElement(By.xpath(property.getProperty("wprimary_xpath")));
		wprimary.sendKeys(wPrimary);
		WebElement wmnum=d.findElement(By.xpath(property.getProperty("wmnum_xpath")));
		wmnum.sendKeys(wMnum);
		WebElement wemail=d.findElement(By.xpath(property.getProperty("wemail_xpath")));
		wemail.sendKeys(wEmail);
		WebElement wdate=d.findElement(By.xpath(property.getProperty("wdate_xpath")));
		wdate.sendKeys(wDate);
		WebElement wownership=d.findElement(By.xpath(property.getProperty("wownership_xpath")));
		wownership.click();
		WebElement woclick=d.findElement(By.xpath(property.getProperty("woclick_xpath")));
		woclick.click();
		WebElement wcap=d.findElement(By.xpath(property.getProperty("wcap_xpath")));
		wcap.sendKeys(wCap);
		WebElement wsqft=d.findElement(By.xpath(property.getProperty("wsqft_xpath")));
		wsqft.sendKeys(wSqft);
		WebElement wcerti=d.findElement(By.xpath(property.getProperty("wcerti_xpath")));
		wcerti.click();
		WebElement wcstat=d.findElement(By.xpath(property.getProperty("wcstat_xpath")));
		wcstat.click();
		WebElement wcountry=d.findElement(By.xpath(property.getProperty("wcountry_xpath")));
		wcountry.sendKeys(wCountry);
		WebElement wstate=d.findElement(By.xpath(property.getProperty("wstate_xpath")));
		wstate.sendKeys(wState);
		WebElement wdist=d.findElement(By.xpath(property.getProperty("wdist_xpath")));
		wdist.sendKeys(wDist);
		WebElement wtaluk=d.findElement(By.xpath(property.getProperty("wtaluk_xpath")));
		wtaluk.sendKeys(wTaluk);
		WebElement wvillage=d.findElement(By.xpath(property.getProperty("wvillage_xpath")));
		wvillage.sendKeys(wVillage);
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement certiagency=d.findElement(By.xpath(property.getProperty("certiagency_xpath")));
		certiagency.click();
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement   wagency=d.findElement(By.xpath(property.getProperty("wagency_xpath")));
		wagency.click();
		WebElement wpin=d.findElement(By.xpath(property.getProperty("wpin_xpath")));
		wpin.sendKeys(wPin);
		EventFiringWebDriver evf=new EventFiringWebDriver(d);
		evf.executeScript("document.querySelector('#mat-dialog-0 > app-warehouse-form > div > mat-dialog-content').scrollTop=6500");
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement wsubmit=d.findElement(By.xpath(property.getProperty("wsubmit_xpath")));
		wsubmit.click();
	}
	//crop adding
	//
	//
	//
	//
	//
	private void addcrop(String cVar)throws IOException
	{
		WebDriverWait wait2 = new WebDriverWait(d,30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("s_xpath"))));
		WebElement setting=d.findElement(By.xpath(property.getProperty("s_xpath")));
		setting.click();
		WebElement addcrop=d.findElement(By.xpath(property.getProperty("addcrop_xpath")));
		addcrop.click();
		WebElement cropv=d.findElement(By.xpath(property.getProperty("cropv_xpath")));
		cropv.click();
		WebElement cname=d.findElement(By.xpath(property.getProperty("cname_xpath")));
		cname.click();
		WebDriverWait wait3 = new WebDriverWait(d,30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("cselect_xpath"))));
		WebElement cselect=d.findElement(By.xpath(property.getProperty("cselect_xpath")));
		cselect.click();
		WebElement cropvar=d.findElement(By.xpath(property.getProperty("cropvar_xpath")));
		cropvar.sendKeys(cVar);
		
	
		WebElement ccat=d.findElement(By.xpath(property.getProperty("ccat_xpath")));
		ccat.click();
		WebDriverWait wait5 = new WebDriverWait(d,30);
		wait5.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("csel_xpath"))));
		WebElement csel=d.findElement(By.xpath(property.getProperty("csel_xpath")));
		csel.click();
		WebElement ctype=d.findElement(By.xpath(property.getProperty("ctype_xpath")));
		ctype.click();
		WebDriverWait wait4 = new WebDriverWait(d,30);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("ctypes_xpath"))));
		WebElement ctypes=d.findElement(By.xpath(property.getProperty("ctypes_xpath")));
		ctypes.click();
		//WebElement cyt=d.findElement(By.xpath(property.getProperty("cyt_xpath")));
		//cyt.click();
		//WebElement cp=d.findElement(By.xpath(property.getProperty("cp_xpath")));
		//cp.click();
		//WebElement cy=d.findElement(By.xpath(property.getProperty("cy_xpath")));
		//cy.sendKeys("3");
		WebElement csave=d.findElement(By.xpath(property.getProperty("csave_xpath")));
		csave.click();
		d.manage().timeouts().implicitlyWait(170,TimeUnit.SECONDS);
		WebElement csc=d.findElement(By.xpath(property.getProperty("csc_xpath")));
		csc.click();
		WebElement cit=d.findElement(By.xpath(property.getProperty("cit_xpath")));
		cit.click();
		WebElement cits=d.findElement(By.xpath(property.getProperty("cits_xpath")));
		cits.click();
		WebElement ciu=d.findElement(By.xpath(property.getProperty("ciu_xpath")));
		ciu.click();
		WebElement cium=d.findElement(By.xpath(property.getProperty("cium_xpath")));
		cium.click();
		WebElement cot=d.findElement(By.xpath(property.getProperty("cot_xpath")));
		cot.click();
		WebDriverWait wait6 = new WebDriverWait(d,30);
		wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("cott_xpath"))));
		WebElement cott=d.findElement(By.xpath(property.getProperty("cott_xpath")));
		cott.click();
		WebElement cou=d.findElement(By.xpath(property.getProperty("cou_xpath")));
		cou.click();
		WebElement cout=d.findElement(By.xpath(property.getProperty("cout_xpath")));
		cout.click();
	}
	//
	//
	//
	//
	
	private void logout() throws IOException
	{
		//logs out from web application
		//WebDriverWait wait3 = new WebDriverWait(d,30);
		//wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("signout_xpath"))));
		d.manage().timeouts().implicitlyWait(190,TimeUnit.SECONDS);
		WebElement signout=d.findElement(By.xpath(property.getProperty("signout_xpath")));
		signout.click();
		WebElement confirm=d.findElement(By.xpath(property.getProperty("confirm_xpath")));
		confirm.click();
		d.close();		
	}

}
