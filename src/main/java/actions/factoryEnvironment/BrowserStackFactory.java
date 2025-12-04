package actions.factoryEnvironment;

import actions.commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackFactory implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName,browserVersion,osName,osVersion;

    public BrowserStackFactory( String osName, String osVersion, String browserName, String browserVersion) {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    @Override
    public WebDriver createDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", browserName);
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("browserVersion", browserVersion);
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
