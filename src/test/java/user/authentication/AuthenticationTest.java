package user.authentication;

import actions.PageObjects.user.AuthenticationPO;
import actions.PageObjects.user.PageGenerator;
import actions.commons.BaseTest;
import com.github.javafaker.Faker;
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
public class AuthenticationTest extends BaseTest {
    private WebDriver driver;
    private String urlUser;
    private AuthenticationPO authentication;
    private DataHelper dataHelper = DataHelper.getDataHelper();
    String FirstName = dataHelper.getFirstName();
    String LastName = dataHelper.getLastName();
    String EmailAddress = dataHelper.getEmailAddress();
    String Password = dataHelper.getPassword();
    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        driver = getBrowserDriver(browserName);
        this.urlUser = urlUser;
        authentication = PageGenerator.getAuthentication(driver);

    }

    @Story("User Registration")
    @Description("Verify that user can register successfully with valid data.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U01_RegisterWithValidData() {
        authentication.openPageUrl(driver, urlUser);
        authentication.clickIconUser();
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

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
