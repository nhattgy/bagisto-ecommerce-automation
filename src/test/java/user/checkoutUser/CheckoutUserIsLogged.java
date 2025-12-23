package user.checkoutUser;

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

@Epic("Checkout Functionality")
@Feature("Checkout as Logged-in User")
public class CheckoutUserIsLogged extends BaseTest {
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        getBrowserDocker(browserName);
        WebDriver driver = DriverManager.getDriver();
        homePage = PageGeneratorUser.getHomePage(driver);
        LoginUserBeforeTest(urlUser);
    }

    @Test
    @Story("Logged-in user completes checkout process successfully")
    @Description("Verify that a logged-in user can place an order successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void U12_CheckoutAsLoggedInUser() {
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
        checkout.selectPayMethod();
        checkout.clickPlaceOrder();
        Assert.assertTrue(checkout.verifyOrderSuccess());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
