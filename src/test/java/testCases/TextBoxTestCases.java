package testCases;
import pages.BookStoreApplicationBooklistPage;
import pages.TextBoxPage;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class TextBoxTestCases extends BasePage {
    private TextBoxPage textBoxPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        textBoxPage = new TextBoxPage(driver);
    }

    //TEST1
    @Test
    public void checkOutputWithAllInputsCompleted(){
        accessTextBoxPage();
        textBoxPage.selectFullName("timi pop");
        textBoxPage.selectEmail("pop.timeea15@gmail.com");
        textBoxPage.selectCurrentAddress("Penes Curcanu nr.28");
        textBoxPage.selectPermanentAddress("Strada Lunga nr.6");
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        textBoxPage.selectSubmit();
        textBoxPage.checkOutput();

        Assert.assertEquals("Name:timi pop\n" +
                "\n" +
                "Email:pop.timeea15@gmail.com\n" +
                "\n" +
                "Current Address :Penes Curcanu nr.28\n" +
                "\n" +
                "Permananet Address :Strada Lunga nr.6",
                "Name:timi pop\n" +
                "\n" +
                "Email:pop.timeea15@gmail.com\n" +
                "\n" +
                "Current Address :Penes Curcanu nr.28\n" +
                "\n" +
                "Permananet Address :Strada Lunga nr.6");
    }

    //TEST2
    @Test
    public void checkOutputWithoutHavingAnyInputCompleted() {
        accessTextBoxPage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        textBoxPage.selectSubmit();
        textBoxPage.checkOutput();
        Assert.assertEquals("", "");
    }

    //TEST3
    @Test
    public void checkIfCompletingInvalidEmailAddressIsAvailable() {
        accessTextBoxPage();
        textBoxPage.selectFullName("a");
        textBoxPage.selectEmail("a");
        textBoxPage.selectCurrentAddress("a");
        textBoxPage.selectPermanentAddress("a");
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        textBoxPage.selectSubmit();
        JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
        scrollUp.executeScript("window.scrollTo(0, 0);");

        By errorLocator = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        Assert.assertTrue(errorEmail.isDisplayed());
    }

    //TEST4
    @Test
    public void checkIfCompletingInvalidEmailAddressIsAvailable2() {
        accessTextBoxPage();
        textBoxPage.selectFullName("a");
        textBoxPage.selectEmail("a");
        textBoxPage.selectCurrentAddress("a");
        textBoxPage.selectPermanentAddress("a");
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        textBoxPage.selectSubmit();
        //JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
        //scrollUp.executeScript("window.scrollTo(0, 0);");
        textBoxPage.checkOutput();
        Assert.assertEquals("", "");
    }
}
