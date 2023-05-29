package testCases;
import pages.BasePage;
import pages.CheckBoxPage;
import pages.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class WebTablesTestCases extends BasePage {
    private WebTablesPage webTablesPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        webTablesPage = new WebTablesPage(driver);
    }

    //TEST1
    @Test
    public void clickOnAddButtonToAddNewValidRecord() {
        driver.manage().window().maximize();
        accessWebTablesPage();
        webTablesPage.selectAddButton();
        WebElement registrationFormModal = driver.findElement(By.xpath("/html/body/div[5]/div/div"));
        Assert.assertTrue(registrationFormModal.isDisplayed());
        webTablesPage.selectFirstNameAndWriteInput("Timi");
        webTablesPage.selectLastNameAndWriteInput("Pop");
        webTablesPage.selectEmailAndWriteInput("pop.timeea15@gmail.com");
        webTablesPage.selectAgeAndWriteInput("23");
        webTablesPage.selectSalaryAndWriteInput("1234");
        webTablesPage.selectDepartmentAndWriteInput("Testing");
        webTablesPage.selectSubmitButton();
        String newUserInputed = webTablesPage.getInputForRowFour(4);
        Assert.assertEquals(newUserInputed, "Timi\n" + "Pop\n" + "23\n" + "pop.timeea15@gmail.com\n" + "1234\n" + "Testing");
    }

    //TEST2
    @Test
    public void deleteLastUserInputed() {
        driver.manage().window().maximize();
        accessWebTablesPage();
        webTablesPage.selectAddButton();
        WebElement registrationFormModal = driver.findElement(By.xpath("/html/body/div[5]/div/div"));
        Assert.assertTrue(registrationFormModal.isDisplayed());
        webTablesPage.selectFirstNameAndWriteInput("Timi");
        webTablesPage.selectLastNameAndWriteInput("Pop");
        webTablesPage.selectEmailAndWriteInput("pop.timeea15@gmail.com");
        webTablesPage.selectAgeAndWriteInput("23");
        webTablesPage.selectSalaryAndWriteInput("1234");
        webTablesPage.selectDepartmentAndWriteInput("Testing");
        webTablesPage.selectSubmitButton();
        String newUserInput = webTablesPage.getInputForRowFour(4);
        Assert.assertEquals(newUserInput, "Timi\n" + "Pop\n" + "23\n" + "pop.timeea15@gmail.com\n" + "1234\n" + "Testing");
        webTablesPage.selectDeleteButtonForLastRecordInputed();
    }

    //TEST3
    @Test
    public void searchForNewUserAdded() {
        driver.manage().window().maximize();
        accessWebTablesPage();
        webTablesPage.selectAddButton();
        WebElement registrationFormModal = driver.findElement(By.xpath("/html/body/div[5]/div/div"));
        Assert.assertTrue(registrationFormModal.isDisplayed());
        webTablesPage.selectFirstNameAndWriteInput("Timi");
        webTablesPage.selectLastNameAndWriteInput("Pop");
        webTablesPage.selectEmailAndWriteInput("pop.timeea15@gmail.com");
        webTablesPage.selectAgeAndWriteInput("23");
        webTablesPage.selectSalaryAndWriteInput("1234");
        webTablesPage.selectDepartmentAndWriteInput("Testing");
        webTablesPage.selectSubmitButton();
        String newUserInput = webTablesPage.getInputForRowFour(4);
        Assert.assertEquals(newUserInput, "Timi\n" + "Pop\n" + "23\n" + "pop.timeea15@gmail.com\n" + "1234\n" + "Testing");
        webTablesPage.selectSearchButton("Timi");
        String userFirstRow = webTablesPage.getInputForRowOne(1);
        Assert.assertEquals(userFirstRow, "Timi\n" + "Pop\n" + "23\n" + "pop.timeea15@gmail.com\n" + "1234\n" + "Testing");

    }

    //TEST4
    @Test
    public void editFirstRecordInTheGivenList() {
        driver.manage().window().maximize();
        accessWebTablesPage();
        webTablesPage.selectEditButtonForFirstRecord();
        webTablesPage.selectFirstNameAndWriteInput("Test");
        webTablesPage.selectLastNameAndWriteInput("Test");
        webTablesPage.selectSubmitButton();
        String newUserInput = webTablesPage.getInputForRowOne(1);
        Assert.assertEquals(newUserInput, "CierraTest\n" + "VegaTest\n" + "39\n" + "cierra@example.com\n" + "10000\n" + "Insurance");
    }

}
