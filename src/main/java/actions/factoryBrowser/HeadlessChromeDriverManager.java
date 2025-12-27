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
options.addArguments("--window-size=1680,1050");

// giống Mac Retina: DPR = 2
options.addArguments("--force-device-scale-factor=2");
options.addArguments("--high-dpi-support=2");

options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--disable-notifications");

return new ChromeDriver(options);

    }
}
