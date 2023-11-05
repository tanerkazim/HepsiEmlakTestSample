package test;

import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.ProductPage;
import pages.SearchPage;

import java.util.List;

public class Case2 {

    @Before
    public void setUp(){
        TestBase.setDriver();
    }

    @Test
    public void webTest(){

        MainPage.openMainPage();
        MainPage.check();
        MainPage.clickOnKiralik();

        SearchPage.check();
        SearchPage.setCityInput("Ankara");
        SearchPage.setCountyInput("Çankaya");
        SearchPage.selectBuildingCategory("Konut");
        SearchPage.pickRoomType("2+1");
        SearchPage.pickWithinSiteOption("Evet");
        SearchPage.search();
        SearchPage.check();
        SearchPage.clickNthSearchResult("3");

        ProductPage.check();
        List<String> phone_numbers = ProductPage.getPhoneNumbers();
        for (String num:
                phone_numbers) {
            assert ((num.contains("+905") || num.contains("+90312")) && num.length() == 17);
        }

    }

    @After
    public void tearDown(){
        TestBase.tear_down();
    }
}
