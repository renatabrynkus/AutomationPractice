import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest extends Pages {

    @ParameterizedTest
    @CsvSource({"WOMEN, Blouses"})
    void test(String category, String subcategory) {
        headerPage.hoverOverElement(headerPage.getHeaderCategory(category))
                .clickOnElement(headerPage.getSubcategory(subcategory));
        productPage.hoverOverElement(productPage.getProductsInCategory().get(0))
                .clickOnElement(productPage.getQuickView());
        assertThat(productQuickViewPage.areThumbnailsMaximized()).isTrue();
    }
}
