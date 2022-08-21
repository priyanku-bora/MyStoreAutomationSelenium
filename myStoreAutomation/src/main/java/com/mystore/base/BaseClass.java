package com.mystore.base;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class BaseClass {
public  static Properties prop;
//public  static WebDriver driver;

    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    @BeforeSuite(groups = {"Regression","Smoke"})
    @Parameters("browser")
    public void beforeSuite(String browser){
        ExtentManager.setExtent(browser);
        DOMConfigurator.configure("log4j.xml");
    }
@BeforeTest
public static void loadConfig() {
    try {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
        prop.load(fis);

    }catch(Exception ex){
        ex.printStackTrace();
    }
}

@Parameters("browser")
public static void launchApp(String browserName ){
    //String browserName = prop.getProperty("browser");
    System.out.println("Browser = "+browserName);
    if(browserName.equalsIgnoreCase("Chrome")){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pribora\\Documents\\drivers\\chromeDriver 104\\chromedriver.exe");
       // driver = new ChromeDriver();
      //  WebDriverManager.chromeDriver().setUp();
        driver.set(new ChromeDriver());
    }
    if(browserName.equalsIgnoreCase("Edge")){
        System.setProperty("webdriver.edge.driver","C:\\Users\\pribora\\Documents\\drivers\\edge driver\\msedgedriver.exe");
        driver.set(new EdgeDriver());
    }
    Action.implicitWait(getDriver(),15);
    Action.pageLoadTimeOut(getDriver(),100);
    getDriver().get(prop.getProperty("url"));
    getDriver().manage().window().maximize();
    getDriver().manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
}

@AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
}
}
