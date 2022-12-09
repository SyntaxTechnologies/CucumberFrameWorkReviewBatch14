package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
//        open the properties file and read through it
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
//        Get the value of a specific property from the read file
        switch(ConfigReader.getPropertyValue("browser")) {
            case"chrome":
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
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
}
