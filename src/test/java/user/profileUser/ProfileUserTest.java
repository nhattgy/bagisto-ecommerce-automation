package user.profileUser;

import actions.PageObjects.user.*;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

@Epic("User Management")
@Feature("Profile Management")
public class ProfileUserTest extends BaseTest {
    private WebDriver driver;
    private ProfilePO profileUser;
    private HomePagePO homePage;
    private LoginPagePO loginPage;
    private AuthenticationPO authentication;
    DataHelper data = DataHelper.getDataHelper();
    String phoneNumber = data.getPhoneNumber();

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorUser.getHomePage(driver);
        authentication = PageGeneratorUser.getAuthentication(driver);
        LoginUserBeforeTest(urlUser);
    }

    @Story("User updates personal information successfully")
    @Description("Verify that a logged-in user can edit profile details, upload avatar, and save successfully.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void U16_UpdateProfileInformation() {
        homePage.clickIconUser();
        profileUser = homePage.openProfilePage();
        profileUser.clickButtonEditUser();
        profileUser.uploadMultipleFiles(driver, "avt.jpg");
        Assert.assertTrue(profileUser.verifyImageUploaded(), "Avatar upload failed!");
        profileUser.editPhoneNumber(phoneNumber);
        profileUser.editBirthDay("2001-10-06");
        profileUser.clickSaveButton();
        Assert.assertTrue(profileUser.verifyImageAfterSaveButton(), "Profile update not reflected after saving!");
    }
    @Test
    @Story("User changes password successfully")
    @Description("Verify that a logged-in user can change their password and log in again with the new credentials.")
    @Severity(SeverityLevel.CRITICAL)
    public void U17_ChangePassword(){
        profileUser.clickButtonEditUser();
        profileUser.enterCurrentPassword("demo123");
        profileUser.enterNewPassword("123456");
        profileUser.enterConfirmPassword("123456");
        profileUser.clickSaveButton();
        Assert.assertTrue(profileUser.verifyUpdateSuccess());
        homePage.clickIconUser();
        homePage.clickLogout();
        homePage.clickIconUser();
        loginPage = authentication.clickLinkSignIn();
        loginPage.enterEmail("john@example.com");
        loginPage.enterPassword("123456");
        loginPage.clickSignIn();
        homePage.clickIconUser();
        Assert.assertTrue(homePage.verifyProfileIsDisplayed());

    }
   @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
