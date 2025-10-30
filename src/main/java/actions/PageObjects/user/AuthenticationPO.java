package actions.PageObjects.user;

import PageUI.user.AuthenticationUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AuthenticationPO extends BasePage {
    WebDriver driver;

    public AuthenticationPO(WebDriver driver) {
        this.driver = driver;
    }



    @Step("Click 'Sign Up' link")
    public void clickLinkSignUp() {
        waitForElementClickable(driver, AuthenticationUI.LINK_SIGNUP);
        clickToElement(driver, AuthenticationUI.LINK_SIGNUP);
    }

    @Step("Enter first name: {0}")
    public void enterFirstName(String firstname) {
        waitForElementVisible(driver, AuthenticationUI.TEXTBOX_FIRST_NAME);
        sendKeyToElement(driver, AuthenticationUI.TEXTBOX_FIRST_NAME, firstname);
    }

    @Step("Enter last name: {0}")
    public void enterLastName(String lastname) {
        waitForElementVisible(driver, AuthenticationUI.TEXTBOX_LAST_NAME);
        sendKeyToElement(driver, AuthenticationUI.TEXTBOX_LAST_NAME, lastname);
    }

    @Step("Enter email: {0}")
    public void enterEmail(String email) {
        waitForElementVisible(driver, AuthenticationUI.TEXTBOX_EMAIL);
        sendKeyToElement(driver, AuthenticationUI.TEXTBOX_EMAIL, email);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        waitForElementVisible(driver, AuthenticationUI.TEXTBOX_PASSWORD);
        sendKeyToElement(driver, AuthenticationUI.TEXTBOX_PASSWORD, password);
    }

    @Step("Enter confirm password: {0}")
    public void enterConfirmPassword(String confirmPassword) {
        waitForElementVisible(driver, AuthenticationUI.TEXTBOX_CONFIRM_PASSWORD);
        sendKeyToElement(driver, AuthenticationUI.TEXTBOX_CONFIRM_PASSWORD, confirmPassword);
    }

    @Step("Click checkbox 'Subscribe to newsletter'")
    public void clickSubscribe() {
        waitForElementClickable(driver, AuthenticationUI.CHECKBOX_SUBSCRIBE);
        clickToElement(driver, AuthenticationUI.CHECKBOX_SUBSCRIBE);
    }

    @Step("Click checkbox 'I agree to terms'")
    public void clickAgree() {
        waitForElementClickable(driver, AuthenticationUI.CHECKBOX_I_AGREE);
        clickToElement(driver, AuthenticationUI.CHECKBOX_I_AGREE);
    }

    @Step("Click button 'Register'")
    public void clickButtonRegister() {
        waitForElementClickable(driver, AuthenticationUI.BUTTON_REGISTER);
        clickToElement(driver, AuthenticationUI.BUTTON_REGISTER);
    }

    @Step("Verify success message 'Account created successfully.' is displayed")
    public boolean verifyMessengerRegisterSuccsessIsDisplayed() {
        waitForElementVisible(driver, AuthenticationUI.SUCCSESS_MESSENGER);
        return isControlDisplayed(driver, AuthenticationUI.SUCCSESS_MESSENGER);
    }
}
