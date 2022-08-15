package Test.Main;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    WebDriver driver = null;
    public void closeBrowser(WebDriver driver){
        driver.close();

    }


    public void quitDriver(){
        driver.quit();
    }

    public void browserWait(int sec){
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
}
