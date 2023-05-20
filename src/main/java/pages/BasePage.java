package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
}
