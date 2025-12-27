package admin.marketingTestAdmin;

import actions.PageObjects.admin.CouponCodePO;
import actions.PageObjects.admin.MarketingPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Epic("Marketing - Coupon Code")
@Feature("Delete Coupon")
public class MarketingAdminTest extends BaseTest {
    private MarketingPO marketing;
    private CouponCodePO couponCode;
    private String nameCoupon = "couponCode"+randomNumber();
    private String nameCouponEdit = "couponCodeEdit"+randomNumber();
    @Parameters({"browser","urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin){
        getBrowserDriver(browserName);
        WebDriver driver = DriverManager.getDriver();
        LoginAdminBeforeTest(urlAdmin);
        marketing = PageGeneratorAdmin.getMarketingAdmin(driver);
    }
    @Story("Add new coupon")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create a new coupon code successfully")
    @Test
    public void A18_AddCoupon(){
        couponCode = marketing.clickLinkMarketing();
        couponCode.openCartRules();
        couponCode.clickCreateCartRule();

        couponCode.enterName(nameCoupon);
        couponCode.selectCouponType(" Specific Coupon ");
        couponCode.selectAutoGenCode(" Yes ");
        couponCode.enterDiscountAmount("20");

        couponCode.clickChannel();
        couponCode.clickCustomerGroups();
        couponCode.clickActiveStatus();

        couponCode.enterFromMarketingTimeStart("2025-11-21 12:00:00");
        couponCode.enterFromMarketingTimeEnd("2025-11-22 12:00:00");

        couponCode.clickSaveCartRule();
        Assert.assertTrue(couponCode.verifyTextCouponAddSuccess());
    }

    @Story("Edit coupon information")
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit coupon information successfully")
    @Test
    public void A19_EditCoupon() {
        couponCode.editCoupon(nameCoupon);
        couponCode.enterName(nameCouponEdit);
        couponCode.clickSaveCartRule();

        try {
            Assert.assertTrue(couponCode.verifyTextEditCoupon(),
                    "FAILED: Text edit coupon is NOT displayed!");
        } catch (AssertionError e) {
            System.out.println("Assertion failed in A19_EditCoupon: " + e.getMessage());
            throw e;
        }
    }


    @Story("Delete coupon")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Delete coupon successfully")

    public void A20_DeleteCoupon(){
        couponCode.deleteCoupon(nameCouponEdit);
        couponCode.clickButtonAgreeDelete();
        Assert.assertTrue(couponCode.verifyTextDeleteCoupon());
    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
