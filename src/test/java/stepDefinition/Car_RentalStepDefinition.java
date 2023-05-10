package stepDefinition;

import com.lufthansa.pages.CarRentalPage;
import com.lufthansa.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Car_RentalStepDefinition {
    private WebDriver driver;
    private Hooks hooks;
    CarRentalPage carRentalPage = new CarRentalPage();

    @Then("user clicks on Car Book Now")
    public void userClicksOnCarBookNow() {
        carRentalPage.clickCarBookNow();
    }

   /* @After(order = 0)
    public void takeScreenshot(Scenario scenario) {
        hooks.takeScreenshot(scenario);
        }
    }*/
}
