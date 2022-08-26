package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.pageInitializers;

import java.util.concurrent.TimeUnit;

public class commonMethods extends pageInitializers {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        configReader.readProperties(constants.CONFIGURATION_FILEPATH);
        String browserName = configReader.getPropertyValue("browser");
        //cross browser testing
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        String url = configReader.getPropertyValue("url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
//intialize the page initializers
        initializePageObjects();

    }

}

