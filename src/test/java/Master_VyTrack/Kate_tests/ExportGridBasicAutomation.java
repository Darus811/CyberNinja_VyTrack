package Master_VyTrack.Kate_tests;

import Untilities.BrowserUtils;
import Untilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExportGridBasicAutomation {

    @Test
    public void export_grid_button_click() {
        //opening the link and logging in
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("user48");
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        //activating actions and navigating to the fleet management
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        actions.moveToElement(fleet).perform();
        BrowserUtils.sleep(2);
        WebElement vehicles = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        vehicles.click();

        //locating export Grid and clicking
        WebElement exportGrid = Driver.getDriver().findElement(By.xpath("(//a[@href='#'])[12]"));
        exportGrid.click();
        //verifying that the btn is displayed
        Assert.assertTrue(exportGrid.isDisplayed(), "ERROR, ExportGrid button is not displayed");

    }

    @Test
    public void export_grid_button_location() {
        //opening the link and logging in
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("user48");
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        //activating actions and navigating to the fleet management
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        actions.moveToElement(fleet).perform();
        BrowserUtils.sleep(2);
        WebElement vehicles = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        vehicles.click();

        //verifying that the Export Grid button is on the left
        String exportGridText = Driver.getDriver().findElement(By.cssSelector(".pull-left.grid-toolbar-mass-actions"))
                .getAttribute("class");
        System.out.println(exportGridText);
        Assert.assertTrue(exportGridText.contains("left"), "Error, export grid text doesn't contain left");
    }

}

