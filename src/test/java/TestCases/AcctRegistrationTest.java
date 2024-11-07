package TestCases;

import PageObjects.AcctRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClassForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcctRegistrationTest extends BaseClassForTests {

    @Test
    public void acctRegistration() {
        HomePage homePage = new HomePage(driver);
        AcctRegistrationPage acctRegistrationPage = new AcctRegistrationPage(driver);

        homePage.clickMyAcctElem();
        homePage.clickRegisterElem();

        acctRegistrationPage.setFirstName("demo");
        acctRegistrationPage.setLastName("demo");
        acctRegistrationPage.setEmail("demo@gamil.com");
        acctRegistrationPage.setTelephone("1234");
        acctRegistrationPage.setPassword("demo");
        acctRegistrationPage.setConfirmPasswd("demo");

        String confirmationMsg = acctRegistrationPage.getConfirmationMsg();

        Assert.assertEquals(confirmationMsg, "Successful!");
    }
}
