package PageUI.admin;

public class AccountUI {
    public static final String LINK_SETTING = "xpath=//p[text() = ' Settings ']";
    public static final String LINK_USER = "xpath=//a[text() = ' Users ']";
    public static final String BUTTON_CREATE_USER = "xpath=//button[text() = ' Create User ']";
    public static final String INPUT_NAME = "css=input#name";
    public static final String INPUT_EMAIL = "css=input#email";
    public static final String INPUT_PASSWORD = "css=input#password";
    public static final String INPUT_CONFIRM_PASSWORD = "css=input#password_confirmation";
    public static final String SELECT_ROLE = "css=select[name='role_id']";
    public static final String SWITCH_BUTTON_STATUS = "css=label[for='status']";
    public static final String BUTTON_SAVE_USER = "xpath=//button[text() = 'Save User']";
    public static final String VERIFY_ACCOUNT_CREATED = "xpath=//p[text() = ' User created successfully.']";
    public static final String ICON_ADMIN = "css=button[class = 'flex h-8 w-8 cursor-pointer items-center justify-center rounded-full bg-blue-400 text-xs font-semibold leading-6 text-white transition-all hover:bg-blue-500 focus:bg-blue-500 sm:h-9 sm:w-9 sm:text-sm']";
    public static final String LINK_LOGOUT = "xpath=//a[text() = ' Logout ']";


}
