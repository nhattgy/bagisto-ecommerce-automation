package actions.PageObjects.user;

import PageUI.user.CartUI;
import PageUI.user.CheckoutUI;
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
        return PageGenerator.getCheckout(driver);
    }
}
