package actions.commons;


import actions.PageObjects.admin.AuthenticationAdminPO;
import actions.PageObjects.admin.DashboardAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.PageObjects.user.AuthenticationPO;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.LoginPagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.factoryBrowser.*;
import actions.factoryEnvironment.*;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

public class BaseTest extends BasePage {
    private WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName) {
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

        driver.manage().window().maximize();

        return driver;
    }

    protected WebDriver getBrowserDriver(String environment, String osName,
                                         String osVersion, String browserName,
                                         String browserVersion) {

        EnvironmentList environmentList = EnvironmentList.valueOf(environment.toUpperCase());

        switch (environmentList) {

            case LOCAL:
                driver = new LocalFactory(browserName).createDriver();
                break;

            case GRID_BROWSERSTACK:
                driver = new BrowserStackFactory(osName, osVersion, browserName, browserVersion).createDriver();
                break;

            case LAMBDA_TEST:
                driver = new LambdaTestFactory(osName, browserName, browserVersion).createDriver();
                break;
            case SAUCE_LAB:
                driver = new SauceLabFactory(osName, osVersion, browserName, browserVersion).createDriver();
                break;
            default:
                throw new RuntimeException("Environment is not supported: " + environment);
        }
        return driver;
    }

    public WebDriver getBrowserDocker(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        DesiredCapabilities capability = new DesiredCapabilities();


        switch (browser) {
            case CHROME:
                capability.setBrowserName("chrome");
                break;
            case FIREFOX:
                capability.setBrowserName("firefox");
                break;
            case EDGE:
                capability.setBrowserName("MicrosoftEdge");
                break;
            default:
                throw new RuntimeException("Browser not support");
        }

        try {
            driver = new RemoteWebDriver(
                    new URL(String.format("http://localhost:4444")),
                    capability
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;


    }

    public void LoginUserBeforeTest(String urlUser) {
        HomePagePO homePage;
        LoginPagePO loginPage;
        AuthenticationPO authentication;
        homePage = PageGeneratorUser.getHomePage(driver);
        loginPage = PageGeneratorUser.getLoginPage(driver);
        authentication = PageGeneratorUser.getAuthentication(driver);
        homePage.openPageUrl(driver, urlUser);
        homePage.acceptCookie();
        homePage.clickIconUser();
        authentication.clickLinkSignIn();
        loginPage.enterEmail("john@example.com");
        loginPage.enterPassword("demo123");
        loginPage.clickSignIn();
    }

    public void LoginAdminBeforeTest(String urlAdmin) {
        AuthenticationAdminPO authenticationAdmin;
        DashboardAdminPO dashboardAdmin;
        authenticationAdmin = PageGeneratorAdmin.getAuthenticationAdmin(driver);
        authenticationAdmin.openPageUrl(driver, urlAdmin);
        dashboardAdmin = authenticationAdmin.enterEmailAddress(GlobalConstants.EMAIL_ADDRESS_ADMIN);
        authenticationAdmin.enterPassword(GlobalConstants.PASSWORD_ADMIN);
        authenticationAdmin.clickSignIn();
        Assert.assertTrue(authenticationAdmin.menuDashboardIsDisplayed());
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }


            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @BeforeSuite
    public void deleteFileInReport() {
        deleteAllFileInFolder();
    }

    public void deleteAllFileInFolder() {
        try {
            String pathFolderDownload = GlobalConstants.ALLURE_PATH;
            File folder = new File(pathFolderDownload);
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles != null && listOfFiles.length > 0) {
                for (File file : listOfFiles) {
                    if (file.isFile() && !file.getName().equals("environment.properties")) {
                        boolean deleted = file.delete();
                        if (!deleted) {
                            System.out.println("⚠️ Không thể xóa file: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("⚠️ Không tìm thấy file trong thư mục: " + pathFolderDownload);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int randomNumber() {
        return new Random().nextInt(9999);
    }
}