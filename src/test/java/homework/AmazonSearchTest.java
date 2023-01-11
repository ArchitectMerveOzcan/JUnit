package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonSearchTest extends TestBase {
    //    Create a new class: AmazonSearch
    @Test
    public void itemTest() {
//      TC01_As user I want to know how many item are there on amazon in the first page after I search “porcelain teapot”?
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot");
        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> listOfResults = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        System.out.println("Number of items= " +listOfResults.size());

//      TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.
        List<Integer> listOfPrices = new ArrayList<>();
        for (WebElement w : listOfResults) {
            listOfPrices.add(Integer.parseInt(w.getText()));
        }
        System.out.println(listOfResults);
        System.out.println(listOfPrices);

        //Find the max value
        Integer maxValue = listOfPrices.stream().sorted().findFirst().get();
        System.out.println("maxValue = " + maxValue + "$");

        //Find the min value
        Integer minValue = listOfPrices.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("minValue = " + minValue +"$");

        //Find the average value
        double sumValue = listOfPrices.stream().reduce(0,Math::addExact);
        System.out.println("sumValue = " + sumValue);

        double avgList = sumValue/listOfResults.size();
        System.out.println("avgList = " + avgList);

        List<Integer> moreThan = new ArrayList<>();
        for (Integer w : listOfPrices){
            if(w>avgList){
                moreThan.add(w);
            }
        }
        Integer avgValue = moreThan.stream().distinct().reduce(Integer.MAX_VALUE, (t,u) -> u);
        System.out.println("avgValue = " + avgValue);
    }
}
    ////span[@class='a-price-whole']
    ////div[@data-component-type='s-search-result']
    ////span[@class='a-price-fraction']

