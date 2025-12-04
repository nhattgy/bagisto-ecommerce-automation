package actions.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManger implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);
    }
}
