package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement titleOfMyAccountPage;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenItemsButton;

    @FindBy(xpath = "//a[@title='Посмотреть корзину']")
    private WebElement goToCartButton;

    public String getTextOfNameOfMyAccountPage() {
        log.info("Getting text of main page");
        return titleOfMyAccountPage.getText();
    }

    public void clickOnWomenItemsPageButton(){
        log.info("Clicking on the women assortment button");
        waitElementToBeClickable(womenItemsButton).click();
    }





}
