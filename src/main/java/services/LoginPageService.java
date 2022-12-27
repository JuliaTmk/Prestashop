package services;

import io.qameta.allure.Step;
import model.User;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginPageService {

    public static final String LOGIN_PAGE_URL = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account";
    private static LoginPage loginPage;


    @Step("Log in and open MyAccount Page")
    public static MyAccountPage login(User user) {
        loginPage = new LoginPage();
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickSignInButton();
        return new MyAccountPage();
    }
}
