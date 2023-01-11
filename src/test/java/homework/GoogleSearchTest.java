package homework;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class GoogleSearchTest extends TestBase{
    @Test
    public  void googleSearchTest(){
//    When user goes to https://www.google.com/
        driver.get("https://www.google.com/");
//    Search for “porcelain teapot”
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("porcelain teapot");
        driver.findElement(By.name("btnK")).click();
//      driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
//    And print how many related results displayed on Google
        String result = driver.findElement(By.id("result-stats")).getText();
        System.out.println(result);
    }
}
