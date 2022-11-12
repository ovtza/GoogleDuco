package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage extends AbstractPage {

    WebDriver driver;
    final By nextPageButton = By.cssSelector("a[id='pnnext'] span[class='SJajHc NVbCr']");
    final By resultStats = By.cssSelector("div[class='LHJvCe'] div");
    final By firstSuggestion = By.xpath("//div[@class='mkHrUc']//li[1]");

    //Duco chars
    final By dChar = By.xpath("//span[normalize-space()='d']");
    final By uChar = By.xpath("//span[normalize-space()='u']");
    final By cChar = By.xpath("//span[normalize-space()='c']");
    final By oChar = By.xpath("//span[normalize-space()='o']");

    public GoogleSearchpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToNextPageByClickingNextPageButton(){
        driver.findElement(nextPageButton).click();
    }

    public void clearSearchTypeForm(){
        driver.findElement(searchInput).clear();
    }

    public String getResultStats(){
        return driver.findElement(resultStats).getText();
    }

    public String getFirstSearchSuggestionText(){
        return driver.findElement(firstSuggestion).getText();
    }

    public void clickOnFirstSearchSuggestion(){
        driver.findElement(firstSuggestion).click();
    }

    public void typeDucoUsingGoogleKeyboard(){
        driver.findElement(dChar).click();
        driver.findElement(uChar).click();
        driver.findElement(cChar).click();
        driver.findElement(oChar).click();
    }
}
