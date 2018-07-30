package BaseClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionClass {

    public Boolean selectFromDropDown(String value, WebElement webElement)
    {
        Select dd=new Select(webElement);
        dd.selectByValue(value);
        return true;
    }

    public void selectRadioButton(String value, WebElement webElement)
    {
        if(!webElement.isSelected())
        {
            webElement.click();
        }
    }
    public void selectCheckBox(WebElement webElement)
    {
        if(!webElement.isSelected())
        {
            webElement.click();
        }
    }
}
