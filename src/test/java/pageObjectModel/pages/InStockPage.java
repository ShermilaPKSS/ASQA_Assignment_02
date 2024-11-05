package pageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InStockPage extends BasePage {

    public InStockPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Locator for the product container
    By productContainerLocator = By.id("CollectionTemplateProductsGrid");

    // Locator for individual product cards within the container
    By productCardLocator = By.cssSelector(".product-card");

    public <T> T clickFirstProductCard() {
        // Wait for the product container to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(productContainerLocator));

        // Find all product cards within the container
        List<WebElement> productCards = driver.findElements(productCardLocator);

        // Check if there is at least one product card
        if (!productCards.isEmpty()) {
            // Get the first product card
            WebElement firstProductCard = productCards.get(0);

            // Wait until the first product card is clickable
            wait.until(ExpectedConditions.elementToBeClickable(firstProductCard));

            // Click on the first product card
            firstProductCard.click();
            System.out.println("Clicked on the first product card.");

            // Return a new instance of the AddToCart page
            return (T) PageFactory.initElements(driver, AddToCart.class);
        } else {
            System.out.println("No product cards found.");
            return null; // Return null if no product cards are found
        }
    }
}