package PageUI.admin;

public class ProductUI {
    public static final String BUTTON_CREATE_PRODUCT = "xpath=//button[text() = ' Create Product ']";
    public static final String VERIFY_TEXT_CREATE_PRODUCT = "xpath=//p[text() = ' Create New Product ']";
    public static final String SELECT_TYPE_PRODUCT = "css=select[name='type']";
    public static final String SELECT_FAMILY_PRODUCT = "css=select[name='attribute_family_id']";
    public static final String INPUT_SKU = "css=input[name='sku']";
    public static final String BUTTON_SAVE_PRODUCT = "xpath=//button[contains(text() , 'Save Product')]";
    public static final String VERIFY_TEXT_PRODUCT_CREATED_SUCCESS = "xpath=//p[text() = ' Product created successfully']";
    public static final String INPUT_NAME = "css=input#name";
    public static final String SELECT_COLOR = "css=select#color";
    public static final String SELECT_SIZE = "css=select#size";
    public static final String SELECT_BRAND = "css=select#brand";
    public static final String SWITCH_IFRAME_01 = "css=iframe#short_description_ifr";
    public static final String INPUT_SHORT_DESCRIPTION = "css=body[data-id = 'short_description']";
    public static final String SWITCH_IFRAME_02 = "css=iframe#description_ifr";
    public static final String INPUT_DESCRIPTION = "css=body[data-id = 'description']";
    public static final String INPUT_META_TITLE = "css=textarea#meta_title";
    public static final String INPUT_META_KEYWORD = "css=textarea#meta_keywords";
    public static final String INPUT_META_DESCRIPTION = "css=textarea#meta_description";
    public static final String INPUT_PRICE = "css=input#price";
    public static final String INPUT_WEIGHT = "css=input#weight";
    public static final String SETTING_NEW = "css=label[for = 'new']";
    public static final String SETTING_FEATURED = "css=label[for = 'featured']";
    public static final String SETTING_VISIBLE_PRODUCT = "css=label[for = 'visible_individually']";
    public static final String SETTING_STATUS = "css=label[for = 'status']";
    public static final String SETTING_GUEST_CHECKOUT = "css=label[for = 'guest_checkout']";
    public static final String SET_INVENTORIES = "xpath=//label[text() = ' Default ']/following-sibling::input";
    public static final String SELECT_CATEGORIES = "xpath=//div[text()='%s']/preceding-sibling::span";
    public static final String VERIFY_TEXT_PRODUCT_UPDATE_SUCCESS = "xpath=//p[text() = ' Product updated successfully']";
    public static final String BUTTON_EDIT_PRODUCT = "xpath=//p[text() = '%s']/parent::div/parent::div/parent::div[@class='hidden md:contents']//span[contains(@class, 'icon-sort')]";
}
