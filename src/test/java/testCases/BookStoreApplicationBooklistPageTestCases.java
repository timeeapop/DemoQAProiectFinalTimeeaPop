package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.BookStoreApplicationBooklistPage;

public class BookStoreApplicationBooklistPageTestCases extends BasePage{
    private BookStoreApplicationBooklistPage bookStoreApplicationBooklistPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        bookStoreApplicationBooklistPage = new BookStoreApplicationBooklistPage(driver);
    }

    @Test (priority = 1)
    public void clickOnImageSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectImageColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    @Test (priority = 2)
    public void clickOnTitleSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectTitleColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    @Test
    public void clickOnAuthorSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectAuthorColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    @Test
    public void clickOnPublisherSection() {
        String initialAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        bookStoreApplicationBooklistPage.selectPublisherColumn();
        String updatedAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertNotEquals(initialAuthor, updatedAuthor);
    }

    @Test
    public void searchForAvailableBookByAuthorWithValidInput() {
        bookStoreApplicationBooklistPage.selectSearchBar("Addy");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals("Addy Osmani", firstAuthor);
    }

    @Test
    public void searchForAvailableBookByPublisherWithValidInput() {
        bookStoreApplicationBooklistPage.selectSearchBar("No Starch");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals("Marijn Haverbeke", firstAuthor);
    }

    @Test
    public void searchForBookWithInvalidInputNumbers() {
        bookStoreApplicationBooklistPage.selectSearchBar("123");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals(" ", firstAuthor);
    }

    @Test
    public void searchForBookWithInvalidInputSpecialCharacters() {
        bookStoreApplicationBooklistPage.selectSearchBar("!@#");
        String firstAuthor = bookStoreApplicationBooklistPage.getAuthorForRow(1);
        Assert.assertEquals(" ", firstAuthor);
    }

    @Test
    public void accessLoginPageFromBookstoreList() {
        bookStoreApplicationBooklistPage.selectLoginButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }
}
