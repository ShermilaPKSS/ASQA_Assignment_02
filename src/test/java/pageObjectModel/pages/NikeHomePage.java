package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NikeHomePage extends BasePage{

    public NikeHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Kids']")
    public WebElement kidsMenu;

    @FindBy(xpath = "//ul[@aria-label='All Shoes']//p[text() = 'Running']")
    public WebElement shoesRunning;

    @FindBy(xpath = "//button[@aria-label='Close Pop Up']")
    public WebElement closeButton;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void hoverAndSelectKidsMenuItem(){

        // Use Actions class to hover over the predefined "Kids" menu element
        Actions actions = new Actions(driver);
        actions.moveToElement(kidsMenu).perform();

        // Wait for the "Running" link to become visible in the dropdown, then click it
        wait.until(ExpectedConditions.visibilityOf(shoesRunning));
        shoesRunning.click();

        // Add assertions to verify that the page navigates correctly
        wait.until(ExpectedConditions.titleContains("Kids Running Shoes"));
    }

    public void closeSelectLocation(){
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
    }

//    public <T> T clickButton (){
//        button.click();
//        if(visibleText.equals("Cell Phones & Accessories")){
//            return (T)PageFactory.initElements(driver, EbayPhonePage.class);
//        }
//        else{
//            return (T)PageFactory.initElements(driver, EbayClothesPage.class);
//        }
//    }
}
