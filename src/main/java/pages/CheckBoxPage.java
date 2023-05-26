package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxPage extends BasePage{
    public CheckBoxPage(WebDriver driver){
        super(driver);
    }

    //Locators and methods for Checkboxpage
    By HomeToggle = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    public void selectHomeToggle() {
        driver.findElement(HomeToggle).click();
    }

    By HomeFileCheckbox = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]");
    public void selectHomeCheckbox() {
        driver.findElement(HomeFileCheckbox).click();
    }

    By ExpandAllButton = By.xpath("//*[@id=\"tree-node\"]/div/button[1]");
    public void selectExpandAllButton() {
        driver.findElement(ExpandAllButton).click();
    }

    By CollapseAllButton = By.xpath("//*[@id=\"tree-node\"]/div/button[2]");
    public void selectCollapseAllButton() {
        driver.findElement(CollapseAllButton).click();
    }

    By DesktopFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label");
    By DesktopFileToggle = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button");
    public void checkIfDesktopFileIsDisplayed() {
        driver.findElement(DesktopFile).isDisplayed();
        Assert.assertTrue(driver.findElement(DesktopFile).isDisplayed());
    }
    public void selectDesktopFileToggle() {
        driver.findElement(DesktopFileToggle).click();
    }
    public void selectDesktopFileCheckBox(){
        driver.findElement(DesktopFile).click();
    }

    By NotesFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label");
    public void checkIfNotesFileIsDisplayed(){
        driver.findElement(NotesFile).isDisplayed();
        Assert.assertTrue(driver.findElement(NotesFile).isDisplayed());
    }
    public void selectNotesFile() {
        driver.findElement(NotesFile).click();
    }

    By CommandsFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label");
    public void checkIfCommandsFileIsDisplayed() {
        driver.findElement(CommandsFile).isDisplayed();
        Assert.assertTrue(driver.findElement(CommandsFile).isDisplayed());
    }
    public void selectCommandsFile() {
        driver.findElement(CommandsFile).click();
    }
    By DocumentsFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label");
    By DocumentsFileToggle = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/ol/li/ol/li[2]/span/button");
    public void checkIfDocumentsFileIsDisplayed() {
        driver.findElement(DocumentsFile).isDisplayed();
        Assert.assertTrue(driver.findElement(DocumentsFile).isDisplayed());
    }
    public void selectDocumentsFileToggle() {
        driver.findElement(DocumentsFileToggle).click();
    }
    public void selectDocumentsFileCheckbox(){
        driver.findElement(DocumentsFile).click();
    }

    By WorkspaceFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/label");
    public void checkIfWorkspaceFileIsDisplayed() {
        driver.findElement(WorkspaceFile).isDisplayed();
        Assert.assertTrue(driver.findElement(WorkspaceFile).isDisplayed());
    }
    public void selectWorkspaceFile() {
        driver.findElement(WorkspaceFile).click();
    }

    By ReactFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label");
    public void checkIfReactFileIsDisplayed() {
        driver.findElement(ReactFile).isDisplayed();
        Assert.assertTrue(driver.findElement(ReactFile).isDisplayed());
    }

    By AngularFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label");
    public void checkIfAngularFileIsDisplayed() {
        driver.findElement(AngularFile).isDisplayed();
        Assert.assertTrue(driver.findElement(AngularFile).isDisplayed());
    }

    By VeuFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label");
    public void checkIfVeuFileIsDisplayed() {
        driver.findElement(VeuFile).isDisplayed();
        Assert.assertTrue(driver.findElement(VeuFile).isDisplayed());
    }

    By OfficeFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label");
    public void checkIfOfficeFileIsDisplayed() {
        driver.findElement(OfficeFile).isDisplayed();
        Assert.assertTrue(driver.findElement(OfficeFile).isDisplayed());
    }
    public void selectOfficeFile() {
        driver.findElement(OfficeFile).click();
    }

    By PublicFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label");
    public void checkIfPublicFileIsDisplayed() {
        driver.findElement(PublicFile).isDisplayed();
        Assert.assertTrue(driver.findElement(PublicFile).isDisplayed());
    }

    By PrivateFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[2]/span/label");
    public void checkIfPrivateFileIsDisplayed() {
        driver.findElement(PrivateFile).isDisplayed();
        Assert.assertTrue( driver.findElement(PrivateFile).isDisplayed());
    }

    By ClassifiedFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label");
    public void checkIfClassifiedFileIsDisplayed() {
        driver.findElement(ClassifiedFile).isDisplayed();
        Assert.assertTrue(driver.findElement(ClassifiedFile).isDisplayed());
    }

    By GeneralFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label");
    public void checkIfGeneralFileIsDisplayed() {
        driver.findElement(GeneralFile).isDisplayed();
        Assert.assertTrue(driver.findElement(GeneralFile).isDisplayed());
    }

    By DownloadsFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label");
    By DownloadsFileToggle = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/ol/li/ol/li[3]/span/button");
    public void checkIfDownloadsFileIsDisplayed() {
        driver.findElement(DownloadsFile).isDisplayed();
        Assert.assertTrue(driver.findElement(DownloadsFile).isDisplayed());
    }
    public void selectDownloadsFileToggle() {
        driver.findElement(DownloadsFileToggle).click();
    }
    public void selectDownloadsFileCheckbox() {
        driver.findElement(DownloadsFile).click();
    }

    By WordfileFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label");
    public void checkIfWordfileFileIsDisplayed() {
        driver.findElement(WordfileFile).isDisplayed();
        Assert.assertTrue(driver.findElement(WordfileFile).isDisplayed());
    }
    public void selectWordfileFile() {
        driver.findElement(WordfileFile).click();
    }

    By ExcelfileFile = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label");
    public void checkIfExcelfileFileIsDisplayed() {
        driver.findElement(ExcelfileFile).isDisplayed();
        Assert.assertTrue(driver.findElement(ExcelfileFile).isDisplayed());

    }
    public void selectExcelfileFile() {
        driver.findElement(ExcelfileFile).click();
    }

}
