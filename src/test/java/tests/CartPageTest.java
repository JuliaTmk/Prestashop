package tests;

import services.CartPageService;
import services.WomenItemsPageService;

public class CartPageTest extends BaseTest {

    private WomenItemsPageService womenItemsPageService = new WomenItemsPageService();
    private CartPageService cartPageService = new CartPageService();

    public void addItemToTheCart() {
        String selectedItemLabel = "Black blouse with flowers";
        womenItemsPageService.openWomenItemsPage()
                .selectItemToBy(selectedItemLabel);

    }
}
