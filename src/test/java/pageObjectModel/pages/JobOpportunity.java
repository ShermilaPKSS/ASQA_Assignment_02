package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobOpportunity extends BasePage {
    public JobOpportunity(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "/html/body/main/div/div[1]/div[2]/a")
    public WebElement applyButton;

    public <T> T clickApplyButton() {
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();

        return (T) PageFactory.initElements(driver, JobApplication.class);
    }
}
