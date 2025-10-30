package actions.PageObjects.user;

import PageUI.user.LoginPageUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPagePO extends BasePage {
    private WebDriver driver;
    public LoginPagePO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Enter email address: {email}")
    public void enterEmail(String email) {
        waitForElementVisible(driver, LoginPageUI.TEXTBOX_EMAIL);
        sendKeyToElement(driver, LoginPageUI.TEXTBOX_EMAIL, email);
    }

    @Step("Enter password: ********")
    public void enterPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.TEXTBOX_PASSWORD);
        sendKeyToElement(driver, LoginPageUI.TEXTBOX_PASSWORD, password);
    }

    @Step("Click the 'Sign In' button")
    public void clickSignIn() {
        waitForElementClickable(driver, LoginPageUI.BUTTON_SIGN_IN);
        clickToElement(driver, LoginPageUI.BUTTON_SIGN_IN);
    }
    @Step("Verify error messenger after login invalid data")
    public boolean verifyErrorMessengerDisplayed() {
        waitForElementVisible(driver, LoginPageUI.VERIFY_ERROR_MESSENGER_LOGIN_INVALID);
        return isControlDisplayed(driver, LoginPageUI.VERIFY_ERROR_MESSENGER_LOGIN_INVALID);
    }
}
