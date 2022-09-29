package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logo")
    protected WebElement logo;

    @FindBy(css = ".product_list .replace-2x")
    private List<WebElement> productsInCategory;

    @FindBy(css = ".product-name")
    private List<WebElement> productNames;

    @FindBy(css = ".quick-view span")
    private WebElement quickView;

    @FindBy(css = ".fancybox-overlay")
    private WebElement boxOverlay;

    public List<WebElement> getProductsInCategory() {
        return productsInCategory;
    }

    public WebElement getQuickView() {
        return quickView;
    }

    public ProductPage hoverOverElement(WebElement elementToHover) {
        logger.info("----------> Moving mouse to element {}", elementToHover.getText() + " <---------");
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        wait.until(ExpectedConditions.visibilityOf(quickView));
        return this;
    }

    public void clickOnElement(WebElement element) {
        logger.info("----------> Clicking on {}", element.getText() + " <----------");
        element.click();
        wait.until(ExpectedConditions.visibilityOf(boxOverlay));
    }
}

