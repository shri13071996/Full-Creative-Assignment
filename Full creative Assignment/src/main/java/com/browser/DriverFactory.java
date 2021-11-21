package com.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.Objects;

public class DriverFactory {

    public static  WebDriver driver =null;

    protected static void launchBrowser(String browser){
        switch( browser.toUpperCase()){
            case "CHROME":
                if(Objects.isNull(driver)){
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            case "FIREFOX":
                if(Objects.isNull(driver)){
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                }
        }
        driver.manage().window().maximize();
    }

    //Launch the url of application
    protected static void loadApplication(String url){
        if(Objects.nonNull(driver)){
            driver.get(url);
        }
    }

    //TO close the browser window
    protected static void driverClose(){
        if(Objects.nonNull(driver)){ /*Checking for driver is not null*/
            driver.close();
        }
    }

    //TO close the browser driver
    protected static void driverQuit(){
        if(Objects.nonNull(driver)){ /*Checking for driver is not null*/
            driver.quit();
            driver =null;
        }
    }

}
