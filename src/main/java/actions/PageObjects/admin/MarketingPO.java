package actions.PageObjects.admin;

import PageUI.admin.MarketingUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MarketingPO extends BasePage {
    private WebDriver driver;

    public MarketingPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Marketing section")
    public CouponCodePO clickLinkMarketing() {
        waitForElementClickable(driver, MarketingUI.LINK_MARKETING);
        clickToElement(driver, MarketingUI.LINK_MARKETING);
        return PageGeneratorAdmin.getCouponCodeAdmin(driver);
    }

    @Step("Navigate to Cart Rules")
    public void clickCartRules() {
        waitForElementClickable(driver, MarketingUI.LINK_CART_RULES);
        clickToElement(driver, MarketingUI.LINK_CART_RULES);
    }

    @Step("Open Create Cart Rule screen")
    public void clickCreateCartRule() {
        waitForElementClickable(driver, MarketingUI.LINK_CREATE_CART_RULE);
        clickToElement(driver, MarketingUI.LINK_CREATE_CART_RULE);
    }

    @Step("Enter coupon name: {nameCoupon}")
    public void enterNameCoupon(String nameCoupon) {
        waitForElementVisible(driver, MarketingUI.INPUT_NAME_CART_RULE);
        sendKeyToElement(driver, MarketingUI.INPUT_NAME_CART_RULE, nameCoupon);
    }

    @Step("Select coupon type: {typeCoupon}")
    public void selectCouponType(String typeCoupon) {
        waitForElementClickable(driver, MarketingUI.SELECT_COUPON_TYPE);
        selectItemInDropDown(driver, MarketingUI.SELECT_COUPON_TYPE, typeCoupon);
    }

    @Step("Enter coupon code: {codeCoupon}")
    public void enterCouponCode(String codeCoupon) {
        waitForElementVisible(driver, MarketingUI.INPUT_COUPON_CODE);
        sendKeyToElement(driver, MarketingUI.INPUT_COUPON_CODE, codeCoupon);
    }

    @Step("Enter usage per coupon: {number}")
    public void enterUserPerCode(String number) {
        waitForElementVisible(driver, MarketingUI.INPUT_USER_PER_COUPON);
        sendKeyToElement(driver, MarketingUI.INPUT_USER_PER_COUPON, number);
    }

    @Step("Enter usage per customer: {number}")
    public void enterUserPerCustomer(String number) {
        waitForElementVisible(driver, MarketingUI.INPUT_USER_PER_CUSTOMER);
        sendKeyToElement(driver, MarketingUI.INPUT_USER_PER_CUSTOMER, number);
    }

    @Step("Enter discount amount: {number}")
    public void enterDiscountAmount(String number) {
        waitForElementVisible(driver, MarketingUI.INPUT_DISCOUNT_AMOUNT);
        sendKeyToElement(driver, MarketingUI.INPUT_DISCOUNT_AMOUNT, number);
    }

    @Step("Enter maximum quantity: {number}")
    public void enterMaximumQuantity(String number) {
        waitForElementVisible(driver, MarketingUI.INPUT_MAXIMUM_QUANTITY);
        sendKeyToElement(driver, MarketingUI.INPUT_MAXIMUM_QUANTITY, number);
    }

    @Step("Select channels")
    public void clickChannels() {
        waitForElementClickable(driver, MarketingUI.LABEL_CHANNELS);
        clickToElementByJS(driver, MarketingUI.LABEL_CHANNELS);
    }

    @Step("Select Customer Group: Guest")
    public void clickCustomerGroupGuest() {
        waitForElementClickable(driver, MarketingUI.CUSTOMER_GROUP_GUEST);
        clickToElementByJS(driver, MarketingUI.CUSTOMER_GROUP_GUEST);
    }

    @Step("Select Customer Group: General")
    public void clickCustomerGroupGeneral() {
        waitForElementClickable(driver, MarketingUI.CUSTOMER_GROUP_GENERAL);
        clickToElementByJS(driver, MarketingUI.CUSTOMER_GROUP_GENERAL);
    }

    @Step("Select Customer Group: Wholesale")
    public void clickCustomerGroupWholesale() {
        waitForElementClickable(driver, MarketingUI.CUSTOMER_GROUP_WHOLESALE);
        clickToElementByJS(driver, MarketingUI.CUSTOMER_GROUP_WHOLESALE);
    }

    @Step("Enable coupon status")
    public void clickStatus() {
        waitForElementClickable(driver, MarketingUI.BUTTON_STATUS);
        clickToElementByJS(driver, MarketingUI.BUTTON_STATUS);
    }

    @Step("Enter start date: {startDate}")
    public void enterStartDate(String startDate) {
        waitForElementVisible(driver, MarketingUI.START_DATE);
        sendKeyToElement(driver, MarketingUI.START_DATE, startDate);
    }

    @Step("Enter end date: {endDate}")
    public void enterEndDate(String endDate) {
        waitForElementVisible(driver, MarketingUI.END_DATE);
        sendKeyToElement(driver, MarketingUI.END_DATE, endDate);
    }

    @Step("Click Save Cart Rule")
    public void saveCartRule() {
        waitForElementClickable(driver, MarketingUI.BUTTON_SAVE_CART_RULE);
        clickToElementByJS(driver, MarketingUI.BUTTON_SAVE_CART_RULE);
    }

    @Step("Verify coupon is created successfully")
    public boolean verifyCouponCreated() {
        waitForElementVisible(driver, MarketingUI.VERIFY_CREATED_CART_RULE);
        return isControlDisplayed(driver, MarketingUI.VERIFY_CREATED_CART_RULE);
    }
    @Step("Click edit coupon code")
    public void clickEditCoupon(String codeCoupon) {
        waitForElementClickable(driver, MarketingUI.ICON_EDIT_COUPON,codeCoupon);
        clickToElementByJS(driver, MarketingUI.ICON_EDIT_COUPON,codeCoupon);
    }
}
