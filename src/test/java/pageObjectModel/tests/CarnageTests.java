package pageObjectModel.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjectModel.pages.*;
import pageObjectModel.utilities.ConfigReader;
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
}
