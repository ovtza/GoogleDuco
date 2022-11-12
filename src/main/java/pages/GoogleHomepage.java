package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class GoogleHomepage extends AbstractPage {

    WebDriver driver;

    final By searchButton = By.xpath("(//input[@name='btnK'])[2]");
    final By settingsButton = By.xpath("//div[@class='ayzqOc pHiOh']");
    final By switchThemesButton = By.xpath("//div[@id='YUIDDb']");
    final By darkThemeElm = By.xpath("//*[name()='path' and contains(@d,'M12,3c-4.9')]");
    final By feelingLuckyButton = By.xpath("(//input[@name='btnI'])[2]");

    private final Logger log = LogManager.getLogger(getClass());

    public GoogleHomepage(WebDriver driver){
        super(driver);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickOnSearchButton(){
        log.info("Clicking the search button");
        driver.findElement(searchButton).click();
    }

    public void clickOnFeelingLuckyButton(){
        log.info("Clicking the feeling lucky button");
        driver.findElement(feelingLuckyButton).click();
    }

    public void clickOnSettingsButton(){
        log.info("Clicking the setting button");
        driver.findElement(settingsButton).click();
    }

    public void clickOnChangeThemeButton(){
        log.info("Clicking switch theme button");
        driver.findElement(switchThemesButton).click();
    }

    public By getDarkThemeElm(){
        return darkThemeElm;
    }

    public By getSwitchThemesButton(){
        return switchThemesButton;
    }
}
