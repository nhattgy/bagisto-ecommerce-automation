package PageUI.user;

public class ProfileUI {
    public static final String BUTTON_EDIT_USER = "xpath=//a[text() = ' Edit ']";
    public static final String INPUT_FILE_IMAGE = "css=input[id = '35_fileInput']";
    public static final String VERIFY_IMAGE_UPLOAD = "xpath=//img[contains(@src, 'data:image')]";
    public static final String INPUT_PHONE_NUMBER = "css=input[name='phone']";
    public static final String DATE_INPUT_BIRTHDAY = "css=input[name='date_of_birth']";
    public static final String BUTTON_SAVE = "xpath=//button[text() = ' Save ']";
    public static final String VERIFY_IMAGE_AFTER_CLICK_BUTTON_SAVE = "css=img[alt='Profile Image']";
    public static final String INPUT_CURRENT_PASSWORD = "css=input[name='current_password']";
    public static final String INPUT_NEW_PASSWORD = "css=input[name='new_password']";
    public static final String INPUT_CONFIRM_PASSWORD = "css=input[name='new_password_confirmation']";
    public static final String VERIFY_UPDATE_PASSWORD_SUCCESS = "xpath=//p[text() = ' Profile Updated Successfully']";

}
