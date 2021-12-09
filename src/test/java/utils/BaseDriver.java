package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import testngPages.Parent;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    static WebDriver driver;
    
    public static WebDriver getDriver() {
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver=BaseDriver.getDriver();
            driver.get("https://demo.openmrs.org/openmrs/login.htm");
        }
        return driver;
    }


  @AfterTest
    public static void driverQuit() {

        Parent.waiting(3);

        if (driver !=null)
        {
            driver.quit();
            driver =null;
        }
    }
}
