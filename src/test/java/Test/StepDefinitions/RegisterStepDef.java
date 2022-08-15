package Test.StepDefinitions;

import Test.Main.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterStepDef {
     WebDriver driver = null;
    Login login;
    Register register;
    BasePage basepage;
    Profile profile;
    Browser browser;


    @When("User inputs user details")
    public void UserInputsUserDetails() {
        login = new Login(driver);
        driver = login.getLoginDriver(driver);
        register = new Register(driver);
        register.userRegisterBtnClick();
        register.explicitWaitforRegister(driver);
        register.inputUserDetails();

    }

    @Then("Register should be successful")
    public void registerShouldBeSuccessful() {
        register.clickRegBtn();
        register.registerSuccessful();
        browser = new Browser();
        browser.closeBrowser(driver);
    }



}
