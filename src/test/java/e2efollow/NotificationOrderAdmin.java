package e2efollow;

import actions.PageObjects.admin.*;
import actions.PageObjects.user.*;
import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Epic("Order Management & Admin Notification System")
@Feature("End-to-End Order Synchronization Between User and Admin Dashboard")
public class NotificationOrderAdmin extends BaseTest {
    private WebDriver driver;
    private String urlUser;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;
    private OrderPO order;
    private OrderAdminPO orderAdmin;
    private String urlAdmin;
    private AuthenticationAdminPO authenticationAdmin;
    private DashboardAdminPO dashboardAdmin;
    private SalesPO sales;
    String numberID;
    @Parameters({"browser","urlUser","urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser, String urlAdmin){
        driver = getBrowserDriver(browserName);
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        homePage = PageGeneratorUser.getHomePage(driver);
        order = PageGeneratorUser.getOrder(driver);
        authenticationAdmin = PageGeneratorAdmin.getAuthenticationAdmin(driver);
        sales = PageGeneratorAdmin.getSalesAdmin(driver);
        orderAdmin = PageGeneratorAdmin.getOrdersAdmin(driver);
        LoginUserBeforeTest(urlUser);
    }
    @Story("User places order → Admin sees new order notification")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that when a user completes checkout, the Admin dashboard displays a notification containing the correct order ID.")
    @Test
    public void E06_UserCheckoutAdminSeeNotification(){
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
        dashboardAdmin.openIconNotification();
        Assert.assertTrue(dashboardAdmin.verifyIdProductIsDisplayed("#"+numberID));
        dashboardAdmin.sleepInSeconds(3);
    }
    @Story("User places order → Admin receives a real-time notification")
    @Description("Validate that after a user completes the checkout flow, the Admin dashboard displays an accurate real-time notification containing the generated order ID.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E07_AdminUpdateStatusUserSeeChange(){
        dashboardAdmin.clickOrder("#"+numberID);
        orderAdmin.clickStatusShip();
        orderAdmin.selectSource(" Default ");
        orderAdmin.clickCreateShipment();
        Assert.assertTrue(orderAdmin.verifyCreateShipmentSuccess());
        orderAdmin.openPageUrl(driver, urlUser);
        homePage.clickIconUser();
        order = homePage.clickOrderPage();
        Assert.assertTrue(order.verifyOrderIDChangeStatus(numberID));
    }
    @Story("Admin generates invoice → Downloads PDF successfully")
    @Description("Verify that the Admin can create an invoice for an order and download the corresponding PDF file from the dashboard.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void E08_AdminGenerateInvoiceAndDownload(){
        order.openPageUrl(driver, urlAdmin);
        sales.clickMenuSales();
        orderAdmin.enterSearch(numberID);
        orderAdmin.clickIconDetailOrder("#"+numberID);
        orderAdmin.clickInvoice();
        orderAdmin.clickCreateInvoice();
        Assert.assertTrue(orderAdmin.verifyCreateInvoiceSuccess());
        orderAdmin.clickDownloadPdfInvoice();
    }
    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
