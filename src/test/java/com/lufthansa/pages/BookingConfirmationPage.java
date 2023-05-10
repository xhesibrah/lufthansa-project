package com.lufthansa.pages;

import com.lufthansa.elements.BookingConfirmationPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BookingConfirmationPage {
    public BookingConfirmationPage() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    WebDriver driver = BaseInformation.getDriver();
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    BookingConfirmationPageElements bookingConfirmationPageElements = new BookingConfirmationPageElements();

    public boolean checkBookingConfirmationMessage() {
        basePageObject.getWaitUtils().waitForElementVisibleWithCustomTime(10000, bookingConfirmationPageElements.bookingResultDiv);
        if (driver.getPageSource().contains("booking reference number") && driver.getPageSource().contains("Please, write down or remember this number")) {
            System.out.println("Booking confirmation message is present");
            return true;
        } else {
            System.out.println("Booking confirmation message is absent");
            return false;
        }
    }

    public void saveBookingNumber() {

        System.out.println("This is your booking number:" + bookingConfirmationPageElements.grBookingSuccess.getAttribute("value"));

    }

    public void compareTableNamesWithLocalStorage() {
        List<WebElement> nameElements = bookingConfirmationPageElements.nameElements;
        boolean allNamesMatch = true;
        for (int i = 0; i < nameElements.size(); i++) {
            WebElement element = nameElements.get(i);
            String name = element.getText();
            String key = "passenger-" + i;
            String value = (String) ((JavascriptExecutor) driver).executeScript("return window.localStorage.getItem(arguments[0]);", key);
            if (!value.equals(name)) {
                allNamesMatch = false;
                System.out.println("Passenger " + i + " name does not match with local storage value.");
            }
        }
        if (allNamesMatch) {
            System.out.println("All passenger names match with local storage values.");
        }
        Assert.assertTrue(allNamesMatch, "Not all passenger names match with local storage values.");
    }



   /* public void printTableNames(){
        for (WebElement element : bookingConfirmationPageElements.nameElements) {
            System.out.println(element.getText());
        }
    }*/
}
