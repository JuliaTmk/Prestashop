package services;

import io.qameta.allure.Step;
import pages.CartPage;


public class CartPageService {

    protected static CartPage cartPage;

    @Step("Adding item to the cart")
    public String addItemToTheCart(String itemLabel) {
        WomenItemsPageService womenItemsPageService = new WomenItemsPageService();
        return womenItemsPageService.openWomenItemsPage()
                .selectItemToBy(itemLabel)
                .clickAddToCartButton()
                .clickToContinueShoppingButton()
                .clickOnGoToCartButton()
                .getTextOfAddedToTheCartItem();
    }

    @Step("Removing item from the cart")
    public boolean removeItemFromTheCart() {
        return cartPage.clickOnDeleteFromCartButton()
                .alertEmptyCartIsVisible();
    }

    @Step("Calculate price for several items in the chart")
    public double calculatePriceForSeveralItems(int itemQuantity) {
        cartPage = new CartPage();
        double itemPrice;
        itemPrice = extractPriceFromString(cartPage.getPriceOfItem());
        cartPage.clickIncreaseItemQuantityButton(itemQuantity);
        double calculatedFinalPrice = itemPrice*(itemQuantity);
        return Math.round(calculatedFinalPrice * 100.0) / 100.0;
    }

    public double getFinalPrice() {
        return extractPriceFromString(cartPage.getTotalPrice());
    }


    public double extractPriceFromString(String string) {
        String newString = string.replace(",", ".");
        String[] parts = newString.split(" ");
        return Double.parseDouble(parts[0].trim());
    }

}
