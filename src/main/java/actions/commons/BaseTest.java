package actions.commons;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
public class BaseTest extends BasePage {
    private WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driver;
    }
    public WebDriver getBrowserDriver(String browserName) {
        BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not supported: " + browserName);
        }

        driver.manage().window().maximize();

        return driver;
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