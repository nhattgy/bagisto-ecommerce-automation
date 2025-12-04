package e2efollow;

import actions.PageObjects.admin.CatalogAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.admin.ProductAdminPO;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.PageObjects.user.ProductPO;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

@Epic("End-to-End Product Visibility Management")
@Feature("Admin Controls Product Creation and Visibility on Storefront")
public class ProductAdminUser extends BaseTest {
    private WebDriver driver;
    private ProductAdminPO productAdmin;
    private CatalogAdminPO catalogAdmin;
    private HomePagePO homePage;
    private ProductPO product;
    private String urlUser, urlAdmin;
    private String sku, productName, shortDesc, longDesc, metaTitle, metaKeyword, metaDescription;
    private String price, weight, inventory;

    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin, String urlUser) {
        driver = getBrowserDriver(browserName);
        LoginAdminBeforeTest(urlAdmin);
        this.urlUser = urlUser;
        this.urlAdmin = urlAdmin;
        catalogAdmin = PageGeneratorAdmin.getCatalogAdmin(driver);
        homePage = PageGeneratorUser.getHomePage(driver);
        DataHelper data = DataHelper.getDataHelper();

        sku = data.randomSKU();
        productName = data.randomProductName();
        shortDesc = data.randomShortDescription();
        longDesc = data.randomLongDescription();
        metaTitle = data.randomMetaTitle();
        metaKeyword = data.randomMetaKeyword();
        metaDescription = data.randomMetaDescription();
        price = data.randomPrice();
        weight = data.randomWeight();
        inventory = data.randomInventory();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Admin adds a new product")
    @Description("Verify that after admin creates a product in admin panel, it appears on the storefront when user searches for it.")
    @Test
    public void E02_AdminAddProductUserSeeInStore() {
        catalogAdmin.clickMenuCatalog();
        productAdmin = catalogAdmin.openProduct();
        productAdmin.clickButtonCreateProduct();
        Assert.assertTrue(productAdmin.verifyTextCreateNewProduct());

        productAdmin.selectTypeProduct(" Simple ");
        productAdmin.selectFamilyProduct(" Default ");

        productAdmin.enterSKU(sku);
        productAdmin.clickButtonSaveProduct();
        Assert.assertTrue(productAdmin.verifyMessageSuccess());

        productAdmin.enterName(productName);

        productAdmin.selectColor(" Green ");
        productAdmin.selectSize(" XL ");
        productAdmin.selectBrand(" Nike ");

        productAdmin.switchToFrame01();
        productAdmin.enterShortDescription(shortDesc);
        driver.switchTo().defaultContent();

        productAdmin.switchToFrame02();
        productAdmin.enterDescription(longDesc);
        driver.switchTo().defaultContent();

        productAdmin.enterMetaTitle(metaTitle);
        productAdmin.enterMetaKeyword(metaKeyword);
        productAdmin.enterMetaDescription(metaDescription);

        productAdmin.uploadMultipleFilesLogo(driver, "ecomlogo.png");

        productAdmin.enterPrice(price);
        productAdmin.enterWeight(weight);

        productAdmin.activeSettingNew();
        productAdmin.activeFeatured();
        productAdmin.activeVisibleIndividually();
        productAdmin.activeStatus();
        productAdmin.activeGuestCheckout();

        productAdmin.enterDefaultInventory(inventory);

        productAdmin.SelectCategories("Active Wear");
        productAdmin.clickButtonSaveProductEdit();

        Assert.assertTrue(productAdmin.verifyTextSuccessCreatedProduct());

        homePage.openPageUrl(driver, urlUser);
        product = homePage.searchProduct(productName);
        Assert.assertTrue(product.verifyTextResultsHomepage(productName));

    }

    @Description("This test verifies that when the admin disables the 'Visible Individually' setting, "
            + "the product no longer appears in the user's search results.")
    @Story("Admin deactivates product visibility individually")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E03_AdminDeactivatesUserSearch() {
        homePage.openNewTabJs(driver);
        homePage.switchToWindowByTitle(driver, "about:blank");
        homePage.openPageUrl(driver, urlAdmin);
        catalogAdmin.clickMenuCatalog();
        productAdmin = catalogAdmin.openProduct();
        productAdmin.clickEditProduct(productName);
        productAdmin.activeVisibleIndividually();
        productAdmin.clickButtonSaveProductEdit();
        driver.close();
        productAdmin.switchToWindowByTitle(driver, "These are results for : " + productName);
        product = homePage.searchProduct(productName);
        Assert.assertTrue(product.verifyTextSearchNoProduct(productName));
    }
    @Story("Admin edits product price")
    @Description("Verify that after the admin updates the product price in the admin panel, "
            + "the user can see the updated price on the storefront search results.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void E04_AdminEditPriceUserCheckPrice(){
        homePage.openNewTabJs(driver);
        homePage.switchToWindowByTitle(driver, "about:blank");
        homePage.openPageUrl(driver, urlAdmin);
        catalogAdmin.clickMenuCatalog();
        productAdmin = catalogAdmin.openProduct();
        productAdmin.clickEditProduct(productName);
        productAdmin.enterPrice("230.0000");
        productAdmin.activeVisibleIndividually();
        productAdmin.clickButtonSaveProductEdit();
        driver.close();
        productAdmin.switchToWindowByTitle(driver, "These are results for : " + productName);
        product = homePage.searchProduct(productName);
        Assert.assertTrue(product.verifyPriceAfterEdit("230.00"));
    }
    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
