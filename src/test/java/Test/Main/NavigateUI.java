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

public class NavigateUI extends BasePage {

    private WebDriver driver;
    ConfigFileReader configFileReader;

    BasePage basepage;
    Login login;

    @FindBy(xpath="/html/body/my-app/div/main/my-home/div/div[1]/div/a/img")
    WebElement popCarLogo;



    @FindBy(xpath="/html/body/my-app/div/main/my-make/div/div[2]/div/div/table/tbody/tr[4]/td[2]/a")
    WebElement carnameTxt;

    @FindBy(xpath="/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[2]/td[3]/a")
    WebElement carnameTxt1;

    @FindBy(id="comment")
    WebElement commentInput;

    @FindBy(xpath="/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/div/button")
    WebElement voteBtn;

    @FindBy(xpath="/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/p")
    WebElement voteSucessMsg;

    @FindBy(xpath="/html/body/my-app/div/main/my-home/div/div[2]/div/a")
    WebElement popModelLogo;

   @FindBy(xpath="/html/body/my-app/div/main/my-home/div/div[3]/div/a/img")
   WebElement allOverRatingLogo;

    public NavigateUI(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public void explicitWaitforComment(WebDriver driver){

        Duration duration = Duration.ofSeconds(20);
        WebDriverWait Wait = new WebDriverWait(driver,duration);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment")));

    }
    public void votePopCar(String carName){

        popCarLogo.click();
        String carNameStr = carnameTxt.getAttribute("innerHTML");
        if (carName.equals(carNameStr)){
            carnameTxt.click();
        }
        else{
            try {
                throw new Exception("Element not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void carComment(){

        configFileReader = new ConfigFileReader();
        commentInput.sendKeys(System.getProperty("Comment",configFileReader.getComment()));
        voteBtn.click();
    }

    public void voteSuccess(){
       String expectedVoteMsg = "Thank you for your vote!";
       String actualVoteMsg = voteSucessMsg.getAttribute("innerHTML");

       Assert.assertEquals(expectedVoteMsg,actualVoteMsg);

    }


    public void votePopularModel(){
        popModelLogo.click();
    }


    public void voteAllOverRating(String carName){

       allOverRatingLogo.click();
        String carNameStr = carnameTxt1.getAttribute("innerHTML");
        if (carName.equals(carNameStr)){

            carnameTxt1.click();
        }
        else{
            try {
                throw new Exception("Element not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
