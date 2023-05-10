package stepDefinition;

import com.lufthansa.elements.FlightDetailsPageElements;
import com.lufthansa.pages.FlightDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Flight_detailsStepDefinition {
    FlightDetailsPage flightDetailsPage = new FlightDetailsPage();
    @Then("user clicks on the flight")
    public void chooseTicketPrice() {
        System.out.println("The user selected the flight preferred");
        flightDetailsPage.clickTicketPriceButton();

    }

    @And("user chooses the {string} price option")
    public void userChoosesPriceOption(String flightType) {
        System.out.println("user chose the " + flightType+ " class option.");
        flightDetailsPage.clickBookNowButton(flightType);

    }

    @And("we check if flights showed are from preferred airline")
    public void weCheckIfFlightsShowedAreFromPreferredAirline() {
        System.out.println("Checked if the flights are from the previously selected as the preferred airline");
        flightDetailsPage.checkPreferredAirline();
    }
}
