package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablesPage extends BasePage {
    public WebTablesPage(WebDriver driver){
        super(driver);
    }

    //Locators and methods for web tables page

    By AddButton = By.id("addNewRecordButton");
    public void selectAddButton() {
        driver.findElement(AddButton).click();
    }

    By FirstName = By.id("firstName");
    public void selectFirstNameAndWriteInput(String arg1) {
        driver.findElement(FirstName).click();
        driver.findElement(FirstName).sendKeys(arg1);
    }

    By LastName = By.id("lastName");
    public void selectLastNameAndWriteInput(String arg2) {
        driver.findElement(LastName).click();
        driver.findElement(LastName).sendKeys(arg2);
    }

    By Email = By.id("userEmail");
    public void selectEmailAndWriteInput(String arg3) {
        driver.findElement(Email).click();
        driver.findElement(Email).sendKeys(arg3);
    }

    By Age = By.id("age");
    public void selectAgeAndWriteInput(String arg4) {
        driver.findElement(Age).click();
        driver.findElement(Age).sendKeys(arg4);
    }

    By Salary = By.id("salary");
    public void selectSalaryAndWriteInput(String arg5) {
        driver.findElement(Salary).click();
        driver.findElement(Salary).sendKeys(arg5);
    }

    By Department = By.id("department");
    public void selectDepartmentAndWriteInput(String arg6) {
        driver.findElement(Department).click();
        driver.findElement(Department).sendKeys(arg6);
    }

    By SubmitButton = By.id("submit");
    public void selectSubmitButton() {
        driver.findElement(SubmitButton).click();
    }

    public String getInputForRowFour(int rowNumber) {
        WebElement userElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div"));
        return userElement.getText();
    }
    public String getInputForRowOne(int rowNumber) {
        WebElement userElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div"));
        return userElement.getText();
    }

    By DeleteButtonForLastRecordInputed = By.id("delete-record-4");
    public void selectDeleteButtonForLastRecordInputed() {
        driver.findElement(DeleteButtonForLastRecordInputed).click();
    }

    By EditButtonForFirstRecord = By.id("edit-record-1");
    public void selectEditButtonForFirstRecord() {
        driver.findElement(EditButtonForFirstRecord).click();
    }

    By SearchButton = By.id("searchBox");
    public void selectSearchButton(String arg7) {
        driver.findElement(SearchButton).click();
        driver.findElement(SearchButton).sendKeys(arg7);
    }
}
