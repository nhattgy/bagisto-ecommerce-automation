package admin.categoryAdmin;

import actions.PageObjects.admin.CatalogAdminPO;
import actions.PageObjects.admin.CategoryAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DataHelper;

@Epic("Admin Panel")
@Feature("Category Management")
public class CategoryAdminTest extends BaseTest {
    private CatalogAdminPO catalogAdmin;
    private CategoryAdminPO categoryAdmin;

    private String nameCategory, description, metaTitle, slug, position;

    @Parameters({"browser", "urlAdmin"})
    @BeforeClass
    @Step("Pre-condition: Login to Admin site and prepare test data")
    public void beforeClass(String browserName, String urlAdmin) {
        getBrowserDriver(browserName);
        LoginAdminBeforeTest(urlAdmin);
        WebDriver driver = DriverManager.getDriver();
        catalogAdmin = PageGeneratorAdmin.getCatalogAdmin(driver);
        DataHelper dataHelper = DataHelper.getDataHelper();

        nameCategory = dataHelper.randomCategoryName();
        description = dataHelper.randomDescription();
        metaTitle = dataHelper.randomMetaTitle();
        slug = dataHelper.randomSlug();
        position = dataHelper.randomNumber(1, 100);
    }


    @Story("Create new category in admin catalog")
    @Description("Verify that admin can create a new category with all valid details including name, description, meta title, slug, and position.")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void A04_AddNewCategory() {
        WebDriver driver = DriverManager.getDriver();
        categoryAdmin = catalogAdmin.clickMenuCatalog();
        catalogAdmin.openCategory();
        categoryAdmin.clickButtonCreateCategory();

        categoryAdmin.enterNameCategory(nameCategory);
        categoryAdmin.switchToIframeTextBox();
        categoryAdmin.enterDescription(description);
        driver.switchTo().defaultContent();

        // categoryAdmin.uploadMultipleFilesLogo(driver, "ecomlogo.png");
        categoryAdmin.enterMetaTitle(metaTitle);
        categoryAdmin.enterSlug(slug);
        categoryAdmin.enterPosition(position);

        categoryAdmin.selectDisplayMode(" Products Only ");
        categoryAdmin.selectAttribute("Brand");

        categoryAdmin.saveCategory();

        Assert.assertTrue(categoryAdmin.verifyMessengerSuccess(), "Success message was not displayed!");
    }

    @Story("Edit existing category information")
    @Description("Verify that an admin user can edit an existing category by updating the name and uploading a new logo image.")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void A05_EditCategoryDetails() {
        categoryAdmin.clickIconEdit(nameCategory, "icon-edit");
        categoryAdmin.enterNameCategoryEdit("Edit name");
        // categoryAdmin.uploadMultipleFilesLogo(driver, "ecombanner.png");
        categoryAdmin.saveCategory();
    }

    @Story("Delete existing category")
    @Description("Verify that an admin user can delete an existing category successfully and that a success message is displayed after deletion.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void A06_DeleteCategory() {
        categoryAdmin.clickDeleteIcon("Edit name", "icon-delete");
        categoryAdmin.clickButtonAgreeDelete();
        Assert.assertTrue(categoryAdmin.verifyMessengerDeleteSuccess());
    }

    @AfterClass(alwaysRun = true)
    @Step("Close browser after test execution")
    public void afterClass() {
        closeBrowserDriver();
    }
}
