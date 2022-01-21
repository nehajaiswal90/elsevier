package org.elsevier.eshopping.pageclass;

import org.elsevier.eshopping.helper.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class MyStorePage extends CommonMethods {
    WebDriver driver;
    public MyStorePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@id=\\\"block_top_menu\\\"]/ul/li[2]//a[@title='Dresses']")
    private WebElement DRESSES;
    private String PAGE_TITLE="My Store";

        public void navigateToDressCategory()
        {
            clickOnElement(DRESSES);
        }

    public void verifyMyStorePageTitle() {
        verifyTitleofPage(PAGE_TITLE);
    }




}
