package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver){
        super(driver);
    }

    //Locators and methods for buttons page
    By DoubleClickMeButton = By.id("doubleClickBtn");
    public void selectDoubleClickMeButton() {
       // Actions actions = new Actions(driver);
       // actions.doubleClick(DoubleClickMeButton).perform(); - nu-mi ruleaza testul daca fac asa, asa ca astea is in test puse direct
        driver.findElement(DoubleClickMeButton).click();
        driver.findElement(DoubleClickMeButton).click();
    }

    By ClickMeButton = By.id("1JbrN");
    public void selectClickMeButton() {
        driver.findElement(ClickMeButton).click(); // nu merge asa - element has a dynamic ID care se schimba de fiecare data
    }
}
