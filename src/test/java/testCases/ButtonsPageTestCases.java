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
        accessButtonsPage();
        executeDoubleClick();
        WebElement successMessageForDoubleClick = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertEquals(successMessageForDoubleClick.getText(),"You have done a double click");
    }

    //TEST2
    @Test
    public void clickOnClickMeButton() {
        accessButtonsPage();
        WebElement lastButton = driver.findElement(By.xpath("(//button)[last()]")); //(//button) selects all the button elements on the page, and [last()] filters it to only select the last button element.
        lastButton.click();
        WebElement successMessageForClickMe = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(successMessageForClickMe.getText(), "You have done a dynamic click");
    }

    //TEST3
    @Test
    public void clickOnRightClickMeButton() {
        accessButtonsPage();
        executeRightClick();
        WebElement successMessageForRightClickMe = driver.findElement(By.id("rightClickMessage"));
        Assert.assertEquals(successMessageForRightClickMe.getText(), "You have done a right click");
    }
}
