package pageObjectModel.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    static BrowserFactory browserFactory;

    ThreadLocal<WebDriver> threadLocal = ThreadLocal.withInitial(()->{
        WebDriver driver = null;
        String browser = ConfigReader.getProperty("browser");

        switch (browser) {
            case "chrome":
                driver =  WebDriverManager.chromedriver().create(); break;
            case "firefox":
                driver =  WebDriverManager.firefoxdriver().create(); break;
            case "edge":
                driver =  WebDriverManager.edgedriver().create(); break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    });

    private BrowserFactory() {

    }

    public static BrowserFactory getBrowserFactory () {
        if (browserFactory == null) {
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver(){
        return threadLocal.get();
    }
}
