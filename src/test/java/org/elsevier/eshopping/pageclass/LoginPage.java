package org.elsevier.eshopping.pageclass;

import org.elsevier.eshopping.helper.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String PAGE_TITLE="Login - My Store";

    public void verifyLoginPageTitle() {
        verifyTitleofPage(PAGE_TITLE);
    }
}
