package pages;

import elements.InputField;
import lombok.extern.log4j.Log4j2;
import model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class AddressPage extends BasePage {

    @FindBy(xpath = "//button[@id='submitAddress']")
    private WebElement saveButton;

    @FindBy(xpath = "//h3[@class='page-subheading']")
    private WebElement nameOfAddress;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement availableAddressesButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//select[@id='id_country']//parent::div")
    private WebElement countryDropDown;

    @FindBy(xpath = "//select[@id='id_state']//parent::div")
    private WebElement stateDropDown;

    @FindBy(xpath = "//select[@id='id_country']//option[@value='216']")
    private WebElement countyID;

    @FindBy(xpath = "//select[@id='id_state']//option[@value='321']")
    private WebElement stateID;


    public AddressPage openPage(String url) {
        log.info("Open address page by URL");
        driver.get(url);
        return this;
    }

    public AddressPage firstNameInput(Address address) {
        log.info("Entering a name");
        new InputField("firstname").writeText(address.getFirstName());
        return this;
    }

    public AddressPage lastNameInput(Address address) {
        log.info("Entering a last name");
        new InputField("lastname").writeText(address.getLastName());
        return this;
    }

    public AddressPage addressInput(Address address) {
        log.info("Entering an address");
        new InputField("address1").writeText(address.getAddress());
        return this;
    }

    public AddressPage zipInput(Address address) {
        log.info("Entering a zip code");
        new InputField("postcode").writeText(address.getZip());
        return this;
    }

    public AddressPage cityInput(Address address) {
        log.info("Entering a name of the city");
        new InputField("city").writeText(address.getCity());
        return this;
    }

    public AddressPage homePhoneInput(Address address) {
        log.info("Entering a home phone");
        new InputField("phone").writeText(address.getHomePhone());
        return this;
    }

    public AddressPage addressTitleInput(Address address) {
        log.info("Entering a title of address");
        new InputField("alias").writeText(address.getAddressTitle());
        return this;
    }

    public AddressPage chooseACountry() {
        log.info("Choosing a country");
        waitVisibilityOf(countryDropDown).click();
        countyID.click();
        return this;
    }


    public AddressPage chooseAState() {
        log.info("Choosing a state");
        waitVisibilityOf(stateDropDown).click();
        stateID.click();
        return this;
    }

    public void clickSaveButton() {
        log.info("Clicking on the save button");
        saveButton.click();
    }

    public String getTextOfNameOfAddress() {
        log.info("Getting a text of name of address");
        waitVisibilityOf(nameOfAddress);
        return nameOfAddress.getText();
    }

    public void clickDeleteAddressButton() {
        log.info("Clicking on the delete address button");
        deleteAddressButton.click();
    }

    public String getText() {
        log.info("Getting text from the button (for assert)");
        return availableAddressesButton.getText();
    }

    public void clickOnLogoutButton() {
        log.info("Clicking on the logout button");
        logoutButton.click();
    }

}
