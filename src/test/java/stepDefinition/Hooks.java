package stepDefinition;

import com.lufthansa.utilities.BaseInformation;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hooks extends BaseInformation {
    private WebDriver driver;

    public Hooks(WebDriver driver) {
        this.driver = driver;
    }

   @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        }
    }

}
