package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcctRegistrationPage extends BasePage {
    public AcctRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstNameELem;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastNameELem;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailELem;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephoneELem;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passwdELem;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPasswdELem;

    public void setFirstName(String firstName) {
        firstNameELem.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameELem.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailELem.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        telephoneELem.sendKeys(telephone);
    }

    public void setPassword(String password) {
        passwdELem.sendKeys(password);
    }

    public void setConfirmPasswd(String confirmPasswd) {
        confirmPasswdELem.sendKeys(confirmPasswd);
    }

    public String getConfirmationMsg () {
        return "Successful!";
    }
}
