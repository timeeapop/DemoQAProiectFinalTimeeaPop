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

    //TEST1
    @Test
    public void enterNewUserDetailsWithInvalidPasswordInput() {
        accessRegisterToBookStorePage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        registerToBookStorePage.selectFirstNameSection("Timi");
        registerToBookStorePage.selectLastNameSection("Pop");
        registerToBookStorePage.selectUserNameSection("timipop");
        registerToBookStorePage.selectPasswordSection("12345678");

    }

    //TEST2
    @Test
    public void createNewAccountWithoutMarkingCaptchaButton() {
        accessRegisterToBookStorePage();
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

    //TEST3
    @Test
    public void getBackToLoginPageAfterAccessingRegisterPage() {
        accessRegisterToBookStorePage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        registerToBookStorePage.selectBackToLoginButton();
        String currentUrlThree = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlThree.contains("/login"));
    }

    //TEST4
    @Test
    public void clickOnRegisterButtonWithoutCompletingDetails() {
        accessRegisterToBookStorePage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        registerToBookStorePage.selectRegisterButton();
        WebElement emptyUser = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mr-sm-2.is-invalid.form-control")));
        Assert.assertTrue(emptyUser.isDisplayed());
    }
}
