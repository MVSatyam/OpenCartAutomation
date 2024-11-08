package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAcctPage extends BasePage {
    public MyAcctPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'My Account']")
    WebElement heading;

    @FindBy(how = How.LINK_TEXT, using = "Logout")
    WebElement logoutElem;

    public boolean isMyAcctPageExists() {
        try {
            return heading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogoutElem() {
        logoutElem.click();
    }
}
