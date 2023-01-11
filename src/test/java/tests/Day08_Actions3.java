package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions3 extends TestBase {
    @Test
    public void pageUpDownTest() throws InterruptedException {
//    Go to techproeducation
        driver.get("https://www.techproeducation.com");
//    Scroll the page down
        Actions actions = new Actions(driver);
//        sendKeys(Keys.PAGE_DOWN) is used to scroll the page down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

//        CHAIN METHOD SCROLLING 3 TIMES
//        .build() is recommended to be used when we chain multiple function to make sure the connection is strong.
//        .perform() is used when there is single or multiple commends to execute the action
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Thread.sleep(2000);
//        ARROW DOWN: scroll down a little bit. This scrolls less than page down
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);

//        PAGE_UP = scroll up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);

//        ARROW UP = scroll up a little bit. This scrolls less than page up
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
    }
}
