package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import services.CartPageService;
import services.WomenItemsPageService;

public class CartPageTest extends BaseTest {

    private CartPageService cartPageService = new CartPageService();
    private CartPage cartPage;

    @Test(priority = 1)
    public void addItemToTheCartTest() {
        String selectedItemLabel = "Faded Short Sleeve T-shirts";
        String actualItemLabel = cartPageService.addItemToTheCart(selectedItemLabel);
        Assert.assertEquals(actualItemLabel,selectedItemLabel,
                "The actual title of the item does not match expected!");
    }

    @Test(priority = 2)
    public void verifyPriceForSeveralItemsTest() {
        double finalCalculatedPrice;
        double expectedFinalPrice;
        int itemQuantityToBy = 3;
        finalCalculatedPrice = cartPageService.calculatePriceForSeveralItems(itemQuantityToBy);
        expectedFinalPrice = cartPageService.getFinalPrice();
        Assert.assertEquals(finalCalculatedPrice,expectedFinalPrice);
    }

    @Test(priority = 3)
    public void deletingItemFromTheCartTest() {
        Assert.assertTrue(cartPageService.removeItemFromTheCart());
    }

}
