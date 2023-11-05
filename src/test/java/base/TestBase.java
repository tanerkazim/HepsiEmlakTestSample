package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestBase {

    static WebDriver driver;
    static WebDriverWait wait;
    static Random random = new Random();
    static Actions actions;

    public static void setDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome_options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        /*Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 5");
        chrome_options.setExperimentalOption("mobileEmulation", mobileEmulation);*/
        chrome_options.setExperimentalOption("prefs", prefs);
        chrome_options.addArguments("--lang=tr");
        driver = new ChromeDriver(chrome_options);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public static void navigate_to(String url){
        driver.get(url);
    }

    public static WebElement wait_for_element(By selector){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public static List<WebElement> wait_for_all_elements(By selector){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    public static void wait_for_element_disappears(By selector){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    public static void scroll_to(By selector){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            actions.scrollToElement(wait.until(ExpectedConditions.presenceOfElementLocated(selector))).perform();
        }
        catch (MoveTargetOutOfBoundsException exception){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tear_down(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}