package PageUI.admin;

public class MarketingUI {
    public static final String LINK_MARKETING = "xpath=//p[text() = ' Marketing ']";
    public static final String LINK_CART_RULES = "xpath=//div[text() = ' Cart Rules ']";
    public static final String LINK_CREATE_CART_RULE = "xpath=//a[text() = ' Create Cart Rule ']";
    public static final String INPUT_NAME_CART_RULE = "css=input#name";
    public static final String SELECT_COUPON_TYPE = "css=select#coupon_type";
    public static final String INPUT_COUPON_CODE = "css=input#coupon_code";
    public static final String INPUT_USER_PER_COUPON = "css=input#uses_per_coupon";
    public static final String INPUT_USER_PER_CUSTOMER = "css=input#usage_per_customer";
    public static final String INPUT_DISCOUNT_AMOUNT = "css=input#discount_amount";
    public static final String INPUT_MAXIMUM_QUANTITY = "css=input#discount_quantity";
    public static final String LABEL_CHANNELS = "css=label[id= 'channel__1']";
    public static final String CUSTOMER_GROUP_GUEST = "css=label[id= 'customer_group__1']";
    public static final String CUSTOMER_GROUP_GENERAL = "css=label[id= 'customer_group__2']";
    public static final String CUSTOMER_GROUP_WHOLESALE = "css=label[id= 'customer_group__3']";
    public static final String BUTTON_STATUS = "css=label[for = 'status']";
    public static final String START_DATE = "css=input#starts_from";
    public static final String END_DATE = "css=input#ends_till";
    public static final String BUTTON_SAVE_CART_RULE = "xpath=//button[text() = ' Save Cart Rule ']";
    public static final String VERIFY_CREATED_CART_RULE = "xpath=//p[text() = ' Cart rule created successfully']";
    public static final String ICON_EDIT_COUPON = "xpath=//p[text() = '%s']/parent::div//span[contains(@class, 'icon-edit')]";
}
