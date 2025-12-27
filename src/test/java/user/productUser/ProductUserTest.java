package user.productUser;

import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.PageObjects.user.ProductPO;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("User Module")
@Feature("Product Search")
public class ProductUserTest extends BaseTest {
    private HomePagePO homePage;
    private ProductPO product;
    private String urlUser;

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        getBrowserDriver(browserName);
        WebDriver driver = DriverManager.getDriver();
        this.urlUser = urlUser;
        homePage = PageGeneratorUser.getHomePage(driver);
    }

    @Story("Product Search Functionality")
    @Description("Verify that user can search for products by keyword and see correct search results.")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void U05_ProductSearch() {
        WebDriver driver = DriverManager.getDriver();
        homePage.openPageUrl(driver, urlUser);
        homePage.acceptCookie();
        product = homePage.searchProduct("shirt");
        Assert.assertEquals(product.verifyTextResults(), "These are results for : shirt");
    }

    @Story("Product Filtering")
    @Description("Verify that the user can filter products by category (e.g., 'Men') and the correct number of results is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void U06_ProductFilter() {
        homePage.clickLinkMenuProduct("Men");
        Assert.assertEquals(product.verifyQuantityResultSearch(), 10);
        homePage.hoverLinkMenuParentProduct("Kids");
        homePage.clickLinkMenuChildProduct("Boys Clothing");
        Assert.assertEquals(product.verifyQuantityResultSearch(), 9);
    }

    @Story("Product Detail")
    @Description("Verify that user can open product detail page successfully and 'Buy Now' button is visible.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U07_ProductDetail() {
        product.clickOnProductByName("Vibrant Trio Boys");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        homePage.hoverLinkMenuParentProduct("Woman");
        homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");
        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
