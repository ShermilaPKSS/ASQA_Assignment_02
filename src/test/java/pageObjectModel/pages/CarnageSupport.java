package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarnageSupport extends  BasePage {
    public CarnageSupport(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@name='req_type']")
    public WebElement requestTypeDropdown;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='contact']")
    public WebElement contactNumberField;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='order_number']")
    public WebElement orderNumberField;

    public void fillRequestForm(String requestType, String firstName, String lastName, String contactNumber, String email, String orderNumber) {
        Select requestTypeSelect = new Select(requestTypeDropdown);
        requestTypeSelect.selectByVisibleText(requestType);

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        contactNumberField.sendKeys(contactNumber);
        emailField.sendKeys(email);
        orderNumberField.sendKeys(orderNumber);
    }
}
