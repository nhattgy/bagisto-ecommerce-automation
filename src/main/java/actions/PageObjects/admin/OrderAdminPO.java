package actions.PageObjects.admin;

import PageUI.admin.OrdersUI;
import actions.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.PDFHelper;

import java.io.File;

public class OrderAdminPO extends BasePage {
    private WebDriver driver;

    public OrderAdminPO(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Verify list of orders is displayed")
    public boolean verifyListOrderIsDisplayed() {
        waitForElementVisible(driver, OrdersUI.VERIFY_LIST_ORDER_IS_DISPLAYED);
        return isControlDisplayed(driver, OrdersUI.VERIFY_LIST_ORDER_IS_DISPLAYED);
    }
    @Step("Click icon View Detail of Order {iconDetail}")
    public void clickIconDetailOrder(String iconDetail) {
        waitForElementClickable(driver, OrdersUI.ICON_DETAIL_ORDER,iconDetail);
        clickToElement(driver, OrdersUI.ICON_DETAIL_ORDER,iconDetail);
    }
    @Step("Verify Order Details page is displayed")
    public boolean verifyOderDetail() {
        waitForElementVisible(driver, OrdersUI.VERIFY_ORDER_DETAILS);
        return isControlDisplayed(driver, OrdersUI.VERIFY_ORDER_DETAILS);
    }
    @Step("Admin opens the shipment creation section")
    public void clickStatusShip() {
        waitForElementClickable(driver, OrdersUI.CLICK_SHIPPING);
        clickToElement(driver, OrdersUI.CLICK_SHIPPING);
    }
    @Step("Admin selects shipment source: {source}")
    public void selectSource(String source) {
        waitForElementClickable(driver, OrdersUI.SELECT_SOURCE);
        selectItemInDropDown(driver, OrdersUI.SELECT_SOURCE, source);
    }
    @Step("Admin clicks the 'Create Shipment' button")
    public void clickCreateShipment() {
        waitForElementClickable(driver, OrdersUI.BUTTON_CREATE_SHIPMENT);
        clickToElement(driver, OrdersUI.BUTTON_CREATE_SHIPMENT);
    }
    @Step("Verify that the shipment is created successfully")
    public boolean verifyCreateShipmentSuccess() {
        waitForElementVisible(driver, OrdersUI.VERIFY_SHIPMENT_SUCCESS);
        return isControlDisplayed(driver, OrdersUI.VERIFY_SHIPMENT_SUCCESS);
    }

    public void enterSearch(String searchNumberId) {
        waitForElementVisible(driver, OrdersUI.INPUT_SEARCH);
        sendKeyToElement(driver, OrdersUI.INPUT_SEARCH, searchNumberId);
        pressKeyToElement(driver, OrdersUI.INPUT_SEARCH, Keys.ENTER);
    }

    public void clickInvoice() {
        waitForElementClickable(driver, OrdersUI.BUTTON_INVOICE);
        clickToElement(driver, OrdersUI.BUTTON_INVOICE);
    }

    public void clickCreateInvoice() {
        waitForElementClickable(driver, OrdersUI.BUTTON_CREATE_INVOICE);
        clickToElement(driver, OrdersUI.BUTTON_CREATE_INVOICE);
    }

    public boolean verifyCreateInvoiceSuccess() {
        waitForElementVisible(driver, OrdersUI.VERIFY_TEXT_CREATE_INVOICE);
        return isControlDisplayed(driver, OrdersUI.VERIFY_TEXT_CREATE_INVOICE);
    }

    public void clickDownloadPdfInvoice() {
        waitForElementClickable(driver, OrdersUI.LINK_DOWNLOAD_PDF);
        clickToElement(driver, OrdersUI.LINK_DOWNLOAD_PDF);
        sleepInSeconds(3);

        String downloadFolder = System.getProperty("user.home") + "/Downloads";
        File pdfFile = PDFHelper.getLatestFile(downloadFolder);

        String pdfText = PDFHelper.readPDF(pdfFile.getAbsolutePath());

        Assert.assertTrue(pdfText.contains("Blossom Breeze Cotton Printed Short Skirt"));
        Assert.assertTrue(pdfText.contains("$24.99"));
    }

}
