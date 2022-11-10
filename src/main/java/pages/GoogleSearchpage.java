package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchpage extends AbstractPage {

    WebDriver driver;

    @FindBy(name = "q")
    WebElement searchInputElement;
    private final By searchInput = By.name("q");

    public GoogleSearchpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
