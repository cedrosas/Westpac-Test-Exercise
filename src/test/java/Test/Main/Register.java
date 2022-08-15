package Test.Main;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Register extends BasePage{
    private WebDriver driver;
    ConfigFileReader configFileReader;
    BasePage basepage;
    private Register register;
    Login login;

    @FindBy(xpath="/html/body/my-app/header/nav/div/my-login/div/form/a")
    WebElement RegBtn;

    @FindBy(xpath="//*[@id=\"username\"]")
    WebElement loginTxt;

    @FindBy(xpath="//*[@id=\"firstName\"]")
    WebElement firstnameTxt;

    @FindBy(xpath="//*[@id=\"lastName\"]")
    WebElement lastnameTxt;

    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement passwordTxt;

    @FindBy(xpath="//*[@id=\"confirmPassword\"]")
    WebElement confirmpassowrdTxt;

    @FindBy(xpath="/html/body/my-app/div/main/my-register/div/div/form/button")
    WebElement regConfirmBtn;

    @FindBy(xpath="/html/body/my-app/div/main/my-register/div/div/form/div[6]")
    WebElement regSucess;

    public Register(WebDriver driver){
        PageFactory.initElements(driver,this);

    }


    public void userRegisterBtnClick(){

        RegBtn.click();

    }

    public void explicitWaitforRegister(WebDriver driver){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait Wait = new WebDriverWait(driver,duration);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/my-app/div/main/my-register/div/div/h2")));

    }

    public void inputUserDetails(){

        configFileReader = new ConfigFileReader();
        loginTxt.sendKeys(System.getProperty("Login",configFileReader.getLoginID()));
        firstnameTxt.sendKeys(System.getProperty("FirstName",configFileReader.getFirstname()));
        lastnameTxt.sendKeys(System.getProperty("LastName",configFileReader.getLastname()));
        passwordTxt.sendKeys(System.getProperty("Password",configFileReader.getPassword()));
        confirmpassowrdTxt.sendKeys(System.getProperty("ConfirmPassword",configFileReader.getConfirmPassword()));
    }


    public void clickRegBtn(){
        regConfirmBtn.click();
    }

    public void registerSuccessful() {
        String expectedRegMessage ="\n" +
                "                Registration is successful\n" +
                "            ";
        String actualRegMessage = regSucess.getAttribute("innerHTML");
        Assert.assertEquals(expectedRegMessage,actualRegMessage);
    }



}
