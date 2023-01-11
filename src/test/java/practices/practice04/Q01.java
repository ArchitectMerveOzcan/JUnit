package practices.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {
    /*
Given
 Go to  https://www.saucedemo.com/
When
 Enter the username  as "standard_user"
And
 Enter the password as "secret_sauce"
And
 Click on login button
And
 Add all products to cart
And
 Go to cart
And
 Click on checkout
And
 Fill your information
And
 Click on continue
Then
 Assert that total price is $140.34
When
 Click on finish
Then
 Assert that CHECKOUT: COMPLETE!
*/
    @Test
    public void test01(){
//        Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
//        Enter the username  as "standard_user"
        waitFor(1);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        Enter the password as "secret_sauce"
        waitFor(1);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        Click on login button
        waitFor(1);
        driver.findElement(By.id("login-button")).click();
//        Add all products to cart
        waitFor(1);
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[.='Add to cart']"));
        addToCart.stream().forEach(WebElement::click);
//        Go to cart
        waitFor(1);
        driver.findElement(By.id("shopping_cart_container")).click();
//        Click on checkout
        waitFor(1);
        driver.findElement(By.id("checkout")).click();
//        Fill your information
        waitFor(1);
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("1234");
//        Click on continue
        waitFor(2);//HARD WAIT
        driver.findElement(By.id("continue")).click();
//        Assert that total price is $140.34
        waitFor(1);
        String totalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        System.out.println("totalPrice = " + totalPrice);
        Assert.assertEquals("Total: $140.34", totalPrice);
//        Click on finish
        waitFor(1);
        driver.findElement(By.id("finish")).click();
//        Assert that CHECKOUT: COMPLETE!
        waitFor(1);
        String complete = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("CHECKOUT: COMPLETE!", complete);

    }
}
