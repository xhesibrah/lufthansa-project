package stepDefinition;

import com.lufthansa.elements.PassengersDetailsPageElements;
import com.lufthansa.pages.PassengersDetailsPage;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.WebDriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Passengers_detailsStepDefinition {

    PassengersDetailsPage passengersDetailsPage = new PassengersDetailsPage();
    WebDriver driver = BaseInformation.getDriver();
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    WebDriverUtils webDriverUtils = new WebDriverUtils(BaseInformation.getBaseInformation());



    PassengersDetailsPageElements passengersDetailsPageElements = new PassengersDetailsPageElements();

    AtomicInteger counter = new AtomicInteger(0);

    @Then("user fills first passenger data with name: {string} lastname: {string} email: {string} phone: {string} gender:{string} date:{string} month: {string} year:{string}")
    public void userFillsFirstPassengerDataWithNameLastnameEmailPhoneDateMonthYear(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
        System.out.println("Filled passengers information with name: " + arg0 + " lastname: " + arg1 + " email: " + arg2 + " phone: " + arg3 + " gender: " + arg4 + " date: " + arg5 + "/" +arg6 + "/" + arg7);
        passengersDetailsPage.fillPassengerInfo(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);

        // Saving the name and lastname in local storage to use later in the test
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();

        // Generate a unique key for this set of values using a counter variable
        String keyName = "passenger-" + counter.getAndIncrement();

        // Save name and lastname in local storage
        localStorage.setItem(keyName,arg0+ " " + arg1);

    }

    @And("user goes to the other passenger form")
    public void userGoesToTheOtherPassengerForm() {
        System.out.println("user goes to the other passenger form");
        passengersDetailsPage.openNextPassengerForm();
    }

    @Then("user clicks seat selection button")
    public void userClicksSeatSelectionButton() {
        System.out.println("User clicks seat selection button");
        passengersDetailsPageElements.seatSelectionBtn.click();
    }

    @And("user selects {string} seat as the main one")
    public void userSelectsSeatAsTheMainOne(String arg0) {
        System.out.println("User selects the " + arg0 + " as the main seat.");
        passengersDetailsPage.chooseSeat(arg0);
    }

    @Then("user clicks the {string} radiobutton")
    public void userClicksTheRadiobutton(String arg0) {
        System.out.println("User selects " + arg0+ " as the payment option." );
        passengersDetailsPage.paymentType(arg0);

    }

    @And("user fills cvv field with {string}")
    public void userFillsCvvFieldWith(String arg0) {
        System.out.println("User filled the Cvv field with " + arg0 + "value.");
        passengersDetailsPage.cvvField(arg0);
    }

    @And("user checks rules and conditions checkbox")
    public void userChecksRulesAndConditionsCheckbox() {
        System.out.println("User checks the rules and conditions checkbox.");
        passengersDetailsPage.checkConditions();
    }

    @And("user clicks confirm booking")
    public void userClicksConfirmBooking() {
        System.out.println("User clicks confirm booking");
        passengersDetailsPage.createBookingButtonClick();
    }

    @And("user goes to the {string} passenger")
    public void userGoesToThePassenger(String arg0) {
        System.out.println("User goes to the " + arg0+ " passenger");
        passengersDetailsPage.clickHeaderByIndex(Integer.parseInt(arg0));
    }

    @And("user closes the {string} form")
    public void userClosesTheForm(String arg0) {
        System.out.println("User closes the " +arg0 + " form.");
        passengersDetailsPage.closePassengerInfo(arg0);

    }

    @And("user fills the card information with card number:{string} cvv:{string} month:{string} year:{string} name:{string} country:{string} billing adress:{string} city:{string} state:{string} zip:{string}")
    public void userFillsTheCardInformation(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        System.out.println("User fills the card information.");
        passengersDetailsPage.fillPassengerInfo(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);

    }

    @And("user clicks add car")
    public void userClicksAddCar() {
        System.out.println("User adds a car to his reservation.");
        passengersDetailsPage.clickCarBtn();
    }

    @And("user goes to the {string} flight")
    public void userGoesToTheFlight(String arg0) {
        System.out.println("User goes to the " + arg0+ " flight.");
        passengersDetailsPage.changeFlightTab(arg0);
    }

    @And("user saves selected seats")
    public void userSavesSelectedSeats() {
        System.out.println("User Saved the seats selected.");
        passengersDetailsPage.userSavesSeats();
    }



    /*

    @And("user goes to the other passenger form")
    public void user_goes_to_the_other_passenger_form() {
        passengersDetailsPage.openNextPassengerForm(List);
    }

    @And("user fills other passenger details")
    public void user_fills_other_passenger_details(List<Map<String, String>> passengerDetails) {
        for (int i = 0; i < passengerDetails.size(); i++) {
            passengersDetailsPage.fillPassengerDetails(passengerDetails.get(i));
        }
    }
*/






}
