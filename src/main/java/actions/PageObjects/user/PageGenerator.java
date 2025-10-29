package actions.PageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static AuthenticationPO getAuthentication(WebDriver driver){
        return new AuthenticationPO(driver);
    }
}
