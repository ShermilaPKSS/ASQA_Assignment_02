package pageObjectModel.tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjectModel.pages.BasePage;
import pageObjectModel.pages.NikeHomePage;
//import pageObjectModel.pages.NikeProductPage;
import pageObjectModel.utilities.Utilities;

import java.time.Duration;

public class NikeTests extends Utilities {

    @Test
    public void testSearchAndAddToCart() {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        NikeHomePage homePage = basePage.loadUrl("");

        WebDriverWait wait = new WebDriverWait(browserFactory.getDriver(), Duration.ofSeconds(30));
    //put assertions
    }
}
