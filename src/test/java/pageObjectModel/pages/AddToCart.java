package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart extends BasePage{
    public AddToCart(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//h5[text()='Add to Cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='cart-increment-btn']")
    public WebElement incrementIcon;

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void increaseCount() {
        wait.until(ExpectedConditions.elementToBeClickable(incrementIcon));
        incrementIcon.click();
    }
}
