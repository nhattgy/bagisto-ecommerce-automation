package user.checkoutUser;

import actions.PageObjects.user.*;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DataHelper;

@Epic("E-commerce Checkout Flow")
@Feature("Guest User Checkout")
public class CheckoutUserTest extends BaseTest {
    private WebDriver driver;
    private String urlUser;
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private CheckoutPO checkout;
    private DataHelper dataHelper = DataHelper.getDataHelper();
    String companyName = dataHelper.getCompany();
    String firstName = dataHelper.getFirstName();
    String lastName = dataHelper.getLastName();
    String emailAddress = dataHelper.getEmailAddress();
    String streetAddress = dataHelper.getStreetAddress();
    String state = dataHelper.getState();
    String city = dataHelper.getCity();
    String zipCode = dataHelper.getZipCode();
    String telephone = dataHelper.getPhoneNumber();

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        driver = getBrowserDriver(browserName);
        this.urlUser = urlUser;
        homePage = PageGenerator.getHomePage(driver);
    }

    @Story("UC-CHECKOUT-001: Guest user can complete checkout successfully")
    @Description("Verify that a guest user can select a product, add it to the cart, enter shipping details using faker data, and successfully place an order.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U11_CheckoutAsGuest() {
        homePage.openPageUrl(driver, urlUser);
        homePage.hoverLinkMenuParentProduct("Woman");
        product = homePage.clickLinkMenuChildProduct("Casual Wear");
        product.clickOnProductByName("Blossom Breeze Cotton Printed Short Skirt");

        Assert.assertTrue(product.verifyBuyNowButtonIsDisplayed());
        product.selectSize("28");
        product.clickToCart();
        Assert.assertEquals(product.verifyTextAddToCart(), "Item Added Successfully");
        product.clickToIconCart();
        cart = product.clickButtonViewCart();
        Assert.assertTrue(product.verifyTitleCartDisplayed());
        checkout = cart.clickProceedToCheckout();
        checkout.enterCompanyName(companyName);
        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterEmail(emailAddress);
        checkout.enterStreetAddress(streetAddress);
        checkout.selectCountry("American Samoa");
        checkout.enterState(state);
        checkout.enterCity(city);
        checkout.enterZipCode(zipCode);
        checkout.enterTelePhone(telephone);
        checkout.clickProceed();
        checkout.selectTypeShipping();
        checkout.selectPayMethod();
        checkout.clickPlaceOrder();
        Assert.assertTrue(checkout.verifyOrderSuccess());
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
