package user.checkoutUser;

import actions.PageObjects.user.*;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Epic("Checkout Functionality")
@Feature("Checkout with PayPal")
public class CheckoutWithPayPal extends BaseTest {
    private WebDriver driver;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getHomePage(driver);
        LoginBeforeTest(urlUser);
    }
    @Story("Logged-in user completes order using PayPal payment")
    @Description("Verify checkout flow using PayPal as a logged-in user")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U12_CheckoutAsLoggedInUser(){
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");

        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.selectSize("28");
        product.clickToCart();
        Assert.assertEquals(product.verifyTextAddToCart(), "Item Added Successfully");
        product.clickToIconCart();
        cart = product.clickButtonViewCart();
        Assert.assertTrue(product.verifyTitleCartDisplayed());
        checkout = cart.clickProceedToCheckout();
        checkout.clickAddressShip("(Littel Group)");
        checkout.clickProceed();
        checkout.selectTypeShipping();
        checkout.selectPayMethodPaypal();
        checkout.clickPlaceOrder();
        checkout.switchToWindowByTitle(driver, "Đăng nhập vào tài khoản PayPal của bạn");
        checkout.enterEmailPayPal("sb-vipxp22130016@business.example.com");
        checkout.enterPasswordPayPal("12345678");
        checkout.clickButtonLogin();
        checkout.selectCreditUnion();
        checkout.clickButtonPurchase();
        Assert.assertTrue(checkout.verifyOrderPaypal());
        checkout.switchToWindowByTitle(driver, "Thank you for your order!");
        Assert.assertTrue(checkout.verifyOrderSuccess());
    }
    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
