package com.lufthansa.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class WebElementUtils {
    WebDriver driver = BaseInformation.getDriver();

    private final BaseInformation baseInformation;
    private final WaitUtils waitUtils;


    public WebElementUtils(BaseInformation baseInformation, Duration defaultDuration) {
        this.baseInformation = baseInformation;
        this.waitUtils = new WaitUtils(baseInformation, defaultDuration);
    }

    public void clickWebElement(WebElement webElement) {
        waitUtils.waitForElementClickable(webElement)
                .click();
    }

    public void javaScriptClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void moveMouseToElement(WebElement element) {
        WaitUtils.waitFor(1000);
        new Actions(driver)

                .moveToElement(element)
                .perform();
    }



    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }
    public void scrollOffset(int x, int y) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
    }

    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getTextWithoutSubElements(WebElement element) {
        String fullText = element.getText()
                .trim();
        for (WebElement subElement : element.findElements(By.xpath(".//*"))) {
            fullText = fullText.replace(subElement.getText().trim(), "");
        }
        fullText = fullText.replaceAll("\n", "");
        return fullText;
    }


    public void sendKeysToElementWithWait(WebElement element, String value, long millsWait) {
        element.sendKeys(value);
        WaitUtils.waitFor(millsWait);
    }


    public boolean isElementVisibleWithWait(int mills, WebElement element) {
        try {
            waitUtils.waitForElementVisibleWithCustomTime(mills, element);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean isTextPresent(String searchText) {
        String pageText = driver.getCurrentUrl();
        return pageText.contains(searchText);
    }

    public boolean isTextDisplayedInColor(WebElement element, String colorCode) {
        String color = element.getCssValue("color");
        return color.equalsIgnoreCase(colorCode);
    }
}
