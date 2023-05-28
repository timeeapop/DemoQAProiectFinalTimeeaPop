package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private String baseUrl = "https://demoqa.com/books";
    public BasePage() {
        // Default constructor
    }
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "\"C:\\Users\\baciu\\Desktop\\chromedriver_win32\\chromedriver.exe\"");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
/*
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

 */

    public void loginWithValidUser(){
        driver.manage().window().maximize();
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys("timipoptest");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Mv!kQp3zQN@TRkp");
        driver.findElement(By.id("login")).click();
        //Assert.assertTrue(currentUrl.contains("/books"));
        //JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        //scrollDown.executeScript("window.scrollTo(0, 1000);");
    }

    public void accessCheckboxPage() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-1")));
        checkBox.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/checkbox"));
    }

    public void accessLoginPage() {
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }

    public void accessRadioButtonPage() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-2")));
        radioButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/radio-button"));
    }

    public void accessRegisterToBookStorePage() {
        driver.manage().window().maximize();
        driver.findElement(By.id("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
        driver.findElement(By.id("newUser")).click();
        String currentUrlTwo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlTwo.contains("/register"));
    }

    public void accessTextBoxPage() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement textBox = driver.findElement(By.id("item-0"));
        Assert.assertTrue(textBox.isDisplayed());
        textBox.click();
    }

    public void accessButtonsPage() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement buttons = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("item-4")));
        buttons.click();
    }

    public void accessWebTablesPage() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webTables = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-3")));
        webTables.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/webtables"));
    }

    public void accessModalDialogPage() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://demoqa.com/"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]")).click();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WebElement modalDialogButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[5]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(modalDialogButton).perform();
        String modalDialogsUrl = driver.getCurrentUrl();
        Assert.assertTrue(modalDialogsUrl.contains("https://demoqa.com/modal-dialogs"));
    }
}
