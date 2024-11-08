package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailElem;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passwdElem;

    @FindBy(xpath = "//input[@type='submit' and @value='Login']")
    WebElement loginBtnElem;

    public void setEmail(String email) {
        emailElem.sendKeys(email);
    }

    public void setPassword(String password) {
        passwdElem.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtnElem.click();
    }

}
