package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * this method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    /**
     * this method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     * this method will get text to element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * this method will count items
     */
    public int countItem(By by){
        List<WebElement> list=driver.findElements(by);
        return list.size();
    }
    /**
     * this is to verify
     */
    public void verifyThis(String expectedResult,By by){
        String actualResult=driver.findElement(by).getText();
        Assert.assertEquals("is not displayed correctly",expectedResult,actualResult);
    }

    //************************* Alert Methods *****************************************************

    /**
     *this method will send value to element
     */
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    /**
     *this method will accept alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     *this method will dismiss alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    /**
     *this method will get text from alert
     */
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }

    //************************* Select Methods *****************************************************
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }
    public void selectByValueTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByValue(text);
    }
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByIndex(index);
    }
    public void dropDownSelect(By by,String value) {
        List<WebElement> List = driver.findElements(by);
        for (WebElement element : List){
            if (element.getText().equals(value)){
                element.click();
            }
        }
    }
    public void mouseHover
            (By by){
        //Computer -------> Software and Click
        WebElement from = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(from).build().perform();
    }
    public void mouseHoverFromTo(By byFrom,By byTo){
        //Computer -------> Software and Click
        WebElement from = driver.findElement(byFrom);
        WebElement to = driver.findElement(byTo);
        Actions actions = new Actions(driver);
        actions.moveToElement(from).moveToElement(to).click().build().perform();
    }
}