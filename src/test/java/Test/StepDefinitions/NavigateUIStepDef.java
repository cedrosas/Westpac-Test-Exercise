package Test.StepDefinitions;

import Test.Main.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class NavigateUIStepDef {

    WebDriver driver = null;
    Login login;
    Register register;
    BasePage basepage;
    Profile profile;
    NavigateUI navigateUI;
    Browser browser;


    @When("User votes {string} in Popular make")
    public void userVotesInPopularMake(String carName) {
        System.out.println("111111111111 +" + carName);
        login = new Login(driver);
        System.out.println("222222222");
        driver = login.getLoginDriver(driver);
        System.out.println("33333333333");
        navigateUI = new NavigateUI(driver);
        System.out.println("44444444444");
        navigateUI.votePopCar(carName);
        System.out.println("555555555555555");
        navigateUI.explicitWaitforComment(driver);
        System.out.println("666666666666");
        navigateUI.carComment();

    }

    @When("User select Popular Model")
    public void userSelectPopularModel() {
        login = new Login(driver);
        driver = login.getLoginDriver(driver);
        navigateUI = new NavigateUI(driver);
        navigateUI.votePopularModel();
        navigateUI.explicitWaitforComment(driver);
        navigateUI.carComment();

    }
    @When("User votes {string} in all over rating")
    public void userVotesInAllOverRating(String carName) {
        login = new Login(driver);
        driver = login.getLoginDriver(driver);
        navigateUI = new NavigateUI(driver);
        navigateUI.voteAllOverRating(carName);
        navigateUI.explicitWaitforComment(driver);
        navigateUI.carComment();
    }
    @Then("Vote should be successful")
    public void voteShouldBeSuccessful() {
        navigateUI.voteSuccess();
        browser = new Browser();
        browser.closeBrowser(driver);
    }



}
