import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.NoAlertPresentException;

public class VerifyLogin1_PositiveTest extends Base{
    @Test
    public void verifyPageTitle(){
        String getPageTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(getPageTitle, expectedTitle);
    }


    @Test
    @Parameters({"userName", "password"})
    public void verifyLogin(String userName, String password){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        GenericFunctions screenshot = new GenericFunctions();
        screenshot.captureScreenshot(driver, "LoginPositive");
        driver.findElement(By.linkText("Logout")).click();
    }
}
