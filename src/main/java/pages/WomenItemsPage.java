package pages;


import elements.ItemToBy;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class WomenItemsPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title_block']")
    private WebElement titleOfWomenItemsPage;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement titleOfSelectedItem;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@title='Посмотреть корзину']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    private WebElement continueShoppingButton;



    public String getTextOfTitleOfWomenItemsPage() {
        log.info("Getting title of women items page");
        return waitVisibilityOf(titleOfWomenItemsPage).getText();
    }

    public WomenItemsPage selectItemToBy (String itemLabel) {
        log.info("Select item to show more details");
        new ItemToBy(itemLabel).ClickItemToBy();
        return this;
    }

    public String getTextOfSelectedItem() {
        log.info("Getting text of selected item");
        return titleOfSelectedItem.getText();
    }

    public WomenItemsPage clickAddToCartButton(){
        log.info("Clicking on the 'Add to Cart' button");
        waitElementToBeClickable(addToCartButton).click();
        return this;
    }

    public CartPage clickOnGoToCartButton(){
        log.info("Clicking on the Go to Cart button");
        waitElementToBeClickable(goToCartButton).click();
        return new CartPage();
    }

    public WomenItemsPage clickToContinueShoppingButton() {
        log.info("Clicking on the continue to shopping button");
        waitVisibilityOf(continueShoppingButton).click();
        return this;
    }






}
