package Test.Main;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends BasePage{

    ConfigFileReader configFileReader;
    WebDriver driver;
    public static WebDriver setDriver;
    BasePage basepage;

    @FindBy(name="login")
    WebElement userNameTB;

    @FindBy(xpath="/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]")
    WebElement passwordTB;

    @FindBy(xpath="/html/body/my-app/header/nav/div/my-login/div/form/button")
    WebElement loginBtn;

    @FindBy(xpath="/html/body/my-app/header/nav/div/my-login/div/ul/li[1]/span")
    WebElement userTitle;


    public Login(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    public WebDriver launchChromeBrowser(WebDriver driver){
        basepage = new BasePage();
        basepage.launchWebPortal(driver);
        setDriver = driver;
        return driver;
    }

    public void userLogin(){

        configFileReader = new ConfigFileReader();
        userNameTB.sendKeys(System.getProperty("Login",configFileReader.getLoginID()));
        passwordTB.sendKeys(System.getProperty("Password",configFileReader.getPassword()));
        loginBtn.click();

    }

    public void loginSuccess() {
        String ExpectedNameTitle = "Hi, " + System.getProperty("Firstname",configFileReader.getFirstname());
        String ActualNameTitle =  userTitle.getAttribute("innerHTML");
        //System.out.println("ExpectedNameTitle " + ExpectedNameTitle);
        //System.out.println("ActualNameTitle " + ActualNameTitle);
        Assert.assertEquals(ExpectedNameTitle,ActualNameTitle);

    }


    public WebDriver getLoginDriver(WebDriver driver){
        return setDriver;
    }






}
