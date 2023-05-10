package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingConfirmationPageElements {
    public BookingConfirmationPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);

    }

    @FindBy(id = "bookingResultDiv")
    public WebElement bookingResultDiv;
    @FindBy(id = "grBookingSuccess")
    public WebElement grBookingSuccess;

    @FindBy(css = "table.ui.single.line.table td:nth-of-type(2)" )
    public List <WebElement> nameElements;





}
