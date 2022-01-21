package org.elsevier.eshopping.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {
    WebDriver driver=null;
    public CommonMethods(WebDriver driver)
    {
        this.driver=driver;
    }
    public void launchURL(String url)
    {
        driver.get(url);
    }
    public void verifyTitleofPage(String pageTitle)
    {
        Assert.assertEquals(driver.getTitle(),pageTitle,"Title don't match for the page");
    }
    public void mouserHover(WebElement e)
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(e).build().perform();
    }
    public void clickOnElement(WebElement e)
    {
        e.click();
    }
    public void waitForElementIsVisible(WebElement e)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(e));

    }
    public void assertElementDisplayed(WebElement e)
    {
        Assert.assertTrue(e.isDisplayed(),"Element not visible");
    }

}
