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

    @FindBy(xpath = "//a[@class='open-comment-form']")
    private WebElement commentField;

    @FindBy(xpath = "//input[@id='comment_title']")
    private WebElement commentTitle;

    @FindBy(xpath = "//textarea[@id='content']")
    private WebElement commentContent;

    @FindBy(xpath = "//button[@id='submitNewMessage']")
    private WebElement sendCommentButton;

    @FindBy(xpath = "//div[@class='fancybox-skin']//h2[contains(text(), 'Новый')]")
    private WebElement successCommentMessage;

    public WomenItemsPage openPage(String url) {
        log.info("Open women items page by URL");
        driver.get(url);
        return this;
    }

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

    public WomenItemsPage clickCommentField(){
        log.info("Clicking on the comment field");
        waitElementToBeClickable(commentField).click();
        return this;
    }

    public WomenItemsPage inputCommentTitle(String commentTitleText){
        log.info("Inputting comment title");
        waitVisibilityOf(commentTitle).sendKeys(commentTitleText);
        return this;
    }

    public WomenItemsPage inputCommentContent(String commentContentText){
        log.info("Inputting comment content");
        waitVisibilityOf(commentContent).sendKeys(commentContentText);
        return this;
    }

    public WomenItemsPage clickSendCommentButton() {
        log.info("Clicking on the send comment button");
        waitVisibilityOf(sendCommentButton).click();
        return this;
    }

    public String getTextOfSuccessCommentMessage() {
        return waitVisibilityOf(successCommentMessage).getText();
    }

}
