package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    static By BTN_PHONE_NUMBER_WEB = By.cssSelector(".detail-sidebar .owner-phone-numbers-button");
    static By PHONE_NUMBERS_LIST = By.cssSelector(".detail-sidebar .owner-phone-numbers-list-wrapper:not([style*=\"display:none;\"])");
    static By PHONE_NUMBERS = By.cssSelector(".detail-sidebar .owner-phone-numbers-list a");
    static By SPEC_GROUPS = By.cssSelector(".spec-groups");

    public static void check(){
        TestBase.wait_for_element(BTN_PHONE_NUMBER_WEB);
        TestBase.wait_for_element(SPEC_GROUPS);
    }
    public static List<String> getPhoneNumbers(){
        List<String> numbers = new ArrayList<>();
        TestBase.scroll_to(SPEC_GROUPS);
        TestBase.wait_for_element(BTN_PHONE_NUMBER_WEB).click();
        TestBase.wait_for_element(PHONE_NUMBERS_LIST);
        List<WebElement> number_elements = TestBase.wait_for_all_elements(PHONE_NUMBERS);
        for (WebElement element: number_elements) {
            numbers.add(element.getAttribute("href"));
        }
        return numbers;
    }
}
