package actions.PageObjects.admin;

import PageUI.admin.CustomerUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CustomerAdminPO extends BasePage {
    private WebDriver driver;

    public CustomerAdminPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click link Customer")
    public void clickLinkCustomer() {
        waitForElementClickable(driver, CustomerUI.LINK_CUSTOMER);
        clickToElement(driver, CustomerUI.LINK_CUSTOMER);
    }

    @Step("Click button Create Customer")
    public void clickCreateCustomer() {
        waitForElementClickable(driver, CustomerUI.BUTTON_CREATE_CUSTOMER);
        clickToElement(driver, CustomerUI.BUTTON_CREATE_CUSTOMER);
    }

    @Step("Enter First Name: {firstName}")
    public void enterFirstName(String firstName) {
        waitForElementVisible(driver, CustomerUI.INPUT_FIRST_NAME);
        sendKeyToElement(driver, CustomerUI.INPUT_FIRST_NAME, firstName);
    }

    @Step("Enter Last Name: {lastname}")
    public void enterLastName(String lastname) {
        waitForElementVisible(driver, CustomerUI.INPUT_LAST_NAME);
        sendKeyToElement(driver, CustomerUI.INPUT_LAST_NAME, lastname);
    }

    @Step("Enter Email Address: {email}")
    public void enterEmailAddress(String email) {
        waitForElementVisible(driver, CustomerUI.INPUT_EMAIL_ADDRESS);
        sendKeyToElement(driver, CustomerUI.INPUT_EMAIL_ADDRESS, email);
    }

    @Step("Enter Date of Birth: {date}")
    public void enterDateOfBirth(String date) {
        waitForElementVisible(driver, CustomerUI.INPUT_DATE_OF_BIRTH);
        sendKeyToElement(driver, CustomerUI.INPUT_DATE_OF_BIRTH, date);
    }

    @Step("Select Gender: {gender}")
    public void selectGender(String gender) {
        waitForElementClickable(driver, CustomerUI.SELECT_GENDER);
        selectItemInDropDown(driver, CustomerUI.SELECT_GENDER, gender);
    }

    @Step("Click Save Customer")
    public void clickSaveCustomer() {
        waitForElementClickable(driver, CustomerUI.BUTTON_SAVE_CREATE_CUSTOMER);
        clickToElement(driver, CustomerUI.BUTTON_SAVE_CREATE_CUSTOMER);
    }

    @Step("Verify customer is created successfully")
    public boolean verifyCustomerCreated() {
        waitForElementVisible(driver, CustomerUI.MESSAGE_CREATED_CUSTOMER);
        return isControlDisplayed(driver, CustomerUI.MESSAGE_CREATED_CUSTOMER);
    }

    @Step("Verify customer account with name: {nameAccount} is displayed in the list")
    public boolean verifyAccountIsDisplayed(String nameAccount) {
        waitForElementVisible(driver, CustomerUI.VERIFY_ACCOUNT_IS_DISPLAYED, nameAccount);
        return isControlDisplayed(driver, CustomerUI.VERIFY_ACCOUNT_IS_DISPLAYED, nameAccount);
    }

    @Step("Click Detail Icon for the customer: {iconDetail}")
    public void clickIconDetailCustomer(String iconDetail) {
        waitForElementClickable(driver, CustomerUI.ICON_DETAIL_CUSTOMER, iconDetail);
        clickToElement(driver, CustomerUI.ICON_DETAIL_CUSTOMER, iconDetail);
    }

    @Step("Click Edit Customer")
    public void clickLinkEditCustomer() {
        waitForElementClickable(driver, CustomerUI.LINK_EDIT_TEXT);
        clickToElement(driver, CustomerUI.LINK_EDIT_TEXT);
    }

    @Step("Verify customer edited successfully")
    public boolean verifyCustomerEditSuccessfully() {
        waitForElementVisible(driver, CustomerUI.VERIFY_EDIT_CUSTOMER);
        return isControlDisplayed(driver, CustomerUI.VERIFY_EDIT_CUSTOMER);
    }

    @Step("Click Delete Account button")
    public void clickDeleteAccount() {
        waitForElementClickable(driver, CustomerUI.BUTTON_DELETE_ACCOUNT);
        clickToElement(driver, CustomerUI.BUTTON_DELETE_ACCOUNT);
    }

    @Step("Confirm delete customer (Click Accept Delete)")
    public void clickAcceptDelete() {
        waitForElementClickable(driver, CustomerUI.BUTTON_AGREE);
        clickToElement(driver, CustomerUI.BUTTON_AGREE);
    }

    @Step("Verify customer is deleted successfully")
    public boolean verifyCustomerDeleteSuccessfully() {
        waitForElementVisible(driver, CustomerUI.VERIFY_TEXT_DELETE_ACCOUNT);
        return isControlDisplayed(driver, CustomerUI.VERIFY_TEXT_DELETE_ACCOUNT);
    }

    @Step("Enter search customer email")
    public void enterSearchCustomer(String emailAddress) {
        waitForElementVisible(driver, CustomerUI.INPUT_SEARCH_CUSTOMER);
        sendKeyToElement(driver, CustomerUI.INPUT_SEARCH_CUSTOMER, emailAddress);
        pressKeyToElement(driver, CustomerUI.INPUT_SEARCH_CUSTOMER, Keys.ENTER);
    }

    @Step("Verify customer email is displayed in result")
    public boolean verifyEmailAddressIsDisplay(String emailAddress) {
        waitForElementVisible(driver, CustomerUI.RESULT_SEARCH_CUSTOMER, emailAddress);
        return isControlDisplayed(driver, CustomerUI.RESULT_SEARCH_CUSTOMER, emailAddress);
    }

    @Step("Click Review link")
    public void clickLinkReview() {
        waitForElementClickable(driver, CustomerUI.LINK_REVIEW);
        clickToElement(driver, CustomerUI.LINK_REVIEW);
    }

    @Step("Click Edit Review button")
    public void clickEditReview(String title) {
        waitForElementClickable(driver, CustomerUI.BUTTON_EDIT_REVIEW, title);
        clickToElement(driver, CustomerUI.BUTTON_EDIT_REVIEW, title);
    }

    @Step("Select review status")
    public void selectStatus(String status) {
        waitForElementClickable(driver, CustomerUI.DROPDOWN_STATUS);
        selectItemInDropDown(driver, CustomerUI.DROPDOWN_STATUS, status);
    }

    @Step("Click Save Review button")
    public void clickSaveReview() {
        waitForElementClickable(driver, CustomerUI.BUTTON_SAVE);
        clickToElement(driver, CustomerUI.BUTTON_SAVE);
    }

    @Step("Verify review status updated successfully")
    public boolean verifySaveStatusReviewSuccess() {
        waitForElementVisible(driver, CustomerUI.VERIFY_REVIEW_UPDATE);
        return isControlDisplayed(driver, CustomerUI.VERIFY_REVIEW_UPDATE);
    }

}
