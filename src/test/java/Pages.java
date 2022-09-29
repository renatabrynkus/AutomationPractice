import org.junit.jupiter.api.BeforeEach;
import pages.HeaderPage;
import pages.ProductPage;
import pages.ProductQuickViewPage;

public class Pages extends BaseTest {

    public HeaderPage headerPage;
    public ProductPage productPage;
    public ProductQuickViewPage productQuickViewPage;

    @BeforeEach
    public void pagesSetup() {
        headerPage = new HeaderPage(driver);
        productPage = new ProductPage(driver);
        productQuickViewPage = new ProductQuickViewPage(driver);
    }
}
