package actions.factoryBrowser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Reduce UI/overlay surprises
        options.addArguments("--disable-notifications");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--high-dpi-support=1");

        // If you still need it, add back:
        // options.addArguments("--remote-allow-origins=*");

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return new ChromeDriver(options);
    }
}
