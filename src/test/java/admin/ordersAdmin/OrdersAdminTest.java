package admin.ordersAdmin;

import actions.PageObjects.admin.OrderAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.admin.SalesPO;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Admin - Sales Management")
@Feature("Order Management")
public class OrdersAdminTest extends BaseTest {
    private WebDriver driver;
    private SalesPO sales;
    private OrderAdminPO orders;

    @Parameters({"browser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin) {
        driver = getBrowserDriver(browserName);
        LoginAdminBeforeTest(urlAdmin);
        sales = PageGeneratorAdmin.getSalesAdmin(driver);
    }
    @Story("View Order List")
    @Description("Verify that the order list displays successfully when accessing Sales menu")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void A16_ViewOrderList() {
        orders = sales.clickMenuSales();
        Assert.assertTrue(orders.verifyListOrderIsDisplayed());
    }
    @Story("View Order Detail")
    @Description("Verify that admin can view detail of a specific order successfully")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void A17_ViewDetailOrder(){
        orders.clickIconDetailOrder("#33");
        Assert.assertTrue(orders.verifyOderDetail());
    }
    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
