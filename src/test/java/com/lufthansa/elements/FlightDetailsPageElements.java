package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightDetailsPageElements {
    public FlightDetailsPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(className = "farePrice")
    public WebElement ticketPriceButton;

    @FindBy(xpath = "(//div[@class='column']//button[contains(text(),'Book Now')])[2]")
    public WebElement firstBusinessOption;
    @FindBy(xpath = "(//div[@class='column']//button[contains(text(),'Book Now')])[4]")
    public WebElement firstBookNowOption;

    @FindBy(className = "flg-image")
    public WebElement airlineFlag;

    @FindBy(xpath = "(//div[@class='column']//button[contains(text(),'Book Now')])[5]")
    public WebElement secondBookNowOption;

    @FindBy(xpath = "(//div[@class='column']//button[contains(text(),'Book Now')])[6]")
    public WebElement thirdBookNowOption;
}
