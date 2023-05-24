package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RadioButtonPage extends BasePage{
    public RadioButtonPage(WebDriver driver){
        super(driver);
    }

    //Locators and methods for radio button page
    By YesButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    public void selectYesButton() {
        driver.findElement(YesButton).click();
    }

    By ImpressiveButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    public void selectImpressiveButton() {
        driver.findElement(ImpressiveButton).click();
    }

    By NoButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label");
    public void selectNoButton() {
        driver.findElement(NoButton).click();
    }
}
