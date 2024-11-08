package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'My Account']")
    WebElement myAcctElem;

    @FindBy(how = How.XPATH, using = "//ul//a[text() = 'Register']")
    WebElement registerElem;

    @FindBy(xpath = "//ul//a[text() = 'Login']")
    WebElement loginElem;

    public void clickMyAcctElem() {
        myAcctElem.click();
    }

    public void clickRegisterElem() {
        registerElem.click();
    }

    public void clickLoginElem() {
        loginElem.click();
    }
}
