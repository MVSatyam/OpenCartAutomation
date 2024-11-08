package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcctPage extends BasePage {
    public MyAcctPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'My Account']")
    WebElement heading;

    public boolean isMyAcctPageExists() {
        try {
            return heading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
