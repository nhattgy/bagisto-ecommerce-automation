package e2efollow;

import actions.PageObjects.admin.CustomerAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.PageObjects.user.ProductPO;
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

@Epic("Product Review Management")
@Feature("User Review Submission and Admin Moderation")
public class UserSubmitReviewAdminCheck extends BaseTest {
    private HomePagePO homePage;
    private ProductPO product;
    private CustomerAdminPO customerAdmin;
    private String title, comment;
    private String urlUser, urlAdmin;
    DataHelper dataHelper = DataHelper.getDataHelper();

    @Parameters({"browser", "urlUser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String urlAdmin) {
        getBrowserDocker(browserName);
        WebDriver driver = DriverManager.getDriver();
        homePage = PageGeneratorUser.getHomePage(driver);
        customerAdmin = PageGeneratorAdmin.getCustomerAdmin(driver);
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        LoginUserBeforeTest(urlUser);
        title = dataHelper.randomMetaDescription();
        comment = dataHelper.randomLongDescription();
    }

    @Story("User submits a review and Admin approves it")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that an Admin can approve a user-submitted product review and the review becomes visible to the user")
    @Test
    public void E11_UserSubmitReviewAdminApproves() {
        WebDriver driver = DriverManager.getDriver();
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.clickToReview();
        product.scrollToBottomPageByJS(driver);
        product.clickWriteAReview();
        product.enterTitle(title);
        product.enterComment(comment);
        product.sleepInSeconds(1);
        product.clickSubmitReview();
        Assert.assertTrue(product.verifyCommentSuccess());
        product.openPageUrl(driver, urlAdmin);
        LoginAdminBeforeTest(urlAdmin);
        customerAdmin.clickLinkCustomer();
        customerAdmin.clickLinkReview();
        customerAdmin.clickEditReview(title);
        customerAdmin.selectStatus(" Approved ");
        customerAdmin.clickSaveReview();
        Assert.assertTrue(customerAdmin.verifySaveStatusReviewSuccess());
        customerAdmin.openPageUrl(driver, urlUser);
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.clickToReview();
        product.scrollToBottomPageByJS(driver);
        Assert.assertTrue(product.verifyReviewIsDisplayed(title));
    }

    @Story("Admin rejects a user review and User should not see the review")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that when Admin rejects a review, the review is not visible to the userx")
    @Test
    public void E12_AdminRejectReviewUserCheck() {
        WebDriver driver = DriverManager.getDriver();
        product.openPageUrl(driver, urlAdmin);
        customerAdmin.clickLinkCustomer();
        customerAdmin.clickLinkReview();
        customerAdmin.clickEditReview(title);
        customerAdmin.selectStatus(" Disapproved ");
        customerAdmin.clickSaveReview();
        Assert.assertTrue(customerAdmin.verifySaveStatusReviewSuccess());
        customerAdmin.openPageUrl(driver, urlUser);
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.clickToReview();
        product.scrollToBottomPageByJS(driver);
        product.sleepInSeconds(1);
        Assert.assertTrue(product.verifyReviewIsNotDisplayed(title));
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
