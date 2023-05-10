package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PassengersDetailsPageElements {
    public PassengersDetailsPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'fname_')]")
    public WebElement passengerFirstName;
    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'lname_')]")
    public WebElement passengerLastName;

    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'email_')]")
    public List<WebElement> passengerEmail;

    @FindBy(xpath = "//div[@class=' title' or @class='title active']//h4[@class='ui dividing header' and contains(text(), 'Passenger 2')]")
    public WebElement secondAdultTitle;

    @FindBy(xpath = "//div[@class=' title']//h4[@class='ui dividing header' and contains(text(), 'Infant')]")
    public WebElement thirdPassenger;
    @FindBy(xpath = "//div[@class='title active']//h4[@class='ui dividing header' and contains(text(), 'Passenger')]")
    public WebElement activeHeadersTitle;

    @FindBy(xpath = "//div[@class='active title']//h4[@class='ui dividing header' and contains(text(), 'Passenger')]")
    public WebElement titleActiveHeadersTitlefirst;



    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'email_c_')]")
    public WebElement passengerEmailConfirm;

    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'phone_')]")
    public List<WebElement> passengerPhone;

    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'gender_f_')]")
    public WebElement passengerFemaleCheckbox;

    @FindBy(xpath = "//div[@class='ui form content active']//input[contains(@id, 'gender_m_')]")
    public WebElement passengerMaleCheckbox;

    @FindBy(xpath = "//div[@class='ui form content active']//select[contains(@id, 'bdate_d_')]")
    public WebElement passengerBdate;

    @FindBy(xpath = "//div[@class='ui form content active']//select[contains(@id, 'bdate_m_')]")
    public WebElement passengerBmonth;

    @FindBy(xpath = "//div[@class='ui form content active']//select[contains(@id, 'bdate_y_')]")
    public WebElement passengerByear;

    @FindBy(xpath = "//div[contains(@id, 'passengerData')]")
    public List <WebElement> passengerForms;

    @FindBy(id = "seatSelectionBtn")
    public WebElement seatSelectionBtn;

    @FindBy(css = "span.seat.seat--chargable.price[data-code*='A'], span.seat.seat--chargable.price[data-code*='F']")
    public List <WebElement> byTheWindowSeatsList;

    @FindBy(className = "meta")
    public List <WebElement> passengerList;
    @FindBy(xpath = "//a[contains(@class,'item') and text()][2]")
    public WebElement secondFlight;

    @FindBy(xpath = "//a[contains(@class,'item') and text()][3]")
    public WebElement thirdFlight;

    @FindBy(xpath = "//button[contains(@class,'save-seats') and text()='Save']")
    public WebElement saveSeatsButton;

    @FindBy(id = "B2CallMeRadioButton")
    public WebElement cashRadiobutton;

    @FindBy(id = "B2CCreditCardRadioButton")
    public WebElement cardRadiobutton;

    @FindBy(id = "AIRcnN_0")
    public WebElement cardNumberField;

    @FindBy(id = "AIRcvv_0")
    public WebElement cvv;

    @FindBy(id = "AIRexp_m_0")
    public WebElement expiryMonthNumber;

    @FindBy(id = "AIRexp_y_0")
    public WebElement expiryYearNumber;

    @FindBy(id = "AIRcname_0")
    public WebElement cardHolderName;

    @FindBy(id = "AIRcntry_0")
    public WebElement cardCountry;

    @FindBy(id = "AIRstr_0")
    public WebElement cardStreet;

    @FindBy(id = "AIRcty_0")
    public WebElement cardCity;

    @FindBy(id = "AIRstate_0")
    public WebElement cardState;

    @FindBy(id = "AIRzip_0")
    public WebElement zipPostalCode;

    @FindBy(id = "CUSTOM_FIELD_834-0")
    public WebElement cvvField;

    @FindBy(id = "cbRules")
    public WebElement rulesCheckbox;

    @FindBy(id = "btnCreateBooking")
    public WebElement btnCreateBooking;

    @FindBy(id = "addCarTravelTypeDiv")
    public WebElement addCarBtn;


}
