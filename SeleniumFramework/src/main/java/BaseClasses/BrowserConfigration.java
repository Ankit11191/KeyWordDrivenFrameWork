package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.PublicKey;

public class BrowserConfigration {
    static WebDriver driver;

    ReadFromPropertiesFile readFromPropertiesFile=new ReadFromPropertiesFile();
    public WebDriver getDriver() {

        if(readFromPropertiesFile.readProperties("BrowserName").contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("Browsers/chromedriver.exe").getPath());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(readFromPropertiesFile.readProperties("BrowserName").contains("FireFox"))
        {

        }
            return driver;
    }

    public void QuitBrowser()
    {
        driver.quit();
    }
}