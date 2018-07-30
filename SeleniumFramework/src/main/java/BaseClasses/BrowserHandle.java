package BaseClasses;

import org.testng.annotations.AfterTest;

public class BrowserHandle {

    @AfterTest
    public void killBrowser()
    {
        BrowserConfigration browserConfigration=new BrowserConfigration();
        browserConfigration.QuitBrowser();
    }
}
