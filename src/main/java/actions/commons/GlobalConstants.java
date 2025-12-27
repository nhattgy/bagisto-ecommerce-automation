package actions.commons;

import java.io.File;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    // Wait Infor
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 35;
    // ACCOUNT
    public static final String EMAIL_ADDRESS_ADMIN = "admin@example.com";
    public static final String PASSWORD_ADMIN = "admin123";

    // Download/ Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;

    // HTML Report Folder
    public static final String ALLURE_PATH =
            PROJECT_PATH + File.separator + "allure-results";

    // Config Browser Stack
    public static final String BROWSER_USERNAME = "lolimals_H4hGry";
    public static final String BROWSER_AUTOMATE_KEY = "2p6RD9ak4HcSiv9QuWmD";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    // Config Lambda Test
    public static final String LAMBDA_USERNAME = "nhatnt56";
    public static final String LAMBDA_AUTOMATE_KEY = "LT_lEfDY4BW7bWkMGO02yhAxgYzW6y3dcYLWaSV75PyeArReT8";

    public static final String LAMBDA_URL =
            "https://" + LAMBDA_USERNAME + ":" + LAMBDA_AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";

    //Config Sauce Lab

    public static final String SAUCE_USERNAME = "oauth-nhatnt56-0c579";
    public static final String SAUCE_AUTOMATE_KEY = "fe1668da-ee52-403f-8b77-f9daccce7bde";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY +
            "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

}