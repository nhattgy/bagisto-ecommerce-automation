package actions.factoryEnvironment;

import actions.commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SauceLabFactory implements EnvironmentFactory {
    private WebDriver driver;
    private String platformName;
    private String browserName;
    private String browserVersion;
    private String platformVersion;

    public SauceLabFactory(String platformName, String platformVersion, String browserName, String browserVersion) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }

    @Override
    public WebDriver createDriver() {

        MutableCapabilities capability;

        switch (browserName.toLowerCase()) {
            case "chrome":
                capability = new ChromeOptions();
                break;
            case "firefox":
                capability = new FirefoxOptions();
                break;
            case "edge":
                capability = new EdgeOptions();
                break;
            case "safari":
                capability = new SafariOptions();
                break;
            default:
                throw new RuntimeException("Browser invalid: " + browserName);
        }

        capability.setCapability("platformName", platformName);
        capability.setCapability("browserVersion", browserVersion);

        HashMap<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", GlobalConstants.SAUCE_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCE_AUTOMATE_KEY);
        sauceOptions.put("build", "automation-fc-build");
        sauceOptions.put("platformVersion", platformVersion);
        sauceOptions.put("name", "Run on " + platformName + " | " + browserName + " | " + browserVersion);

        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        return driver;
    }
}
