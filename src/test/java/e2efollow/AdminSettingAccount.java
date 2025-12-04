package e2efollow;

import actions.PageObjects.admin.AccountAdminPO;
import actions.PageObjects.admin.AuthenticationAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;

@Epic("Admin Account Management")
@Feature("Admin User Creation & Authentication")
public class AdminSettingAccount extends BaseTest {
    private WebDriver driver;
    private AccountAdminPO accountAdmin;
    private AuthenticationAdminPO authenticationAdmin;
    private String urlUser, urlAdmin;
    private String name, email, password;
    DataHelper dataHelper = DataHelper.getDataHelper();

    @Parameters({"browser", "urlUser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browser, String urlUser, String urlAdmin) {

        driver = getBrowserDriver(browser);
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

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
