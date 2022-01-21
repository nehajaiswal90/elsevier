package org.elsevier.eshopping.pageclass;

import org.elsevier.eshopping.helper.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SummerDressesPage extends CommonMethods {

    WebDriver driver;
    public SummerDressesPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "(//div[@class='right-block'])[1]")
    private WebElement PRODUCT_HOVER_BLOCK;
    @FindBy(how = How.XPATH, using = "//div[@class='button-container']/a[@title='Add to cart']")
    private WebElement ADD_TO_CART;
    @FindBy(how = How.XPATH, using = "//div[@class='button-container']/a[@title='Proceed to checkout']")
    private WebElement PROCEED_TO_CHECKOUT;
    @FindBy(how = How.XPATH, using = "//*[@class='product_list grid row']")
    private WebElement PRODUCT_LIST;
    @FindBy(how = How.XPATH, using = "//h2/i")
    private WebElement OK_ICON;
    private String PAGE_TITLE="Summer Dresses - My Store";

    public void verifysummerDressAvailable()
    {
        waitForElementIsVisible(PRODUCT_LIST);
        assertElementDisplayed(PRODUCT_LIST);
    }

    public void verifydressAddedtoCart()
    {
        mouserHover(PRODUCT_HOVER_BLOCK);
        clickOnElement(ADD_TO_CART);
        waitForElementIsVisible(OK_ICON);
        assertElementDisplayed(OK_ICON);//could add xpath of complete block

    }

    public void userProceedtoCheckout()
    {
        clickOnElement(PROCEED_TO_CHECKOUT);
    }


    public void verifySummerDressPageTitle() {
        verifyTitleofPage(PAGE_TITLE);
    }
}
