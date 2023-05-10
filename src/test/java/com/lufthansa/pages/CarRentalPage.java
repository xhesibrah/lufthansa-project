package com.lufthansa.pages;

import com.lufthansa.elements.CarRentalPageElements;
import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.support.PageFactory;

public class CarRentalPage {
    CarRentalPageElements carRentalPageElements = new CarRentalPageElements();

    public CarRentalPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void clickCarBookNow() {
        carRentalPageElements.carBookNowButton.click();
    }


}
