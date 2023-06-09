package testCases;

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
import pages.CheckBoxPage;
import java.time.Duration;

public class CheckBoxTestCases extends BasePage {
    private CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        checkBoxPage = new CheckBoxPage(driver);
    }

    //TEST1
    @Test
    public void expandListWithMainElements() {
        //driver.manage().window().maximize();
        accessCheckboxPage();
        checkBoxPage.selectHomeToggle();
        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();

    }

    //TEST2
    @Test
    public void selectHomeCheckBox() throws InterruptedException {
        accessCheckboxPage();
        checkBoxPage.selectHomeCheckbox();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" +
                "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }


    //TEST3
    @Test
    public void expandEntireListWithExpandAllButton() {
        accessCheckboxPage();
        checkBoxPage.selectExpandAllButton();
        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfNotesFileIsDisplayed();
        checkBoxPage.checkIfCommandsFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfWorkspaceFileIsDisplayed();
        checkBoxPage.checkIfReactFileIsDisplayed();
        checkBoxPage.checkIfAngularFileIsDisplayed();
        checkBoxPage.checkIfVeuFileIsDisplayed();
        checkBoxPage.checkIfOfficeFileIsDisplayed();
        checkBoxPage.checkIfPublicFileIsDisplayed();
        checkBoxPage.checkIfPrivateFileIsDisplayed();
        checkBoxPage.checkIfClassifiedFileIsDisplayed();
        checkBoxPage.checkIfGeneralFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();
        checkBoxPage.checkIfWordfileFileIsDisplayed();
        checkBoxPage.checkIfExcelfileFileIsDisplayed();
    }

    //TEST4
    @Test
    public void expandThenCollapseEntireListWithCollapseAllButton() {
        accessCheckboxPage();
        checkBoxPage.selectExpandAllButton();
        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfNotesFileIsDisplayed();
        checkBoxPage.checkIfCommandsFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfWorkspaceFileIsDisplayed();
        checkBoxPage.checkIfReactFileIsDisplayed();
        checkBoxPage.checkIfAngularFileIsDisplayed();
        checkBoxPage.checkIfVeuFileIsDisplayed();
        checkBoxPage.checkIfOfficeFileIsDisplayed();
        checkBoxPage.checkIfPublicFileIsDisplayed();
        checkBoxPage.checkIfPrivateFileIsDisplayed();
        checkBoxPage.checkIfClassifiedFileIsDisplayed();
        checkBoxPage.checkIfGeneralFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();
        checkBoxPage.checkIfWordfileFileIsDisplayed();
        checkBoxPage.checkIfExcelfileFileIsDisplayed();
        checkBoxPage.selectCollapseAllButton();
        WebElement HomeFile = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li"));
        Assert.assertTrue(HomeFile.isDisplayed());
    }


    //TEST5
    @Test(priority = 1)
    public void expandFullListThanCollapseListToMainFiles() {
        accessCheckboxPage();
        checkBoxPage.selectExpandAllButton();
        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfNotesFileIsDisplayed();
        checkBoxPage.checkIfCommandsFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfWorkspaceFileIsDisplayed();
        checkBoxPage.checkIfReactFileIsDisplayed();
        checkBoxPage.checkIfAngularFileIsDisplayed();
        checkBoxPage.checkIfVeuFileIsDisplayed();
        checkBoxPage.checkIfOfficeFileIsDisplayed();
        checkBoxPage.checkIfPublicFileIsDisplayed();
        checkBoxPage.checkIfPrivateFileIsDisplayed();
        checkBoxPage.checkIfClassifiedFileIsDisplayed();
        checkBoxPage.checkIfGeneralFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();
        checkBoxPage.checkIfWordfileFileIsDisplayed();
        checkBoxPage.checkIfExcelfileFileIsDisplayed();

        checkBoxPage.selectDesktopFileToggle();
        checkBoxPage.selectDocumentsFileToggle();
        checkBoxPage.selectDownloadsFileToggle();

        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();
    }

    //TEST6
    @Test
    public void expandListToTheMainElementsAndSelectEachFile() {
        accessCheckboxPage();
        checkBoxPage.selectHomeToggle();
        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();

        checkBoxPage.selectDesktopFileCheckBox();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You have selected :\n" + "desktop\n" + "notes\n" + "commands");

        checkBoxPage.selectDocumentsFileCheckbox();
        WebElement resultSecond = driver.findElement(By.id("result"));
        Assert.assertEquals(resultSecond.getText(), "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" +
                "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general");

        checkBoxPage.selectDownloadsFileCheckbox();
        WebElement resultThird = driver.findElement(By.id("result"));
        Assert.assertEquals(resultThird.getText(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" +
                "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }


    //TEST7
    @Test
    public void expandMainFilesAndClickOnTheFilesIncludedInMainFiles() {
        accessCheckboxPage();
        checkBoxPage.selectHomeToggle();
        checkBoxPage.checkIfDesktopFileIsDisplayed();
        checkBoxPage.checkIfDocumentsFileIsDisplayed();
        checkBoxPage.checkIfDownloadsFileIsDisplayed();

        checkBoxPage.selectDesktopFileToggle();
        checkBoxPage.selectNotesFile();
        WebElement firstResult = driver.findElement(By.id("result"));
        Assert.assertEquals(firstResult.getText(), "You have selected :\n" + "notes");
        checkBoxPage.selectCommandsFile();
        WebElement secondResult = driver.findElement(By.id("result"));
        Assert.assertEquals(secondResult.getText(), "You have selected :\n" + "desktop\n" + "notes\n" + "commands");

        checkBoxPage.selectDocumentsFileToggle();
        checkBoxPage.selectWorkspaceFile();
        WebElement thirdResult = driver.findElement(By.id("result"));
        Assert.assertEquals(thirdResult.getText(), "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "workspace\n" + "react\n" + "angular\n" + "veu");
        checkBoxPage.selectOfficeFile();
        WebElement fourthResult = driver.findElement(By.id("result"));
        Assert.assertEquals(fourthResult.getText(), "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" +
                "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general");

        checkBoxPage.selectDownloadsFileToggle();
        checkBoxPage.selectWordfileFile();
        WebElement fifthResult = driver.findElement(By.id("result"));
        Assert.assertEquals(fifthResult.getText(), "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" +
                "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "wordFile");
        checkBoxPage.selectExcelfileFile();
        WebElement sixthResult = driver.findElement(By.id("result"));
        Assert.assertEquals(sixthResult.getText(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" +
                "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }
}
