package actions.PageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePagePO getHomePage(WebDriver driver) {
        return new HomePagePO(driver);
    }

    public static AuthenticationPO getAuthentication(WebDriver driver) {
        return new AuthenticationPO(driver);
    }

    public static LoginPagePO getLoginPage(WebDriver driver) {
        return new LoginPagePO(driver);
    }
    public static ProductPO getProduct(WebDriver driver){
        return new ProductPO(driver);
    }
    public static CartPO getCart(WebDriver driver){
        return new CartPO(driver);
    }
}
