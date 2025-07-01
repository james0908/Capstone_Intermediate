import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyLogin2_NegativeTest extends Base{

    @Test(priority = 1)
    public void verifyPageTitle(){
        String getPageTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(getPageTitle, expectedTitle);
    }


    @Test(priority = 0)
    @Parameters({"userName", "password"})
    public void verifyLogin(String userName, String password){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String loginErrorText = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        String expectedText = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginErrorText, expectedText);
        GenericFunctions screenshot = new GenericFunctions();
        screenshot.captureScreenshot(driver, "LoginNegative");
    }
}
