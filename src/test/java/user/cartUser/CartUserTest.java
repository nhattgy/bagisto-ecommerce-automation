package user.cartUser;

import actions.PageObjects.user.CartPO;
import actions.PageObjects.user.HomePagePO;
import actions.PageObjects.user.PageGeneratorUser;
import actions.PageObjects.user.ProductPO;
import actions.commons.BaseTest;
import actions.commons.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Cart Management")
@Feature("Add Product to Cart")
public class CartUserTest extends BaseTest {
    private HomePagePO homePage;
    private ProductPO product;
    private CartPO cart;
    private String urlUser;

    @Parameters({"browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        getBrowserDocker(browserName);
        WebDriver driver = DriverManager.getDriver();
        this.urlUser = urlUser;
        homePage = PageGeneratorUser.getHomePage(driver);
    }

    @Story("User adds a product to cart from the product detail page")
    @Description("Verify that user can add a product to the cart successfully when clicking on a product from category page.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void U08_AddProductToCart() {
        WebDriver driver = DriverManager.getDriver();
        homePage.openPageUrl(driver, urlUser);
        homePage.acceptCookie();
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
    }

    @Story("User updates product quantity in the shopping cart")
    @Description("Verify that the user can successfully update the quantity of a product in the cart and the cart total is recalculated correctly.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void U09_UpdateProductQuantityInCart() {
        cart.increaseQuantity();
        cart.updateCart();
        Assert.assertEquals(cart.priceUpdate("$49.98"), "$49.98");
    }

    @Story("User removes a product from the shopping cart")
    @Description("Verify that the user can remove a product from the cart successfully and the cart is updated accordingly.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void U10_RemoveProductFromCart() {
        cart.removeProduct();
        cart.clickAgree();
        Assert.assertEquals(cart.verifyTextRemoveSuccess(), "You don’t have a product in your cart.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
