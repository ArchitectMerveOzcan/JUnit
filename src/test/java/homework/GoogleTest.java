package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class GoogleTest extends TestBase {
//    Then create 3 different test methods using the following names. And Go to google.
    @Test
    public void titleTest(){
//    titleTest =>Verify if google title = “Google”
        driver.get("https://www.google.com/");
//    imageTest => Verify if google image displays or not
        WebElement image = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        Assert.assertTrue(image.isDisplayed());
//    gmailLinkTest => Verify if the Gmail link is displayed or not
        WebElement gmailLink = driver.findElement(By.linkText("//a[@class='gb_j']"));
        Assert.assertTrue(gmailLink.isDisplayed());
//    Close the browser after each test
    }
}
