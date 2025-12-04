package actions.PageObjects.admin;

import PageUI.admin.AuthenticationUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AuthenticationAdminPO extends BasePage {
    private WebDriver driver;

    public AuthenticationAdminPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter admin email address: {emailAddress}")
    public DashboardAdminPO enterEmailAddress(String emailAddress) {
        waitForElementVisible(driver, AuthenticationUI.EMAIL_ADDRESS_ADMIN);
        sendKeyToElement(driver, AuthenticationUI.EMAIL_ADDRESS_ADMIN, emailAddress);
        return PageGeneratorAdmin.getDashboardAdmin(driver);
    }

    @Step("Enter admin password: {password}")
    public void enterPassword(String password) {
        waitForElementVisible(driver, AuthenticationUI.PASSWORD_ADMIN);
        sendKeyToElement(driver, AuthenticationUI.PASSWORD_ADMIN, password);
    }

    @Step("Click the Sign In button")
    public void clickSignIn() {
        waitForElementClickable(driver, AuthenticationUI.BUTTON_SIGN_IN);
        clickToElement(driver, AuthenticationUI.BUTTON_SIGN_IN);
    }

    @Step("Verify that Dashboard menu is displayed")
    public boolean menuDashboardIsDisplayed() {
        waitForElementVisible(driver, AuthenticationUI.MENU_NAV_BAR_DASHBOARD);
        return isControlDisplayed(driver, AuthenticationUI.MENU_NAV_BAR_DASHBOARD);
    }

    @Step("Verify that the current URL contains '/admin/login'")
    public String verifyUrlLoginAdmin() {
        waitForUrlContains(driver, "https://demo.bagisto.com/bagisto-common/admin/login");
        return getCurrentURL(driver);
    }

    @Step("Verify that the error message is displayed after invalid login attempt")
    public boolean verifyErrorMessenger() {
        waitForElementVisible(driver, AuthenticationUI.VERIFY_ERROR_MESSENGER);
        return isControlDisplayed(driver, AuthenticationUI.VERIFY_ERROR_MESSENGER);
    }
}
