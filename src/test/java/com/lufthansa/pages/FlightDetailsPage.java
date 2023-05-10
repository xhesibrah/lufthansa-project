package com.lufthansa.pages;

import com.lufthansa.elements.FlightDetailsPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.WebElementUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class FlightDetailsPage {
    WebDriver driver = BaseInformation.getDriver();

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    FlightDetailsPageElements flightDetailsPageElements = new FlightDetailsPageElements();

    WebElementUtils webElementUtils = new WebElementUtils(BaseInformation.getBaseInformation(), Duration.ofSeconds(10));
    public FlightDetailsPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    public void clickTicketPriceButton(){
        basePageObject
                .getWaitUtils()
                .waitForElementClickable(flightDetailsPageElements.ticketPriceButton)
                .click();
    }

    public void checkPreferredAirline(){
        // Get the value from local storage
        String key = "airlines-0";
        String value = (String) ((JavascriptExecutor) driver).executeScript("return window.localStorage.getItem(arguments[0]);", key);

        // Get the string from the attribute
        String airlineFlag = flightDetailsPageElements.airlineFlag.getAttribute("title");

        // Comparing the strings
        if (airlineFlag.trim().equals(value.trim())) {
            System.out.println("The airline matches the value in local storage.");
        } else {
            System.out.println("The airline does not match the value in local storage.");
        }
        Assert.assertEquals(airlineFlag.trim(), value.trim(), "The airline does not match the value in local storage.");
    }

    public void clickBookNowButton(String type) {
        webElementUtils.scrollOffset(0, 400);

        //basePageObject.getWaitUtils().waitForElementVisibleWithCustomTime(100,flightDetailsPageElements.firstBookNowOption);
        switch(type.toLowerCase()) {
            case "first":
                flightDetailsPageElements.firstBookNowOption.click();
                break;
            case "second":
                flightDetailsPageElements.secondBookNowOption.click();
                break;
            case "third":
                flightDetailsPageElements.thirdBookNowOption.click();
                break;

            case "first business":
                webElementUtils.scrollOffset(0, 400);
                flightDetailsPageElements.firstBusinessOption.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid Economy flight type: " + type);
        }
    }

}
