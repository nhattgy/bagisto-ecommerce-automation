package actions.PageObjects.admin;

import PageUI.admin.CouponCodeUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CouponCodePO extends BasePage {
    private WebDriver driver;

    public CouponCodePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Cart Rules page")
    public void openCartRules() {
        waitForElementClickable(driver, CouponCodeUI.LINK_CART_RULE);
        clickToElement(driver, CouponCodeUI.LINK_CART_RULE);
    }

    @Step("Click Create Cart Rule button")
    public void clickCreateCartRule() {
        waitForElementClickable(driver, CouponCodeUI.BUTTON_CREATE_CART_RULE);
        clickToElement(driver, CouponCodeUI.BUTTON_CREATE_CART_RULE);
    }

    @Step("Enter coupon name: {nameCoupon}")
    public void enterName(String nameCoupon) {
        waitForElementVisible(driver, CouponCodeUI.INPUT_NAME);
        sendKeyToElement(driver, CouponCodeUI.INPUT_NAME, nameCoupon);
    }

    @Step("Select coupon type: {couponType}")
    public void selectCouponType(String couponType) {
        waitForElementVisible(driver, CouponCodeUI.SELECT_COUPON_TYPE);
        selectItemInDropDown(driver, CouponCodeUI.SELECT_COUPON_TYPE, couponType);
    }

    @Step("Select Auto Generate Code: {codeAutoGen}")
    public void selectAutoGenCode(String codeAutoGen) {
        waitForElementVisible(driver, CouponCodeUI.INPUT_GEN_COUPON_CODE);
        selectItemInDropDown(driver, CouponCodeUI.INPUT_GEN_COUPON_CODE, codeAutoGen);
    }

    @Step("Enter discount amount: {discount}")
    public void enterDiscountAmount(String discount) {
        waitForElementVisible(driver, CouponCodeUI.INPUT_DISCOUNT);
        sendKeyToElement(driver, CouponCodeUI.INPUT_DISCOUNT, discount);
    }

    @Step("Select Channel checkbox")
    public void clickChannel() {
        scrollToElementOnDownByJS(driver, CouponCodeUI.CHECKBOX_CHANEL);
        waitForElementClickable(driver, CouponCodeUI.CHECKBOX_CHANEL);
        clickToElementByJS(driver, CouponCodeUI.CHECKBOX_CHANEL);
    }

    @Step("Select Customer Groups checkbox")
    public void clickCustomerGroups() {
        waitForElementClickable(driver, CouponCodeUI.CHECKBOX_CUSTOMER_GROUP);
        clickToElementByJS(driver, CouponCodeUI.CHECKBOX_CUSTOMER_GROUP);
    }

    @Step("Toggle Active Status")
    public void clickActiveStatus() {
        waitForElementClickable(driver, CouponCodeUI.LABEL_STATUS);
        clickToElementByJS(driver, CouponCodeUI.LABEL_STATUS);
    }

    @Step("Enter Start Date: {startDate}")
    public void enterFromMarketingTimeStart(String startDate) {
        waitForElementVisible(driver, CouponCodeUI.START_FORM_DATE);
        sendKeyToElement(driver, CouponCodeUI.START_FORM_DATE, startDate);
    }

    @Step("Enter End Date: {endDate}")
    public void enterFromMarketingTimeEnd(String endDate) {
        waitForElementVisible(driver, CouponCodeUI.END_FORM_DATE);
        sendKeyToElement(driver, CouponCodeUI.END_FORM_DATE, endDate);
    }

    @Step("Click Save Cart Rule button")
    public void clickSaveCartRule() {
        waitForElementClickable(driver, CouponCodeUI.BUTTON_SAVE_CART_RULE);
        clickToElement(driver, CouponCodeUI.BUTTON_SAVE_CART_RULE);
    }

    @Step("Verify coupon added successfully")
    public boolean verifyTextCouponAddSuccess() {
        waitForElementVisible(driver, CouponCodeUI.VERIFY_TEXT_ADDED_COUPON);
        return isControlDisplayed(driver, CouponCodeUI.VERIFY_TEXT_ADDED_COUPON);
    }

    @Step("Click Edit icon for coupon: {nameCoupon}")
    public void editCoupon(String nameCoupon) {
        waitForElementClickable(driver, CouponCodeUI.ICON_EDIT_COUPON, nameCoupon);
        clickToElement(driver, CouponCodeUI.ICON_EDIT_COUPON, nameCoupon);
    }

    @Step("Verify coupon edited successfully")
    public boolean verifyTextEditCoupon() {
        waitForElementVisible(driver, CouponCodeUI.VERIFY_TEXT_EDIT_COUPON);
        return isControlDisplayed(driver, CouponCodeUI.VERIFY_TEXT_EDIT_COUPON);
    }

    @Step("Click Delete icon for coupon: {nameCouponDelete}")
    public void deleteCoupon(String nameCouponDelete) {
        waitForElementClickable(driver, CouponCodeUI.ICON_DELETE_COUPON, nameCouponDelete);
        clickToElement(driver, CouponCodeUI.ICON_DELETE_COUPON, nameCouponDelete);
    }

    @Step("Confirm delete coupon")
    public void clickButtonAgreeDelete() {
        waitForElementClickable(driver, CouponCodeUI.BUTTON_AGREE);
        clickToElement(driver, CouponCodeUI.BUTTON_AGREE);
    }

    @Step("Verify coupon deleted successfully")
    public boolean verifyTextDeleteCoupon() {
        waitForElementVisible(driver, CouponCodeUI.VERIFY_TEXT_DELETE);
        return isControlDisplayed(driver, CouponCodeUI.VERIFY_TEXT_DELETE);
    }
}
