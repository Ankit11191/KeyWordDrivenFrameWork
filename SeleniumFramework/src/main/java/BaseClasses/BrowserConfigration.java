package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;

public class BrowserConfigration {
    ReadFromPropertiesFile readFromPropertiesFile=new ReadFromPropertiesFile();

    private BrowserConfigration()
    {
    }
    private static BrowserConfigration instance = new BrowserConfigration();

    public static BrowserConfigration getInstance()
    {
        return instance;
    }

    private WebDriver getDriverInstance() {
        WebDriver driver=null;
        if(readFromPropertiesFile.readProperties("BrowserName").contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("Browsers/chromedriver.exe").getPath());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(readFromPropertiesFile.readProperties("BrowserName").contains("FireFox"))
        {
            System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("Browsers/geckodriver.exe").getPath());
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette",true);
            driver = new FirefoxDriver(capabilities);
        }
        return driver;
    }

    ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        protected WebDriver initialValue()
        {
            return getDriverInstance();
        }
    };
    public WebDriver getDriver()
    {
        return localDriver.get();
    }

    public void QuitBrowser()
    {
        getDriver().quit();
    }
}