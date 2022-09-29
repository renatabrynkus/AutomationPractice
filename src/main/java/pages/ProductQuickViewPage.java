package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductQuickViewPage extends BasePage {

    public ProductQuickViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#bigpic")
    private WebElement bigImage;

    @FindBy(css = "#thumbs_list_frame a")
    private List<WebElement> thumbnails;

    @FindBy(css = ".fancybox-iframe")
    private WebElement iframe;

    public List<WebElement> getThumbnails() {
        return thumbnails;
    }

    public WebElement getBigImage() {
        return bigImage;
    }

    public boolean areThumbnailsMaximized() {
        switchToIframe(iframe);
        boolean areThumbnailsMaximized = false;
        for (WebElement thumbnail : thumbnails) {
            hoverOverElement(thumbnail);
            String bigImageUrl = trimImageUrl(getBigImage().getAttribute("src"));
            logger.info("-----> Big image's url is {}", bigImageUrl + " <-----");
            String thumbnailUrl = trimImageUrl(thumbnail.getAttribute("href"));
            logger.info("-----> Thumbnail's url is {}", thumbnailUrl + " <-----");

            if (thumbnailUrl.equals(bigImageUrl)) {
                areThumbnailsMaximized = true;
            }
        }
        return areThumbnailsMaximized;
    }

    private String trimImageUrl(String url) {
        return url.substring(0, 40);
    }

    private void switchToIframe(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        driver.switchTo().frame(element);
        logger.info("-----> Switched to iframe <------");
    }
}

