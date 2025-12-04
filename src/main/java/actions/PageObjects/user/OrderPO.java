package actions.PageObjects.user;

import PageUI.user.OrderUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class OrderPO extends BasePage {
    private WebDriver driver;

    public OrderPO(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify Order Product displayed")
    public boolean verifyOrder() {
        waitForElementVisible(driver, OrderUI.VERIFY_PRODUCT_ORDER);
        return isControlDisplayed(driver, OrderUI.VERIFY_PRODUCT_ORDER);
    }
    @Step("Verify Order Page")
    public void viewOrderDetails() {
        waitForElementClickable(driver, OrderUI.VIEW_ORDERS_PAGE_DISPLAYED);
        clickToElement(driver, OrderUI.VIEW_ORDERS_PAGE_DISPLAYED);
    }
    @Step("Verify Detail Order")
    public boolean verifyOrderDetails(String nameProduct) {
        waitForElementVisible(driver, OrderUI.VERIFY_DETAIL_ORDER, nameProduct);
        return isControlDisplayed(driver, OrderUI.VERIFY_DETAIL_ORDER,nameProduct);
    }
    @Step("Verify that the order with ID: {numberID} displays the updated status")
    public boolean verifyOrderIDChangeStatus(String numberID) {
        waitForElementVisible(driver, OrderUI.VERIFY_ORDER_PROCESSING, numberID);
        return isControlDisplayed(driver, OrderUI.VERIFY_ORDER_PROCESSING,numberID);
    }
}
