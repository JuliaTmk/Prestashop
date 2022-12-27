package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.WomenItemsPageService;

import static services.WomenItemsPageService.EXPECTED_SUCCESS_COMMENT_MESSAGE_TEXT;

public class WomenItemsPageTest extends BaseTest {

    private WomenItemsPageService womenItemsPageService = new WomenItemsPageService();

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        loginPageService.login(user);
    }
    @Test(priority = 1, alwaysRun = true)
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

    @Test(priority = 3)
    public void leftCommentTest() {
        String commentTitle = "Good";
        String commentContent = "I like this!";
        String actualSendCommentMessage = womenItemsPageService.leftComment(commentTitle,commentContent);
        Assert.assertEquals(actualSendCommentMessage,EXPECTED_SUCCESS_COMMENT_MESSAGE_TEXT,
                "The actual text of the message does not match expected!");
    }

    /*
    <test name="Women Items Page Test">
        <classes>
            <class name="tests.WomenItemsPageTest"></class>
        </classes>
    </test>
     */


}
