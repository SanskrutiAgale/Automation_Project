package ASSIGNMENT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; 
import java.time.Duration;

public class ForgotPasswordValidation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://app-staging.nokodr.com/");
            driver.manage().window().maximize();

            WebElement forgetButton = driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']"));
            forgetButton.click();

            WebElement emailField = driver.findElement(By.xpath("//input[contains(@type, 'email')]"));
            emailField.sendKeys("abc123@gmail.com");

            WebElement proceedButton = driver.findElement(By.xpath("//button[contains(text(), 'Proceed')]"));
            proceedButton.click();

            WebElement successMessageElement = driver.findElement(By.xpath("//div[contains(@id, 'successMessage')]"));
            String successMessage = successMessageElement.getText();
            System.out.println("Success Message: " + successMessage);

            emailField.clear();
            emailField.sendKeys("invalid-email");

            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
            submitButton.click();

            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(@id, 'errorMessage')]"));
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error Message: " + errorMessage);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
        	
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();
        }
    }
}
