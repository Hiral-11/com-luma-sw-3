package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.Utility;

import static org.openqa.selenium.By.xpath;

public class MenTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        mouseHover(xpath("//ul[@id='ui-id-2']"));
        //Mouse Hover on Bottoms
        mouseHover(xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        //Click on Pants
        Thread.sleep(1000);
        clickOnElement(xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHover(xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHover(xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHover(xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        Thread.sleep(1000);
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Thread.sleep(2000);
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(xpath("//div[contains(text(),'Cronus ')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text ‘Shopping Cart.’
        verifyThis("Shopping Cart", xpath("//span[@class='base']"));
        //Verify the product name ‘Cronus Yoga Pant’
        verifyThis("Cronus Yoga Pant", xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        //Verify the product size ‘32’
        verifyThis("32", xpath("//dd[contains(text(),'32')]"));
        //Verify the product colour ‘Black’
        verifyThis("Black", xpath("//dd[contains(text(),'Black')]"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

