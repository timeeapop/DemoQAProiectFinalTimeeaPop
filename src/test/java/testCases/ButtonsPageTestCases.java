package testCases;

import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.ButtonsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckBoxPage;

import java.time.Duration;

public class ButtonsPageTestCases extends BasePage {
    private ButtonsPage buttonsPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        buttonsPage = new ButtonsPage(driver);
    }

    //TEST1
    @Test
    public void doubleClickOnDoubleClickMeButton() {
        /*
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        WebElement buttons = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("item-4")));
        buttons.click();

         */
        accessButtonsPage();
        //buttonsPage.selectDoubleClickMeButton(); - it does not work daca am pus de doua ori click in metoda
        WebElement doubleClickMeButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMeButton).perform();
        WebElement successMessageForDoubleClick = driver.findElement(By.id("doubleClickMessage"));
        //System.out.println("Result Text: " + successMessageForDoubleClick.getText());
        Assert.assertEquals(successMessageForDoubleClick.getText(),"You have done a double click");
    }

    //TEST2
    @Test
    public void clickOnClickMeButton() {
        accessButtonsPage();
        //buttonsPage.selectClickMeButton();
        WebElement lastButton = driver.findElement(By.xpath("(//button)[last()]")); //(//button) selects all the button elements on the page, and [last()] filters it to only select the last button element.
        lastButton.click();
        WebElement successMessageForClickMe = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(successMessageForClickMe.getText(), "You have done a dynamic click");
    }

    //TEST3
    @Test
    public void clickOnRightClickMeButton() {
        accessButtonsPage();
        WebElement rightClickMeButton = driver.findElement(By.id("rightClickBtn"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMeButton).perform();
        WebElement successMessageForRightClickMe = driver.findElement(By.id("rightClickMessage"));
        Assert.assertEquals(successMessageForRightClickMe.getText(), "You have done a right click");
    }
}
