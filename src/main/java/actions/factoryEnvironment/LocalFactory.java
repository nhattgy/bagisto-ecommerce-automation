package actions.factoryEnvironment;

import actions.factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class LocalFactory implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public WebDriver createDriver() {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME:
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            case SAFARI:
                driver = new SafariDriverManger().getBrowserDriver();
                break;
            case HEADLESS_CHROME:
                driver = new HeadlessChromeDriverManager().getBrowserDriver();
                break;
            case HEADLESS_EDGE:
                driver = new HeadlessEdgeDriverManager().getBrowserDriver();
                break;
            case HEADLESS_FIREFOX:
                driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
            default:
                throw new BrowserNotSupportedException("Browser name is not supported: " + browserName);
        }

        return driver;
    }
}
