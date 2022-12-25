package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemToBy {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private final static int WAIT_TIMEOUT_SECONDS = 30;
    private static final String BUTTON_XPATH = "//a[@title='%s']/ancestor::div[@class='right-block']//a[@title='Add to cart']";
    private static final String ELEMENT_XPATH = "//a[@title='%s']";
    private String label;

   // public AddToCartButton(String label) {
  //      this.label = label;
  //  }

   /* public void addItemToTheCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(ELEMENT_XPATH,label)))).click().build();
        //driver.findElement((By.xpath(String.format(BUTTON_XPATH,label)))).click();
    } */

    public void addItemToTheCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[2]"))).click().build();
        //driver.findElement((By.xpath(String.format(BUTTON_XPATH,label)))).click();
    }


}
