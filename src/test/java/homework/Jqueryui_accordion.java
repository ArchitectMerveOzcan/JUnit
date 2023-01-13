package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Jqueryui_accordion extends TestBase {
    @Test
    public void accordion() throws InterruptedException {
        driver.get("https://jqueryui.com/accordion/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        We need to use Actions class to drag and drop


//        Elements are inside the iframe, so switch first
        driver.switchTo().frame(0);

        WebElement section2 = driver.findElement(By.id("ui-id-3"));


        Actions actions = new Actions(driver);
        actions.click(section2).perform();

//        Thread.sleep(1);
        String text = driver.findElement(By.xpath("//p[contains(text(),'Sed non urna.')]")).getText();
        System.out.println(text);

    }
}

//    BENİM ÇÖZÜMÜM
//    @Test
//    public void test(){
//        //    When user goes to https://jqueryui.com/accordion/
//        driver.get("https://jqueryui.com/accordion/");

////    And user clicks on Section2 accordion
//        driver.switchTo().frame(0);
//        driver.findElement(By.id("ui-id-3")).click();

////    Verify the text contains “Sed non urna.”
//        String text = driver.findElement(By.id("ui-id-4")).getText();
//        Assert.assertTrue(text.contains("Sed non urna."));
//        driver.switchTo().defaultContent();
//
//        driver.close();
//    }
//}
