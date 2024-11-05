package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarnageHoodiesPage extends BasePage {

    public CarnageHoodiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='size']")
    public WebElement sizeDropdown;

    @FindBy(xpath = "//div[text()='In stock']")
    public WebElement sizeCheckbox;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void selectSizeDropdown() {
        wait.until(ExpectedConditions.visibilityOf(sizeDropdown));
        sizeDropdown.click();
    }

    public void selectSizeCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(sizeCheckbox));
        sizeCheckbox.click();
    }
}
