package ASSIGNMENT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Scanner;

public class SignupPageValidation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://app-staging.nokodr.com/");
            driver.manage().window().maximize();

            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign up']")));
            signUpButton.click();

            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
            emailField.sendKeys("sanskrutiagale04@gmail.com");

            WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='slds-checkbox_faux']")));
            termsCheckbox.click();

            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//abx-button[contains(@class, 'btn')]//button")));
            proceedButton.click();

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter the OTP sent to your email: ");
                String otpCode = scanner.nextLine();

                WebElement otpField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'id_')]")));
                otpField.sendKeys(otpCode);
            }
            WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//abx-button[@name='verifyCode']//button")));
            verifyButton.click();

            WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_17364501337443107']")));
            firstNameField.sendKeys("Sanskruti");

            WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_17364501337449279']")));
            lastNameField.sendKeys("Agale");

            WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_17364501337455888']")));
            passwordField.sendKeys("Agale@123");

            WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_17364501337455888-confirmpassword']")));
            confirmPasswordField.sendKeys("Agale@123");

            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//abx-button[@name='register']//button")));
            registerButton.click();

            System.out.println("Sign Up successful! You can now log in.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

