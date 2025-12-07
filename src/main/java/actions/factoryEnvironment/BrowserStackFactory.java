package actions.factoryEnvironment;

import actions.commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackFactory implements EnvironmentFactory {

    private WebDriver driver;
    private String osName, osVersion, browserName, browserVersion;

    public BrowserStackFactory(String osName, String osVersion, String browserName, String browserVersion) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }

    @Override
    public WebDriver createDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();

        // browser-level
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        // bstack-level
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("userName", GlobalConstants.BROWSER_USERNAME);
        bstackOptions.put("accessKey", GlobalConstants.BROWSER_AUTOMATE_KEY);
        bstackOptions.put("consoleLogs", "info");
        bstackOptions.put("seleniumVersion", "4.23.0");
        bstackOptions.put("projectName", "Bagisto Framework Selenium");

        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        return driver;
    }
}

