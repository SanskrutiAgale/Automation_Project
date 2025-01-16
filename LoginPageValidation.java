package ASSIGNMENT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager; // Ensure this library is included
import java.time.Duration;

public class LoginPageValidation {
    public static void main(String[] args) {
    	
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app-staging.nokodr.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@type, 'email')]")
            ));
            usernameField.sendKeys("sanskrutiagale04@gmail.com");

            WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@type, 'password')]")
            ));
            passwordField.sendKeys("Agale@123");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'slds-button_destructive')]")
            ));
            loginButton.click();

            System.out.println("Login process completed successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred during the login process: " + e.getMessage());
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

