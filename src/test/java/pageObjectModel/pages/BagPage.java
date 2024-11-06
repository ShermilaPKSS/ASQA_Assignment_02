package pageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BagPage extends BasePage {

    public BagPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//div[contains(@class, 'grid grid-cols-2 md:grid-cols-4 gap-4 md:gap-4 xl:gap-10')]//div[contains(@class, 'product-card')][1]")
    public WebElement firstBag;

    public <T> T clickFirstBag() {
        wait.until(ExpectedConditions.elementToBeClickable(firstBag));
        firstBag.click();

        return (T) PageFactory.initElements(driver, AddToCart.class);
    }



}
