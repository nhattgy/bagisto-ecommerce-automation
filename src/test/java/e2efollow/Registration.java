package e2efollow;

import actions.PageObjects.admin.AuthenticationAdminPO;
import actions.PageObjects.admin.CustomerAdminPO;
import actions.PageObjects.admin.DashboardAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.user.AuthenticationPO;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;
@Epic("E2E User Registration Flow")
@Feature("User creates account and admin verifies customer")
public class Registration extends BaseTest {
    private WebDriver driver;
    private String urlUser, urlAdmin;
    private HomePagePO homePage;
    private AuthenticationPO authentication;
    private AuthenticationAdminPO authenticationAdmin;
    private DashboardAdminPO dashboardAdmin;
    private CustomerAdminPO customerAdmin;
    private DataHelper dataHelper = DataHelper.getDataHelper();
    String FirstName = dataHelper.getFirstName();
    String LastName = dataHelper.getLastName();
    String EmailAddress = dataHelper.getEmailAddress();
    String Password = dataHelper.getPassword();

    @Parameters({"browser", "urlUser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String urlAdmin) {
        driver = getBrowserDriver(browserName);
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        homePage = PageGeneratorUser.getHomePage(driver);
        authenticationAdmin = PageGeneratorAdmin.getAuthenticationAdmin(driver);
        customerAdmin = PageGeneratorAdmin.getCustomerAdmin(driver);
    }
    @Story("User registers a new account successfully")
    @Description("Verify that a user can register on frontend and the admin can search & validate the new customer in the Admin Dashboard.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E01_UserRegisterAdminCheckUser() {
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
        Assert.assertTrue(authentication.verifyMessengerRegisterSuccsessIsDisplayed());
        authenticationAdmin.openPageUrl(driver, urlAdmin);
        dashboardAdmin = authenticationAdmin.enterEmailAddress(GlobalConstants.EMAIL_ADDRESS_ADMIN);
        authenticationAdmin.enterPassword(GlobalConstants.PASSWORD_ADMIN);
        authenticationAdmin.clickSignIn();
        Assert.assertTrue(authenticationAdmin.menuDashboardIsDisplayed());
        customerAdmin.clickLinkCustomer();
        customerAdmin.enterSearchCustomer(EmailAddress);
        Assert.assertTrue(customerAdmin.verifyEmailAddressIsDisplay(EmailAddress));
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
