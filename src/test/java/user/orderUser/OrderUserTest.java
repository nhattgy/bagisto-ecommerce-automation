package user.orderUser;

import actions.PageObjects.user.*;
import actions.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderUserTest extends BaseTest {
    private WebDriver driver;
    private String urlUser;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;
    private OrderPO order;
    @Parameters({"browser","urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser){
        driver = getBrowserDriver(browserName);
        this.urlUser = urlUser;
        homePage = PageGenerator.getHomePage(driver);
        LoginBeforeTest(urlUser);
    }

    @Test
    public void U14_PlaceOrderSuccessfully(){
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
    @Test
    public void U15_ViewOrderDetails(){
        order.viewOrderDetails();
        Assert.assertTrue(order.verifyOrderDetails("Blossom Breeze Cotton Printed Short Skirt"));
    }
    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
