package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {
    Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickOnElement(WebElement element) {
        logger.info("----------> Clicking on {}", element.getText() + " <----------");
        element.click();
    }

    public BasePage hoverOverElement(WebElement elementToHover) {
        logger.info("----------> Moving mouse to element {}", elementToHover.getText() + " <---------");
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        return this;
    }
}