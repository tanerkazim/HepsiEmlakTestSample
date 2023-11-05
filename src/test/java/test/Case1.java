package test;

import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.SearchPage;

import java.util.List;

public class Case1 {
    String[] desired_filters = {"İzmir","Bornova","İşyeri","1.000.000 TL - 20.000.000 TL","Sıfır Bina","1-5", "6-10"};

    @Before
    public void setUp(){
        TestBase.setDriver();
    }

    @Test
    public void webTest(){

        MainPage.openMainPage();
        MainPage.check();
        MainPage.clickOnSatilik();

        SearchPage.check();
        SearchPage.setCityInput("İzmir");
        SearchPage.setCountyInput("Bornova");
        SearchPage.selectBuildingCategory("İşyeri");
        SearchPage.setPriceMinInput("1.000.000");
        SearchPage.setPriceMaxInput("20.000.000");
        SearchPage.pickBuildingAge(new String[] {"Sıfır Bina", "1-5", "6-10"});
        SearchPage.search();
        SearchPage.check();

        List<String> applied_filters = SearchPage.getAppliedFilters();
        for (String filter: desired_filters) {
            assert applied_filters.contains(filter);
        }

    }

    @After
    public void tearDown(){
        TestBase.tear_down();
    }

}
