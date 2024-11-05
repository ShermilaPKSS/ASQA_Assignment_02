package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public CarnageHomePage loadUrl(String url) {
        driver.get(url);
        return PageFactory.initElements(driver, CarnageHomePage.class);
    }
}
