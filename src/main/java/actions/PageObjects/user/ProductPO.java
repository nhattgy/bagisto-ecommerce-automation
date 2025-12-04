package actions.PageObjects.user;

import PageUI.user.ProductUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ProductPO extends BasePage {
    private WebDriver driver;

    public ProductPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify title result search")
    public String verifyTextResults() {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_SEARCH_RESULTS);
        return getTextElement(driver, ProductUI.VERIFY_TEXT_SEARCH_RESULTS);
    }

    @Step("Verify the number of search result products displayed")
    public int verifyQuantityResultSearch() {
        waitForElementVisible(driver, ProductUI.VERIFY_QUANTITY_RESULT_SEARCH);
        return getElementsSize(driver, ProductUI.VERIFY_QUANTITY_RESULT_SEARCH);
    }

    @Step("User click product : {'productName'}")
    public void clickOnProductByName(String productName) {
        waitForElementClickable(driver, ProductUI.LINK_PRODUCT, productName);
        clickToElement(driver, ProductUI.LINK_PRODUCT, productName);
    }

    @Step("Verify button is displayed on product")
    public boolean verifyBuyNowButtonIsDisplayed() {
        waitForElementVisible(driver, ProductUI.VERIFY_BUTTON_BUY_NOW);
        return isControlDisplayed(driver, ProductUI.VERIFY_BUTTON_BUY_NOW);
    }

    @Step("User selects size option: {selectSize}")
    public void selectSize(String selectSize) {
        waitForElementClickable(driver, ProductUI.LABEL_SELECT_SIZE, selectSize);
        clickToElement(driver, ProductUI.LABEL_SELECT_SIZE, selectSize);
    }

    @Step("User clicks 'Add to Cart' button")
    public void clickToCart() {
        waitForElementClickable(driver, ProductUI.BUTTON_ADD_TO_CART);
        clickToElement(driver, ProductUI.BUTTON_ADD_TO_CART);
    }

    @Step("Verify 'Item Added Successfully' message is displayed")
    public String verifyTextAddToCart() {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_ADD_TO_CART);
        return getTextElement(driver, ProductUI.VERIFY_TEXT_ADD_TO_CART);
    }

    @Step("User clicks on cart icon in the header")
    public void clickToIconCart() {
        waitForElementClickable(driver, ProductUI.ICON_CART);
        clickToElement(driver, ProductUI.ICON_CART);
    }

    @Step("User clicks on 'View Cart' button in the cart popup")
    public CartPO clickButtonViewCart() {
        waitForElementClickable(driver, ProductUI.BUTTON_VIEW_CART);
        clickToElement(driver, ProductUI.BUTTON_VIEW_CART);
        return PageGeneratorUser.getCart(driver);
    }

    @Step("Verify Cart page title is displayed")
    public boolean verifyTitleCartDisplayed() {
        waitForElementVisible(driver, ProductUI.VERIFY_HEADING_CART_TITLE);
        return isControlDisplayed(driver, ProductUI.VERIFY_HEADING_CART_TITLE);
    }

    @Step("Verify product '{productName}' is displayed on homepage search results")
    public boolean verifyTextResultsHomepage(String productName) {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_SEARCH_RESULTS_HOMEPAGE, productName);
        return isControlDisplayed(driver, ProductUI.VERIFY_TEXT_SEARCH_RESULTS_HOMEPAGE, productName);
    }

    @Step("Verify product '{productName}' is undisplayed on homepage search results")
    public boolean verifyTextSearchNoProduct(String productName) {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_NO_RESULTS, productName);
        return isControlDisplayed(driver, ProductUI.VERIFY_TEXT_NO_RESULTS, productName);
    }

    @Step("Verify that the product price is updated to: {price}")
    public boolean verifyPriceAfterEdit(String price) {
        waitForElementVisible(driver, ProductUI.VERIFY_PRICE_AFTER_EDIT, price);
        return isControlDisplayed(driver, ProductUI.VERIFY_PRICE_AFTER_EDIT, price);
    }



    @Step("Click Review tab")
    public void clickToReview() {
        waitForElementClickable(driver, ProductUI.BUTTON_REVIEW);
        clickToElement(driver, ProductUI.BUTTON_REVIEW);
    }

    @Step("Click Write a Review button")
    public void clickWriteAReview() {
        waitForElementClickable(driver, ProductUI.BUTTON_WRITE_REVIEW);
        clickToElement(driver, ProductUI.BUTTON_WRITE_REVIEW);
    }

    @Step("Enter review title")
    public void enterTitle(String title) {
        waitForElementVisible(driver, ProductUI.INPUT_TITLE);
        sendKeyToElement(driver, ProductUI.INPUT_TITLE, title);
    }

    @Step("Enter review comment")
    public void enterComment(String comment) {
        waitForElementVisible(driver, ProductUI.INPUT_COMMENT);
        sendKeyToElement(driver, ProductUI.INPUT_COMMENT, comment);
    }

    @Step("Submit review form")
    public void clickSubmitReview() {
        waitForElementClickable(driver, ProductUI.BUTTON_SUBMIT_REVIEW);
        clickToElement(driver, ProductUI.BUTTON_SUBMIT_REVIEW);
    }

    @Step("Verify success message displayed")
    public boolean verifyCommentSuccess() {
        waitForElementVisible(driver, ProductUI.VERIFY_COMMENT_SUCCESS);
        return isControlDisplayed(driver, ProductUI.VERIFY_COMMENT_SUCCESS);
    }

    @Step("Verify review is displayed on review list")
    public boolean verifyReviewIsDisplayed(String title) {
        waitForElementVisible(driver, ProductUI.VERIFY_REVIEW_IS_DISPLAYED, title);
        return isControlDisplayed(driver, ProductUI.VERIFY_REVIEW_IS_DISPLAYED, title);
    }

    @Step("Verify review is not displayed")
    public boolean verifyReviewIsNotDisplayed(String title) {
        waitForElementInVisible(driver, ProductUI.VERIFY_REVIEW_IS_DISPLAYED, title);
        return true;
    }
}
