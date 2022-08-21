package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    WebElement quantity;

    @FindBy(xpath = "//*[@id=\"attributes\"]/fieldset[2]/label")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/div[2]")
    WebElement windowLayer;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span/text()")
    WebElement proceedToCheckOut;
    public AddToCartPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public Boolean validateQuantity(){
       return Action.isDisplayed(getDriver(),quantity);
    }

    public void enterQuantity(String number){
        Action.type(quantity,number);
    }

    public void selectSize(String value){
        Action.selectByValue(size,value);
    }

    public void clickAddToCart(){
        Action.click(getDriver(),addToCart);

    }

    public Boolean validateWindowLayer(){
        return Action.isDisplayed(getDriver(),windowLayer);
    }

    public OrderPage clickProceed(){
        Action.JSClick(getDriver(),proceedToCheckOut);
        return new OrderPage();
    }

}
