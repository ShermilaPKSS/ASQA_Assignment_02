package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobApplication extends  BasePage {
    public JobApplication(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Contact Number']")
    public WebElement contactField;

    // Methods to enter data into each text field
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterContact(String contactNumber) {
        contactField.sendKeys(contactNumber);
    }

    public void fillJobApplicationForm(String firstName, String lastName, String email, String contactNumber) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterContact(contactNumber);
    }
}
