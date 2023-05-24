package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.BookStoreApplicationBooklistPage;
import pages.RadioButtonPage;
import java.time.Duration;

public class RadioButtonTestCases extends BasePage {
    private RadioButtonPage radioButtonPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        radioButtonPage = new RadioButtonPage(driver);
    }

    //TEST1
    @Test
    public void checkIfCursorStyleIsChangedWhenHoveringItOverNoButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement radioButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("item-2")));
        radioButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/radio-button"));

        WebElement noButton = driver.findElement(By.id("noRadio"));
        // this creates an instance of the Actions class
        Actions actions = new Actions(driver);
        // Moving the cursor to the "No" radio button
        actions.moveToElement(noButton).perform();
        // Get the cursor style attribute of the "No" radio button
        String cursorStyle = noButton.getCssValue("cursor");
        // Verify that the cursor style is changed when hovering over the "No" radio button
        assert !cursorStyle.equals("auto") : "Cursor style did not change on hover.";
    }

    //TEST2
    @Test
    public void checkIfNoButtonIsClickableSecond() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement radioButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("item-2")));
        radioButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/radio-button"));

        WebElement noButton = driver.findElement(By.id("noRadio"));
        Assert.assertFalse(noButton.isEnabled());
    }

    //TEST3
    @Test
    public void clickOnYesButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-2")));
        radioButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/radio-button"));

        radioButtonPage.selectYesButton();
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    //TEST4
    @Test
    public void clickOnImpressiveButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-2")));
        radioButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/radio-button"));

        radioButtonPage.selectImpressiveButton();
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span"));
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
