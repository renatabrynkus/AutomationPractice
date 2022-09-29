package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logo")
    protected WebElement logo;

    @FindBy(css = ".sf-menu > li")
    private List<WebElement> headerMenuCategories;

    @FindBy(css = "li > a")
    private List<WebElement> subcategories;

    @FindBy(css = ".sfHover >.submenu-container")
    private WebElement submenu;

    public WebElement getHeaderCategory(String categoryToUse) {
        for (WebElement headerCategory : headerMenuCategories) {
            if (headerCategory.getText().equals(categoryToUse)) {
                return headerCategory;
            }
        }
        return logo;
    }

    public WebElement getSubcategory(String subcategoryToUse) {
        for (WebElement subcategory : subcategories) {
            if (subcategory.getText().equals(subcategoryToUse)) {
                return subcategory;
            }
        }
        return logo;
    }

    public HeaderPage hoverOverElement(WebElement elementToHover) {
        logger.info("----------> Moving mouse to element {}", elementToHover.getText() + " <---------");
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        wait.until(ExpectedConditions.visibilityOf(submenu));
        return this;
    }
}
