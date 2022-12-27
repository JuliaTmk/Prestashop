package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.CheckoutOrderPageService;
import services.LoginPageService;

public class CheckoutOrderPageTest extends BaseTest {
    private CheckoutOrderPageService checkoutOrderPadeService = new CheckoutOrderPageService();

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (alwaysRun = true)
    public void checkoutOrderTest() {
        String selectedItemLabel = "Faded Short Sleeve T-shirts";
        checkoutOrderPadeService.ordering(selectedItemLabel);
        String actualMessageOfCheckoutPage = checkoutOrderPadeService.getTextOfOrderConfirmationMessage();
        String expectedMessageOfCheckoutPage = "ORDER CONFIRMATION";
        checkoutOrderPadeService.deleteAddress();
        Assert.assertTrue(actualMessageOfCheckoutPage.contains(expectedMessageOfCheckoutPage), "The actual text of checkout page does not match expected!");
    }

}
