package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlackFridayPage extends BasePage {
    public BlackFridayPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        @FindBy(xpath = "//div[text()='Availability']")
        public WebElement availabilityDropdown;

        @FindBy(xpath = "//div[text()='In stock']")
        public WebElement inStock;

        public void selectAvailabilityDropdown() {
            wait.until(ExpectedConditions.visibilityOf(availabilityDropdown));
            availabilityDropdown.click();
        }

        public <T> T selectAvailabilityCheckbox() {
            wait.until(ExpectedConditions.visibilityOf(inStock));
            inStock.click();
            return (T) PageFactory.initElements(driver, InStockPage.class);
        }
}
