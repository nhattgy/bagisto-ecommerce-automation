package PageUI.user;

public class OrderUI {
    public static final String VERIFY_PRODUCT_ORDER = "xpath=//div[contains(@class, 'table')]";
    public static final String VIEW_ORDERS_PAGE_DISPLAYED = "xpath=//span[contains(@class, 'icon-eye')]";
    public static final String VERIFY_DETAIL_ORDER = "xpath=//td[text() = ' %s ']";
    public static final String VERIFY_ORDER_PROCESSING = "xpath=//p[text() = '%s']/following-sibling::p/p[text() = 'Processing']";

}
