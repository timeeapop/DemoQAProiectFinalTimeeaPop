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
}
