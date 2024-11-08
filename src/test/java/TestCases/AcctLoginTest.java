package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAcctPage;
import TestBase.BaseClassForTests;
import Utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcctLoginTest extends BaseClassForTests {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void acctLogin(String email, String password, String exp) {
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
            loginPage.setEmail(email);
            loginPage.setPassword(password);
            loginPage.clickLoginBtn();

            boolean isMyAcctPageExists = myAcctPage.isMyAcctPageExists();

            if (isMyAcctPageExists) {
                myAcctPage.clickLogoutElem();
                Assert.assertTrue(true);
            } else {
                Assert.fail("Testcase failed");
            }



        } catch (Exception e) {
            Assert.fail("Testcase is failed");
        }

        logger.info("***** End of the AcctLoginTest *****");
    }
}
