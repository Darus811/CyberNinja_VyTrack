package Untilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static void main(String[] args) {
        getDriver("google chrome");
    }

    public static WebDriver getDriver(String browserType) {
        String expGoogleBrowser = "Google Chrome";
        String expFirBrowser = "Firefox";
        if (browserType.equalsIgnoreCase(expFirBrowser)) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        } else {
            WebDriverManager.chromedriver().setup();
            WebDriver googleDriver = new ChromeDriver();
            return googleDriver;
        }
    }
}
