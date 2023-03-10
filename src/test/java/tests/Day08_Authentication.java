package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {
    @Test
    public void authTest(){
        /*
        username : admin
        pass     : admin
        url      : the-internet.herokuapp.com/basic_auth
        GO LINK  : https://username:pass@url
         */
        //this will do authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String succesMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(succesMessage.contains("Congratulations! You must have the proper credentials."));
        //assertion
    }
}
        /*
        Auth are used for security reason
One way to auth is to use below syntax:
https://username:password@URL
       username : admin
       password : admin
       url      :  the-internet.herokuapp.com/basic_auth
     URL FOR AUTH:
     https://admin:admin@the-internet.herokuapp.com/basic_auth
driver.get(“https://admin:admin@the-internet.herokuapp.com/basic_auth”);
This will auth the page
         */
