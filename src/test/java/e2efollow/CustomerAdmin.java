package e2efollow;

import actions.PageObjects.admin.CustomerAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.user.*;
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

@Epic("Customer Management")
@Feature("Admin Creates Customer & Customer Profile Completion")
public class CustomerAdmin extends BaseTest {
    private CustomerAdminPO customerAdmin;
    private ProfilePO profile;
    private HomePagePO homePage;
    private LoginPagePO loginPage;
    private AuthenticationPO authentication;
    private String urlUser, urlAdmin;
    private String firstName, lastname, email, phone, password;
    DataHelper dataHelper = DataHelper.getDataHelper();

    @Parameters({"browser", "urlUser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String urlAdmin) {
        getBrowserDocker(browserName);
        WebDriver driver = DriverManager.getDriver();
        customerAdmin = PageGeneratorAdmin.getCustomerAdmin(driver);
        homePage = PageGeneratorUser.getHomePage(driver);
        authentication = PageGeneratorUser.getAuthentication(driver);
        LoginAdminBeforeTest(urlAdmin);
        firstName = dataHelper.getFirstName();
        lastname = dataHelper.getLastName();
        email = dataHelper.getEmailAddress();
        phone = dataHelper.getPhoneNumber();
        password = dataHelper.getPassword();
    }

    @Story("E16 - Admin creates a new customer and customer completes required profile information")
    @Description("""
            Verify that an admin can successfully create a new customer account.
            Customer is then able to access the storefront, log in with the initial credentials, 
            complete missing mandatory profile fields (phone number, password, confirm password), 
            save the profile successfully, and log in again using the updated password.
            """)
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E16_AdminAddCustomerUserLogin() {
        WebDriver driver = DriverManager.getDriver();
        String parentID = driver.getWindowHandle();
        customerAdmin.clickLinkCustomer();
        customerAdmin.clickCreateCustomer();
        customerAdmin.enterFirstName(firstName);
        customerAdmin.enterLastName(lastname);
        customerAdmin.enterEmailAddress(email);
        customerAdmin.enterDateOfBirth("2001-05-06");
        customerAdmin.selectGender("Male");
        customerAdmin.clickSaveCustomer();
        Assert.assertTrue(customerAdmin.verifyCustomerCreated());
        Assert.assertTrue(customerAdmin.verifyAccountIsDisplayed(firstName + " " + lastname));
        profile = customerAdmin.clickOpenProfile(firstName + " " + lastname);
        customerAdmin.switchToWindowByID(driver, parentID);
        Assert.assertTrue(profile.verifyLoginSuccessFully(firstName + " " + lastname));
    }

    @Story("E17 - Customer profile validation for invalid phone number input")
    @Description("""
            Verify that when the customer enters an invalid phone number format in the profile page,
            the system displays the correct validation error message.
            """)
    @Severity(SeverityLevel.MINOR)
    @Test
    public void E17_E18_VerifyValidateInputProfile() {
        profile.clickButtonEditUser();
        profile.editPhoneNumber("##$$$$");
        Assert.assertTrue(profile.verifyValidatePhoneNumber());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
