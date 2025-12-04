package PageUI.user;

public class CheckoutUI {
    public static final String COMPANY_NAME = "css=input[name='billing.company_name']";
    public static final String FIRST_NAME = "css=input[name='billing.first_name']";
    public static final String LAST_NAME = "css=input[name='billing.last_name']";
    public static final String EMAIL_ADDRESS = "css=input[name='billing.email']";
    public static final String STREET_ADDRESS = "xpath=//input[contains(@name, 'billing.address')]";
    public static final String SELECT_COUNTRY = "css=select[name='billing.country']";
    public static final String TEXTBOX_STATE = "css=input[name='billing.state']";
    public static final String TEXTBOX_CITY = "css=input[name='billing.city']";
    public static final String TEXTBOX_ZIP_CODE = "css=input[name='billing.postcode']";
    public static final String TEXTBOX_TELEPHONE = "css=input[name='billing.phone']";
    public static final String BUTTON_PROCEED = "xpath=//button[text() = 'Proceed']";
    public static final String TYPE_SHIPPING_FREE = "xpath=//span[text() = 'Free Shipping']";
    public static final String TYPE_CASH_ON_DELIVERY = "xpath=//p[text() = 'Cash On Delivery'][1]";
    public static final String BUTTON_PLACE_ORDER = "xpath=//button[text() = 'Place Order']";
    public static final String VERIFY_TEXT_ORDER_SUCCESS = "xpath=//p[text() = ' Thank you for your order! ']";
    public static final String SELECT_ADDRESS_SHIP = "xpath=//p[text() = ' %s ']";
    public static final String SELECT_PAYMENT_PAYPAL = "xpath=//p[text() = 'PayPal Standard'][1]";
    public static final String TEXTBOX_EMAIL_PAYPAL = "css=input#email";
    public static final String TEXTBOX_PASSWORD_PAYPAL = "css=input#password";
    public static final String BUTTON_LOGIN_PAYPAL = "css=button#btnLogin";
    public static final String SELECT_CREDIT_UNION = "xpath=//span[text() = 'CREDIT UNION 1']";
    public static final String BUTTON_COMPLETE_PURCHASE = "css=button[data-id = 'payment-submit-btn']";
    public static final String VERIFY_ORDER_COMPLETE_PAYPAL = "xpath=//p[text() = 'Payment completed!']";

    public static final String TEXT_ID_PRODUCT = "xpath=//a[contains(@href, 'orders/view')]";
}
