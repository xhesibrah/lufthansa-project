package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarRentalPageElements {

    public CarRentalPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(id = "departure_date")
    public WebElement carDepartureDate;

    @FindBy(id = "return_date")
    public WebElement carReturnDate;

    @FindBy(css = ".ui.button.light-blue.right.floated:first-of-type")
    public WebElement carBookNowButton;




}
