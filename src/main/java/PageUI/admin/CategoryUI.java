package PageUI.admin;

public class CategoryUI {
    public static final String BUTTON_CREATE_CATEGORY = "xpath=//div[text() = ' Create Category ']";
    public static final String TEXTBOX_NAME_CATEGORY = "css=input#name";
    public static final String TEXTBOX_NAME_CATEGORY_EDIT = "css=input#en\\[name\\]";
    public static final String SWITCH_IFRAME_CSS = "css=iframe#description_ifr";
    public static final String TEXTBOX_DESCRIPTION = "css=body#tinymce>p";
    public static final String INPUT_FILE_IMAGE_LOGO = "xpath=//input[@type = 'file']";
    public static final String TEXTBOX_META_TITLE = "css=input#meta_title";
    public static final String TEXTBOX_SLUG = "css=input#slug";
    public static final String TEXTBOX_POSITION = "css=input[placeholder = 'Enter Position']";
    public static final String SELECT_DISPLAY_MODE = "css=select#display_mode";
    public static final String FILTERABLE_ATTRIBUTE = "xpath=//label[@id = '%s']";
    public static final String BUTTON_SAVE_CATEGORY = "xpath=//button[text() = ' Save Category ']";
    public static final String VERIFY_CREATE_CATEGORY = "xpath=//p[text() = ' Category created successfully.']";
    public static final String FUNCTION_ICON = "xpath=//p[text() = '%s']//following-sibling::p/span[contains(@class, '%s')]";
    public static final String BUTTON_AGREE_DELETE = "xpath=//button[text() = 'Agree']";
    public static final String VERIFY_TEXT_DELETE_SUCCESS = "xpath=//p[text() = ' The category has been successfully deleted.']";
}
