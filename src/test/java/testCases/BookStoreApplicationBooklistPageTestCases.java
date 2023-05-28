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
import java.time.Duration;

public class BookStoreApplicationBooklistPageTestCases extends BasePage{
    private BookStoreApplicationBooklistPage bookStoreApplicationBooklistPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        bookStoreApplicationBooklistPage = new BookStoreApplicationBooklistPage(driver);
    }

    //TEST1
    @Test (priority = 1)
    public void clickOnImageSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectImageColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    //TEST2
    @Test (priority = 2)
    public void clickOnTitleSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectTitleColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    //TEST3
    @Test
    public void clickOnAuthorSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectAuthorColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    //TEST4
    @Test
    public void clickOnPublisherSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectPublisherColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    //TEST5
    @Test
    public void searchForAvailableBookByAuthorWithValidInput() {
        bookStoreApplicationBooklistPage.selectSearchBar("Addy");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals("Addy Osmani", firstAuthor);
    }

    //TEST6
    @Test
    public void searchForAvailableBookByPublisherWithValidInput() {
        bookStoreApplicationBooklistPage.selectSearchBar("No Starch");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals("Marijn Haverbeke", firstAuthor);
    }

    //TEST7
    @Test
    public void searchForBookWithInvalidInputNumbers() {
        bookStoreApplicationBooklistPage.selectSearchBar("123");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals(" ", firstAuthor);
    }

    //TEST8
    @Test
    public void searchForBookWithInvalidInputSpecialCharacters() {
        bookStoreApplicationBooklistPage.selectSearchBar("!@#");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals(" ", firstAuthor);
    }

    //TEST9
    @Test
    public void accessLoginPageFromBookstoreList() {
        bookStoreApplicationBooklistPage.selectLoginButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }

    //TEST10
    @Test
    public void clickOnElementsSectionFromLeftMenuAndCheckIfListIsDisplayed(){
        bookStoreApplicationBooklistPage.selectElements();
        WebElement textBox = driver.findElement(By.id("item-0"));
        Assert.assertTrue(textBox.isDisplayed());
        WebElement checkBox = driver.findElement(By.id("item-1"));
        Assert.assertTrue(checkBox.isDisplayed());
        WebElement radioButton = driver.findElement(By.id("item-2"));
        Assert.assertTrue(radioButton.isDisplayed());
        WebElement webTables = driver.findElement(By.id("item-3"));
        Assert.assertTrue(webTables.isDisplayed());
        WebElement buttons = driver.findElement(By.id("item-4"));
        Assert.assertTrue(buttons.isDisplayed());
        WebElement links = driver.findElement(By.id("item-5"));
        Assert.assertTrue(links.isDisplayed());
        WebElement brokenLinks = driver.findElement(By.id("item-6"));
        Assert.assertTrue(brokenLinks.isDisplayed());
        WebElement uploadAndDownload = driver.findElement(By.id("item-7"));
        Assert.assertTrue(uploadAndDownload.isDisplayed());
        WebElement dynamicProperties = driver.findElement(By.id("item-8"));
        Assert.assertTrue(dynamicProperties.isDisplayed());
    }

    //TEST11
    @Test
    public void clickOnFirstItemFromElementsList() {
        bookStoreApplicationBooklistPage.selectElements();
        bookStoreApplicationBooklistPage.selectTextBox();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/text-box"));
    }

    //TEST12
    @Test (priority = 3)
    public void clickOnSecondItemFromElementsList() {
        driver.manage().window().maximize();
        bookStoreApplicationBooklistPage.selectElements();
        WebElement checkBox  = driver.findElement(By.id("item-1"));
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("arguments[0].scrollIntoView(true);", checkBox);
        bookStoreApplicationBooklistPage.selectCheckBox();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/checkbox"));
    }

    //TEST13
    @Test (priority = 5)
    public void clickOnThirdItemFromElementsList() {
        driver.manage().window().maximize();
        bookStoreApplicationBooklistPage.selectElements();
        WebElement radioButton  = driver.findElement(By.id("item-2"));
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("arguments[0].scrollIntoView(true);", radioButton);
        bookStoreApplicationBooklistPage.selectRadioButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/radio-button"));
    }
}
