package Master_VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class triel {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //go to the VyTrack web page
        driver.get("https://qa3.vytrack.com/entity/update/Extend_Entity_Carreservation/item");
        driver.manage().window().maximize();
        //Create WebElement UserName text box, password, rememberCheckBox, LoginButton
        WebElement usernaneBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernaneBox.sendKeys("salesmanager149");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser123");
        WebElement rememberCheckBox = driver.findElement(By.xpath("//span[@class='custom-checkbox__icon']"));
        rememberCheckBox.click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        driver.navigate().refresh();
        //Close the error window that is shows on the page
        Thread.sleep(3000);
        WebElement x = driver.findElement(By.xpath("//button[@type='button']"));
        x.click();

        //add Vehicle Module
        Thread.sleep(3000);
        //refresh
        driver.navigate().refresh();
        WebElement vehicleModule = driver.findElement(By.xpath("//button[@name='temp-validation-name-93']"));
        vehicleModule.click();
    }
}
