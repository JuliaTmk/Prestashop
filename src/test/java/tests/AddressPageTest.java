package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.AddressPageService;
import services.LoginPageService;

public class AddressPageTest extends BaseTest {

    private AddressPageService addressPageService = new AddressPageService();

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        loginPageService.login(user);
    }

    @Test(priority = 1, alwaysRun = true)
    public void createAddressTest() {
        addressPageService.createYourAddress();
        String actualTitleOfAddress = addressPageService.getTitleOfAddressPage();
        String expectedTitleOfAddress = "KIEV";
        Assert.assertTrue(actualTitleOfAddress.contains(expectedTitleOfAddress), "The actual title of the address does not match expected!");
    }

    @Test(priority = 2)
    public void deleteAddressTest() {
        addressPageService.deleteAddress();
        String actualMessageOfPageAfterDeleteAddress = addressPageService.getTextOfPageAfterDeleteAddress();
        String expectedMessageOfPageAfterDeleteAddress = "No addresses are available.";
        addressPageService.clickOnLogoutButton();
        Assert.assertTrue(actualMessageOfPageAfterDeleteAddress.contains(expectedMessageOfPageAfterDeleteAddress), "The actual message of the page does not match expected!");
    }

}
