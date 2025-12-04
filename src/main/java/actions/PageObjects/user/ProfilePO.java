package actions.PageObjects.user;

import PageUI.user.ProfileUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ProfilePO extends BasePage {
    private WebDriver driver;

    public ProfilePO(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click 'Edit Profile' button")
    public void clickButtonEditUser() {
        waitForElementClickable(driver, ProfileUI.BUTTON_EDIT_USER);
        clickToElement(driver, ProfileUI.BUTTON_EDIT_USER);
    }

    @Step("Verify avatar image is uploaded successfully")
    public boolean verifyImageUploaded() {
        waitForElementPresence(driver, ProfileUI.VERIFY_IMAGE_UPLOAD);
        return isControlDisplayed(driver, ProfileUI.VERIFY_IMAGE_UPLOAD);
    }

    @Step("Edit phone number with value: {0}")
    public void editPhoneNumber(String numberPhone) {
        waitForElementVisible(driver, ProfileUI.INPUT_PHONE_NUMBER);
        sendKeyToElement(driver, ProfileUI.INPUT_PHONE_NUMBER, numberPhone);
    }

    @Step("Edit birthday with value: {0}")
    public void editBirthDay(String birthDay) {
        waitForElementVisible(driver, ProfileUI.DATE_INPUT_BIRTHDAY);
        sendKeyToElement(driver, ProfileUI.DATE_INPUT_BIRTHDAY, birthDay);
    }

    @Step("Click 'Save' button to update profile information")
    public void clickSaveButton() {
        waitForElementClickable(driver, ProfileUI.BUTTON_SAVE);
        clickToElement(driver, ProfileUI.BUTTON_SAVE);
    }

    @Step("Verify avatar image is displayed after saving changes")
    public boolean verifyImageAfterSaveButton() {
        waitForElementPresence(driver, ProfileUI.VERIFY_IMAGE_AFTER_CLICK_BUTTON_SAVE);
        return isControlDisplayed(driver, ProfileUI.VERIFY_IMAGE_AFTER_CLICK_BUTTON_SAVE);
    }

    @Step("Enter current password: {currentPassword}")
    public void enterCurrentPassword(String currentPassword) {
        waitForElementVisible(driver, ProfileUI.INPUT_CURRENT_PASSWORD);
        sendKeyToElement(driver, ProfileUI.INPUT_CURRENT_PASSWORD, currentPassword);
    }

    @Step("Enter new password: {newPassword}")
    public void enterNewPassword(String newPassword) {
        waitForElementVisible(driver, ProfileUI.INPUT_NEW_PASSWORD);
        sendKeyToElement(driver, ProfileUI.INPUT_NEW_PASSWORD, newPassword);
    }

    @Step("Enter confirm password: {confirmPassword}")
    public void enterConfirmPassword(String confirmPassword) {
        waitForElementVisible(driver, ProfileUI.INPUT_CONFIRM_PASSWORD);
        sendKeyToElement(driver, ProfileUI.INPUT_CONFIRM_PASSWORD, confirmPassword);
    }
    @Step("Verify edit success")
    public boolean verifyUpdateSuccess() {
        waitForElementVisible(driver, ProfileUI.VERIFY_UPDATE_PASSWORD_SUCCESS);
        return isControlDisplayed(driver, ProfileUI.VERIFY_UPDATE_PASSWORD_SUCCESS);
    }
}
