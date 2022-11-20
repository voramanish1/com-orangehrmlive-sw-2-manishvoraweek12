package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //Find forgot password link and click
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        //Verify reset message text on reset password page
        String expectedMessage = "Reset Password";

        //Find reset message element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String actualMessage = actualTextMessageElement.getText();

        //Validate actual and expected
        Assert.assertEquals("Text not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closingBrowser();
    }
}