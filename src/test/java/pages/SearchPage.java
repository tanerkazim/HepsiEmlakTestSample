package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    static By PICK_CITY = By.cssSelector(".locationCitySec");
    static By PICK_CITY_OPENED = By.cssSelector(".locationCitySec .he-select-base__dropdown:not([style*=\"display:none;\"])");
    static By SEARCH_CITY_INPUT = By.cssSelector(".js-city-filter input");
    static By DESIRED_CITY = By.cssSelector(".locationCitySec .he-select__list-item:first-child");
    static By PICK_COUNTY = By.cssSelector(".locationCountySec");
    static By PICK_COUNTY_OPENED = By.cssSelector(".locationCountySec .he-select-base__dropdown:not([style*=\"display:none;\"])");
    static By SEARCH_COUNTY_INPUT = By.cssSelector(".js-county-filter input");
    static By DESIRED_COUNTY = By.cssSelector(".locationCountySec .he-multiselect__list-item:first-child");
    public static By RADIO_BTN_KATEGORI(String category){
        return By.xpath(String.format("//*[@class=\"md-radio\"][.//*[contains(text(),\"%s\")]]", category) );
    }
    static By PRICE_MIN_INPUT = By.id("priceMin");
    static By PRICE_MAX_INPUT = By.id("priceMax");
    static By BUILDING_AGE = By.cssSelector(".buildingAgeSec .filter-item-inner");
    static By BUILDING_AGE_LIST = By.cssSelector(".buildingAgeSec .dropdown-list:not([style*=\"display:none;\"])");
    public static By DESIRED_BUILDING_AGE(String buildingAge){
        return By.xpath(String.format("//*[@class=\"buildingAgeSec\"]//span[text()=\"%s\"]", buildingAge));
    }
    static By ROOM_TYPE = By.cssSelector(".roomTypeSec .filter-item-inner");
    static By ROOM_TYPE_LIST = By.cssSelector(".roomTypeSec .dropdown-list:not([style*=\"display:none;\"])");
    public static By DESIRED_ROOM_TYPE(String roomType){
        return By.xpath(String.format("//*[@class=\"roomTypeSec\"]//span[text()=\"%s\"]", roomType));
    }
    static By WITHIN_SITE = By.cssSelector(".js-within-site-filter .he-control-base__field");
    static By WITHIN_SITE_DROPDOWN_LIST = By.cssSelector(".js-within-site-filter .he-select-base__dropdown:not([style*=\"display:none;\"])");
    public static By DESIRED_WITHIN_SITE_OPTION(String option){
        return By.xpath(String.format("//*[@class=\"js-within-site-filter\"]//li[span[text()=\"%s\"]]", option));
    }
    static By HEATING_TYPE_AREA = By.cssSelector(".heatingTypeSec .filter-item-inner");
    static By KEYWORD_SEARCH = By.id("keywordResult");
    static By BTN_SEARCH = By.cssSelector(".filter-button-wrapper .btn-red");
    static By SEARCH_PROGRESS = By.className("nuxt-progress");
    static By APPLIED_FILTERS = By.className("applied-filters-list-item");
    static By SEARCH_RESULTS = By.className("list-view-content");
    public static By NTH_SEARCH_RESULT(String nthChild){
        return By.cssSelector(String.format(".listing-item:nth-child(%s)", nthChild));
    }

    public static void check(){
        TestBase.wait_for_element(PICK_CITY);
        TestBase.wait_for_element(PICK_COUNTY);
        TestBase.wait_for_element(PRICE_MAX_INPUT);
        TestBase.wait_for_element(BTN_SEARCH);
    }
    public static void setCityInput(String cityInput){
        TestBase.wait_for_element(PICK_CITY).click();
        TestBase.wait_for_element(PICK_CITY_OPENED);
        TestBase.wait_for_element(SEARCH_CITY_INPUT).sendKeys(cityInput);
        TestBase.wait_for_element(DESIRED_CITY).click();
    }

    public static void setCountyInput(String countyInput){
        TestBase.wait_for_element(PICK_COUNTY).click();
        TestBase.wait_for_element(PICK_COUNTY_OPENED);
        TestBase.wait_for_element(SEARCH_COUNTY_INPUT).sendKeys(countyInput);
        TestBase.wait_for_element(DESIRED_COUNTY).click();
    }

    public static void selectBuildingCategory(String category){
        TestBase.wait_for_element(RADIO_BTN_KATEGORI(category)).click();
        TestBase.wait_for_element(SEARCH_PROGRESS);
        TestBase.wait_for_element_disappears(SEARCH_PROGRESS);
    }

    public static void setPriceMinInput(String minInput){
        TestBase.wait_for_element(PRICE_MIN_INPUT).sendKeys(minInput);
    }

    public static void setPriceMaxInput(String maxInput){
        TestBase.wait_for_element(PRICE_MAX_INPUT).sendKeys(maxInput);
    }

    public static void pickBuildingAge(String[] buildingAge){
        TestBase.scroll_to(HEATING_TYPE_AREA);
        TestBase.wait_for_element(BUILDING_AGE).click();
        TestBase.wait_for_element(BUILDING_AGE_LIST);
        for (String age :
                buildingAge) {
            TestBase.wait_for_element(DESIRED_BUILDING_AGE(age)).click();
        }
    }

    public static void pickRoomType(String roomType){
        TestBase.scroll_to(BUILDING_AGE);
        TestBase.wait_for_element(ROOM_TYPE).click();
        TestBase.wait_for_element(ROOM_TYPE_LIST);
        TestBase.wait_for_element(DESIRED_ROOM_TYPE(roomType)).click();
    }

    public static void pickWithinSiteOption(String option){
        TestBase.scroll_to(KEYWORD_SEARCH);
        TestBase.wait_for_element(WITHIN_SITE).click();
        TestBase.wait_for_element(WITHIN_SITE_DROPDOWN_LIST);
        TestBase.wait_for_element(DESIRED_WITHIN_SITE_OPTION(option)).click();
    }

    public static void search(){
        TestBase.wait_for_element(BTN_SEARCH).click();
        TestBase.wait_for_element(SEARCH_PROGRESS);
        TestBase.wait_for_element_disappears(SEARCH_PROGRESS);
    }

    public static void clickNthSearchResult(String nthResult){
        TestBase.wait_for_element(SEARCH_RESULTS);
        TestBase.wait_for_element(NTH_SEARCH_RESULT(nthResult)).click();
    }

    public static List<String> getAppliedFilters(){
        List<String> applied_filters = new ArrayList<>();
        List<WebElement> applied_filter_elements = TestBase.wait_for_all_elements(APPLIED_FILTERS);
        for (WebElement filter: applied_filter_elements) {
            applied_filters.add(filter.getText());
        }
        return applied_filters;
    }


}
