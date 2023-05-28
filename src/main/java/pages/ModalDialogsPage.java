package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;

public class ModalDialogsPage extends BasePage {
    public ModalDialogsPage(WebDriver driver){
        super(driver);
    }

    //Locators and methods for Modal Dialog page
    // SMALL MODAL
    By SmallModalButton = By.id("showSmallModal");
    public void selectSmallModalButton() {
        driver.findElement(SmallModalButton).click();
    }

    By CloseSmallModalButton = By.id("closeSmallModal");
    public void selectCloseSmallModalButton() {
        driver.findElement(CloseSmallModalButton).click();
    }

    By XBtnToCloseSmallModal = By.xpath("/html/body/div[4]/div/div/div[1]/button");
    public void selectXBtnToCloseSmallModal() {
        driver.findElement(XBtnToCloseSmallModal).click();
    }

    // LARGE MODAL
    By LargeModalButton = By.id("showLargeModal");
    public void selectLargeModalButton() {
        driver.findElement(LargeModalButton).click();
    }

    By CloseLargeModalButton = By.id("closeLargeModal");
    public void selectCloseLargeModalButton() {
        driver.findElement(CloseLargeModalButton).click();
    }

    By XBtnToCloseLargeModal = By.xpath("/html/body/div[4]/div/div/div[1]/button");
    public void selectXBtnToCloseLargeModal() {
        driver.findElement(XBtnToCloseLargeModal).click();
    }

}
