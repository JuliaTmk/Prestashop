package tests;

import io.qameta.allure.Description;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.LoginPageService;

public class LoginPageTest extends BaseTest {

    @Test
    @Description("Login to the Prestashop")
    public void loginTest() {
        String expectedTextOfInventoryPage = "MY ACCOUNT";
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        String actualTextOfMyAccountPage = loginPageService.login(user)
                .getTextOfNameOfMyAccountPage();
        Assert.assertEquals(actualTextOfMyAccountPage,expectedTextOfInventoryPage,
                "The actual title of the page does not match expected!");
    }

    /*
     <test name="Login Page Test">
        <classes>
            <class name="tests.LoginPageTest"></class>
        </classes>
    </test>
     */
}
