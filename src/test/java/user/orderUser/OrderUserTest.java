package user.orderUser;

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

@Epic("Order Management")
@Feature("Place and View Orders")
public class OrderUserTest extends BaseTest {
    private String urlUser;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;
    private OrderPO order;

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        getBrowserDriver(browserName);
        WebDriver driver = DriverManager.getDriver();
        this.urlUser = urlUser;
        homePage = PageGeneratorUser.getHomePage(driver);
        LoginUserBeforeTest(urlUser);
    }

    @Story("User places an order successfully after checkout")
    @Description("Verify that a logged-in user can complete the checkout process and place an order successfully.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U14_PlaceOrderSuccessfully() {
        WebDriver driver = DriverManager.getDriver();
        homePage.openPageUrl(driver, urlUser);
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
        homePage.clickIconUser();
        order = homePage.clickOrderPage();
        Assert.assertTrue(order.verifyOrder());
    }

    @Story("User views order details")
    @Description("Verify that a logged-in user can view order details of previously placed orders.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void U15_ViewOrderDetails() {
        order.viewOrderDetails();
        Assert.assertTrue(order.verifyOrderDetails("Blossom Breeze Cotton Printed Short Skirt"));
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
