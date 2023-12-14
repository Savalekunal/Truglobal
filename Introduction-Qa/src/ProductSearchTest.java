import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kunal\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
    }

    @Test
    public void testProductSearch() {
        // Navigate to Amazon.in
        driver.get("https://www.amazon.in/");

        // Search  iPhone
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

        WebElement firstResult = driver.findElement(By.cssSelector("div[data-asin][data-index='0']"));
        firstResult.click();

        // Get the price 
        WebElement priceElement = driver.findElement(By.id("priceblock_ourprice"));
        String price = priceElement.getText();

        // Add to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
