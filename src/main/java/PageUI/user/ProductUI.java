package PageUI.user;

public class ProductUI {
    public static final String VERIFY_TEXT_SEARCH_RESULTS = "css=h2>span";
    public static final String VERIFY_TEXT_SEARCH_RESULTS_HOMEPAGE = "xpath=//span[text() = 'These are results for : %s']";
    public static final String VERIFY_QUANTITY_RESULT_SEARCH = "xpath=//img[contains(@id, 'image-') and contains(@class, 'after')]";
    public static final String LINK_PRODUCT = "xpath=//img[contains(@alt,'%s')]";
    public static final String VERIFY_BUTTON_BUY_NOW = "xpath=//button[@type='submit' and text() = 'Buy Now']";
    public static final String LABEL_SELECT_SIZE = "xpath=//label[@title='%s']";
    public static final String BUTTON_ADD_TO_CART = "xpath=//button[text() = 'Add To Cart']";
    public static final String VERIFY_TEXT_ADD_TO_CART = "xpath=//p[text() = ' Item Added Successfully']";
    public static final String ICON_CART = "css=span.icon-cart";
    public static final String BUTTON_VIEW_CART = "xpath=//a[text() = ' View Cart ']";
    public static final String VERIFY_HEADING_CART_TITLE = "css=p[role='heading']";
    public static final String VERIFY_TEXT_NO_RESULTS = "xpath=//p[text() = ' No products available in this category ']";
    public static final String VERIFY_PRICE_AFTER_EDIT = "xpath=//p[contains(text() , '%s')]";
    public static final String BUTTON_REVIEW = "css=div#review-tab-button";
    public static final String BUTTON_WRITE_REVIEW = "xpath=//div[text() = ' Write a Review ']";
    public static final String INPUT_TITLE = "css=input[name = 'title']";
    public static final String INPUT_COMMENT = "css=textarea[name = 'comment']";
    public static final String BUTTON_SUBMIT_REVIEW = "xpath=//button[text() = ' Submit Review ']";
    public static final String VERIFY_COMMENT_SUCCESS = "xpath=//p[text() = ' Review submitted successfully.']";
    public static final String VERIFY_REVIEW_IS_DISPLAYED = "xpath=//p[text() = '%s']";

}
