package TestCase1;

import BaseClasses.BrowserConfigration;
import BaseClasses.BrowserHandle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Page1 extends BrowserHandle {
    WebDriver driver;
    @FindBy(id="btn-make-appointment") WebElement makeAppointmant;
    @FindBy(id="txt-username") WebElement username;
    @FindBy(name="password") WebElement password;
    @FindBy(xpath = "//button[@id=\"btn-login\"]") WebElement LoginButton;

    @Test(priority = 1)
    public void CreateAccount ()
    {
        BrowserConfigration browserConfigration=new BrowserConfigration();
        this.driver=browserConfigration.getDriver();
        PageFactory.initElements(driver, this);
        driver.get("http://demoaut.katalon.com/");
        makeAppointmant.click();
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        LoginButton.click();
    }
}
