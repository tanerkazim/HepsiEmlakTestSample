package pages;

import base.TestBase;
import org.openqa.selenium.By;
public class MainPage {
    static By BTN_SATILIK_NATIVE = By.cssSelector(".btn-search[href*=\"/satilik\"]");
    static By BTN_KIRALIK_NATIVE = By.cssSelector(".btn-search[href*=\"/kiralik\"]");

    public static void openMainPage(){
        TestBase.navigate_to("http://www.hepsiemlak.com/");
    }

    public static void check(){
        TestBase.wait_for_element(BTN_SATILIK_NATIVE);
        TestBase.wait_for_element(BTN_KIRALIK_NATIVE);
    }
    public static void clickOnSatilik(){
        TestBase.wait_for_element(BTN_SATILIK_NATIVE).click();
    }

    public static void clickOnKiralik(){
        TestBase.wait_for_element(BTN_KIRALIK_NATIVE).click();
    }
}
