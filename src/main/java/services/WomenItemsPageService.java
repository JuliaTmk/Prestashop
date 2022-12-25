package services;

import model.User;
import pages.WomenItemsPage;

public class WomenItemsPageService {

    protected static WomenItemsPage womenItemsPage;

    public static WomenItemsPage openWomenItemsPage() {
        User user = new User();
        LoginPageService.login(user)
                .clickOnWomenItemsPageButton();
        return new WomenItemsPage();
    }

    public String selectItemToBy(String itemLabel) {
        womenItemsPage = new WomenItemsPage();
        return womenItemsPage.selectItemToBy(itemLabel)
                .getTextOfSelectedItem();
    }







}
