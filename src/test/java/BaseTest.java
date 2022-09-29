import configuration.AppProperties;
import configuration.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    private static AppProperties appProperties;

    @BeforeAll
    static void beforeAll() {
        logger.info("-----> Getting properties from config.yaml file <-----");
        try {
            appProperties = AppProperties.getInstance();
        } catch (WebDriverException e) {
            logger.error("-----> Unable to open the website <------");
        }
    }

    @BeforeEach
    void setUp() {
        driver = new DriverFactory().getDriver();
        logger.info("-----> Opening the website <-----");
        driver.get(System.getProperty("appUrl"));
    }

    @AfterEach
    void quit() {
        logger.info("-----> Quitting driver <----");
        driver.quit();
    }
}
