package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {

    public HomePageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(id = "RoundTrip")
    public WebElement roundTripButton;

    @FindBy(id = "OneWay")
    public WebElement oneWayButton;

    @FindBy(id = "MultiDestination")
    public WebElement multiDestinationButton;

    @FindBy(id = "exactdate")
    public WebElement exactDateRadioButton;

    @FindBy(id = "departure_city")
    public WebElement departureCity;

    @FindBy(id = "destination_city")
    public WebElement destinationCity;

    @FindBy(id = "departure_city_0")
    public WebElement firstDepartureCity;


    @FindBy(id = "destination_city_0")
    public WebElement firstDestinationCity;
    @FindBy(id = "departure_city_1")
    public WebElement departureCity2;

    @FindBy(id = "destination_city_1")
    public WebElement destinationCity2;

    @FindBy(id = "departure_city_2")
    public WebElement departureCity3;

    @FindBy(id = "destination_city_2")
    public WebElement destinationCity3;

    @FindBy(id = "ui-id-1")
    public WebElement departureCityResults;

    @FindBy(id = "ui-id-2")
    public WebElement destinationCityResults;

    @FindBy(className = "accordion")
    public WebElement advancedSettings;

    @FindBy(id = "pref_airline")
    public WebElement prefAirlineField;

    @FindBy(id = "addLeg_0")
    public WebElement addSecondFlight;

    @FindBy(id = "addLeg_1")
    public WebElement addThirdFlight;

    @FindBy(id = "pref_class")
    public WebElement flightClass;

    @FindBy(id = "adult-counter")
    public WebElement passengersDropdown;

    @FindBy(id = "infant-counter")
    public WebElement infantCounterDropdown;

    @FindBy(id = "departure_date")
    public WebElement departureDateField;

    @FindBy(id = "return_date")
    public WebElement return_date;

    @FindBy(className = "ui-icon-circle-triangle-e")
    public WebElement nextMonthButton;

    @FindBy(className = "ui-datepicker-month")
    public WebElement currentMonth;

    @FindBy(className = "ui-datepicker-year")
    public WebElement currentYear;

    @FindBy(className = "ui-datepicker-week-end")
    public List<WebElement> dateButtons;

    @FindBy(id = "submitBTN")
    public WebElement submitButton;



}
