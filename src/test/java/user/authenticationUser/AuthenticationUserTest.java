package user.authenticationUser;

import actions.PageObjects.user.AuthenticationPO;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.LoginPagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

@Epic("User Module")
@Feature("Authentication")
public class AuthenticationUserTest extends BaseTest {
    private String urlUser;
    private HomePagePO homePage;
    private AuthenticationPO authentication;
    private LoginPagePO loginPage;
    private DataHelper dataHelper = DataHelper.getDataHelper();
    String FirstName = dataHelper.getFirstName();
    String LastName = dataHelper.getLastName();
    String EmailAddress = dataHelper.getEmailAddress();
    String Password = dataHelper.getPassword();

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        getBrowserDriver(browserName);
        WebDriver driver = DriverManager.getDriver();
        this.urlUser = urlUser;
        homePage = PageGeneratorUser.getHomePage(driver);

    }

    @Story("User Registration")
    @Description("Verify that user can register successfully with valid data.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U01_RegisterWithValidData() {
        WebDriver driver = DriverManager.getDriver();
        homePage.openPageUrl(driver, urlUser);
        homePage.acceptCookie();
        authentication = homePage.clickIconUser();
        authentication.clickLinkSignUp();
        authentication.enterFirstName(FirstName);
        authentication.enterLastName(LastName);
        authentication.enterEmail(EmailAddress);
        authentication.enterPassword(Password);
        authentication.enterConfirmPassword(Password);
        authentication.clickSubscribe();
        authentication.clickAgree();
        authentication.clickButtonRegister();
        Assert.assertTrue(authentication.verifyMessengerRegisterSuccsessIsDisplayed());
    }

    @Story("User Registration")
    @Description("Verify that the system displays an appropriate error message when attempting to register with an email address that has already been registered.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void U02_RegisterWithExistingEmail() {
        WebDriver driver = DriverManager.getDriver();
        homePage.openPageUrl(driver, urlUser);
        authentication = homePage.clickIconUser();
        authentication.clickLinkSignUp();
        authentication.enterFirstName(FirstName);
        authentication.enterLastName(LastName);
        authentication.enterEmail(EmailAddress);
        authentication.enterPassword(Password);
        authentication.enterConfirmPassword(Password);
        authentication.clickSubscribe();
        authentication.clickAgree();
        authentication.clickButtonRegister();

        Assert.assertTrue(authentication.verifyEmailAlReadyRegistered());
    }

    @Story("User Login")
    @Description("User logs in successfully and is redirected to the homepage.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U03_LoginWithValidCredentials() {
        WebDriver driver = DriverManager.getDriver();
        homePage.openPageUrl(driver, urlUser);
        homePage.clickIconUser();
        loginPage = authentication.clickLinkSignIn();
        loginPage.enterEmail(EmailAddress);
        loginPage.enterPassword(Password);
        loginPage.clickSignIn();
        homePage.clickIconUser();
        Assert.assertTrue(homePage.verifyProfileIsDisplayed());
    }

    @Story("Login with invalid password")
    @Description("User login invalid Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U04_LoginWithInvalidPassword() {
        homePage.clickLogout();
        homePage.clickIconUser();
        loginPage = authentication.clickLinkSignIn();
        loginPage.enterEmail(EmailAddress);
        loginPage.enterPassword("112939@@");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.verifyErrorMessengerDisplayed());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
