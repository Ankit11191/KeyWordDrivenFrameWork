import BaseClasses.ActionClass;
import BaseClasses.ReadFromPropertiesFile;
import TestCase1.Page1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends Page1 {

    @FindBy(id="combo_facility")WebElement facilityDropDown;
    @FindBy(xpath = "//span[@class=\"glyphicon glyphicon-calendar\"]") WebElement calendar;
    @FindBy(xpath = "//input[@id=\"txt_visit_date\"]") WebElement date;
    @FindBy(xpath = "//button[@id=\"btn-book-appointment\"]") WebElement bookAppointment;
    @FindBy(xpath = "//div[@class=\"col-sm-4\"]/label/input[@id=\"radio_program_medicaid\"]") WebElement  Medicaid;
    @FindBy(xpath = "//input[@id=\"chk_hospotal_readmission\"]") WebElement checkBox;

    @Test(priority = 2)
    public void CreateAppointmant()
    {
        ActionClass actionClass=new ActionClass();
        actionClass.selectFromDropDown("Seoul CURA Healthcare Center",facilityDropDown);
        actionClass.selectCheckBox(Medicaid);
        actionClass.selectRadioButton("",Medicaid);
        calendar.click();
        date.sendKeys("31/07/2018");
        bookAppointment.click();
    }

    @FindBy(id="facility") WebElement facility;
    @FindBy(id="visit_date") WebElement visit_date;
    @FindBy(xpath="//a[@class=\"btn btn-default\"]") WebElement HomePageButton;
    @Test(priority = 3)
    public void VerifyConformation()
    {
        String facilityText=facility.getText();
        Assert.assertEquals(facilityText,"Seoul CURA Healthcare Center");
        String VisitDate=visit_date.getText();
        Assert.assertEquals(VisitDate,"31/07/2018");
        HomePageButton.click();
    }
}
