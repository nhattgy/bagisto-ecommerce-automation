package e2efollow;

import actions.PageObjects.admin.AccountAdminPO;
import actions.PageObjects.admin.AuthenticationAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;

@Epic("Admin Account Management")
@Feature("Admin User Creation & Authentication")
public class AdminSettingAccount extends BaseTest {
    private AccountAdminPO accountAdmin;
    private AuthenticationAdminPO authenticationAdmin;
    private String urlUser, urlAdmin;
    private String name, email, password;
    private String passwordChange = "123456!@#";
    DataHelper dataHelper = DataHelper.getDataHelper();

    @Parameters({"browser", "urlUser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browser, String urlUser, String urlAdmin) {

        getBrowserDocker(browser);
        WebDriver driver = DriverManager.getDriver();
        LoginAdminBeforeTest(urlAdmin);

        accountAdmin = PageGeneratorAdmin.getAccountAdmin(driver);
        name = dataHelper.getName();
        email = dataHelper.getEmailAddress();
        password = dataHelper.getPassword();
    }


    @Story("E13 - Admin creates a new admin account and the new admin can log in successfully")
    @Description("Verify that an existing admin can create a new admin account, and the newly created admin can successfully log in using the provided credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E13_AdminCreateAccountUserLogin() {
        accountAdmin.openSetting();
        accountAdmin.clickLinkUsers();
        accountAdmin.clickCreateUser();
        accountAdmin.enterName(name);
        accountAdmin.enterEmail(email);
        accountAdmin.enterPassword(password);
        accountAdmin.enterConfirmPassword(password);
        accountAdmin.selectRole("Administrator");
        accountAdmin.clickStatus();
        accountAdmin.clickSaveUser();
        Assert.assertTrue(accountAdmin.verifyCreatedAccount());
        accountAdmin.clickIconAdmin();
        authenticationAdmin = accountAdmin.clickLogout();
        authenticationAdmin.enterEmailAddress(email);
        authenticationAdmin.enterPassword(password);
        authenticationAdmin.clickSignIn();
        Assert.assertTrue(authenticationAdmin.menuDashboardIsDisplayed());
    }

    @Story("E14 - Change admin password and verify login with the updated credentials")
    @Description("""
            Ensure that an admin user is able to change their password. After updating the
            password, validate that the admin can log out and log in again using the new
            credentials without issues.
            """)
    @Severity(SeverityLevel.NORMAL)

   // @Test
    public void E14_AdminChangePasswordAfterLogin() {
        accountAdmin.editAccountAdmin(name);
        accountAdmin.enterPassword(passwordChange);
        accountAdmin.enterConfirmPassword(passwordChange);
        accountAdmin.clickSaveUser();
        accountAdmin.clickIconAdmin();
        authenticationAdmin = accountAdmin.clickLogout();
        authenticationAdmin.enterEmailAddress(email);
        authenticationAdmin.enterPassword(passwordChange);
        authenticationAdmin.clickSignIn();
        Assert.assertTrue(authenticationAdmin.menuDashboardIsDisplayed());
    }

    @Story("E15 - Validate password mismatch error during admin password update")
    @Description("""
            Verify that when an admin attempts to update their password with mismatched
            'Password' and 'Confirm Password' fields, the system correctly displays a
            validation error message and prevents the update.
            """)
    @Severity(SeverityLevel.MINOR)
   // @Test
    public void E15_AdminChangePasswordMissMatchPassword() {
        accountAdmin.editAccountAdmin(name);
        accountAdmin.enterPassword(passwordChange);
        accountAdmin.enterConfirmPassword("1111");
        Assert.assertTrue(accountAdmin.verifyAccountMissMatch());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
