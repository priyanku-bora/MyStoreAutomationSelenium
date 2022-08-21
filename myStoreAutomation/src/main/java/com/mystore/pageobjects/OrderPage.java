package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement proceedTocheckOut;

    @FindBy(xpath="")
    WebElement price;

    public OrderPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public AddressPage clickProceed(){
        Action.click(getDriver(),proceedTocheckOut);
        return new AddressPage();
    }


}
