package pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NikeHomePage extends BasePage{

    public NikeHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "")
    public WebElement x;

    @FindBy(xpath = "")
    public WebElement y;

    public void xy(){

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
