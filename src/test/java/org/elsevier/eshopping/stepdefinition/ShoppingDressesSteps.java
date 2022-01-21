package org.elsevier.eshopping.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.elsevier.eshopping.helper.BrowserManager;
import org.elsevier.eshopping.pageclass.*;
import org.openqa.selenium.WebDriver;

public class ShoppingDressesSteps {

    protected WebDriver driver = null;
    protected BrowserManager browserManagerObj=null;
    protected MyStorePage myStorePageObj=null;
    protected OrderMyStorePage orderMyStorePageObj =null;
    protected DressesPage dressesPageObj=null;
    protected SummerDressesPage summerDressesPageObj=null;
    protected LoginPage loginPageObj=null;


    @Given("User open {string} browser")
    public void user_open_browser(String browserName) throws Exception {
        browserManagerObj=new BrowserManager();
        driver=browserManagerObj.initialisebroswer(driver,browserName);
        myStorePageObj=new MyStorePage(driver);
        orderMyStorePageObj=new OrderMyStorePage(driver);
        dressesPageObj=new DressesPage(driver);
        summerDressesPageObj=new SummerDressesPage(driver);
         loginPageObj=new LoginPage(driver);
    }
    @Given("Launch the Website {string}")
    public void launch_the_website(String url) {
        myStorePageObj.launchURL(url);
        myStorePageObj.verifyMyStorePageTitle();
    }

    @When("User go to summer dress category")
    public void userGoToSummerDressCategory() {
        myStorePageObj.navigateToDressCategory();
        dressesPageObj.verifyDressPageTitle();
        dressesPageObj.navigateToSummerDress();
        summerDressesPageObj.verifySummerDressPageTitle();
    }
    @When("User adds the Summer dress to cart")
    public void userAddsTheSummerDressToCart() {
        summerDressesPageObj.verifysummerDressAvailable();
        summerDressesPageObj.verifydressAddedtoCart();

    }


    @Then("Verify user is able to checkout the product")
    public void verifyUserIsAbleToCheckoutTheProduct() {
        summerDressesPageObj.userProceedtoCheckout();
        orderMyStorePageObj.verifyOrderPageTitle();
        orderMyStorePageObj.continueCheckout();
        loginPageObj.verifyLoginPageTitle();


    }
    @After
    @Then("Close the browser")
    public void Close_the_browser() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
