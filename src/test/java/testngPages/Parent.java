package testngPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseDriver;
import java.util.List;
import java.util.Random;

public class Parent {

    static WebDriverWait wait;
    public Parent()
    {
        wait =new WebDriverWait(BaseDriver.getDriver(),15);
    }

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        element.click();
    }

    public static void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waiting(int second)
    {
        try {
            Thread.sleep(1000 *second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void randomClick (List<WebElement> element)
    {
        Random rnd = new Random();
        int index = rnd.nextInt(element.size());
        element.get(index).click();
    }

    public void verifyContainsText(WebElement element,String msg) {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(msg));
    }

    public void chooseAndVerify(List<WebElement> list,WebElement element,WebElement element1,String msg) {
        element.click();
        for (WebElement x:list) {
            x.click();
            msg= element1.getText();
            Assert.assertEquals(element1.getText(),msg);
            element.click();
        }
    }
    public void hoverFunction(WebElement element){
        Actions actions=new Actions(BaseDriver.getDriver());
        Action action = actions.moveToElement(element).build();
        action.perform();
    }


}
