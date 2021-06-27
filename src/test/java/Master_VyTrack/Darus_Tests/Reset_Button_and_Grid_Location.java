package Master_VyTrack.Darus_Tests;

import Untilities.BrowserUtils;
import Untilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class Reset_Button_and_Grid_Location {
    @Test
    public void GridLocationTest(){
      // Going to VyTrack QA page
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

        //Logging in to Vytrack as Truck Driver
        WebElement loging = Driver.getDriver().findElement(By.id("prependedInput"));
        loging.sendKeys("User49");
        WebElement password = Driver.getDriver().findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement login = Driver.getDriver().findElement(By.id("_submit"));
        login.click();

        BrowserUtils.sleep(2);
        //Going to Vehicle Page
        WebElement Fleet = Driver.getDriver().findElement(By.xpath("//header/div[@id='main-menu']/ul[1]/li[1]/a[1]/span[1]"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Fleet).build().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[@id='main-menu']/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]")));


        WebElement Vehicles = Driver.getDriver().findElement(By.xpath("//header/div[@id='main-menu']/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
        actions.moveToElement(Vehicles);
        actions.click().build().perform();
        BrowserUtils.sleep(2);

        // Comparing Location of Reset Button To Grid Settings
        WebElement gridSetting = Driver.getDriver().findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/i[1]"));
        System.out.println("Grid Setting Button - " + gridSetting.getLocation());
        gridSetting.getLocation();

        WebElement reset = Driver.getDriver().findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[3]/i[1]"));
        System.out.println("Reset Button - "+reset.getLocation());
        BrowserUtils.sleep(2);

        //Testing Reset button by going to next page then reset to default page
        WebElement next = Driver.getDriver().findElement(By.xpath("//i[contains(text(),'Next')]"));
        next.click();
        BrowserUtils.sleep(2);

        reset.click();
        BrowserUtils.sleep(2);
        //Testing Reset button by changing default View Per Page to 100 then resetting
        WebElement dropdown = Driver.getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']")
        );
        dropdown.click();
        BrowserUtils.sleep(2);
        WebElement hundo = Driver.getDriver().findElement(By.xpath("//a[@data-size='100']"));
        hundo.click();
        BrowserUtils.sleep(2);

       /*Printing out webelements to make sure it is changing from View per Page of 100
        Back to default of 25
        */
        Driver.getDriver().findElements(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        List<WebElement> listElement = Driver.getDriver().findElements(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        for(int i =0;i<listElement.size();i++) {
            String elementText = listElement.get(i).getText();
            System.out.print(elementText);
        }
        System.out.println(listElement.size());

        reset.click();
        BrowserUtils.sleep(2);
        System.out.println(" ====================");

        Driver.getDriver().findElements(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        List<WebElement> listElement2 = Driver.getDriver().findElements(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate']"));
        for(int i =0;i<listElement2.size();i++) {
            String elementText = listElement2.get(i).getText();
            System.out.print(elementText);
        }
        System.out.println("===============");
        System.out.println(listElement2.size());
    }


}
