package Untilities;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.VyTrackPageTanya;

public class VyTrack_Utility extends VyTrackPageTanya {
    public static void login() {
        String storeManagerUsername = "Salesmanager149";
        String storeManagerPassword = "UserUser123";

        inputUsername.sendKeys(storeManagerUsername);
        inputPassword.sendKeys(storeManagerPassword);
        logInButton.click();
    }

    public static void clickVehicle() {
        fleetButton.click();
        BrowserUtils.sleep(1);
        vehicleButton.click();
    }

    public static int getCoordinates() {
        Point point = gridSettingsButton.getLocation();
        int xPosition = point.getX();
        int yPosition = point.getY();
        return xPosition + yPosition;
        //        int yCoordinates = point.getY();
//        System.out.println("Element's Position from left side is: " + xCoordinates + " pixels.");
//        System.out.println("Element's Position from top is: " + yCoordinates + " pixels.");
    }

    public static boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
