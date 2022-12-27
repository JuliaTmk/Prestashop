package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputField {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    private static final String INPUT_XPATH = "//input[@id='%s']";
    private final static int WAIT_TIMEOUT_SECONDS = 30;
    private final String label;


    public InputField(String label) {
        this.label = label;
    }

    public void writeText(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath(String.format(INPUT_XPATH, label)))).sendKeys(text);
    }

}
