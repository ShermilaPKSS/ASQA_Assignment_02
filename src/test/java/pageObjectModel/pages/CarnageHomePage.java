package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarnageHomePage extends BasePage{

    public CarnageHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='group h-full item-2']")
    public WebElement womenMenu;

    @FindBy(xpath = "//div[@class='space-y-1']/a[@href='/collections/womens-hoodies-and-jackets']")
    public WebElement womenMenuItem;

    @FindBy(xpath = "//a[@class='button w-fit']")
    public WebElement shopSaleButton;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void hoverAndSelectWomenMenuItem() {

        // Use Actions class to hover over the predefined "Women" menu element
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).perform();
    }

    public <T> T clickHoodiesButton (){
        // Wait for the "HOODIES & JACKETS" link to become visible in the dropdown, then click it
        wait.until(ExpectedConditions.visibilityOf(womenMenuItem));
        womenMenuItem.click();

        // Add assertions to verify that the page navigates correctly
        wait.until(ExpectedConditions.titleContains("Women's Hoodies and Jackets"));
        return (T) PageFactory.initElements(driver, CarnageHoodiesPage.class);
    }

    public void scrollPage(int x, int y) {
        new Actions(driver).scrollByAmount(x, y).perform();
    }

    public <T> T clickShopSaleButton() {
        wait.until(ExpectedConditions.visibilityOf(shopSaleButton));
        shopSaleButton.click();

        wait.until(ExpectedConditions.titleContains("Black Friday"));
        return (T) PageFactory.initElements(driver, BlackFridayPage.class);
    }
}
