package e2efollow;

import actions.PageObjects.admin.MarketingPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.user.CartPO;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.PageObjects.user.ProductPO;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

@Epic("Promotion & Discount Management")
@Feature("Coupon Creation & Application Flow")
public class AdminCreateCouponUserApplies extends BaseTest {
    private WebDriver driver;
    private String urlUser, urlAdmin;
    private MarketingPO marketing;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    DataHelper dataHelper = DataHelper.getDataHelper();
    private String codeCoupon, nameCoupon, state, zipcode;
    String userPerCode = "1000";
    String userPerCustomer = "1000";
    String discountAmount = "20";
    String maximumQuantity = "15";
    String startDate = "2025-11-30 12:00:00";
    String endDate = "2026-02-03 12:00:00";
    String countryName = "Albania";


    @Parameters({"browser", "urlUser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String urlAdmin) {
        driver = getBrowserDriver(browserName);
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        marketing = PageGeneratorAdmin.getMarketingAdmin(driver);
        homePage = PageGeneratorUser.getHomePage(driver);
        codeCoupon = dataHelper.generateCouponCode();
        nameCoupon = dataHelper.randomMetaKeyword();
        state = dataHelper.getState();
        zipcode = dataHelper.getZipCode();
        LoginAdminBeforeTest(urlAdmin);
    }

    @Story("Admin creates a coupon → User successfully applies it during checkout")
    @Description("Validate that the Admin can create a valid coupon code in the Marketing module, "
            + "and confirm that a user is able to apply the generated coupon during cart estimation "
            + "and receive the expected discount.")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void E09_AdminCreateCouponUserApplies() {
        marketing.clickLinkMarketing();
        marketing.clickCartRules();
        marketing.clickCreateCartRule();
        marketing.enterNameCoupon(nameCoupon);
        marketing.selectCouponType(" Specific Coupon ");
        marketing.enterCouponCode(codeCoupon);
        marketing.enterUserPerCode(userPerCode);
        marketing.enterUserPerCustomer(userPerCustomer);
        marketing.enterDiscountAmount(discountAmount);
        marketing.enterMaximumQuantity(maximumQuantity);
        marketing.clickChannels();
        marketing.clickCustomerGroupGuest();
        marketing.clickCustomerGroupGeneral();
        marketing.clickCustomerGroupWholesale();
        marketing.clickStatus();
        marketing.enterStartDate(startDate);
        marketing.enterEndDate(endDate);
        marketing.saveCartRule();
        Assert.assertTrue(marketing.verifyCouponCreated());
        marketing.openPageUrl(driver, urlUser);
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.selectSize("28");
        product.clickToCart();
        Assert.assertEquals(product.verifyTextAddToCart(), "Item Added Successfully");
        product.clickToIconCart();
        cart = product.clickButtonViewCart();
        cart.sleepInSeconds(3);
        cart.clickEstimateCart();
        cart.selectCountry(countryName);
        cart.enterState(state);
        cart.enterZipcode(zipcode);
        // cart.clickFreeShip();
        cart.clickApplyCoupon();
        cart.enterCode(codeCoupon);
        cart.clickApply();
        Assert.assertTrue(cart.verifyApplyCodeSuccess());
    }

    @Story("Disabled coupon cannot be applied by user during checkout")
    @Description("""
            Validate that when the Admin disables an existing coupon, 
            the user is no longer able to apply that coupon during the checkout flow. 
            This ensures the system correctly enforces coupon availability rules in real time.
            """)
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void E10_AdminDisablesCouponUserCannotUse() {
        cart.openPageUrl(driver, urlAdmin);
        marketing.clickLinkMarketing();
        marketing.clickCartRules();
        marketing.clickEditCoupon(codeCoupon);
        marketing.clickStatus();
        marketing.saveCartRule();
        marketing.openPageUrl(driver, urlUser);
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.selectSize("28");
        product.clickToCart();
        Assert.assertEquals(product.verifyTextAddToCart(), "Item Added Successfully");
        product.clickToIconCart();
        cart = product.clickButtonViewCart();
        cart.sleepInSeconds(3);
        cart.clickEstimateCart();
        cart.selectCountry(countryName);
        cart.enterState(state);
        cart.enterZipcode(zipcode);
        // cart.clickFreeShip();
        cart.clickApplyCoupon();
        cart.enterCode(codeCoupon);
        cart.clickApply();
        Assert.assertTrue(cart.verifyApplyFailCoupon());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
