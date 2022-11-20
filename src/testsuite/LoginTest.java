package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //public static WebDriver driver;
    String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username field element and pass the value
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        // find password field element and send key to field
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("admin123");

        // click on submit button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        // Verify the ‘Welcome’ text is display

        //Verify dashboard text after login
        String expectedMessage = "Dashboard";

        //Find Log out text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMessage = actualTextMessageElement.getText();

        //Validate actual and expected
        Assert.assertEquals("Text message not found", expectedMessage, actualMessage);
    }





    @After
    public void closing() {
        closingBrowser();

    }
}