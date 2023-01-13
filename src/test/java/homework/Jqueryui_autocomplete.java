package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Jqueryui_autocomplete extends TestBase {
    @Test
    public void test() throws InterruptedException {
//    When user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/");
        Thread.sleep(3000);
//    And type Apple
        driver.findElement(By.id("tags")).sendKeys("apple");
        Thread.sleep(3000);
//    Then select Applescript
        driver.findElement(By.xpath("//div[.='AppleScript']")).click();
    }
}
