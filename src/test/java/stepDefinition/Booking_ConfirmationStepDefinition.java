package stepDefinition;

import com.lufthansa.pages.BookingConfirmationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Booking_ConfirmationStepDefinition {

    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
    @Then("user checks the booking confirmation message")
    public void checkBookingConfirmationMessage() {
        System.out.println("User checked the booking confirmation message");
        Assert.assertTrue(bookingConfirmationPage.checkBookingConfirmationMessage());
    }

    @Then("user saves the booking number to console")
    public void userSavesTheBookingNumberToConsole() {
        System.out.println("The booking number is saved to console");
        bookingConfirmationPage.saveBookingNumber();
    }

    @And("check the names from the final table with the actual names")
    public void checkNames() {
        System.out.println("check the names from the final table with the actual names");
        bookingConfirmationPage.compareTableNamesWithLocalStorage();
    }
}
