package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {

    @FindBy(xpath="//*[@id=\"form\"]/p/button/span")
    WebElement proceedToCheckout;

    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckBox;

    public ShippingPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void clickTermsOfService(){
        Action.click(getDriver(),termsOfServiceCheckBox);
    }
    public PaymentPage clickProceed(){
        Action.click(getDriver(),proceedToCheckout);
        return new PaymentPage();
    }
}
