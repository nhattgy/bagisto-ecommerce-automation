package PageUI.user;

public class AuthenticationUI {
    public static final String LINK_SIGNUP = "xpath=//a[text() = ' Sign Up ']";
    public static final String TEXTBOX_FIRST_NAME = "name=first_name";
    public static final String TEXTBOX_LAST_NAME = "name=last_name";
    public static final String TEXTBOX_EMAIL = "name=email";
    public static final String TEXTBOX_PASSWORD = "name=password";
    public static final String TEXTBOX_CONFIRM_PASSWORD = "name=password_confirmation";
    public static final String CHECKBOX_SUBSCRIBE = "xpath=//label[@for='is-subscribed' and contains(@class, 'icon-uncheck')]";
    public static final String CHECKBOX_I_AGREE = "css=label#agreement";
    public static final String BUTTON_REGISTER = "css=button[type='submit']";
    public static final String SUCCSESS_MESSENGER = "xpath=//div[contains(@class, 'fixed top-5')]//p[text()=' Account created successfully.']";







}
