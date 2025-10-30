package actions.PageObjects.user;

import PageUI.user.AuthenticationUI;
import PageUI.user.HomePageUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
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



}
