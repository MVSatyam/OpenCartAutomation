package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAcctPage;
import TestBase.BaseClassForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcctLoginTest extends BaseClassForTests {
    @Test
    public void acctLogin() {
        logger.info("***** Start of the AcctLoginTest *****");

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            MyAcctPage myAcctPage = new MyAcctPage(driver);

            logger.info("Clicking MyAccount");
            homePage.clickMyAcctElem();

            logger.info("Clicking Login");
            homePage.clickLoginElem();

            logger.info("Providing credentials");
            loginPage.setEmail(properties.getProperty("email"));
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLoginBtn();

            boolean isMyAcctPageExists = myAcctPage.isMyAcctPageExists();

            Assert.assertTrue(isMyAcctPageExists, "Testcase is failed");
        } catch (Exception e) {
            Assert.fail("Testcase is failed");
        }

        logger.info("***** End of the AcctLoginTest *****");
    }
}
