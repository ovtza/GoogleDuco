import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomepage;
import java.time.Duration;

public class HomepageTests {

    WebDriver driver;
    GoogleHomepage googleHomepage;
    final String googleHomepageUrl = "https://www.google.com/";
    final String googleDoodlesUrl = "https://www.google.com/doodles";

    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        googleHomepage = new GoogleHomepage(driver);
        googleHomepage.isAt(googleHomepageUrl);
        googleHomepage.clickOnAcceptTermsButton();
    }

    @AfterMethod
    public void AfterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void searchDucoByClickingSearchButton(){
        googleHomepage.typeSearchTerm("duco");
        googleHomepage.clickOnSearchButton();

        Assert.assertTrue(googleHomepage.getTitle().startsWith("duco"));
        Assert.assertTrue(googleHomepage.getUrl().startsWith(googleHomepageUrl + "search?q=duco"));
    }

    @Test
    public void userIsAbleToClickFeelingLuckyButton(){
        googleHomepage.clickOnFeelingLuckyButton();

        Assert.assertEquals(googleHomepage.getTitle(), "Doodle Google");
        Assert.assertEquals(googleHomepage.getUrl(), googleDoodlesUrl);
    }

    @Test
    public void userIsAbleToSwitchBetweenThemes() {
        googleHomepage.clickOnSettingsButton();
        googleHomepage.clickOnChangeThemeButton();
        googleHomepage.clickOnSettingsButton();
        new Actions(driver)
                .clickAndHold(driver.findElement(googleHomepage.getSwitchThemesButton()))
                .perform();

        Assert.assertTrue(driver.findElement(googleHomepage.getDarkThemeElm()).isDisplayed());
    }

    @Test
    public void userHaveToTypeSomethingBeforeClickingSearchButton() {
        googleHomepage.isAt(googleHomepageUrl);
        googleHomepage.clickOnSearchButton();

        Assert.assertEquals(googleHomepageUrl, googleHomepage.getUrl());
    }
}
