package services;

import driver.DriverSingleton;
import io.qameta.allure.Step;
import model.Address;
import org.openqa.selenium.Alert;
import pages.AddressPage;

import static model.Address.ADDRESSES_PAGE_URL;
import static model.Address.ADDRESS_PAGE_URL;

public class AddressPageService {

    private AddressPage addressPage;

    @Step("Creating address")
    public void createYourAddress() {
        addressPage = new AddressPage();
        Address address = new Address();
        addressPage.openPage(ADDRESS_PAGE_URL)
                .firstNameInput(address)
                .lastNameInput(address)
                .addressInput(address)
                .zipInput(address)
                .cityInput(address)
                .chooseACountry()
                .homePhoneInput(address)
                .chooseAState()
                .addressTitleInput(address)
                .clickSaveButton();
    }

    @Step("Clicking on logout button")
    public void clickOnLogoutButton() {
        addressPage.clickOnLogoutButton();
    }

    @Step("Getting title of address page")
    public String getTitleOfAddressPage() {
        return addressPage.getTextOfNameOfAddress();
    }

    @Step("Deleting address")
    public void deleteAddress() {
        addressPage.openPage(ADDRESSES_PAGE_URL)
                .clickDeleteAddressButton();
        Alert alert = DriverSingleton.getInstance().getDriver().switchTo().alert();
        alert.accept();
    }

    @Step("Getting text of the page after deleting address")
    public String getTextOfPageAfterDeleteAddress() {
        return addressPage.getText();
    }

}
