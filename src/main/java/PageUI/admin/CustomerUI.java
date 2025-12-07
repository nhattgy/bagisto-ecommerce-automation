package PageUI.admin;

public class CustomerUI {
    public static final String LINK_CUSTOMER = "xpath=//a//p[text() = ' Customers ']";
    public static final String BUTTON_CREATE_CUSTOMER = "xpath=//button[text() = ' Create Customer ']";
    public static final String INPUT_FIRST_NAME = "css=input#first_name";
    public static final String INPUT_LAST_NAME = "css=input#last_name";
    public static final String INPUT_EMAIL_ADDRESS = "css=input#email";
    public static final String INPUT_DATE_OF_BIRTH= "css=input#dob";
    public static final String SELECT_GENDER = "css=select#gender";
    public static final String BUTTON_SAVE_CREATE_CUSTOMER = "xpath=//button[text() = 'Save customer']";
    public static final String MESSAGE_CREATED_CUSTOMER = "xpath=//p[text() = ' Customer created successfully']";
    public static final String VERIFY_ACCOUNT_IS_DISPLAYED = "xpath=//p[text() = '%s']";
    public static final String ICON_DETAIL_CUSTOMER = "xpath=//p[contains(text() , '%s')]/parent::div/parent::div/following-sibling::div//div/a[contains(@class, 'icon-sort-right')]";
    public static final String LINK_EDIT_TEXT = "xpath=//div[text() = ' Edit ']";
    public static final String VERIFY_EDIT_CUSTOMER = "xpath=//p[text() = ' Customer Updated Successfully']";
    public static final String BUTTON_DELETE_ACCOUNT = "xpath=//div[text() = ' Delete Account ']";
    public static final String BUTTON_AGREE = "xpath=//button[text() = 'Agree']";
    public static final String VERIFY_TEXT_DELETE_ACCOUNT = "xpath=//p[text() = ' Customer Deleted Successfully']";
    public static final String INPUT_SEARCH_CUSTOMER = "css=input[name='search']";
    public static final String RESULT_SEARCH_CUSTOMER = "xpath=//p[text() = '%s']";
    public static final String LINK_REVIEW = "xpath=//a[text() = ' Reviews ']";
    public static final String BUTTON_EDIT_REVIEW = "xpath=//p[text() = '%s']/parent::div/preceding-sibling::div/parent::div//a/span[contains(@class, 'icon-sort')]";
    public static final String DROPDOWN_STATUS = "css=select[name = 'status']";
    public static final String BUTTON_SAVE = "xpath=//button[text() = ' Save ']";
    public static final String VERIFY_REVIEW_UPDATE = "xpath=//p[text() = ' Review Update Successfully']";
    public static final String PROFILE_ADMIN = "xpath=//p[text() = '%s']/ancestor::div[contains(@class, 'row grid grid-cols-1 gap-2 md:grid-cols-[minmax(150px,_2fr)_1fr_1fr]')]//a[contains(@class, 'icon-login')]";

}
