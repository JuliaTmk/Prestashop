package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.WomenItemsPageService;

public class WomenItemsPageTest extends BaseTest {

    private WomenItemsPageService womenItemsPageService = new WomenItemsPageService();

    @Test(priority = 1)
    public void openWomenItemsPageTest() {
        String expectedTextOfWomenItemsPage = "WOMEN";
        String actualTextOfWomenItemsPage = womenItemsPageService.openWomenItemsPage()
                .getTextOfTitleOfWomenItemsPage();
        Assert.assertEquals(actualTextOfWomenItemsPage,expectedTextOfWomenItemsPage,
                "The actual title of the page does not match expected!");
    }

    @Test(priority = 2)
    public void selectItemTest() {
        String selectedItemLabel = "Black blouse with flowers";
        String actualItemLabel = womenItemsPageService.selectItemToBy(selectedItemLabel);
        Assert.assertEquals(actualItemLabel,selectedItemLabel,
                "The actual title of the item does not match expected!");
    }

    /*
    <test name="Women Items Page Test">
        <classes>
            <class name="tests.WomenItemsPageTest"></class>
        </classes>
    </test>
     */


}
