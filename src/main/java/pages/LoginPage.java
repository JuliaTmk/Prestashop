package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id ='SubmitLogin']")
    private WebElement signInButton;

    public LoginPage openPage(String url) {
        driver.get(url);
        waitVisibilityOf(signInButton);
        return this;
    }

    public LoginPage fillInEmailField(String emailToLogin) {
        log.info("Fill in email field");
        waitVisibilityOf(emailField).clear();
        emailField.sendKeys(emailToLogin);
        return this;
    }

    public LoginPage fillInPasswordField (String passwordToLogin) {
        log.info("Fill in password field");
        waitVisibilityOf(passwordField).clear();
        passwordField.sendKeys(passwordToLogin);
        return this;
    }

    public void clickSignInButton(){
        log.info("Click log in button");
        waitElementToBeClickable(signInButton).click();
    }

}
