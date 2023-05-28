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
import pages.ModalDialogsPage;
import java.time.Duration;
public class ModalDialogsTestCases extends BasePage {
    private ModalDialogsPage modalDialogsPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        modalDialogsPage = new ModalDialogsPage(driver);
    }

    //TEST1
    @Test
    public void openSmallModalAndCheckDescriptionText() {
        /*
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
         */
        accessModalDialogPage();
        modalDialogsPage.selectSmallModalButton();
        WebElement smallModalTitle = driver.findElement(By.id("example-modal-sizes-title-sm"));
        Assert.assertEquals(smallModalTitle.getText(), "Small Modal");
        WebElement smallModalDescriptionText = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]"));
        Assert.assertEquals(smallModalDescriptionText.getText(), "This is a small modal. It has very less content");
    }

    //TEST2
    @Test (priority = 1)
    public void openSmallModalAndCloseItWithXButton() {
        accessModalDialogPage();
        modalDialogsPage.selectSmallModalButton();
        modalDialogsPage.selectXBtnToCloseSmallModal();
    }

    //TEST3
    @Test
    public void openSmallModalAndCloseItWithCloseButton() {
        accessModalDialogPage();
        modalDialogsPage.selectSmallModalButton();
        modalDialogsPage.selectCloseSmallModalButton();
    }

    //TEST4
    @Test
    public void openLargeModalAndCheckTitleAndDescription() {
        accessModalDialogPage();
        modalDialogsPage.selectLargeModalButton();
        WebElement largeModalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
        System.out.println(largeModalTitle.getText());
        Assert.assertEquals(largeModalTitle.getText(), "Large Modal");
        WebElement largeModalTitleDescription = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]"));
        System.out.println(largeModalTitleDescription.getText());
        Assert.assertEquals(largeModalTitleDescription.getText(), "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
    }

    //TEST5
    @Test
    public void openLargeModalAndCloseItWithXButton() {
        accessModalDialogPage();
        modalDialogsPage.selectLargeModalButton();
        modalDialogsPage.selectXBtnToCloseLargeModal();
    }

    //TEST6
    @Test
    public void openLargeModalAndCloseItWithCloseButton() {
        accessModalDialogPage();
        modalDialogsPage.selectLargeModalButton();
        modalDialogsPage.selectCloseLargeModalButton();
    }
}
