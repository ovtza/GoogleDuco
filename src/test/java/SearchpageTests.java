import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleSearchpage;

import java.time.Duration;

public class SearchpageTests {

    WebDriver driver;
    GoogleSearchpage googleSearchpage;
    final String googleDucoSearchpageUrl = "https://www.google.com/search?q=duco";

    @BeforeMethod
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        googleSearchpage = new GoogleSearchpage(driver);
        googleSearchpage.isAt(googleDucoSearchpageUrl);
        googleSearchpage.clickOnAcceptTermsButton();
    }

    @AfterMethod
    public void AfterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void userIsAbleToChangeSearchPages(){
        googleSearchpage.setPolishLanguage();
        googleSearchpage.isAt(googleDucoSearchpageUrl);
        googleSearchpage.goToNextPageByClickingNextPageButton();
        googleSearchpage.goToNextPageByClickingNextPageButton();

        Assert.assertTrue(googleSearchpage.getResultStats().startsWith("Strona 3"));
    }

    @Test
    public void serachSuggestionsAreClickable() {
        googleSearchpage.clearSearchTypeForm();
        googleSearchpage.typeSearchTerm("Duco company");
        String firstSuggestion = googleSearchpage.getFirstSearchSuggestionText();
        googleSearchpage.clickOnFirstSearchSuggestion();

        Assert.assertTrue(googleSearchpage.getTitle().startsWith(firstSuggestion));
    }

    @Test
    public void searchDucoUsingGoogleKeyboard() {
        googleSearchpage.clearSearchTypeForm();
        googleSearchpage.clickOnKeyboardElm();
        googleSearchpage.typeDucoUsingGoogleKeyboard();
        driver.findElement(googleSearchpage.getSearchInput()).submit();

        Assert.assertTrue(googleSearchpage.getTitle().startsWith("duco"));
    }

    @Test
    public void firstResultFromSearchEngineIsPossibleToOpen() {
        String targetUrl = googleSearchpage.getFirstResultUrl();
        googleSearchpage.clickOnFirstSearchResult();

        Assert.assertEquals(googleSearchpage.getUrl(), targetUrl);
    }
}
