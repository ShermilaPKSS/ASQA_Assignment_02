package pageObjectModel.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjectModel.pages.*;
import pageObjectModel.utilities.ConfigReader;
import pageObjectModel.utilities.JobApplicationDataProvider;
import pageObjectModel.utilities.RequestDataProvider;
import pageObjectModel.utilities.Utilities;

public class CarnageTests extends Utilities {

    String url = ConfigReader.getProperty("url");

    @Test (priority = 1)
    public void selectHoodies() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        CarnageHomePage homePage = basePage.loadUrl(url);
        homePage.hoverAndSelectWomenMenuItem();
        CarnageHoodiesPage hoodiesPage = homePage.clickHoodiesButton();
        hoodiesPage.selectSizeDropdown();
        hoodiesPage.selectSizeCheckbox();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void shopSale() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        CarnageHomePage homePage = basePage.loadUrl(url);
        homePage.scrollPage(0, 300);
        BlackFridayPage salePage = homePage.clickShopSaleButton();
        salePage.selectAvailabilityDropdown();
        InStockPage inStockPage = salePage.selectAvailabilityCheckbox();
        AddToCart addToCart = inStockPage.clickFirstProductCard();
        addToCart.addToCart();
        Thread.sleep(5000);
    }

    @Test (alwaysRun = true)
    public void addAndRemoveBag() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        CarnageHomePage homePage = basePage.loadUrl(url);
        homePage.searchText("bag");
        BagPage bagPage = homePage.clickSearchButton();
        AddToCart addToCart = bagPage.clickFirstBag();
        addToCart.addToCart();
        Thread.sleep(5000);
        addToCart.increaseCount();
        Thread.sleep(2000);
    }

    @Test(dataProvider = "jobApplicationData", dataProviderClass = JobApplicationDataProvider.class, priority = 3)
    public void applyToJob(String firstName, String lastName, String email, String contactNumber) throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        CarnageHomePage homePage = basePage.loadUrl(url);
        homePage.scrollPage(0, 1000);
        JobDisplay jobDisplay =  homePage.clickCareersButton();
        jobDisplay.scrollPage(0, 600);
        JobOpportunity jobOpportunity = jobDisplay.clickFirstJob();
        JobApplication jobApplication = jobOpportunity.clickApplyButton();
        jobApplication.fillJobApplicationForm(firstName, lastName, email, contactNumber);
        Thread.sleep(1000);
    }

    @Test(dataProvider = "requestData", dataProviderClass = RequestDataProvider.class, priority = 4)
    public void requestSupport(String requestType, String firstName, String lastName, String contactNumber, String email, String orderNumber) throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        CarnageHomePage homePage = basePage.loadUrl(url);
        homePage.scrollPage(0, 1000);
        CarnageSupport carnageSupport =  homePage.submitRequestButton();
        carnageSupport.fillRequestForm(requestType, firstName, lastName, contactNumber, email, orderNumber);
        Thread.sleep(1000);
    }
}
