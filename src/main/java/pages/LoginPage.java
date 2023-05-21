package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    // locators and methods from login page
    By UserName = By.id("userName");
    public void selectUserName(String arg1) {
        driver.findElement(UserName).click();
        driver.findElement(UserName).sendKeys(arg1);
    }

    By Password = By.id("password");
    public void selectPassword(String agr2) {
        driver.findElement(Password).click();
        driver.findElement(Password).sendKeys(agr2);
    }

    By LoginButton = By.id("login");
    public void selectLoginButton() {
        driver.findElement(LoginButton).click();
    }

    By NewUserButton = By.id("newUser");
    public void selectNewUserButton() {
        driver.findElement(NewUserButton).click();
    }
}
