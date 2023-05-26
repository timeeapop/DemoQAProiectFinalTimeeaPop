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
        /*
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement textBox = driver.findElement(By.id("item-0"));
        Assert.assertTrue(textBox.isDisplayed());
        textBox.click();

         */
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
        /*
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement textBox = driver.findElement(By.id("item-0"));
        Assert.assertTrue(textBox.isDisplayed());
        textBox.click();

         */
        accessTextBoxPage();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        textBoxPage.selectSubmit();
        textBoxPage.checkOutput();
        Assert.assertEquals("", "");
    }

    //TEST
    /*
    @Test
    public void checkIfCompletingInvalidEmailAddressIsAvailable() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement textBox = driver.findElement(By.id("item-0"));
        Assert.assertTrue(textBox.isDisplayed());
        textBox.click();

        textBoxPage.selectFullName("a");
        textBoxPage.selectEmail("a");
        textBoxPage.selectCurrentAddress("a");
        textBoxPage.selectPermanentAddress("a");
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        textBoxPage.selectSubmit();
        JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
        scrollUp.executeScript("window.scrollTo(0, 0);");


        By errorLocator = By.cssSelector("mr-sm-2 field-error form-control");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        Assert.assertTrue(errorEmail.isDisplayed());

        ======

        WebElement errorEmail = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mr-sm-2 field-error form-control")));
        Assert.assertTrue(errorEmail.isDisplayed());
        ======

        WebElement errorEmail = driver.findElement(By.cssSelector("input#email.mr-sm-2.field-error.form-control"));
        Assert.assertTrue(errorEmail.isDisplayed());



        // nu merge asa .. ar mai fi o varianta de vazut de verificat ca output ii gol - check TEST4
    }
    */


    //TEST4
    @Test
    public void checkIfCompletingInvalidEmailAddressIsAvailable2() {
        /*
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement textBox = driver.findElement(By.id("item-0"));
        Assert.assertTrue(textBox.isDisplayed());
        textBox.click();

         */
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