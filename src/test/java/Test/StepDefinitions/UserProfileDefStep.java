package Test.StepDefinitions;

import Test.Main.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UserProfileDefStep {
    WebDriver driver = null;
    Login login;
    Register register;
    BasePage basepage;
    Profile profile;
    Browser browser;



    @When("user update profile additional info")
    public void UserUpdateProfileAdditionalInfo() {

        login = new Login(driver);
        driver = login.getLoginDriver(driver);
        profile = new Profile(driver);
        profile.userUpdateAddInfo();
    }

    @Then("Update profile should be successful")
    public void updateProfileShouldBeSuccessful() {
        profile.updateSuccess();
        browser = new Browser();
        browser.closeBrowser(driver);

    }

    @When("User updates the password")
    public void userUpdatesThePassword() {

        login = new Login(driver);
        driver = login.getLoginDriver(driver);
        profile = new Profile(driver);
        profile.updatePassword();
    }

    @Then("Update profile password should be successful")
    public void updateProfilePasswordShouldBeSuccessful() {
        profile.updateSuccess();
        browser = new Browser();
        browser.closeBrowser(driver);
    }

}
