package Test.StepDefinitions;

import Test.Main.BasePage;
import Test.Main.Browser;
import Test.Main.Login;
import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDef {
    Login login;
    ConfigFileReader configFileReader;
    WebDriver driver;
    BasePage basepage;
    Browser browser;


    @Given("Open Test web portal")
    public void OpenWebPortal() {
        basepage = new BasePage();
        login = new Login(driver);
        driver =  basepage.getChromeWebDriver();
        login.launchChromeBrowser(driver);
    }


    @When("I Login into the Portal")
    public void iLoginIntoThePortal() {
        login = new Login(driver);
        driver = login.getLoginDriver(driver);
        login.userLogin();
    }


    @Then("Login should be Successful")
    public void loginShouldBeSuccessful() {

        login.loginSuccess();
        System.out.println("Before Driver "+ driver);
        browser = new Browser();
        browser.closeBrowser(driver);
    }

}
