package Master_VyTrack;

import Untilities.BrowserUtils;
import Untilities.LoginVyTrack;
import Untilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrack_VehiclePage {

    WebDriver driver;

    @BeforeClass
    public void WebBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/");
    }

    @Test
    public void logIn_fleet_vehicle() throws InterruptedException {
        //LOGIN
        LoginVyTrack.logInSalesManager149(driver);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //CHECK IF THE PAGE IS WHAT NEEDED
        String role = "Sales Manager #149";
        String expHomePageMainWord = "Dashboard";
        WebElement title = driver.findElement(By.xpath("//script[@id='page-title']"));
        String actualTitle = title.getText();
        System.out.println(actualTitle);
//        Assert.assertTrue(actualTitle.equals(expHomePageMainWord));

        driver.navigate().refresh();
        BrowserUtils.sleep(3);
        //Fleet Page
        WebElement Fleet = driver.findElement(By.xpath("//i[@class='fa-asterisk menu-icon']/.."));
        Fleet.click();
        Thread.sleep(3000);
        //Action action = new Action(driver);

        //Vehicle Page
        WebElement vchl = driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
        vchl.click();
        //Check if it is as expected
        String actualTitleVchl = driver.getTitle();
        String expectedTitle = "Dashboard";
        System.out.println(actualTitleVchl.equals(expectedTitle) ? "You are on the Vehicles Page" : "You are on the wrong page");
        System.out.println(driver.getTitle());

        //------------
        //CREATE A CAR
        WebElement createCar = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCar.click();
        //Add information for the new car
        Thread.sleep(1000);
        //License Plate
        WebElement licensePlate = driver.findElement(By.cssSelector("input[name='custom_entity_type[LicensePlate]']"));
        licensePlate.sendKeys("VAE12");
        //Tags
        WebElement tags = driver.findElement(By.xpath("//input[@data-name='field__5']"));
        Thread.sleep(1000);
        tags.click();
        //Driver Name
        WebElement driverName = driver.findElement(By.xpath("//input[@name='custom_entity_type[Driver]']"));
        driverName.sendKeys("Nasha Ti");
        //License Plate
        WebElement location = driver.findElement(By.xpath("//input[@name='custom_entity_type[Location]']"));
        location.sendKeys("VA");
        //Chassis Number
        WebElement chassisNumber = driver.findElement(By.xpath("//input[@name='custom_entity_type[ChassisNumber]']"));
        chassisNumber.sendKeys("287665");
        //Model Year
        WebElement modelYear = driver.findElement(By.xpath("//input[@name='custom_entity_type[ModelYear]']"));
        modelYear.sendKeys("2019");
        //Model Year
//        WebElement lastOdometer = driver.findElement(By.xpath("//input[@name='custom_entity_type[LastOdometer]']"));
//        lastOdometer.sendKeys("9877");
        //----------------------

        //add Vehicle Model
        Thread.sleep(3000);
        WebElement vehicleModel = driver.findElement(By.xpath("//button[@type='button']"));
        vehicleModel.click();

        WebElement checkBoxModel = driver.findElement(By.xpath("//td[@class=\"boolean-cell grid-cell grid-body-cell grid-body-cell-assigned\"]//input[1]"));
        Thread.sleep(3000);
        System.out.println("Model is - ");
        checkBoxModel.getText();
        checkBoxModel.click();

        Thread.sleep(2000);
        WebElement selectButton = driver.findElement(By.xpath("//button[@data-action-name='select']"));
        selectButton.click();

        //Add Vehicle Make
        Thread.sleep(3000);
        WebElement vehicleMake = driver.findElement(By.xpath("(//button[@class='btn btn-medium add-btn'])[2]"));
        vehicleMake.click();

        WebElement checkBoxMake = driver.findElement(By.xpath("(//td[@data-column-label='Assigned'])[2]"));
        Thread.sleep(3000);
        checkBoxMake.click();

        Thread.sleep(1000);
        WebElement selectButton2 = driver.findElement(By.xpath("//button[@data-action-name='select']"));
        selectButton2.click();

        //Save
        WebElement saveClose = driver.findElement(By.xpath("//div//button[@class='btn btn-success action-button']/.."));
        saveClose.click();

        //edit car
        WebElement editCar = driver.findElement(By.xpath("//a[@class='btn back icons-holder-text edit-button main-group']"));
        editCar.click();

        //add edition
        WebElement sitNumber = driver.findElement(By.xpath("//input[@data-name='field__seats-number']"));
        sitNumber.sendKeys("2");

        //Save
        Thread.sleep(3000);
        WebElement saveClose2 = driver.findElement(By.xpath("//div//button[@class='btn btn-success action-button']/.."));
        saveClose2.click();

        //3TS - Delete the car
        Thread.sleep(1500);
        WebElement deleteTheCar = driver.findElement(By.xpath("//a[@title='Delete Car']"));
        Thread.sleep(3000);
        deleteTheCar.click();

        //Delete button
        Thread.sleep(3000);
        WebElement deleteButton = driver.findElement(By.xpath("//a[@class=\"btn ok btn-danger\"]"));
        deleteButton.click();
    }

      @AfterClass
              public void quit () throws InterruptedException {
            Thread.sleep(5000);
            driver.quit();
    }
}
