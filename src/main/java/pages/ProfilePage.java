package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver){
        super(driver);
    }
    //Locators and methods for Profile Page
    By NextButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/button");
    public void selectNextButton(){
        driver.findElement(NextButton).click();
    }

    By GoToStoreButton = By.id("gotoStore");
    public void selectGoToStoreButton(){
        driver.findElement(GoToStoreButton).click();
    }
    public String getAuthorForRow(int rowNumber) {
        WebElement authorElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]"));
        return authorElement.getText();
    }
}
