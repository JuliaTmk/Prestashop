package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CartPage extends BasePage {

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteFromCartButton;

    @FindBy(xpath = "//p[@class='product-name']//following-sibling::a")
    private WebElement labelOfAddedToTheCartItem;

    @FindBy(xpath = "//h1[@id='cart_title']")
    private WebElement titleOfCartPage;

    @FindBy(xpath = "//span[@class='price']/span")
    private WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']/span")
    private WebElement totalPrice;

    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement increaseItemQuantityButton;

    @FindBy(xpath = "//span[@id='summary_products_quantity']")
    private WebElement numberOfAddedToTheCartItems;

    @FindBy(xpath = "//p[contains(text(), 'Your shopping cart is empty')]")
    private WebElement alertEmptyCart;


    public CartPage clickOnDeleteFromCartButton(){
        log.info("Delete item from the cart");
        deleteFromCartButton.click();
        deleteFromCartButton.click();
        driver.navigate().refresh();
        return this;
    }
    public String getTextOfAddedToTheCartItem() {
        log.info("Getting text of main page");
        waitVisibilityOf(titleOfCartPage);
        return labelOfAddedToTheCartItem.getAttribute("innerText").trim();
    }

    public String getPriceOfItem() {
        log.info("Getting price of item");
        return unitPrice.getText();
    }

    public String getTotalPrice() {
        log.info("Getting total price of items");
        driver.navigate().refresh();
        return totalPrice.getText();
    }

    public boolean alertEmptyCartIsVisible() {
        return waitVisibilityOf(alertEmptyCart).isDisplayed();
    }

    public CartPage clickIncreaseItemQuantityButton(int clickNumber) {
        int i;
        for(i=1;i<clickNumber;i++) {
            increaseItemQuantityButton.click();
        }
        return this;
    }

}
