package e2efollow;

import actions.PageObjects.admin.*;
import actions.PageObjects.user.*;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import actions.commons.GlobalConstants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("E2E Flow")
@Feature("Orders Management")
public class OrdersUserToAdminView extends BaseTest {
    private String urlUser;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;
    private OrderPO order;
    private OrderAdminPO orders;
    private String urlAdmin;
    private AuthenticationAdminPO authenticationAdmin;
    private DashboardAdminPO dashboardAdmin;
    private SalesPO sales;
    String numberID;

    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin, String urlUser) {
        getBrowserDriver(browserName);
        WebDriver driver = DriverManager.getDriver();
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        homePage = PageGeneratorUser.getHomePage(driver);
        order = PageGeneratorUser.getOrder(driver);
        authenticationAdmin = PageGeneratorAdmin.getAuthenticationAdmin(driver);
        sales = PageGeneratorAdmin.getSalesAdmin(driver);
        LoginUserBeforeTest(urlUser);
    }

    @Story("User places an order and Admin views the newly created order")
    @Description("Verify that when a user successfully places an order on the storefront, "
            + "the new order appears in the Admin Sales → Orders list with the correct Order ID.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E05_OrdersUserPlacesOrderAdminSeesNewOrder() {
        WebDriver driver = DriverManager.getDriver();
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
        numberID = checkout.getTextIdProduct();
        order.openPageUrl(driver, urlAdmin);
        dashboardAdmin = authenticationAdmin.enterEmailAddress(GlobalConstants.EMAIL_ADDRESS_ADMIN);
        authenticationAdmin.enterPassword(GlobalConstants.PASSWORD_ADMIN);
        authenticationAdmin.clickSignIn();
        Assert.assertTrue(authenticationAdmin.menuDashboardIsDisplayed());
        orders = sales.clickMenuSales();
        Assert.assertTrue(orders.verifyListOrderIsDisplayed());
        sales.enterSearch(numberID);
        Assert.assertTrue(sales.verifyIdProductDisplayed("#" + numberID));
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
