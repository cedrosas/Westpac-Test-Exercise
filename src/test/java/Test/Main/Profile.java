package Test.Main;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Profile extends BasePage{
    private WebDriver driver;
    ConfigFileReader configFileReader;

    BasePage basepage;
    Login login;


    @FindBy(xpath="/html/body/my-app/header/nav/div/my-login/div/ul/li[2]/a")
    WebElement profileTab;

    @FindBy(id="gender")
    WebElement userGenderDP;

    @FindBy(id="age")
    WebElement userAge;

    @FindBy(id="address")
    WebElement userAddress;

    @FindBy(id="phone")
    WebElement userPhone;

    @FindBy(id="hobby")
    WebElement userHobbyDP;

    @FindBy(xpath="/html/body/my-app/div/main/my-profile/div/form/div[2]/div/button")
    WebElement profileSaveBtn;

    @FindBy(xpath="/html/body/my-app/div/main/my-profile/div/form/div[1]/div[1]/div[2]")
    WebElement updateSuccessMessage;

    @FindBy(id="currentPassword")
    WebElement currentPasswordTB;

    @FindBy(id="newPassword")
    WebElement newPasswordTB;

    @FindBy(id="newPasswordConfirmation")
    WebElement newPasswordConfirmationTB;

    public Profile(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void userUpdateAddInfo(){

        configFileReader = new ConfigFileReader();


        profileTab.click();
        userGenderDP.sendKeys(System.getProperty("Gender",configFileReader.getGender()));
        userAge.sendKeys(System.getProperty("Age",configFileReader.getAge()));
        userAddress.sendKeys(System.getProperty("Address",configFileReader.getAddress()));
        userPhone.sendKeys(System.getProperty("Phone",configFileReader.getPhone()));
        userHobbyDP.sendKeys(System.getProperty("Hobby",configFileReader.getHobby()));
        profileSaveBtn.click();
    }

    public void updateSuccess() {
        String expectedUpdateMessage = "\n" +
                "                    The profile has been saved successful\n" +
                "                ";
        String actualUpdateMessage = updateSuccessMessage.getAttribute("innerHTML");
        Assert.assertEquals(expectedUpdateMessage,actualUpdateMessage);
    }

    public void updatePassword(){

        configFileReader = new ConfigFileReader();
        profileTab.click();

        currentPasswordTB.sendKeys(System.getProperty("Password",configFileReader.getPassword()));
        newPasswordTB.sendKeys(System.getProperty("newPassword",configFileReader.getnewPassword()));
        newPasswordConfirmationTB.sendKeys(System.getProperty("newPassword",configFileReader.getnewPassword()));

        profileSaveBtn.click();
    }


}
