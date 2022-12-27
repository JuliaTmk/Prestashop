package services;

import io.qameta.allure.Step;
import pages.CheckoutOrderPage;

public class CheckoutOrderPageService {

    private CartPageService cartPageService;
    private AddressPageService addressPageService;
    private CheckoutOrderPage checkoutOrderPage;

    @Step("Making order")
    public void ordering(String itemLabel) {
        cartPageService = new CartPageService();
        addressPageService = new AddressPageService();
        checkoutOrderPage = new CheckoutOrderPage();

        addressPageService.createYourAddress();
        cartPageService.addItemToTheCart(itemLabel);
        checkoutOrderPage.clickOnProceedToCheckoutButton();
        checkoutOrderPage.clickOnProceedToCheckoutSecondButton();
        checkoutOrderPage.chooseAPickupShipping();
        checkoutOrderPage.clickOnProceedToCheckoutButtonAfterAgreementOfTermsOfServices();
        checkoutOrderPage.clickOnBankTransferButton();
        checkoutOrderPage.clickOnOrderConfirmationButton();
    }

    @Step("Getting text of order confirmation message")
    public String getTextOfOrderConfirmationMessage() {
        return checkoutOrderPage.getTextOfOrderConfirmationMessage();
    }

    @Step("Deleting address")
    public void deleteAddress() {
        addressPageService.deleteAddress();
    }

}
