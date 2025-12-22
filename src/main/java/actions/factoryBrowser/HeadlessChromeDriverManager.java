package actions.factoryBrowser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();

        // Headless mode for CI / Jenkins
        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--window-size=1920,1080");

        // Stability options for Linux / Docker / CI
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");

        // Optional: only needed when Chrome & Driver version mismatch
        chromeOptions.addArguments("--remote-allow-origins=*");

        // Page load strategy for stable execution
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return new ChromeDriver(chromeOptions);
    }
}
