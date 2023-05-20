package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class RegisterToBookStorePage extends BasePage {
    public RegisterToBookStorePage(WebDriver driver){
        super(driver);
    }

    // locators and methods for Register new account page
    By FirstName = By.xpath("//*[@id=\"firstname\"]");
    public void selectFirstNameSection (String arg1) {
        driver.findElement(FirstName).click();
        driver.findElement(FirstName).sendKeys(arg1);
    }

    By LastName = By.xpath("//*[@id=\"lastname\"]");
    public void selectLastNameSection (String arg2) {
        driver.findElement(LastName).click();
        driver.findElement(LastName).sendKeys(arg2);
    }

    By UserName = By.xpath("//*[@id=\"userName\"]");
    public void selectUserNameSection (String arg3) {
        driver.findElement(UserName).click();
        driver.findElement(UserName).sendKeys(arg3);
    }

    By Password = By.xpath("//*[@id=\"password\"]");
    public void selectPasswordSection (String arg4) {
        driver.findElement(Password).click();
        driver.findElement(Password).sendKeys(arg4);
    }

    By RegisterButton = By.id("register");
    public void selectRegisterButton() {
        driver.findElement(RegisterButton).click();
        driver.findElement(RegisterButton).click();
    }

    By BackToLoginButton = By.id("gotologin");
    public void selectBackToLoginButton() {
        driver.findElement(BackToLoginButton).click();
    }

    By ReadCaptchaButton = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]");
    public void selectCaptchaButton() {
        driver.findElement(ReadCaptchaButton).click();
    }

}
