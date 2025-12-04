package admin.productAdmin;

import actions.PageObjects.admin.CatalogAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.admin.ProductAdminPO;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;
@Epic("Admin Panel Management")
@Feature("Product Management")
public class ProductAdminTest extends BaseTest {
    private WebDriver driver;
    private ProductAdminPO productAdmin;
    private CatalogAdminPO catalogAdmin;

    private String sku, productName, shortDesc, longDesc, metaTitle, metaKeyword, metaDescription;
    private String price, weight, inventory;

    @Parameters({"browser","urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin){
        driver = getBrowserDriver(browserName);
        LoginAdminBeforeTest(urlAdmin);
        catalogAdmin = PageGeneratorAdmin.getCatalogAdmin(driver);

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
    @Story("Create a new product with full details")
    @Description("This testcase creates a new simple product in the Admin panel with all fields filled, uploads image, sets inventory, categories, and validates success messages.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void A07_A011_ProductAdminFullFollow() {
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
    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
