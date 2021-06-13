package Untilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginVyTrack {
    public static void logInSalesManager149(WebDriver driver){
        WebElement usernaneBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernaneBox.sendKeys("salesmanager149");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser123");
        WebElement rememberCheckBox = driver.findElement(By.xpath("//span[@class='custom-checkbox__icon']"));
        rememberCheckBox.click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    public static void logInSalesUser48(WebDriver driver){
//        String user = ConfigurationReader.getProperty("userName");
//        String pas= ConfigurationReader.getProperty("password");
        WebElement usernaneBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernaneBox.sendKeys("user48");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser123");
        WebElement rememberCheckBox = driver.findElement(By.xpath("//span[@class='custom-checkbox__icon']"));
        rememberCheckBox.click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

}
