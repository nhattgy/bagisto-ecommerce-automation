package actions.PageObjects.user;

import PageUI.user.CartUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CartPO extends BasePage {
    private WebDriver driver;

    public CartPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Increase product quantity in cart")
    public void increaseQuantity() {
        waitForElementClickable(driver, CartUI.SELECT_INCREASE_PRODUCT);
        clickToElement(driver, CartUI.SELECT_INCREASE_PRODUCT);
    }

    @Step("Click 'Update Cart' button")
    public void updateCart() {
        waitForElementClickable(driver, CartUI.BUTTON_UPDATE_CART);
        clickToElement(driver, CartUI.BUTTON_UPDATE_CART);
    }

    @Step("Get updated price of the product in cart")
    public String priceUpdate(String priceUpdate) {
        waitForElementVisible(driver, CartUI.PRICE_AFTER_UPDATE, priceUpdate);
        return getTextElement(driver, CartUI.PRICE_AFTER_UPDATE, priceUpdate);
    }

    @Step("Remove a product from the cart")
    public void removeProduct() {
        waitForElementClickable(driver, CartUI.LINK_REMOVE_PRODUCT);
        clickToElement(driver, CartUI.LINK_REMOVE_PRODUCT);
    }

    @Step("Confirm removal of product from the cart")
    public void clickAgree() {
        waitForElementClickable(driver, CartUI.BUTTON_AGREE);
        clickToElement(driver, CartUI.BUTTON_AGREE);
        waitForElementInVisible(driver, CartUI.LINK_REMOVE_PRODUCT);
    }

    @Step("Verify that the product removal message is displayed")
    public String verifyTextRemoveSuccess() {
        waitForElementVisible(driver, CartUI.VERIFY_TEXT_REMOVE_SUCCESS);
        return getTextElement(driver, CartUI.VERIFY_TEXT_REMOVE_SUCCESS);
    }

    @Step("Click Proceed to Checkout button in Cart page")
    public CheckoutPO clickProceedToCheckout() {
        waitForElementClickable(driver, CartUI.BUTTON_PROCEED_CART);
        clickToElement(driver, CartUI.BUTTON_PROCEED_CART);
        return PageGeneratorUser.getCheckout(driver);
    }

    @Step("User clicks 'Estimate Shipping & Tax'")
    public void clickEstimateCart() {
        waitForElementClickable(driver, CartUI.ESTIMATE_CART);
        clickToElement(driver, CartUI.ESTIMATE_CART);
    }

    @Step("User selects country: {country}")
    public void selectCountry(String country) {
        waitForElementClickable(driver, CartUI.SELECT_COUNTRY);
        selectItemInDropDown(driver, CartUI.SELECT_COUNTRY, country);
    }

    @Step("User enters state: {state}")
    public void enterState(String state) {
        waitForElementVisible(driver, CartUI.INPUT_STATE);
        sendKeyToElement(driver, CartUI.INPUT_STATE, state);
    }

    @Step("User enters zipcode: {zipcode}")
    public void enterZipcode(String zipcode) {
        waitForElementVisible(driver, CartUI.INPUT_ZIPCODE);
        sendKeyToElement(driver, CartUI.INPUT_ZIPCODE, zipcode);
    }

    @Step("User selects Free Shipping option")
    public void clickFreeShip() {
        waitForElementClickable(driver, CartUI.FREE_SHIPPING);
        clickToElement(driver, CartUI.FREE_SHIPPING);
    }

    @Step("User clicks 'Apply Coupon'")
    public void clickApplyCoupon() {
        waitForElementClickable(driver, CartUI.LINK_APPLY_CODE);
        clickToElement(driver, CartUI.LINK_APPLY_CODE);
    }

    @Step("User enters coupon code: {codeCoupon}")
    public void enterCode(String codeCoupon) {
        waitForElementVisible(driver, CartUI.INPUT_CODE);
        sendKeyToElement(driver, CartUI.INPUT_CODE, codeCoupon);
    }

    @Step("User clicks 'Apply' to apply coupon code")
    public void clickApply() {
        waitForElementClickable(driver, CartUI.BUTTON_APPLY_CODE);
        clickToElement(driver, CartUI.BUTTON_APPLY_CODE);
    }

    @Step("Verify coupon has been successfully applied")
    public boolean verifyApplyCodeSuccess() {
        waitForElementVisible(driver, CartUI.VERIFY_APPLIED_CODE);
        return isControlDisplayed(driver, CartUI.VERIFY_APPLIED_CODE);
    }

    @Step("Verify coupon has been fail applied")
    public boolean verifyApplyFailCoupon() {
        waitForElementVisible(driver, CartUI.VERIFY_APPLIED_CODE_FAIL);
        return isControlDisplayed(driver, CartUI.VERIFY_APPLIED_CODE_FAIL);
    }
}
