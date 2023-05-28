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

    //TEST1
    @Test
    public void loginWithValidUser() {
        accessLoginPage();

        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectUserName("timipoptest");
        loginPage.selectPassword("Mv!kQp3zQN@TRkp");
        loginPage.selectLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameAfterLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
        Assert.assertEquals("timipoptest", userNameAfterLogin.getText());
    }

    //TEST2
    @Test
    public void loginWithValidUserThanLogout() {
        accessLoginPage();

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
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

    }

    //TEST3
    @Test
    public void clickOnNewUserButtonFromLoginPage() {
        accessLoginPage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectNewUserButton();

        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));
    }

    //TEST4
    @Test
    public void loginWithInvalidUsernameAndPassword() {
        accessLoginPage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectUserName("vsfkjdnkjdsfn");
        loginPage.selectPassword("sclksvsnsvn");
        loginPage.selectLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Assert.assertEquals("Invalid username or password!", errorMessage.getText());
    }

    //TEST5
    @Test
    public void clickOnLoginWithoutCompletingUserNameAndPassword() {
        accessLoginPage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        loginPage.selectLoginButton();
        WebElement emptyUser = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mr-sm-2.is-invalid.form-control")));
        Assert.assertTrue(emptyUser.isDisplayed());
    }
}
