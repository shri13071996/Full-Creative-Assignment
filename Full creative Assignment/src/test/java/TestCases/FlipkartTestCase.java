package TestCases;

import Config.Config;
import Pages.FlipkartHomePage;
import com.browser.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartTestCase extends DriverFactory {

    FlipkartHomePage Flipkartloginpage;

    @BeforeTest
    public void beforeTest() {
        Flipkartloginpage = new FlipkartHomePage();
        DriverFactory.launchBrowser("chrome");
        DriverFactory.loadApplication(Config.flipkartUrl);
    }


    @Test
    public void AddToCartAndRemove() {

        Flipkartloginpage.enterItemToBeSearched("HP Laptop");
        Flipkartloginpage.selectFirstProduct();
        Flipkartloginpage.goToNewProductPageAndAddToCart();
        Flipkartloginpage.closeWindow();
        Flipkartloginpage.clearTheSearchBar();
        Flipkartloginpage.enterItemToBeSearched("Redmi");
        Flipkartloginpage.selectFirstProduct();
        Flipkartloginpage.goToNewProductPageAndAddToCart();
        Flipkartloginpage.removeFirstAddedItemFromCart();
        Assert.assertTrue( Flipkartloginpage.checkTheLastAddedItemInCart());
        Flipkartloginpage.closeWindow();
    }

    @AfterTest
    public void cleanUp(){
        DriverFactory.driverQuit();
    }
}
