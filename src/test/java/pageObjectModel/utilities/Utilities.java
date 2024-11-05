package pageObjectModel.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

    public class Utilities {
        WebDriver driver;

        @BeforeMethod
        public void initializeBrowser () {
            //initialize browser
            driver = WebDriverManager.firefoxdriver().create();
//        driver = new ChromeDriver(); //if we directly create a Driver
            //driver = WebDriverManager.chromedriver().create(); //if we use Web Driver Manager
            driver.manage().window().maximize();
            driver.get("https://www.ebay.com");
        }
        @AfterMethod
        public void closeBrowser () {
            driver.quit();
            //driver.close();
        }
    }

}
