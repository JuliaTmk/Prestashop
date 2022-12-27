package services;

import io.qameta.allure.Step;
import pages.WomenItemsPage;


public class WomenItemsPageService {

    protected static WomenItemsPage womenItemsPage;
    public static final String WOMEN_ITEMS_PAGE_URL = "http://prestashop.qatestlab.com.ua/ru/3-women";

    public static final String EXPECTED_SUCCESS_COMMENT_MESSAGE_TEXT = "Новый комментарий";

    @Step("Open page with woman items")
    public static WomenItemsPage openWomenItemsPage() {
        womenItemsPage = new WomenItemsPage();
        womenItemsPage.openPage(WOMEN_ITEMS_PAGE_URL);
        return new WomenItemsPage();
    }

    @Step("Selecting item to oder")
    public String selectItemToBy(String itemLabel) {
        return womenItemsPage.selectItemToBy(itemLabel)
                .getTextOfSelectedItem();
    }

    @Step("Writing comment for selected item")
    public String leftComment(String commentTitleText, String commentContentText) {
        return womenItemsPage.clickCommentField()
                .inputCommentTitle(commentTitleText)
                .inputCommentContent(commentContentText)
                .clickSendCommentButton()
                .getTextOfSuccessCommentMessage();
    }

}
