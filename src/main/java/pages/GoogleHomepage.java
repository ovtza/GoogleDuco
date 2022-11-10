package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomepage extends AbstractPage {

    private WebDriver driver;
    @FindBy(name = "q")
    WebElement searchInputElement;

    private final By searchButton = By.xpath("(//input[@name='btnK'])[2]");
    private final By acceptTermsButton = By.cssSelector("button[id='L2AGLb'] div[role='none']");
    private final By searchInput = By.name("q");

    public GoogleHomepage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAcceptTermsButton(){
        driver.findElement(acceptTermsButton).click();
    }

    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
//        searchButtonElement.click();
    }

    public void typeSearchTerm(String term){
        driver.findElement(searchInput).sendKeys(term);
    }
}
