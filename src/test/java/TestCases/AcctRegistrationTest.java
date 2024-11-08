package TestCases;

import PageObjects.AcctRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClassForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcctRegistrationTest extends BaseClassForTests {

    @Test
    public void acctRegistration() {
        logger.info("***** Start of the Account Registration *****");
        HomePage homePage = new HomePage(driver);
        AcctRegistrationPage acctRegistrationPage = new AcctRegistrationPage(driver);

        try {
            logger.info("Clicked on MyAccount");
            homePage.clickMyAcctElem();

            logger.info("Clicked on Register");
            homePage.clickRegisterElem();

            logger.info("Providing details");
            acctRegistrationPage.setFirstName("nextgen");
            acctRegistrationPage.setLastName("del");
            acctRegistrationPage.setEmail("nextgen@gamil.com");
            acctRegistrationPage.setTelephone("35634745643");
            acctRegistrationPage.setPassword("nextgen123");
            acctRegistrationPage.setConfirmPasswd("nextgen123");
            acctRegistrationPage.checkPrivacy();
            acctRegistrationPage.clickContinue();

            String confirmationMsg = acctRegistrationPage.getConfirmationMsg();

            Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!", "Testcase is failed");
//            logger.info("Validating Testcase");
//            if (confirmationMsg.equals("Your Account Has Been Created!")) {
//                logger.info("Testcase is passed");
//                Assert.assertTrue(true);
//            } else {
//                logger.error("Testcase is failed");
//                Assert.assertTrue(false);
//            }
        } catch (AssertionError error) {
            logger.error("Assertion Error", error);
            Assert.fail(error.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
