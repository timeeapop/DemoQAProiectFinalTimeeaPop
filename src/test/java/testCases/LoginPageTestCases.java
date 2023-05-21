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
import pages.LoginPage;
import java.time.Duration;
public class LoginPageTestCases extends BasePage{
    private LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidUser() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectUserName("timipoptest");
        loginPage.selectPassword("Mv!kQp3zQN@TRkp");
        loginPage.selectLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameAfterLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
        Assert.assertEquals("timipoptest", userNameAfterLogin.getText());
    }
    @Test
    public void loginWithValidUserThanLogout() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectUserName("timipoptest");
        loginPage.selectPassword("Mv!kQp3zQN@TRkp");
        loginPage.selectLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameAfterLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
        Assert.assertEquals("timipoptest", userNameAfterLogin.getText());
        WebElement logoutButton = driver.findElement(By.id("submit"));
        logoutButton.click();
        Assert.assertTrue(currentUrl.contains("/login"));

    }

    @Test
    public void clickOnNewUserButtonFromLoginPage(){
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectNewUserButton();

        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));
    }

    @Test
    public void loginWithInvalidUsernameAndPassword() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectUserName("vsfkjdnkjdsfn");
        loginPage.selectPassword("sclksvsnsvn");
        loginPage.selectLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Assert.assertEquals("Invalid username or password!", errorMessage.getText());
    }

    @Test
    public void clickOnLoginWithoutCompletingUserNameAndPassword() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectLoginButton();
        WebElement emptyUser = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mr-sm-2.is-invalid.form-control")));
        Assert.assertTrue(emptyUser.isDisplayed());
    }
}