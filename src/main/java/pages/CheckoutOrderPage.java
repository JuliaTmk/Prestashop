package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CheckoutOrderPage extends BasePage {

    @FindBy(xpath = "//a[@title = 'Proceed to checkout']/span")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement proceedToCheckoutSecondButton;

    @FindBy(xpath = "//input[@value='1']")
    private WebElement pickupCheckbox;

    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement proceedToCheckoutButtonAfterAgreementOfTermsOfServices;

    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement bankTransferTypeOfPaymentButton;

    @FindBy(xpath = "//i//ancestor::button[@type='submit']")
    private WebElement orderConfirmationButton;

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement orderConfirmationMessage;

    public void clickOnProceedToCheckoutButton() {
        log.info("Clicking on the proceed to checkout button");
        driver.navigate().refresh();
        waitVisibilityOf(proceedToCheckoutButton).click();
    }

    public void clickOnProceedToCheckoutSecondButton() {
        log.info("Clicking on the proceed to checkout second button");
        proceedToCheckoutSecondButton.click();
    }

    public void chooseAPickupShipping() {
        log.info("Choosing a type of delivery");
        pickupCheckbox.click();
    }

    public void clickOnProceedToCheckoutButtonAfterAgreementOfTermsOfServices() {
        log.info("Clicking on the proceed to checkout button after agreement of terms of delivery");
        proceedToCheckoutButtonAfterAgreementOfTermsOfServices.click();
    }

    public void clickOnBankTransferButton() {
        log.info("Choosing a bank transfer payment");
        bankTransferTypeOfPaymentButton.click();
    }

    public void clickOnOrderConfirmationButton() {
        log.info("Clicking on the order confirmation button");
        orderConfirmationButton.click();
    }

    public String getTextOfOrderConfirmationMessage() {
        log.info("Getting a text of order confirmation message");
        return orderConfirmationMessage.getText();
    }

}
