package page;

import Untilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackPageTanya {
    public VyTrackPageTanya() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public static WebElement inputUsername;

    @FindBy(id = "prependedInput2")
    public static WebElement inputPassword;

    @FindBy(id = "_submit")
    public static WebElement logInButton;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public static WebElement fleetButton;

    @FindBy(xpath = "//a[@href='entity/Extend_Entity_Carreservation']")
    public static WebElement vehicleButton;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public static WebElement gridSettingsButton;
}
