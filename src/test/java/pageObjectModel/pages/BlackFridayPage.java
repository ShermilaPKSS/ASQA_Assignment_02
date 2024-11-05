package pageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlackFridayPage extends BasePage {
    public BlackFridayPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Locator for the product container
        By productContainerLocator = By.id("CollectionTemplateProductsGrid");

        // Locator for individual product cards within the container
        By productCardLocator = By.cssSelector(".product-card"); // Update with the actual class of each product card

        @FindBy(xpath = "//div[text()='Availability']")
        public WebElement availabilityDropdown;

        @FindBy(xpath = "//div[text()='In stock']")
        public WebElement inStock;

        @FindBy(xpath = "//*[@id='ProductCard-7293044981966']/div/div/div[1]/button")
        public WebElement quickAdd;

        public void selectAvailabilityDropdown() {
            wait.until(ExpectedConditions.visibilityOf(availabilityDropdown));
            availabilityDropdown.click();
        }

        public void selectAvailabilityCheckbox() {
            wait.until(ExpectedConditions.visibilityOf(inStock));
            inStock.click();
        }

        public void hoverOverFirstProductCard() {
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

                // Hover over the first product card
                Actions actions = new Actions(driver);
                actions.moveToElement(firstProductCard).perform();

                System.out.println("Hovered over the first product card.");
            } else {
                System.out.println("No product cards found.");
            }
        }

        public void setQuickAdd() {
            quickAdd.click();
        }
}
