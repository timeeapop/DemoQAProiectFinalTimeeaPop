package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.BookStoreApplicationBooklistPage;
import pages.RegisterToBookStorePage;
import java.time.Duration;


public class RegisterToBookStoreTestCases extends BasePage {
    private RegisterToBookStorePage registerToBookStorePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
       registerToBookStorePage = new RegisterToBookStorePage(driver);
    }
/*
    @Test
    public void enterNewUserDetails() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
        driver.findElement(By.id("newUser")).click();
        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));

        registerToBookStorePage.selectFirstNameSection("Timi");
        registerToBookStorePage.selectLastNameSection("Pop");
        registerToBookStorePage.selectUserNameSection("timipop");
        registerToBookStorePage.selectPasswordSection("12345678");
    }

    @Test
    public void createNewAccountWithoutMarkingCaptchaButton() {
        driver.manage().window().maximize();
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
        driver.findElement(By.id("newUser")).click();
        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        registerToBookStorePage.selectFirstNameSection("Timi1");
        registerToBookStorePage.selectLastNameSection("Pop1");
        registerToBookStorePage.selectUserNameSection("timipop1");
        registerToBookStorePage.selectPasswordSection("12345678");
        registerToBookStorePage.selectRegisterButton();

        WebElement errorMessage = driver.findElement(By.id("name"));
        Assert.assertEquals("Please verify reCaptcha to register!", errorMessage.getText());
    }

    @Test
    public void getBackToLoginPageAfterAccessingRegisterPage() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
        driver.findElement(By.id("newUser")).click();
        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        registerToBookStorePage.selectBackToLoginButton();
        String currentUrlThree = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }

 */

    @Test
    public void clickOnRegisterButtonWithoutCompletingDetails() {
        driver.manage().window().maximize();
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
        driver.findElement(By.id("newUser")).click();
        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        registerToBookStorePage.selectRegisterButton();
        WebElement emptyUserName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mr-sm-2.is-invalid.form-control")));
        Assert.assertTrue(emptyUserName.isDisplayed());
    }
}
