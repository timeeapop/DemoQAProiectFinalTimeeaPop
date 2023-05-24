package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreApplicationBooklistPage extends BasePage{
    public BookStoreApplicationBooklistPage(WebDriver driver){
        super(driver);
    }

    //Locators + methods for book list
    By Image = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]");
    public void selectImageColumn() {
        driver.findElement(Image).click();
        driver.findElement(Image).click();
    }

    By Title = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]");
    public void selectTitleColumn() {
        driver.findElement(Title).click();
        driver.findElement(Title).click();
    }

    By Author = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[3]");
    public void selectAuthorColumn() {
        driver.findElement(Author).click();
    }

    By Publisher = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[4]");
    public void selectPublisherColumn() {
        driver.findElement(Publisher).click();
    }

    public String getAuthorForRow(int rowNumber) {
        WebElement authorElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]"));
        return authorElement.getText();
    }


    By SearchBar = By.id("searchBox");
    public void selectSearchBar(String arg1) {
        driver.findElement(SearchBar).click();
        driver.findElement(SearchBar).sendKeys(arg1);
    }

    By LoginButton = By.id("login");
    public void selectLoginButton() {
        driver.findElement(LoginButton).click();
    }

    By Elements = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span");
    public void selectElements() {
        driver.findElement(Elements).click();
    }

    By TextBox = By.id("item-0");
    public void selectTextBox() {
        driver.findElement(TextBox).click();
    }

    By CheckBox = By.id("item-1");
    public void selectCheckBox() {
        driver.findElement(CheckBox).click();
    }

    By RadioButton = By.id("item-2");
    public void selectRadioButton() {
        driver.findElement(RadioButton).click();
    }

    By WebTables = By.id("item-3");
    public void selectWebTables() {
        driver.findElement(WebTables).click();
    }

    By Buttons = By.id("item-4");
    public void selectButtons() {
        driver.findElement(Buttons).click();
    }

    By Links = By.id("item-5");
    public void selectLinks() {
        driver.findElement(Links).click();
    }

    By BrokenLinks = By.id("item-6");
    public void selectBrokenLinks() {
        driver.findElement(BrokenLinks).click();
    }

    By UploadAndDownload = By.id("item-7");
    public void selectUploadAndDownload() {
        driver.findElement(UploadAndDownload).click();
    }

    By DynamicProperties = By.id("item-8");
    public void selectDynamicProperties() {
        driver.findElement(DynamicProperties).click();
    }

    By Forms = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/span/div");
    public void selectForms() {
        driver.findElement(Forms).click();
    }

    By AlertsFrameAndWindows = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div");
    public void selectAlertsFrameAndWindows() {
        driver.findElement(AlertsFrameAndWindows).click();
    }

    By Widgets = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[2]/div[2]/svg");
    public void selectWidgets () {
        driver.findElement(Widgets).click();
    }

    By Interactions = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[5]/span/div");
    public void selectInteractions() {
        driver.findElement(Interactions).click();
    }
}
