package actions.PageObjects.admin;

import PageUI.admin.AccountUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AccountAdminPO extends BasePage {
    private WebDriver driver;

    public AccountAdminPO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open Settings menu")
    public void openSetting() {
        waitForElementClickable(driver, AccountUI.LINK_SETTING);
        clickToElement(driver, AccountUI.LINK_SETTING);
    }

    @Step("Click Users link in Setting")
    public void clickLinkUsers() {
        waitForElementClickable(driver, AccountUI.LINK_USER);
        clickToElement(driver, AccountUI.LINK_USER);
    }

    @Step("Click button Create User")
    public void clickCreateUser() {
        waitForElementClickable(driver, AccountUI.BUTTON_CREATE_USER);
        clickToElement(driver, AccountUI.BUTTON_CREATE_USER);
    }

    @Step("Enter user name: {name}")
    public void enterName(String name) {
        waitForElementVisible(driver, AccountUI.INPUT_NAME);
        sendKeyToElement(driver, AccountUI.INPUT_NAME, name);
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email) {
        waitForElementVisible(driver, AccountUI.INPUT_EMAIL);
        sendKeyToElement(driver, AccountUI.INPUT_EMAIL, email);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        waitForElementVisible(driver, AccountUI.INPUT_PASSWORD);
        sendKeyToElement(driver, AccountUI.INPUT_PASSWORD, password);
    }

    @Step("Enter confirm password")
    public void enterConfirmPassword(String password) {
        waitForElementVisible(driver, AccountUI.INPUT_CONFIRM_PASSWORD);
        sendKeyToElement(driver, AccountUI.INPUT_CONFIRM_PASSWORD, password);
    }

    @Step("Select role: {administrator}")
    public void selectRole(String administrator) {
        waitForElementClickable(driver, AccountUI.SELECT_ROLE);
        selectItemInDropDown(driver, AccountUI.SELECT_ROLE, administrator);
    }

    @Step("Toggle account status switch")
    public void clickStatus() {
        waitForElementClickable(driver, AccountUI.SWITCH_BUTTON_STATUS);
        clickToElement(driver, AccountUI.SWITCH_BUTTON_STATUS);
    }

    @Step("Click Save User button")
    public void clickSaveUser() {
        waitForElementClickable(driver, AccountUI.BUTTON_SAVE_USER);
        clickToElement(driver, AccountUI.BUTTON_SAVE_USER);
    }

    @Step("Verify created account is displayed")
    public boolean verifyCreatedAccount() {
        waitForElementVisible(driver, AccountUI.VERIFY_ACCOUNT_CREATED);
        return isControlDisplayed(driver, AccountUI.VERIFY_ACCOUNT_CREATED);
    }

    @Step("Click Admin icon on header")
    public void clickIconAdmin() {
        waitForElementClickable(driver, AccountUI.ICON_ADMIN);
        clickToElementByJS(driver, AccountUI.ICON_ADMIN);
    }

    @Step("Click Logout and navigate to Authentication page")
    public AuthenticationAdminPO clickLogout() {
        waitForElementClickable(driver, AccountUI.LINK_LOGOUT);
        clickToElementByJS(driver, AccountUI.LINK_LOGOUT);
        return PageGeneratorAdmin.getAuthenticationAdmin(driver);
    }
    @Step("Admin click edit icon")
    public void editAccountAdmin(String editAccount) {
        waitForElementClickable(driver, AccountUI.LINK_EDIT,editAccount);
        clickToElement(driver, AccountUI.LINK_EDIT,editAccount);
    }
    @Step("Verify when enter confirm password miss match")
    public boolean verifyAccountMissMatch() {
        waitForElementVisible(driver, AccountUI.VERIFY_ACCOUNT_MISS_MATCH);
        return isControlDisplayed(driver, AccountUI.VERIFY_ACCOUNT_MISS_MATCH);
    }
}
