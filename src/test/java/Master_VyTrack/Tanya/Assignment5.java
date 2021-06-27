package Master_VyTrack.Tanya;

import Untilities.BrowserUtils;
import Untilities.Driver;
import Untilities.VyTrack_Utility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment5 extends VyTrack_Utility{
    @BeforeClass
    public void getDriver() {
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
        VyTrack_Utility.login();
        BrowserUtils.sleep(2);
        VyTrack_Utility.clickVehicle();
    }

    @Test(priority = 1)
    public void checkGridButtonLocation() {
        // Grid Setting button is on the right of the page
        Assert.assertTrue(getCoordinates() > (getCoordinates() / 2));


    }

    @Test(priority = 2)
    public void clickGridSettingButton() {
        // Store Manager should be able to click Grid Settings button
        Assert.assertTrue(isClickable(gridSettingsButton), "Grid Settings button is not clickable");

    }

    @AfterClass
    public void tearDown() {
        Driver.getDriver().quit();
    }
}
