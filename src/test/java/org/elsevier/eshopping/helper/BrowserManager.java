package org.elsevier.eshopping.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserManager {
    public static final String USERNAME = "";//Todo- Add your browserstack username key. this is usually store in jenkins
    public static final String AUTOMATE_KEY = "";//Todo- Add your browserstack Access key.this is usually store in jenkins
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public WebDriver initialisebroswer(WebDriver driver,String browser) throws Exception {
        if(browser.startsWith("bs_")) {
            DesiredCapabilities caps = setCapabilities(browser);
            driver = new RemoteWebDriver(new URL(URL), caps);
        }
        else {
            switch (browser) {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "IE":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;


                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome":

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;


            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public DesiredCapabilities setCapabilities(String deviceName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.console","errors");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", true);
        switch (deviceName.toLowerCase()) {

            case "bs_iphone12":
                caps.setCapability("os_version", "14");
                caps.setCapability("device", "iPhone 12");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                break;

            case "bs_iphone11":
                caps.setCapability("os_version", "14");
                caps.setCapability("device", "iPhone 11");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                break;
            case "bs_ipadair2019":
                caps.setCapability("os_version", "12");
                caps.setCapability("device", "iPad Air 2019");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                break;
            case "bs_pixel6":
                caps.setCapability("os_version", "12.0");
                caps.setCapability("device", "Google Pixel 6");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                break;

        }
        return caps;
    }
}