package Test.Main;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
     ConfigFileReader configFileReader;



    public BasePage() {

    }


    public void ImplicitWait(int Tsec){
         driver.manage().timeouts().implicitlyWait(Tsec, TimeUnit.SECONDS);
     }

    public WebDriver getChromeWebDriver() {

        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");


        //configFileReader = new ConfigFileReader();
        //System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();

        return driver;
    }
    public void launchWebPortal(WebDriver driver){
            configFileReader = new ConfigFileReader();
            driver.get(System.getProperty("url",configFileReader.getApplicationUrl()));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
    }


    public WebDriver setBasePage() {
        driver = new ChromeDriver();
        return driver;
    }
    public void closeBrowser() {
        driver.close();
    }
}


