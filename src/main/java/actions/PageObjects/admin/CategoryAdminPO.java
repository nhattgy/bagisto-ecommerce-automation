package actions.PageObjects.admin;

import PageUI.admin.CategoryUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CategoryAdminPO extends BasePage {
    private WebDriver driver;

    public CategoryAdminPO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click on 'Create Category' button")
    public void clickButtonCreateCategory() {
        waitForElementClickable(driver, CategoryUI.BUTTON_CREATE_CATEGORY);
        clickToElement(driver, CategoryUI.BUTTON_CREATE_CATEGORY);
    }

    @Step("Enter category name: {nameCategory}")
    public void enterNameCategory(String nameCategory) {
        waitForElementVisible(driver, CategoryUI.TEXTBOX_NAME_CATEGORY);
        sendKeyToElement(driver, CategoryUI.TEXTBOX_NAME_CATEGORY, nameCategory);
    }

    @Step("Enter category description: {description}")
    public void enterDescription(String description) {
        waitForElementVisible(driver, CategoryUI.TEXTBOX_DESCRIPTION);
        sendKeyToElement(driver, CategoryUI.TEXTBOX_DESCRIPTION, description);
    }

    @Step("Enter Meta Title: {metaData}")
    public void enterMetaTitle(String metaData) {
        waitForElementVisible(driver, CategoryUI.TEXTBOX_META_TITLE);
        sendKeyToElement(driver, CategoryUI.TEXTBOX_META_TITLE, metaData);
    }

    @Step("Enter Slug: {slug}")
    public void enterSlug(String slug) {
        waitForElementVisible(driver, CategoryUI.TEXTBOX_SLUG);
        sendKeyToElement(driver, CategoryUI.TEXTBOX_SLUG, slug);
    }

    @Step("Enter Position: {position}")
    public void enterPosition(String position) {
        waitForElementVisible(driver, CategoryUI.TEXTBOX_POSITION);
        sendKeyToElement(driver, CategoryUI.TEXTBOX_POSITION, position);
    }

    @Step("Select Display Mode: {displayedMode}")
    public void selectDisplayMode(String displayedMode) {
        waitForElementClickable(driver, CategoryUI.SELECT_DISPLAY_MODE);
        selectItemInDropDown(driver, CategoryUI.SELECT_DISPLAY_MODE, displayedMode);
    }

    @Step("Select Filterable Attribute: {AttributeName}")
    public void selectAttribute(String AttributeName) {
        waitForElementClickable(driver, CategoryUI.FILTERABLE_ATTRIBUTE, AttributeName);
        clickToElement(driver, CategoryUI.FILTERABLE_ATTRIBUTE, AttributeName);
    }

    @Step("Click on 'Save Category' button")
    public void saveCategory() {
        waitForElementClickable(driver, CategoryUI.BUTTON_SAVE_CATEGORY);
        clickToElement(driver, CategoryUI.BUTTON_SAVE_CATEGORY);
    }

    @Step("Verify success message is displayed after creating category")
    public boolean verifyMessengerSuccess() {
        waitForElementVisible(driver, CategoryUI.VERIFY_CREATE_CATEGORY);
        return isControlDisplayed(driver, CategoryUI.VERIFY_CREATE_CATEGORY);
    }

    @Step("Switch to iframe of category description textbox")
    public void switchToIframeTextBox() {
        switchToIframe(driver, CategoryUI.SWITCH_IFRAME_CSS);
    }
    @Step("Click on 'Edit Icon'")
    public void clickIconEdit(String iconEdit, String editClass) {
        waitForElementClickable(driver, CategoryUI.FUNCTION_ICON, iconEdit,editClass);
        clickToElement(driver, CategoryUI.FUNCTION_ICON,iconEdit,editClass);
    }
    @Step("Edit name textbox: {editName}")
    public void enterNameCategoryEdit(String editName) {
        waitForElementVisible(driver, CategoryUI.TEXTBOX_NAME_CATEGORY_EDIT);
        sendKeyToElement(driver, CategoryUI.TEXTBOX_NAME_CATEGORY_EDIT,editName);
    }
    @Step("Click on 'DELETE Icon'")
    public void clickDeleteIcon(String iconDelete, String deleteClass) {
        waitForElementClickable(driver, CategoryUI.FUNCTION_ICON, iconDelete,deleteClass);
        clickToElement(driver, CategoryUI.FUNCTION_ICON,iconDelete,deleteClass);
    }
    @Step("Click button Agree Delete")
    public void clickButtonAgreeDelete() {
        waitForElementClickable(driver, CategoryUI.BUTTON_AGREE_DELETE);
        clickToElement(driver, CategoryUI.BUTTON_AGREE_DELETE);
    }
    @Step("Verify message delete success")
    public boolean verifyMessengerDeleteSuccess() {
        waitForElementVisible(driver, CategoryUI.VERIFY_TEXT_DELETE_SUCCESS);
        return isControlDisplayed(driver, CategoryUI.VERIFY_TEXT_DELETE_SUCCESS);
    }
}
