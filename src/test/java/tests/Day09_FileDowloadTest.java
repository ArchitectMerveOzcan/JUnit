package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDowloadTest extends TestBase {
//    Create a class:FileDownloadTest
//    downloadTest()
    @Test
    public void downloadTest() throws InterruptedException {
//    In the downloadTest() method, do the following test:
//    https://testcenter.techproeducation.com/index.php?page=file-download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
//    Download some-file.txt file
        driver.findElement(By.linkText("junit-4.13-beta-3.jar")).click(); //downloading the file
        Thread.sleep(2000); //After click, it takes a few millisecond, so using hard wait
//    Then verify if the file downloaded successfully
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory+"\\Desktop\\junit-4.13-beta-3.jar";

        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);


    }



}
