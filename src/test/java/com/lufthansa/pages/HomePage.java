package com.lufthansa.pages;

import com.lufthansa.elements.CarRentalPageElements;
import com.lufthansa.elements.HomePageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.WebDriverUtils;
import com.lufthansa.utilities.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.time.Month;

public class HomePage {
    WebDriver driver = BaseInformation.getDriver();
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    HomePageElements homePageElements = new HomePageElements();
    CarRentalPageElements carRentalPageElements = new CarRentalPageElements();

    public HomePage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    public void verifyPageURL(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURL)) {
            System.out.println("On the correct page");
        } else {
            System.out.println("Not on the correct page");
        }
    }

    public void clickFlightTypeButton(String buttonName) {
        switch (buttonName) {
            case "Round Trip":
                homePageElements.roundTripButton.click();
                break;
            case "One Way":
                homePageElements.oneWayButton.click();
                break;
            case "Multi Destinations":
                homePageElements.multiDestinationButton.click();
                break;
            default:
                System.out.println("Invalid button name: " + buttonName);
                break;
        }
    }

    public void setPreferredAirline(String airline) {
        WebElement airlineField = homePageElements.prefAirlineField;
        airlineField.sendKeys(airline);

        WebElement dropdownOption = basePageObject.getWaitUtils().waitForElementVisible(By.xpath("//a[contains(span[@id], '" + airline + "')]"));
        dropdownOption.click();

    }
    public void clickAdvancedSettings() {homePageElements.advancedSettings.click();}

    public void addFlight(String flightNo) {
        switch (flightNo) {
            case "2nd":
                homePageElements.addSecondFlight.click();
                break;
            case "3rd":
                homePageElements.addThirdFlight.click();
                break;
            default:
                System.out.println("Invalid flight number: " + flightNo);
                break;
        }
    }

    public void selectOption(String cityName, String cityType) {
        WebElement cityField;
        WebElement cityResults;

        switch (cityType) {
            case "origin":
                cityField = homePageElements.departureCity;
                cityResults = homePageElements.departureCityResults;
                break;
            case "destination":
                cityField = homePageElements.destinationCity;
                cityResults = homePageElements.destinationCityResults;
                break;
            case "firstDeparture":
                cityField = homePageElements.firstDepartureCity;
                cityResults = homePageElements.departureCityResults;
                break;
            case "firstDestination":
                cityField = homePageElements.firstDestinationCity;
                cityResults = homePageElements.destinationCityResults;
                break;
            case "secondDeparture":
                cityField = homePageElements.departureCity2;
                cityResults = homePageElements.departureCity2;
                break;
            case "secondDestination":
                cityField = homePageElements.destinationCity2;
                cityResults = homePageElements.destinationCity2;
                break;
            case "thirdDeparture":
                cityField = homePageElements.departureCity3;
                cityResults = homePageElements.departureCity3;
                break;
            case "thirdDestination":
                cityField = homePageElements.destinationCity3;
                cityResults = homePageElements.destinationCity3;
                break;
            default:
                System.out.println("Invalid city type specified");
                return;
        }

        cityField.sendKeys(cityName);
        basePageObject.getWaitUtils().waitForElementVisibleWithCustomTime(2000, cityResults);
        cityField.sendKeys(Keys.ENTER);
    }


    public void verifySelectedRoute(String originCity, String destinationCity) {
        String actualOriginCity = homePageElements.departureCity.getAttribute("value");
        String actualDestinationCity = homePageElements.destinationCity.getAttribute("value");

        if (!actualOriginCity.contains(originCity) || !actualDestinationCity.contains(destinationCity)) {
            Assert.fail("Selected route does not contain the expected origin and destination cities. Expected: " + originCity + " to " + destinationCity + ". Actual: " + actualOriginCity + " to " + actualDestinationCity);
        }

        System.out.println("Selected route contains the expected origin and destination cities: " + originCity + " to " + destinationCity);
    }

    public void checkRadioButton(String option) {
        switch (option) {
            case "Exact Dates":
                if (!WebDriverUtils.isRadioButtonSelected(homePageElements.exactDateRadioButton)) {
                    throw new IllegalStateException("Exact date radio button is not selected");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid radio button option: " + option);
        }
    }

    public void userSelectsOptionFromDropdown(String optionText, String dropdownId) {
        WebElement dropdownElement;
        switch (dropdownId) {
            case "Cabin Preference":
                dropdownElement = homePageElements.flightClass;
                break;
            case "Adult":
                dropdownElement = homePageElements.passengersDropdown;
                break;
            case "Infant":
                dropdownElement = homePageElements.infantCounterDropdown;
                break;
            default:
                throw new IllegalArgumentException("Invalid dropdown ID: " + dropdownId);
        }
        WebDriverUtils.selectDropdownOption(driver, dropdownElement, optionText);
    }

    public void selectDate(String month, String date, String dateType) {
        switch (dateType) {
            case "departure":
                homePageElements.departureDateField.click();
                break;
            case "return":
                homePageElements.return_date.click();
                break;
            case "carReturn":
                carRentalPageElements.carReturnDate.click();
                break;
            case "carDeparture":
                carRentalPageElements.carDepartureDate.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid date selection: " + dateType);
        }

        // Get the current month and year from the calendar header
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.currentMonth);
        String currentMonth = homePageElements.currentMonth.getText();
        int currentYear = Integer.parseInt(homePageElements.currentYear.getText());

       // System.out.println("Current month: " + currentMonth);
       // System.out.println("Current year: " + currentYear);

        // Calculate the target month and year based on the arguments
        int targetMonth = calculateTargetMonth(month, currentMonth);
        int targetYear = currentYear;
        if (targetMonth < getMonthNumber(currentMonth)) {
            targetYear++;
        }

       // System.out.println("Target month: " + targetMonth);
        //System.out.println("Target year: " + targetYear);

        // Click the next month arrow until we reach the target month and year
        while (true) {
            String currentMonthText = homePageElements.currentMonth.getText();
            if (getMonthNumber(currentMonthText) == targetMonth && Integer.parseInt(homePageElements.currentYear.getText()) == targetYear) {
                break;
            }
            homePageElements.nextMonthButton.click();
        }

        // Select the desired date
        for (WebElement day : homePageElements.dateButtons) {
            //System.out.println("Date button: " + day.getText());

            if (day.getText().equals(date)) {
                day.click();
                break;
            }
        }
    }


    private int calculateTargetMonth(String targetMonth, String currentMonth) {
        int currentMonthNum = getMonthNumber(currentMonth);
        int targetMonthNum = getMonthNumber(targetMonth);
        if (targetMonthNum >= currentMonthNum) {
            return targetMonthNum;
        } else {
            return targetMonthNum + 12;
        }
    }

    private int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

    public void clickSubmitButton() {
        homePageElements.submitButton.click();
    }


}
