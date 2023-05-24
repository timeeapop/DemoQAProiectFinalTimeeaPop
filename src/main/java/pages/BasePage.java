package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
    @AfterMethod //folosim @AfterMethod daca vrem sa inchidem browserul dupa fiecare test case in parte
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
       // Assert.assertTrue(currentUrl.contains("/books"));
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollTo(0, 1000);");
    }
}
