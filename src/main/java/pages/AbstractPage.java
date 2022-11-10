package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    WebDriver driver;

    public AbstractPage(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "C:/chromedrivers/chromedriver.exe");
        this.driver = driver;
    }

    public void isAt(String url){
        driver.get(url);
    }
}
