package PageUI.user;

public class CartUI {
    public static final String SELECT_INCREASE_PRODUCT = "css=span.icon-plus";
    public static final String BUTTON_UPDATE_CART = "xpath=//button[text() = 'Update Cart']";
    public static final String PRICE_AFTER_UPDATE = "xpath=//p[@class= 'text-lg font-semibold'and text() = '%s']";
    public static final String LINK_REMOVE_PRODUCT = "xpath=//div[@class='text-right max-md:hidden']//span[text() = ' Remove ']";
    public static final String BUTTON_AGREE = "xpath=//button[text() = 'Agree']";
    public static final String VERIFY_TEXT_REMOVE_SUCCESS = "xpath=//p[@role='heading']";
    public static final String BUTTON_PROCEED_CART = "xpath=//a[text() = ' Proceed To Checkout ']";
    public static final String ESTIMATE_CART = "xpath=//div[text() = ' Estimate Shipping and Tax ']";
    public static final String SELECT_COUNTRY = "css=select[name = 'country']";
    public static final String INPUT_STATE = "css=input[name = 'state']";
    public static final String INPUT_ZIPCODE = "css=input[name = 'postcode']";
    public static final String FREE_SHIPPING = "css=label#free_free";
    public static final String LINK_APPLY_CODE = "xpath=//span[text() = ' Apply Coupon ']";
    public static final String INPUT_CODE = "css=input[name = 'code']";
    public static final String BUTTON_APPLY_CODE = "xpath=//button[text() = 'Apply']";
    public static final String VERIFY_APPLIED_CODE = "xpath=//p[text() = ' Coupon code applied successfully.']";
    public static final String VERIFY_APPLIED_CODE_FAIL = "xpath=//p[text() = ' Coupon not found.']";


}
