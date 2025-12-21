package PageUI.admin;

public class OrdersUI {
    public static final String VERIFY_LIST_ORDER_IS_DISPLAYED = "css=div[class = 'row grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-y-4 border-b px-2 sm:px-4 py-2.5 transition-all hover:bg-gray-50 dark:border-gray-800 dark:hover:bg-gray-950']";
    public static final String ICON_DETAIL_ORDER = "xpath=//p[text() = '%s']/parent::div/following-sibling::div//a";
    public static final String VERIFY_ORDER_DETAILS = "xpath=//p[contains(text(), 'Order Items')]";
    public static final String CLICK_SHIPPING = "xpath=//div[text() = ' Ship ']";
    public static final String SELECT_SOURCE = "css=select[id = 'shipment[source]']";
    public static final String BUTTON_CREATE_SHIPMENT = "xpath=//button[text() = ' Create Shipment ']";
    public static final String VERIFY_SHIPMENT_SUCCESS = "xpath=//p[text() = ' Shipment created successfully']";
    public static final String INPUT_SEARCH = "xpath=//input[@name = 'search']";
    public static final String BUTTON_INVOICE = "xpath=//div[text() = ' Invoice ']";
    public static final String BUTTON_CREATE_INVOICE = "xpath=//button[text() = ' Create Invoice ']";
    public static final String VERIFY_TEXT_CREATE_INVOICE = "xpath=//p[text() = ' Invoice created successfully']";
    public static final String LINK_DOWNLOAD_PDF = "xpath=//a[text() = ' Download PDF ']";
}
