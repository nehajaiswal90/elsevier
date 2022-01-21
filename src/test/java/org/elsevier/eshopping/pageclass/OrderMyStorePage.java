package org.elsevier.eshopping.pageclass;

import org.elsevier.eshopping.helper.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderMyStorePage extends CommonMethods {

    public OrderMyStorePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = "//p/a[@title='Proceed to checkout']")
    private WebElement PROCEED_TO_CHECKOUT_ORDER;
    private String PAGE_TITLE="Summer Dresses - My Store";

    public void verifyOrderPageTitle() {
        verifyTitleofPage(PAGE_TITLE);
    }
    public void continueCheckout()
    {
        clickOnElement(PROCEED_TO_CHECKOUT_ORDER);
    }

}
