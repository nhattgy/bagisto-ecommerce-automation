package admin.customerAdminTest;

import actions.PageObjects.admin.CustomerAdminPO;
import actions.PageObjects.admin.PageGeneratorAdmin;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;
@Epic("Admin - Customer Management")
@Feature("Create and Edit Customer")
public class CustomerAdminTest extends BaseTest {
    private CustomerAdminPO customerAdmin;
    private String firstName,lastname,email;
    @Parameters({"browser","urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin){
        getBrowserDriver(browserName);
        WebDriver driver = DriverManager.getDriver();
        LoginAdminBeforeTest(urlAdmin);
        customerAdmin = PageGeneratorAdmin.getCustomerAdmin(driver);
        DataHelper dataHelper = DataHelper.getDataHelper();
        firstName = dataHelper.getFirstName();
        lastname = dataHelper.getLastName();
        email = dataHelper.getEmailAddress();
    }
    @Story("Create Customer")
    @Description("Create a new customer with valid information")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void A12_A13_CreateNewCustomer(){
        customerAdmin.clickLinkCustomer();
        customerAdmin.clickCreateCustomer();
        customerAdmin.enterFirstName(firstName);
        customerAdmin.enterLastName(lastname);
        customerAdmin.enterEmailAddress(email);
        customerAdmin.enterDateOfBirth("2001-05-06");
        customerAdmin.selectGender("Male");
        customerAdmin.clickSaveCustomer();
        Assert.assertTrue(customerAdmin.verifyCustomerCreated());
        Assert.assertTrue(customerAdmin.verifyAccountIsDisplayed(firstName +" "+ lastname));
    }

    @Story("Edit Customer")
    @Description("Edit customer information successfully")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void A14_EditCustomer(){
        customerAdmin.clickIconDetailCustomer(firstName);
        customerAdmin.clickLinkEditCustomer();
        customerAdmin.selectGender("Female");
        customerAdmin.clickSaveCustomer();
        Assert.assertTrue(customerAdmin.verifyCustomerEditSuccessfully());

    }
    @Story("Delete Customer")
    @Description("Delete customer account successfully")
    @Severity(SeverityLevel.NORMAL)

    public void A15_DeleteCustomer(){
        customerAdmin.clickDeleteAccount();
        customerAdmin.clickAcceptDelete();
        Assert.assertTrue(customerAdmin.verifyCustomerDeleteSuccessfully());
    }
    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
