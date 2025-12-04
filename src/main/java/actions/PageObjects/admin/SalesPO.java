package actions.PageObjects.admin;

import PageUI.admin.SalesUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SalesPO extends BasePage {
    private WebDriver driver;

    public SalesPO(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click Sales menu")
    public OrderAdminPO clickMenuSales() {
        waitForElementClickable(driver, SalesUI.LINK_MENU_SALES);
        clickToElement(driver, SalesUI.LINK_MENU_SALES);
        return PageGeneratorAdmin.getOrdersAdmin(driver);
    }
    @Step("Search for Order ID: {numberID}")
    public void enterSearch(String numberID) {
        waitForElementVisible(driver, SalesUI.INPUT_SEARCH);
        sendKeyToElement(driver, SalesUI.INPUT_SEARCH, numberID);
        pressKeyToElement(driver, SalesUI.INPUT_SEARCH, Keys.ENTER);
    }
    @Step("Verify that Order ID '{numberID}' is displayed in Admin Orders list")
    public boolean verifyIdProductDisplayed(String numberID) {
        waitForElementVisible(driver, SalesUI.VERIFY_ID_PRODUCT,numberID);
        return isControlDisplayed(driver, SalesUI.VERIFY_ID_PRODUCT, numberID);
    }
}
