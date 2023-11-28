package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));
        // * Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        //get product list for comparison
        List<WebElement> list=driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/strong"));
        List<String> expectedList= new ArrayList<>();
        for(WebElement e:list){
            expectedList.add(e.getText());
        }
        Collections.sort(expectedList);
        //Select Sort By filter “Product Name”
        selectByValueTextFromDropDown(By.xpath("//select[@id='sorter']"),"name");
        //Verify the products name display in
        Thread.sleep(2000);
        List<WebElement> list1=driver.findElements(By.xpath("//ol[@class='products list items product-items']/li/div/div/strong"));
        List<String> actualList= new ArrayList<>();
        for(WebElement e:list1){
            actualList.add(e.getText());
        }
        Assert.assertEquals("List is not sorted",expectedList,actualList);
    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));
        // * Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        //get product list for comparison
        List<WebElement> list=driver.findElements(By.xpath("//span[@class='normal-price']//span[@class='price']"));
        List<String> expectedList= new ArrayList<>();
        for(WebElement e:list){
            expectedList.add(e.getText());
        }
        Collections.sort(expectedList);
        //Select Sort By filter “Product Name”
        selectByValueTextFromDropDown(By.xpath("//select[@id='sorter']"),"price");
        //Verify the products name display in
        Thread.sleep(2000);
        List<WebElement> list1=driver.findElements(By.xpath("//span[@class='normal-price']//span[@class='price']"));
        List<String> actualList= new ArrayList<>();
        for(WebElement e:list1){
            actualList.add(e.getText());
        }
        Assert.assertEquals("List is not sorted",expectedList,actualList);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

