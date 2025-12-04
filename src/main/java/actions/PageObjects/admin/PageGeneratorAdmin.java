package actions.PageObjects.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorAdmin {
    public static AuthenticationAdminPO getAuthenticationAdmin(WebDriver driver){
        return new AuthenticationAdminPO(driver);
    }
    public static DashboardAdminPO getDashboardAdmin(WebDriver driver){
        return new DashboardAdminPO(driver);
    }
    public static CategoryAdminPO getCategoryAdmin(WebDriver driver){
        return new CategoryAdminPO(driver);
    }
    public static CatalogAdminPO getCatalogAdmin(WebDriver driver){
        return new CatalogAdminPO(driver);
    }
    public static ProductAdminPO getProductAdmin(WebDriver driver){
        return new ProductAdminPO(driver);
    }
    public static CustomerAdminPO getCustomerAdmin(WebDriver driver){
        return new CustomerAdminPO(driver);
    }
    public static SalesPO getSalesAdmin(WebDriver driver){
        return new SalesPO(driver);
    }
    public static OrderAdminPO getOrdersAdmin(WebDriver driver){
        return new OrderAdminPO(driver);
    }
    public static MarketingPO getMarketingAdmin(WebDriver driver){
        return new MarketingPO(driver);
    }
    public static CouponCodePO getCouponCodeAdmin(WebDriver driver){
        return new CouponCodePO(driver);
    }
    public static AccountAdminPO getAccountAdmin(WebDriver driver){
        return new AccountAdminPO(driver);
    }
}
