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
import pages.ProfilePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
public class ProfilePageTestCases extends BasePage{
    private ProfilePage profilePage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        profilePage = new ProfilePage(driver);
    }

    //TEST1

    @Test
    public void scrollThroughBooksOnProfile(){
        driver.manage().window().maximize();
        loginWithValidUser();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        WebElement profileButton = driver.findElement(By.id("item-3"));
        scrollDown.executeScript("arguments[0].scrollIntoView(true);", profileButton);
        profileButton.click();

        String initialAuthor = profilePage.getAuthorForRow(1);
        profilePage.selectNextButton();
        String updatedAuthor = profilePage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }


    @Test
    public void scrollThroughBooksOnProfile2() {
        driver.manage().window().maximize();
        loginWithValidUser();
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;

        // Scroll down to the profile button
        WebElement profileButton = driver.findElement(By.id("item-3"));
        scrollDown.executeScript("arguments[0].scrollIntoView(true);", profileButton);

        // Scroll further down if needed
        scrollDown.executeScript("window.scrollBy(0, 200);");

        // Wait for the profile button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        profileButton = wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();

        String initialAuthor = profilePage.getAuthorForRow(1);
        profilePage.selectNextButton();
        String updatedAuthor = profilePage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    @Test
    public void scrollThroughBooksOnProfile3() {
        driver.manage().window().maximize();
        loginWithValidUser();

        Actions actions = new Actions(driver);
        WebElement loginButton = driver.findElement(By.id("item-0"));

        // Scroll to the profile button using moveToElement()
        actions.moveToElement(loginButton).perform();

        // Press the Arrow Down key to scroll further down
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // Wait for the profile button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        WebElement profileButtonLink = driver.findElement(By.xpath("//*[@id=\"loading-label\"]/a"));
        profileButtonLink.click();

        String initialAuthor = profilePage.getAuthorForRow(1);
        profilePage.selectNextButton();
        String updatedAuthor = profilePage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

}
