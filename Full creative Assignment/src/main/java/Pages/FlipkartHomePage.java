package Pages;

import Config.Config;
import Utils.SeleniumUtils;
import com.browser.DriverFactory;
import org.openqa.selenium.By;

public class FlipkartHomePage extends DriverFactory{

    public String parentWin = null;

    /*Page locators*/
    By searchbar = By.xpath("//input[@title='Search for products, brands and more']");
    By searchIcon = By.xpath("//button[@type='submit']");
    By firstProduct = By.xpath("(//div[@class='_1AtVbE col-12-12']//div[starts-with(.,'HP')]/text())[1]");
    By addToCart = By.xpath("//button[text()='ADD TO CART']");
    By removeButtonOfFirsAddedItem = By.xpath("/(//div[text()='Remove'])[last()]"); //since first added item will be the last in cart using the last() function in xpath
    By removeItemBtn = By.xpath("//div[text()='Remove Item']//following::div[text()='Remove'][1]");
    By placeorderBtn = By.xpath("//button/span[text()='Place Order']");


    public void enterItemToBeSearched(String product) {
        SeleniumUtils.enterText(searchbar, product);
        SeleniumUtils.waitAndClick(searchIcon);
    }

    public void selectFirstProduct() {
        SeleniumUtils.waitAndClick(firstProduct);
    }

    public void goToNewProductPageAndAddToCart() {
        parentWin = SeleniumUtils.switchToNewWindow(driver);
        SeleniumUtils.waitAndClick(addToCart);
    }
    public void closeWindow(){
        driverClose();
        SeleniumUtils.switchToParentWindow(driver,parentWin);
    }
    public void clearTheSearchBar() {
        SeleniumUtils.clear(searchbar);
    }
    public void removeFirstAddedItemFromCart(){
        SeleniumUtils.waitAndClick(removeButtonOfFirsAddedItem);
        SeleniumUtils.waitAndClick(removeItemBtn);
    }

    public boolean checkTheLastAddedItemInCart(){
        /*Verifying the last added item in cart by checking for 'Place order' button*/
        return SeleniumUtils.isElementPresent(driver, placeorderBtn);
    }


}
