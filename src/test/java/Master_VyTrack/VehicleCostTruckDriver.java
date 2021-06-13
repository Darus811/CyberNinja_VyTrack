package Master_VyTrack;

import Untilities.ConfigurationReader;
import Untilities.LoginVyTrack;
import Untilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;
import java.util.concurrent.TimeUnit;

public class VehicleCostTruckDriver {

    WebDriver driver;
    @BeforeClass
    public void setBrowser(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("dataVytrack");
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        LoginVyTrack.logInSalesUser48(driver);
    }


    @Test
    public void vehicle_cost(){

    }

}
