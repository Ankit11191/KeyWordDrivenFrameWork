package TestCase1;

import BaseClasses.BrowserConfigration;
import BaseClasses.BrowserHandle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Page1 extends BrowserHandle {

    WebDriver driver1;
    @BeforeTest
    public void beforeTest ()
    {
        driver1=BrowserConfigration.getInstance().getDriver();
        driver1.get("http://demoaut.katalon.com/");
    }
    @AfterTest
    public void afterTest ()
    {

    }
    @FindBy(id="btn-make-appointment") WebElement makeAppointmant;
    @FindBy(id="txt-username") WebElement username;
    @FindBy(name="password") WebElement password;
    @FindBy(xpath = "//button[@id=\"btn-login\"]") WebElement LoginButton;

    @Test(priority = 1)
    public void CreateAccount ()
    {
        PageFactory.initElements(driver1, this);
        makeAppointmant.click();
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        LoginButton.click();
    }
}
