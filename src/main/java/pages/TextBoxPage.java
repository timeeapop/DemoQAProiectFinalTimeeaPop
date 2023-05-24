package pages;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TextBoxPage extends BasePage{
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    By FullName = By.id("userName");
    public void selectFullName(String arg1) {
        driver.findElement(FullName).click();
        driver.findElement(FullName).sendKeys(arg1);
    }

    By Email = By.id("userEmail");
    public void selectEmail(String arg2) {
        driver.findElement(Email).click();
        driver.findElement(Email).sendKeys(arg2);
    }

    By CurrentAddress = By.id("currentAddress");
    public void selectCurrentAddress(String arg3) {
        driver.findElement(CurrentAddress).click();
        driver.findElement(CurrentAddress).sendKeys(arg3);
    }

    By PermanentAddress = By.id("permanentAddress");
    public void selectPermanentAddress(String arg4) {
        driver.findElement(PermanentAddress).click();
        driver.findElement(PermanentAddress).sendKeys(arg4);
    }

    By SubmitButton = By.id("submit");
    public void selectSubmit() {
        driver.findElement(SubmitButton).click();
    }

    By Output = By.id("output");
    public void checkOutput() {
        driver.findElement(Output).isDisplayed();
        driver.findElement(Output).getText();
    }
}
