package actions.PageObjects.user;

import PageUI.user.CheckoutUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutPO extends BasePage {
    private WebDriver driver;

    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter company name: {companyName}")
    public void enterCompanyName(String companyName) {
        waitForElementVisible(driver, CheckoutUI.COMPANY_NAME);
        sendKeyToElement(driver, CheckoutUI.COMPANY_NAME, companyName);
    }

    @Step("Enter first name: {firstName}")
    public void enterFirstName(String firstName) {
        waitForElementVisible(driver, CheckoutUI.FIRST_NAME);
        sendKeyToElement(driver, CheckoutUI.FIRST_NAME, firstName);
    }

    @Step("Enter last name: {lastName}")
    public void enterLastName(String lastName) {
        waitForElementVisible(driver, CheckoutUI.LAST_NAME);
        sendKeyToElement(driver, CheckoutUI.LAST_NAME, lastName);
    }

    @Step("Enter email address: {emailAddress}")
    public void enterEmail(String emailAddress) {
        waitForElementVisible(driver, CheckoutUI.EMAIL_ADDRESS);
        sendKeyToElement(driver, CheckoutUI.EMAIL_ADDRESS, emailAddress);
    }

    @Step("Enter street address: {streetAddress}")
    public void enterStreetAddress(String streetAddress) {
        waitForElementVisible(driver, CheckoutUI.STREET_ADDRESS);
        sendKeyToElement(driver, CheckoutUI.STREET_ADDRESS, streetAddress);
    }

    @Step("Select country: {valueSelect}")
    public void selectCountry(String valueSelect) {
        waitForElementSelected(driver, CheckoutUI.SELECT_COUNTRY);
        selectItemInDropDown(driver, CheckoutUI.SELECT_COUNTRY, valueSelect);
    }

    @Step("Enter state: {state}")
    public void enterState(String state) {
        waitForElementVisible(driver, CheckoutUI.TEXTBOX_STATE);
        sendKeyToElement(driver, CheckoutUI.TEXTBOX_STATE, state);
    }

    @Step("Enter city: {city}")
    public void enterCity(String city) {
        waitForElementVisible(driver, CheckoutUI.TEXTBOX_CITY);
        sendKeyToElement(driver, CheckoutUI.TEXTBOX_CITY, city);
    }

    @Step("Enter zip code: {zipCode}")
    public void enterZipCode(String zipCode) {
        waitForElementVisible(driver, CheckoutUI.TEXTBOX_ZIP_CODE);
        sendKeyToElement(driver, CheckoutUI.TEXTBOX_ZIP_CODE, zipCode);
    }

    @Step("Enter telephone number: {telephone}")
    public void enterTelePhone(String telephone) {
        waitForElementVisible(driver, CheckoutUI.TEXTBOX_TELEPHONE);
        sendKeyToElement(driver, CheckoutUI.TEXTBOX_TELEPHONE, telephone);
    }

    @Step("Click Proceed button to continue to shipping")
    public void clickProceed() {
        waitForElementClickable(driver, CheckoutUI.BUTTON_PROCEED);
        clickToElement(driver, CheckoutUI.BUTTON_PROCEED);
    }

    @Step("Select free shipping method")
    public void selectTypeShipping() {
        waitForElementClickable(driver, CheckoutUI.TYPE_SHIPPING_FREE);
        clickToElement(driver, CheckoutUI.TYPE_SHIPPING_FREE);

    }

    @Step("Select Cash on Delivery payment method")
    public void selectPayMethod() {
        waitForElementClickable(driver, CheckoutUI.TYPE_CASH_ON_DELIVERY);
        clickToElement(driver, CheckoutUI.TYPE_CASH_ON_DELIVERY);
    }

    @Step("Click Place Order button")
    public void clickPlaceOrder() {
        waitForElementClickable(driver, CheckoutUI.BUTTON_PLACE_ORDER);
        clickToElement(driver, CheckoutUI.BUTTON_PLACE_ORDER);
    }

    @Step("Verify order placed successfully")
    public boolean verifyOrderSuccess() {
        waitForElementVisible(driver, CheckoutUI.VERIFY_TEXT_ORDER_SUCCESS);
        return isControlDisplayed(driver, CheckoutUI.VERIFY_TEXT_ORDER_SUCCESS);
    }

    @Step("Select address ship")
    public void clickAddressShip(String addressShip) {
        waitForElementClickable(driver, CheckoutUI.SELECT_ADDRESS_SHIP, addressShip);
        clickToElement(driver, CheckoutUI.SELECT_ADDRESS_SHIP, addressShip);
    }

    @Step("Select PayPal as payment method")
    public void selectPayMethodPaypal() {
        waitForElementClickable(driver, CheckoutUI.SELECT_PAYMENT_PAYPAL);
        clickToElement(driver, CheckoutUI.SELECT_PAYMENT_PAYPAL);
    }

    @Step("Enter PayPal email: {usernamePaypal}")
    public void enterEmailPayPal(String usernamePaypal) {
        waitForElementVisible(driver, CheckoutUI.TEXTBOX_EMAIL_PAYPAL);
        sendKeyToElement(driver, CheckoutUI.TEXTBOX_EMAIL_PAYPAL, usernamePaypal);
    }

    @Step("Enter PayPal password")
    public void enterPasswordPayPal(String passwordPaypal) {
        waitForElementVisible(driver, CheckoutUI.TEXTBOX_PASSWORD_PAYPAL);
        sendKeyToElement(driver, CheckoutUI.TEXTBOX_PASSWORD_PAYPAL, passwordPaypal);
    }

    @Step("Click 'Log In' button on PayPal")
    public void clickButtonLogin() {
        waitForElementClickable(driver, CheckoutUI.BUTTON_LOGIN_PAYPAL);
        clickToElement(driver, CheckoutUI.BUTTON_LOGIN_PAYPAL);
    }

    @Step("Select bank: Credit Union")
    public void selectCreditUnion() {
        waitForElementClickable(driver, CheckoutUI.SELECT_CREDIT_UNION);
        clickToElement(driver, CheckoutUI.SELECT_CREDIT_UNION);
    }

    @Step("Click 'Complete Purchase' button on PayPal")
    public void clickButtonPurchase() {
        waitForElementClickable(driver, CheckoutUI.BUTTON_COMPLETE_PURCHASE);
        clickToElement(driver, CheckoutUI.BUTTON_COMPLETE_PURCHASE);
    }

    @Step("Verify PayPal order completion message is displayed")
    public boolean verifyOrderPaypal() {
        waitForElementVisible(driver, CheckoutUI.VERIFY_ORDER_COMPLETE_PAYPAL);
        return isControlDisplayed(driver, CheckoutUI.VERIFY_ORDER_COMPLETE_PAYPAL);
    }
}
