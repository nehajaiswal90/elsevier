package org.elsevier.eshopping.pageclass;

import org.elsevier.eshopping.helper.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DressesPage extends CommonMethods {

    public DressesPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = "//div[@id='subcategories']/ul/li[contains(.,'Summer Dresses')]")
    private WebElement SUMMER_DRESSES;
    private String PAGE_TITLE="Dresses - My Store";

    public void navigateToSummerDress()
    {
        clickOnElement(SUMMER_DRESSES);
    }

    public void verifyDressPageTitle() {
        verifyTitleofPage(PAGE_TITLE);
    }

}
