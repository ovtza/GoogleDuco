package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class GoogleHomepage extends AbstractPage {

    WebDriver driver;

    final By searchButton = By.xpath("(//input[@name='btnK'])[2]");
    final By settingsButton = By.xpath("//div[@class='ayzqOc pHiOh']");
    final By switchThemesButton = By.xpath("//div[@id='YUIDDb']");
    final By darkThemeElm = By.xpath("//*[name()='path' and contains(@d,'M12,3c-4.9')]");
    final By feelingLuckyButton = By.xpath("(//input[@name='btnI'])[2]");

    public GoogleHomepage(WebDriver driver){
        super(driver);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }

    public void clickOnFeelingLuckyButton(){
        driver.findElement(feelingLuckyButton).click();
    }

    public void clickOnSettingsButton(){
        driver.findElement(settingsButton).click();
    }

    public void clickOnChangeThemeButton(){
        driver.findElement(switchThemesButton).click();
    }

    public By getDarkThemeElm(){
        return darkThemeElm;
    }

    public By getSwitchThemesButton(){
        return switchThemesButton;
    }
}
