import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserRegistrationTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kunal\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        //  WebDriver
        WebDriver driver = new ChromeDriver();
    }

    @Test
    public void testUserRegistration() {
        // Navigate to Amazon.in
        driver.get("https://www.amazon.in/");

        WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
        signInButton.click();

        // Create your Amazon account
        WebElement createAccountButton = driver.findElement(By.id("createAccountSubmit"));
        createAccountButton.click();

        // Fill in registration detail
        WebElement nameField = driver.findElement(By.id("ap_customer_name"));
        nameField.sendKeys("Your Name");

        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("your.email@example.com");

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("yourpassword");

        WebElement confirmPasswordField = driver.findElement(By.id("ap_password_check"));
        confirmPasswordField.sendKeys("yourpassword");

        // Click on the "Create your Amazon account" 
        WebElement createAccountSubmitButton = driver.findElement(By.id("continue"));
        createAccountSubmitButton.click();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
