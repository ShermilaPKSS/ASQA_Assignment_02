package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    @FindBy(xpath = "//input[@class='max-xl:hidden placeholder:text-[var(--text-color)]']")
    public WebElement searchField;

    @FindBy(xpath = "//input[@id='Search']")
    public WebElement searchInputLocator;

    @FindBy(xpath = "//button[@class='w-full md:w-1/4']")
    public WebElement searchIcon;

    @FindBy(xpath = "//a[@href='https://careers.incarnage.com/']")
    public WebElement careersButton;

    @FindBy(xpath = "//div[contains(@class, 'flex') and contains(@class, 'flex-col') and contains(@class, 'items-start') and contains(@class, 'space-y-1') and contains(@class, 'w-full')]//a[6]\n")
    public WebElement requestButton;

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

    public void searchText(String query) throws InterruptedException {
        // Click on the search icon
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.click();

        // Wait for the search input to become visible in the popup
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOf(searchInputLocator));

        // Clear any pre-existing text
        searchInput.clear();

        // Send keys one by one with a delay
        for (char c : query.toCharArray()) {
            searchInput.sendKeys(Character.toString(c));
            Thread.sleep(1000); // Adding a slight delay (1000 ms)
        }

        // Assertion to check if the search input field is displayed (indicating that the popup is displayed)
        Assert.assertTrue(searchInput.isDisplayed(), "Search input is not displayed.");

        System.out.println("Search popup is displayed, and search text entered successfully.");
    }

    public <T> T clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchIcon));
        searchIcon.click();
        return (T) PageFactory.initElements(driver, BagPage.class);
    }

    public <T> T clickCareersButton() {
        wait.until(ExpectedConditions.visibilityOf(careersButton));
        careersButton.click();

        return (T) PageFactory.initElements(driver, JobDisplay.class);
    }

    public <T> T submitRequestButton() {
        wait.until(ExpectedConditions.visibilityOf(requestButton));
        requestButton.click();

        return (T) PageFactory.initElements(driver, CarnageSupport.class);
    }
}
