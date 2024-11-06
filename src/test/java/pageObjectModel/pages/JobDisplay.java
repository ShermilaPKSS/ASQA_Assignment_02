package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobDisplay extends BasePage {
    public JobDisplay(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//div[contains(@class, 'grid grid-cols-1') and contains(@class, 'md:grid-cols-2') and contains(@class, 'lg:grid-cols-3') and contains(@class, 'gap-6') and contains(@class, 'md:gap-10')]//a[1]")
    public WebElement firstJob;

    public <T> T clickFirstJob() {
        // Wait until the first job link is visible
        wait.until(ExpectedConditions.visibilityOf(firstJob));

        if (firstJob.isDisplayed()) {
            // Click the first <a> tag
            firstJob.click();
            System.out.println("Clicked on the first <a> tag in the grid.");

            // Return the JobApplication page object
            return (T) PageFactory.initElements(driver, JobOpportunity.class);
        } else {
            System.out.println("No <a> tags found in the grid.");
            return null;
        }
    }

    public void scrollPage(int x, int y) {
        new Actions(driver).scrollByAmount(x, y).perform();
    }
}
