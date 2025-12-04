package actions.PageObjects.admin;

import PageUI.admin.ProductUI;
import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class ProductAdminPO extends BasePage {
    private WebDriver driver;

    public ProductAdminPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click button 'Create Product'")
    public void clickButtonCreateProduct() {
        waitForElementClickable(driver, ProductUI.BUTTON_CREATE_PRODUCT);
        clickToElement(driver, ProductUI.BUTTON_CREATE_PRODUCT);
    }

    @Step("Verify text 'Create New Product' is displayed")
    public boolean verifyTextCreateNewProduct() {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_CREATE_PRODUCT);
        return isControlDisplayed(driver, ProductUI.VERIFY_TEXT_CREATE_PRODUCT);
    }

    @Step("Select product type: {typeProduct}")
    public void selectTypeProduct(String typeProduct) {
        waitForElementClickable(driver, ProductUI.SELECT_TYPE_PRODUCT);
        selectItemInDropDown(driver, ProductUI.SELECT_TYPE_PRODUCT, typeProduct);
    }

    @Step("Select product family: {familyProduct}")
    public void selectFamilyProduct(String familyProduct) {
        waitForElementClickable(driver, ProductUI.SELECT_FAMILY_PRODUCT);
        selectItemInDropDown(driver, ProductUI.SELECT_FAMILY_PRODUCT, familyProduct);
    }

    @Step("Enter SKU: {sku}")
    public void enterSKU(String sku) {
        waitForElementVisible(driver, ProductUI.INPUT_SKU);
        sendKeyToElement(driver, ProductUI.INPUT_SKU, sku);
    }

    @Step("Click button 'Save Product'")
    public void clickButtonSaveProduct() {
        waitForElementClickable(driver, ProductUI.BUTTON_SAVE_PRODUCT);
        clickToElement(driver, ProductUI.BUTTON_SAVE_PRODUCT);
    }

    @Step("Verify product created successfully message")
    public boolean verifyMessageSuccess() {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_PRODUCT_CREATED_SUCCESS);
        return isControlDisplayed(driver, ProductUI.VERIFY_TEXT_PRODUCT_CREATED_SUCCESS);
    }

    @Step("Enter product name: {name}")
    public void enterName(String name) {
        waitForElementVisible(driver, ProductUI.INPUT_NAME);
        sendKeyToElement(driver, ProductUI.INPUT_NAME, name);
    }

    @Step("Select color: {color}")
    public void selectColor(String color) {
        waitForElementClickable(driver, ProductUI.SELECT_COLOR);
        selectItemInDropDown(driver, ProductUI.SELECT_COLOR, color);
    }

    @Step("Select size: {size}")
    public void selectSize(String size) {
        waitForElementClickable(driver, ProductUI.SELECT_SIZE);
        selectItemInDropDown(driver, ProductUI.SELECT_SIZE, size);
    }

    @Step("Select brand: {brand}")
    public void selectBrand(String brand) {
        waitForElementClickable(driver, ProductUI.SELECT_BRAND);
        selectItemInDropDown(driver, ProductUI.SELECT_BRAND, brand);
    }

    @Step("Switch to short description iframe")
    public void switchToFrame01() {
        switchToIframe(driver, ProductUI.SWITCH_IFRAME_01);
    }

    @Step("Enter short description")
    public void enterShortDescription(String shortDescription) {
        waitForElementVisible(driver, ProductUI.INPUT_SHORT_DESCRIPTION);
        sendKeyToElement(driver, ProductUI.INPUT_SHORT_DESCRIPTION, shortDescription);
    }

    @Step("Switch to long description iframe")
    public void switchToFrame02() {
        switchToIframe(driver, ProductUI.SWITCH_IFRAME_02);
    }

    @Step("Enter long description")
    public void enterDescription(String description) {
        waitForElementVisible(driver, ProductUI.INPUT_DESCRIPTION);
        sendKeyToElement(driver, ProductUI.INPUT_DESCRIPTION, description);
    }

    @Step("Enter meta title: {metaTitle}")
    public void enterMetaTitle(String metaTitle) {
        waitForElementVisible(driver, ProductUI.INPUT_META_TITLE);
        sendKeyToElement(driver, ProductUI.INPUT_META_TITLE, metaTitle);
    }

    @Step("Enter meta keyword: {metaKeyword}")
    public void enterMetaKeyword(String metaKeyword) {
        waitForElementVisible(driver, ProductUI.INPUT_META_KEYWORD);
        sendKeyToElement(driver, ProductUI.INPUT_META_KEYWORD, metaKeyword);
    }

    @Step("Enter meta description: {metaDescription}")
    public void enterMetaDescription(String metaDescription) {
        waitForElementVisible(driver, ProductUI.INPUT_META_DESCRIPTION);
        sendKeyToElement(driver, ProductUI.INPUT_META_DESCRIPTION, metaDescription);
    }

    @Step("Enter price: {price}")
    public void enterPrice(String price) {
        waitForElementVisible(driver, ProductUI.INPUT_PRICE);
        sendKeyToElement(driver, ProductUI.INPUT_PRICE, price);
    }

    @Step("Enter weight: {weight}")
    public void enterWeight(String weight) {
        waitForElementVisible(driver, ProductUI.INPUT_WEIGHT);
        sendKeyToElement(driver, ProductUI.INPUT_WEIGHT, weight);
    }

    @Step("Activate 'New' setting")
    public void activeSettingNew() {
        waitForElementClickable(driver, ProductUI.SETTING_NEW);
        clickToElement(driver, ProductUI.SETTING_NEW);
    }

    @Step("Activate 'Featured' setting")
    public void activeFeatured() {
        waitForElementClickable(driver, ProductUI.SETTING_FEATURED);
        clickToElement(driver, ProductUI.SETTING_FEATURED);
    }

    @Step("Activate 'Visible Individually'")
    public void activeVisibleIndividually() {
        waitForElementClickable(driver, ProductUI.SETTING_VISIBLE_PRODUCT);
        clickToElementByJS(driver, ProductUI.SETTING_VISIBLE_PRODUCT);
    }

    @Step("Activate 'Status'")
    public void activeStatus() {
        waitForElementClickable(driver, ProductUI.SETTING_STATUS);
        clickToElementByJS(driver, ProductUI.SETTING_STATUS);
    }

    @Step("Activate 'Guest Checkout'")
    public void activeGuestCheckout() {
        waitForElementClickable(driver, ProductUI.SETTING_GUEST_CHECKOUT);
        clickToElement(driver, ProductUI.SETTING_GUEST_CHECKOUT);
    }

    @Step("Enter default inventory: {inventories}")
    public void enterDefaultInventory(String inventories) {
        waitForElementVisible(driver, ProductUI.SET_INVENTORIES);
        sendKeyToElement(driver, ProductUI.SET_INVENTORIES, inventories);
    }

    @Step("Select category: {categoryName}")
    public void SelectCategories(String categoryName) {
        waitForElementClickable(driver, ProductUI.SELECT_CATEGORIES, categoryName);
        clickToElement(driver, ProductUI.SELECT_CATEGORIES, categoryName);
    }

    @Step("Click button 'Save Product Edit'")
    public void clickButtonSaveProductEdit() {
        scrollToElementOnDownByJS(driver, ProductUI.BUTTON_SAVE_PRODUCT);
        waitForElementClickable(driver, ProductUI.BUTTON_SAVE_PRODUCT);
        clickToElement(driver, ProductUI.BUTTON_SAVE_PRODUCT);
    }

    @Step("Verify product updated successfully message")
    public boolean verifyTextSuccessCreatedProduct() {
        waitForElementVisible(driver, ProductUI.VERIFY_TEXT_PRODUCT_UPDATE_SUCCESS);
        return isControlDisplayed(driver, ProductUI.VERIFY_TEXT_PRODUCT_UPDATE_SUCCESS);
    }

    public void clickEditProduct(String productName) {
        waitForElementClickable(driver, ProductUI.BUTTON_EDIT_PRODUCT,productName);
        clickToElement(driver, ProductUI.BUTTON_EDIT_PRODUCT,productName);
    }
}
