package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    WebDriver driver;
    final By searchInput = By.name("q");
    final By acceptTermsButton = By.cssSelector("button[id='L2AGLb'] div[role='none']");
    final By googleKeyBoardElm = By.xpath("(//span[@class='ly0Ckb'])[1]");

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public void setPolishLanguage(){
        driver.get("https://www.google.com/preferences#languages");
        driver.findElement(By.xpath("//div[@data-value='pl']//span[@class='jfk-radiobutton-radio']")).click();
        driver.findElement(By.xpath("//div[@class='goog-inline-block jfk-button jfk-button-action']")).click();
        driver.switchTo().alert().accept();
    }

    public void typeSearchTerm(String term){
        driver.findElement(searchInput).sendKeys(term);
    }

    public void clickOnAcceptTermsButton(){
        driver.findElement(acceptTermsButton).click();
    }

    public void isAt(String url){
        driver.get(url);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickOnKeyboardElm(){
        driver.findElement(googleKeyBoardElm).click();
    }

    public By getSearchInput(){
        return searchInput;
    }
}
