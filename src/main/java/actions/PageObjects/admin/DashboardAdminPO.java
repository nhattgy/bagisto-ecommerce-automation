package actions.PageObjects.admin;

import PageUI.admin.DashboardUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DashboardAdminPO extends BasePage {
    private WebDriver driver;
    public DashboardAdminPO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click on the Profile button in the top navigation bar")
    public void clickButtonProfile() {
        waitForElementClickable(driver, DashboardUI.BUTTON_PROFILE);
        clickToElement(driver, DashboardUI.BUTTON_PROFILE);
    }

    @Step("Click on the Logout link to sign out from the Admin Panel")
    public void clickLogout() {
        waitForElementClickable(driver, DashboardUI.LINK_LOGOUT);
        clickToElement(driver, DashboardUI.LINK_LOGOUT);
    }
    @Step("Admin opens the notification panel")
    public void openIconNotification() {
        waitForElementClickable(driver, DashboardUI.ICON_NOTIFICATION);
        clickToElement(driver, DashboardUI.ICON_NOTIFICATION);
    }
    @Step("Verify the order notification with ID: {idNotification} is displayed")
    public boolean verifyIdProductIsDisplayed(String idNotification) {
        waitForElementVisible(driver, DashboardUI.VERIFY_ID_PRODUCT_NOTIFICATION, idNotification);
        return isControlDisplayed(driver, DashboardUI.VERIFY_ID_PRODUCT_NOTIFICATION, idNotification);
    }
    @Step("Admin opens order details for Order ID: {idProduct}")
    public void clickOrder(String idProduct) {
        waitForElementClickable(driver, DashboardUI.ID_PRODUCT_ORDER, idProduct);
        clickToElement(driver, DashboardUI.ID_PRODUCT_ORDER,idProduct);
    }
}
