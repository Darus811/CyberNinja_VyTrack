package Master_VyTrack;

import Untilities.BrowserUtils;
import Untilities.LoginVyTrack;
import Untilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class doubleTry {
    WebDriver driver;

    @BeforeClass
    public void WebBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/");
    }

    @Test
    public void logIn_fleet_vehicle() throws InterruptedException {
        //LOGIN
        LoginVyTrack.logInSalesUser48(driver);
        //remove the alert
        driver.navigate().refresh();

        //Hover on the Fleet --> Vehicle Cost
        BrowserUtils.sleep(1);
        Actions action = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("//i[@class='fa-asterisk menu-icon']/.."));
        action.moveToElement(fleet).click().perform();
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("//span[.='Vehicle Costs']")).click();
    }
//    @Test
//    public void checkThePage(){
//        //refreshButton
//        BrowserUtils.sleep(1);
//      driver.findElement(By.xpath("//div[@class='pull-right grid-toolbar-tools']"));
//      BrowserUtils.sleep(1);
//        WebElement refresh = driver.findElement(By.xpath("//div[@class='actions-panel pull-right form-horizontal']//a[@title='Refresh']"));
//        refresh.click();
//    }

    @Test
    public void set100View(){
        //set on 100 views
        BrowserUtils.sleep(3);
        driver.findElement(By.xpath("(//div[@class='btn-group'])[3]")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("(//a[@class='dropdown-item'])[4]")).click();
    }


    @AfterClass
    public void quit () throws InterruptedException {
        Thread.sleep(100000);
        driver.quit();
    }
}
