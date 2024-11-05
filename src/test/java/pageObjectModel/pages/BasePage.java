package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pageObjectModel.pages.NikeHomePage;

public class BasePage {
    protected WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public NikeHomePage loadUrl(String url) {
        driver.get(url);
        return PageFactory.initElements(driver, NikeHomePage.class);
    }

}
