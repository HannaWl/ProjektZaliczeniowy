package selenium.uj.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTestClass {


    @Test
    public void testSearch() {
        driver.findElement(By.xpath("//span[@class='sb-icon-search']")).click();
        // klikam w ikonke lupy

        WebElement phrase = driver.findElement(By.id("phrase"));
        phrase.sendKeys("test");
        //

        driver.findElement(By.xpath("//input[@class='sb-search-submit']")).click();
        // klikam w ikonkę lupy aby potwierdzić

        String text =  driver.findElement(By.xpath("/html[1]/body[1]/section[1]/form[1]/div[1]/div[1]/div[1]/p[1]")).getText();

        Assert.assertEquals(text, "Wyniki wyszukiwania dla test");

    }

    @Test
    public void testSearchAgain() {
        driver.findElement(By.xpath("//span[@class='sb-icon-search']")).click();
        // klikam w ikonke lupy

        WebElement phrase = driver.findElement(By.id("phrase"));
        phrase.sendKeys("test");
        //

        driver.findElement(By.xpath("//input[@class='sb-search-submit']")).click();
        // klikam w ikonkę lupy aby potwierdzić


        WebElement searchword = driver.findElement(By.id("searchword"));
        searchword.sendKeys("2");
        driver.findElement(By.xpath("//button[@class='btn btn-outline-dark btn-sm my-2 my-sm-0']")).click();


        String text =  driver.findElement(By.xpath("/html[1]/body[1]/section[1]/form[1]/div[1]/div[1]/div[1]/p[1]")).getText();



        Assert.assertEquals(text, "Wyniki wyszukiwania dla test2");

    }

    @Test
    public void testSearchCategoryFilter() {
        driver.findElement(By.xpath("//span[@class='sb-icon-search']")).click();
        // klikam w ikonke lupy

        WebElement phrase = driver.findElement(By.id("phrase"));
        phrase.sendKeys("test");
        //

        driver.findElement(By.xpath("//input[@class='sb-search-submit']")).click();
        // klikam w ikonkę lupy aby potwierdzić

        driver.findElement(By.xpath("//button[@class='btn btn-outline-dark btn-sm my-2 my-sm-0']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Wydarzenia')]")).click();

        String text =  driver.findElement(By.xpath("/html[1]/body[1]/section[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/h2[1]")).getText();



        Assert.assertEquals(text, "Wydarzenia");

    }

}
