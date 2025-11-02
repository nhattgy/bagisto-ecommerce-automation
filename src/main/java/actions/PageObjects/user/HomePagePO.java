package actions.PageObjects.user;

import PageUI.user.HomePageUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePagePO extends BasePage {
    WebDriver driver;

    public HomePagePO(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click icon user on header")
    public AuthenticationPO clickIconUser() {
        waitForElementClickable(driver, HomePageUI.ICON_USER);
        clickToElement(driver, HomePageUI.ICON_USER);
        return PageGenerator.getAuthentication(driver);
    }


    @Step("Verify that user profile icon or name is displayed on the Home Page")
    public boolean verifyProfileIsDisplayed() {
        waitForElementVisible(driver, HomePageUI.VERIFY_PROFILE);
        return isControlDisplayed(driver, HomePageUI.VERIFY_PROFILE);
    }
    @Step("User click logout account")
    public void clickLogout() {
        waitForElementClickable(driver, HomePageUI.LINK_LOGOUT);
        clickToElement(driver, HomePageUI.LINK_LOGOUT);
        sleepInSeconds(2);
    }
    @Step("User searches for product with keyword: {keywordSearch}")
    public ProductPO searchProduct(String keywordSearch) {
        waitForElementVisible(driver,HomePageUI.TEXTBOX_SEARCH);
        sendKeyToElement(driver, HomePageUI.TEXTBOX_SEARCH, keywordSearch);
        pressKeyToElement(driver, HomePageUI.TEXTBOX_SEARCH, Keys.ENTER);
        return PageGenerator.getProduct(driver);
    }

    @Step("Click on menu link '{linkMenuHeaderParent}' in the header")
    public void clickLinkMenuProduct(String linkMenuHeaderParent) {
        waitForElementClickable(driver, HomePageUI.LIST_MENU_HEADER_PARENT, linkMenuHeaderParent);
        clickToElement(driver, HomePageUI.LIST_MENU_HEADER_PARENT, linkMenuHeaderParent);
    }
    @Step("User hover link '{hoverLinkMenuParent}' menu parent in the header")
    public void hoverLinkMenuParentProduct(String hoverLinkMenuParent) {
        waitForElementClickable(driver, HomePageUI.LIST_MENU_HEADER_PARENT, hoverLinkMenuParent);
        hoverMouseToElement(driver, HomePageUI.LIST_MENU_HEADER_PARENT, hoverLinkMenuParent);
    }
    @Step("User click link '{linkMenuChild}' menu child in the header")
    public ProductPO clickLinkMenuChildProduct(String linkMenuChild) {
        waitForElementClickable(driver, HomePageUI.LIST_MENU_HEADER_CHILD, linkMenuChild);
        clickToElement(driver, HomePageUI.LIST_MENU_HEADER_CHILD, linkMenuChild);
        return PageGenerator.getProduct(driver);
    }
}
