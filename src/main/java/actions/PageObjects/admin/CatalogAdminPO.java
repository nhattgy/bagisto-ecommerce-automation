package actions.PageObjects.admin;

import PageUI.admin.CatalogUI;
import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class CatalogAdminPO extends BasePage {
    private WebDriver driver;

    public CatalogAdminPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click menu 'Catalog'")
    public CategoryAdminPO clickMenuCatalog() {
        waitForElementClickable(driver, CatalogUI.LINK_CATALOG);
        clickToElement(driver, CatalogUI.LINK_CATALOG);
        return PageGeneratorAdmin.getCategoryAdmin(driver);
    }

    @Step("Open 'Category' page")
    public void openCategory() {
        waitForElementClickable(driver, CatalogUI.LINK_CATEGORY);
        clickToElement(driver, CatalogUI.LINK_CATEGORY);
    }

    @Step("Open 'Product' page")
    public ProductAdminPO openProduct() {
        waitForElementClickable(driver, CatalogUI.LINK_PRODUCT);
        clickToElement(driver, CatalogUI.LINK_PRODUCT);
        return PageGeneratorAdmin.getProductAdmin(driver);
    }
}
