import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.*;

public class ClassOne {
    WebDriver driver ;
    @Test(priority = 1)
    void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        System.out.println("Web page open successfully");
    }
    @Test(priority = 2)
    void registration(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Tester");
        driver.findElement(By.id("LastName")).sendKeys("Software");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("06");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("June");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1983");
        driver.findElement(By.id("Email")).sendKeys("ab12@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("NHS");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();
        System.out.println("Registration done successfully");
    }
    @Test(priority = 3)
    void logIn(){
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("ab12@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
        System.out.println("Log in successfully");
    }
    @Test(priority = 4)
    void logOut(){
     driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
     String actualhomepage =driver.getCurrentUrl();
     String expactedhomepage = "https://demo.nopcommerce.com/";
     if (actualhomepage.equals(expactedhomepage)){
         System.out.println("Homepage is correct");
     }
     else {
         System.out.println("Homepage is incorrect");
        }
        }
        @Test(priority = 5)
        void closeBrowser(){
        driver.close();
            System.out.println("Browser close successfully");



    }
}
