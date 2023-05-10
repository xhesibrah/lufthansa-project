package stepDefinition;

import com.lufthansa.pages.HomePage;
import com.lufthansa.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.concurrent.atomic.AtomicInteger;


public class Book_a_tripStepDefinition {
    HomePage homePage = new HomePage();
    WebDriver driver = BaseInformation.getDriver();
    AtomicInteger counter = new AtomicInteger(0);
    LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();


    @Given("User is on homepage")
    public void userIsOnHomepage() {
        System.out.println("We navigate to the homepage");
        homePage.getUrl(ConfigurationReader.getProperty("baseurl"));
    }

    @And("check if we are in the right url")
    public void checkIfWeAreInTheRightUrl() {
        System.out.println("We check if we are in the correct page");
        homePage.verifyPageURL(driver, "https://airprojects.resvoyage.com/airtravel.htm?Idle=true&lang=en-us");
    }

    @When("User clicks on {string} menu option")
    public void userClicksOnOneWayMenuOption(String buttonName) {
        System.out.println("We click on the" +buttonName + " option");
        homePage.clickFlightTypeButton(buttonName);
    }

    @And("check that the {string} radiobutton is selected")
    public void checkThatTheExactDatesRadiobuttonIsSelected(String RadiobuttonName) {
        System.out.println("Checked if the" + RadiobuttonName + " radiobutton is selected");
        homePage.checkRadioButton(RadiobuttonName);

    }

    @And("user selects {string} as the {string} city")
    public void userSelectsTheOriginCity(String cityName, String cityType) {
        System.out.println("User chooses the origin City");
        homePage.selectOption(cityName, cityType);
    }

    @And("user selects {string} on {string}")
    public void userSelectsEconomyOnCabinPreference(String option, String dropdown) {
        System.out.println("User chose the option " + option + " from the " + dropdown + " dropdown.");
        homePage.userSelectsOptionFromDropdown(option, dropdown);
    }

    @And("user sets the date to {string} {string} on the {string} date")
    public void userSetsTheDate(String month, String date, String datetype) {
        System.out.println("User chose the date " + date + " from the month " + month + " .");
        homePage.selectDate(month, date, datetype);
    }

    @And("user clicks Submit button")
    public void userClicksSubmitButton() {
        System.out.println("User clicked on the Submit button");
        homePage.clickSubmitButton();
    }


    @Then("the selected route should be {string} to {string}")
    public void theSelectedRouteShouldBeTo(String arg0, String arg1) {
        System.out.println("Verified the selected route is " + arg0 + " to " + arg1 + ".");
        homePage.verifySelectedRoute(arg0, arg1);

        /*
        //saving the route to local storage
        String keyName = "route-" + counter.getAndIncrement();
        localStorage.setItem(keyName, arg0+ " " +arg1);*/

    }

    @And("user adds a {string} flight")
    public void userAddsAFlight(String arg0) {
        System.out.println("User added a " + arg0 + "flight" +".");
        homePage.addFlight(arg0);
    }

    @And("user sets {string} as the preferred airline")
    public void userSetsAsThePreferredAirline(String arg0) {
        System.out.println("User set " + arg0 + "as the preferred airline.");
        homePage.setPreferredAirline(arg0);
        // Saving the preferred airline on local storage so we can check the results later
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();

        // Generating a key for this set of values using a counter variable
        String keyName = "airlines-" + counter.getAndIncrement();

        // Saving the airline in local storage
        localStorage.setItem(keyName, arg0);


    }

    @And("user clicks Advanced Settings")
    public void userClicksAdvancedSettings() {
        System.out.println("User clicked on Advanced Settings");
        homePage.clickAdvancedSettings();
    }
}
