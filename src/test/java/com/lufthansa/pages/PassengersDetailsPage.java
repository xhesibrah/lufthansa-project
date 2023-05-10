package com.lufthansa.pages;

import com.lufthansa.elements.PassengersDetailsPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.WebDriverUtils;
import com.lufthansa.utilities.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.*;

public class PassengersDetailsPage {
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    WebDriver driver = BaseInformation.getDriver();

    PassengersDetailsPageElements passengersDetailsPageElements = new PassengersDetailsPageElements();
    WebDriverUtils webDriverUtils = new WebDriverUtils(BaseInformation.getBaseInformation());

    WebElementUtils webElementUtils = new WebElementUtils(BaseInformation.getBaseInformation(), Duration.ofSeconds(10));

    public PassengersDetailsPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }


    public void fillPassengerInfo(String firstName, String lastName, String email, String phone, String gender, String bdate, String bmonth, String byear) {
        basePageObject.getWaitUtils().waitForElementVisibleWithCustomTime(10000, passengersDetailsPageElements.passengerFirstName);
        passengersDetailsPageElements.passengerFirstName.sendKeys(firstName);
        passengersDetailsPageElements.passengerLastName.sendKeys(lastName);

        if (!email.isEmpty()) {
            List<WebElement> emailFields = passengersDetailsPageElements.passengerEmail;
            if (!emailFields.isEmpty()) {
                WebElement emailField = emailFields.get(0);
                emailField.sendKeys(email);
                passengersDetailsPageElements.passengerEmailConfirm.sendKeys(email);
            }
        }

        if (!phone.isEmpty()) {
            List<WebElement> phoneFields = passengersDetailsPageElements.passengerPhone;
            if (!phoneFields.isEmpty()) {
                WebElement phoneField = phoneFields.get(0);
                phoneField.sendKeys(phone);
            }
        }

        if (gender.equalsIgnoreCase("female")) {
            passengersDetailsPageElements.passengerFemaleCheckbox.click();
        } else {
            passengersDetailsPageElements.passengerMaleCheckbox.click();
        }

        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.passengerBdate, bdate);
        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.passengerBmonth, bmonth);
        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.passengerByear, byear);

    }

    public void closePassengerInfo(String passenger) {
        switch (passenger) {
            case "first":
                passengersDetailsPageElements.titleActiveHeadersTitlefirst.click();
                break;
            case "second":
                passengersDetailsPageElements.activeHeadersTitle.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid selection: " + passenger);
        }
    }

    public void clickHeaderByIndex(int index) {
        switch (index) {
            case 1:
                basePageObject.getWaitUtils().waitForElementClickable(passengersDetailsPageElements.titleActiveHeadersTitlefirst);
                passengersDetailsPageElements.titleActiveHeadersTitlefirst.click();
                break;
            case 2:
                basePageObject.getWaitUtils().waitForElementClickable(passengersDetailsPageElements.secondAdultTitle);

                passengersDetailsPageElements.secondAdultTitle.click();
                break;
            case 3:
                basePageObject.getWaitUtils().waitForElementClickable(passengersDetailsPageElements.thirdPassenger);

                passengersDetailsPageElements.thirdPassenger.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid selection: " + index);
        }
    }

    public void openNextPassengerForm() {
        int currentPassenger = 1;
        for (WebElement form : passengersDetailsPageElements.passengerForms) {
            WebElement title = form.findElement(By.cssSelector("div.title > h4.ui.dividing.header"));
            if (title.getText().contains("Passenger")) {
                if (currentPassenger == passengersDetailsPageElements.passengerForms.indexOf(form) + 1) {
                    webElementUtils.scrollToElement(title);
                    title.click();
                    break;
                }
                currentPassenger++;
            }
        }
    }

    Set<String> selectedSeats = new HashSet<>();

    public void chooseSeat(String seatCode) {
        for (WebElement passenger : passengersDetailsPageElements.passengerList) {
            webElementUtils.scrollToElement(passenger);

            passenger.click();

            boolean foundSeat = false;
            WebElement seatToChoose = null;

            // Check if any of the window seats have the desired seat code
            for (WebElement seat : passengersDetailsPageElements.byTheWindowSeatsList) {
                if (!seat.isSelected() && !selectedSeats.contains(seat.getAttribute("data-code"))) {
                    if (seat.getAttribute("data-code").equals(seatCode)) {
                        foundSeat = true;
                        seatToChoose = seat;
                        break;
                    }
                }
            }

            // If the desired seat is not found, choose a random window seat
            if (!foundSeat) {
                Random random = new Random();
                List<WebElement> availableSeats = passengersDetailsPageElements.byTheWindowSeatsList;
                List<WebElement> availableSeatsToChoose = new ArrayList<>();

                // Filter out already selected seats
                for (WebElement seat : availableSeats) {
                    if (!selectedSeats.contains(seat.getAttribute("data-code"))) {
                        availableSeatsToChoose.add(seat);
                    }
                }

                int numSeats = availableSeatsToChoose.size();
                if (numSeats == 0) {
                    throw new RuntimeException("No available seats to choose from!");
                }
                int index = random.nextInt(numSeats);
                seatToChoose = availableSeatsToChoose.get(index);
            }

            // Choose the desired seat
            webElementUtils.scrollToElement(seatToChoose);
            seatToChoose.click();
            selectedSeats.add(seatToChoose.getAttribute("data-code"));
        }

        webElementUtils.scrollToElement(passengersDetailsPageElements.saveSeatsButton);

        passengersDetailsPageElements.saveSeatsButton.click();

    }

    public void userSavesSeats() {
        webElementUtils.scrollToElement(passengersDetailsPageElements.saveSeatsButton);
        passengersDetailsPageElements.saveSeatsButton.click();

    }

    public void changeFlightTab(String flight) {
        switch (flight) {
            case "2":
                passengersDetailsPageElements.secondFlight.click();
                break;
            case "3":
                passengersDetailsPageElements.thirdFlight.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid selection: " + flight);
        }
    }

    public void paymentType(String type) {
        if (type.equals("card")) {
            // webElementUtils.scrollToElement(passengersDetailsPageElements.cardRadiobutton);
            webElementUtils.javaScriptClick(passengersDetailsPageElements.cardRadiobutton);
            // passengersDetailsPageElements.cardRadiobutton.click();
            System.out.println("The card option is selected");
        } else if (type.equals("cash")) {
            webElementUtils.javaScriptClick(passengersDetailsPageElements.cashRadiobutton);
            //passengersDetailsPageElements.cashRadiobutton.click();
            System.out.println("The cash option is selected");
        }
    }


    public void fillPassengerInfo(String cardNumber, String cvv, String month, String year, String name, String country, String adress, String city, String state, String zip) {
        basePageObject.getWaitUtils().waitForElementVisible(passengersDetailsPageElements.cardNumberField);
        passengersDetailsPageElements.cardNumberField.sendKeys(cardNumber);
        passengersDetailsPageElements.cvv.sendKeys(cvv);
        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.expiryMonthNumber, month);
        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.expiryYearNumber, year);
        passengersDetailsPageElements.cardHolderName.sendKeys(name);
        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.cardCountry, country);
        passengersDetailsPageElements.cardStreet.sendKeys(adress);
        webDriverUtils.selectDropdownOption(driver, passengersDetailsPageElements.cardState, state);
        passengersDetailsPageElements.cardCity.sendKeys(city);
        passengersDetailsPageElements.zipPostalCode.sendKeys(zip);


    }

    public void clickCarBtn() {
        webElementUtils.scrollToElement(passengersDetailsPageElements.addCarBtn);
        passengersDetailsPageElements.addCarBtn.click();
    }

    public void cvvField(String cvv) {
        passengersDetailsPageElements.cvvField.sendKeys(cvv);
    }

    public void checkConditions() {
        passengersDetailsPageElements.rulesCheckbox.click();
    }

    public void createBookingButtonClick() {
        passengersDetailsPageElements.btnCreateBooking.click();
    }

}




