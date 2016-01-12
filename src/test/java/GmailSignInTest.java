import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by chowdhuryamirhossain on 10/22/15.
 */
public class GmailSignInTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void gmailLoginShouldBeSuccessful(){

        //Go to gmail website

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://gmail.com");

        //Fill in the username
        WebElement userNameTextBox = driver.findElement(By.id("Email"));
        userNameTextBox.clear();
        userNameTextBox.sendKeys("chowdhury.hassan117@gmail.com");

        //click Next
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();


        //fill in the password
        WebElement passwordTextBox = driver.findElement(By.id("Passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("abir1234");

        //click SignIn
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        //verify signIn
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);

    }

    @Test

    public void gmailSendAndReceiveTest(){

        //Go to gmail website

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://gmail.com");

        //Fill in the username
        WebElement userNameTextBox = driver.findElement(By.id("Email"));
        userNameTextBox.clear();
        userNameTextBox.sendKeys("chowdhury.hassan117@gmail.com");

        //click Next
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();


        //fill in the password
        WebElement passwordTextBox = driver.findElement(By.id("Passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("abir1234");

        //click SignIn
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        //verify signIn
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);

        //find compose
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        composeButton.click();

        //input the receipent address
        WebElement receipentAddress = driver.findElement(By.cssSelector("textarea[name='to']"));
        receipentAddress.clear();
        receipentAddress.sendKeys("chowdhury.hassan117@gmail.com");

        //input the subject
        WebElement subjectArea = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        final String subject = "Send gmail test email";
        subjectArea.clear();
        subjectArea.sendKeys(subject);

        //write in the body area
        WebElement bodyArea = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        final String emailBody = "Good Morning!";
        bodyArea .clear();
        bodyArea.sendKeys(emailBody);

        //send button
        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendButton.click();

        //click inbox again
        WebElement inboxAgain = driver.findElement(By.linkText("Inbox (1)"));
        inboxAgain.click();

        //click on the email.
        WebElement newEmail = driver.findElement(By.cssSelector());
        newEmail.click();

        //verify the subject and the body area
        WebElement verifySubject = driver.findElement(By.cssSelector());
        Assert.assertEquals("The subject should be the same", subject, verifySubject.getText() );

        WebElement verifyBody = driver.findElement(By.cssSelector());
        Assert.assertEquals("The body should be the same", emailBody, verifyBody.getText() );

        //
    }

    @After
    public void closeDown(){
        driver.close();
    }

}
