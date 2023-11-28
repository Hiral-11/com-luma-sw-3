package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        Thread.sleep(2000);
        mouseHover(By.xpath("//a[@id='ui-id-6']"));
        //Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        //Verify the text ‘Overnight Duffle’
        verifyThis("Overnight Duffle",By.xpath("//span[@class='base']"));
        //Change Qty 3
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("3");
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        //Verify the text
        //‘You added Overnight Duffle to your shopping cart.’
        Thread.sleep(2000);
        verifyThis("You added Overnight Duffle to your shopping cart.",By.xpath("//div[@class='message-success success message']"));
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the product name ‘Cronus Yoga Pant’
        verifyThis("Overnight Duffle",By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        //verify quantity 3
        Thread.sleep(2000);
        String expected="3";
        String actual=driver.findElement(By.xpath("//input[@value = '3']")).getAttribute("value");
        Assert.assertEquals("Not displayed correctly",expected,actual);
        //Change Qty to ‘5’
        clickOnElement(By.xpath("//input[@class='input-text qty']"));
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        //Verify the product price ‘$225.00’
        verifyThis( "$225.00",By.xpath("//span[contains(text(),'$225.00')]"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

