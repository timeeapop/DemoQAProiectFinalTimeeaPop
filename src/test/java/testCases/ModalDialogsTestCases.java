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
import pages.ModalDialogsPage;
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
        Assert.assertEquals(largeModalTitle.getText(), "Large Modal");
        WebElement largeModalTitleDescription = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]"));
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
