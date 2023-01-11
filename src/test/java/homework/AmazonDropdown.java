package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonDropdown extends TestBase{
//    Create A Class: AmazonDropdown
//    Create A Method dropdownTest
    @Test
    public void dropdownTest() throws InterruptedException {
//    Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Thread.sleep(2000);
//    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
        Select select = new Select(dropdown);
        String firstOption = select.getFirstSelectedOption().getText();
        System.out.println(firstOption);
       if (firstOption.equals("All Departments")){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
       }
//    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
       String fourthOption = select.getFirstSelectedOption().getText();
        System.out.println(fourthOption);
        if(fourthOption.equals("Amazon Devices")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
//    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions = select.getOptions();
        for(WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());
        }
//    Print the the total number of options in the dropdown
        System.out.println("the total number of options =>> " +allOptions.size());
//    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        boolean isExistAppliance = false;
        for(WebElement eachOption : allOptions){
            if(eachOption.getText().equals("Appliances")){
                 isExistAppliance=true;
            }
        }
        System.out.println(isExistAppliance);
//    BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> optionList = new ArrayList<>();
        for (WebElement w : allOptions){
            optionList.add(w.getText());
        }
        System.out.println(optionList);
        List<String> sortedList = optionList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedList,optionList);
    }
}
