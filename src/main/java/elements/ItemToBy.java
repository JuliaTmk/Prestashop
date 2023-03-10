package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemToBy {

    private static final int WAIT_TIMEOUT_SECONDS = 30;
    private static final String ITEM_XPATH = "(//a[@title='%s'])[2]";
    private WebDriver driver = DriverSingleton.getInstance().getDriver();
    private String itemLabel;

    public ItemToBy(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public void ClickItemToBy(){
        new WebDriverWait (driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(ITEM_XPATH,itemLabel))))
                .click();
    }

}
