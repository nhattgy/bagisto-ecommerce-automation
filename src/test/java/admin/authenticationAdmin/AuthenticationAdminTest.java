package admin.authenticationAdmin;

import actions.PageObjects.admin.AuthenticationAdminPO;
import actions.PageObjects.admin.DashboardAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Admin Authentication")
@Feature("Login Functionality")
public class AuthenticationAdminTest extends BaseTest {
    private WebDriver driver;
    private AuthenticationAdminPO authenticationAdmin;
    private DashboardAdminPO dashboardAdmin;
    private String urlAdmin;

    @Parameters({"browser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin) {
        driver = getBrowserDriver(browserName);
        this.urlAdmin = urlAdmin;
        authenticationAdmin = PageGeneratorAdmin.getAuthenticationAdmin(driver);
    }

    @Story("Verify that admin can log in successfully to the Admin Panel")
    @Description("Ensure that a valid admin user can log in to the Admin Panel using correct credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void A01_LoginAdminPanel() {
        authenticationAdmin.openPageUrl(driver, urlAdmin);
        dashboardAdmin = authenticationAdmin.enterEmailAddress(GlobalConstants.EMAIL_ADDRESS_ADMIN);
        authenticationAdmin.enterPassword(GlobalConstants.PASSWORD_ADMIN);
        authenticationAdmin.clickSignIn();
        Assert.assertTrue(authenticationAdmin.menuDashboardIsDisplayed());
    }

    @Description("Verify that the system displays an error message when the admin tries to log in with invalid credentials.")
    @Severity(SeverityLevel.NORMAL)
    @Step("A02 - Admin attempts to log in with invalid password and should see an error message")
    @Test
    public void A02_LoginWithInvalidCredentials() {
        dashboardAdmin.clickButtonProfile();
        dashboardAdmin.clickLogout();
        Assert.assertEquals(
                authenticationAdmin.verifyUrlLoginAdmin(),
                "https://demo.bagisto.com/bagisto-common/admin/login"
        );

        authenticationAdmin.enterEmailAddress(GlobalConstants.EMAIL_ADDRESS_ADMIN);
        authenticationAdmin.enterPassword("@###%%#%#");
        authenticationAdmin.clickSignIn();

        Assert.assertTrue(authenticationAdmin.verifyErrorMessenger());
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
