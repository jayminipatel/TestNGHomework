import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGHomework {
    WebDriver driver;
    @Test(priority = 1)
    void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        System.out.println("Web page open successfully");
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    void computer() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img")).click();
        System.out.println("Successfully done");
        Thread.sleep(1000);

    }

    @Test(priority = 3)
    void addToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button-3")).click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("/html/body/div[5]/div/p"));
        Assert.assertTrue(message.isDisplayed(), "The Product has been added to your cart");

    }
    @Test(priority = 4)
    void shoppingCart() {
        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();
    }
@Test(priority = 5)
    void clearQuantity() {
        driver.findElement(By.className("qty-input")).clear();
    driver.findElement(By.className("qty-input")).sendKeys("3");
    System.out.println("Successfully  add quantity 3");

        }
        @Test(priority = 6)
     void termsAndCondition(){
        driver.findElement(By.id("termsofservice")).click();
         System.out.println("Terms and conditions ticked successfully");
         driver.findElement(By.id("checkout")).click();
            System.out.println("Successfully check out");
     }
     @Test(priority = 7)

     void guestCheckOut(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
         System.out.println("Guest check out successfully");
     }
     @Test(priority = 8)
     void billingInformation() throws InterruptedException {
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Tester");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Software");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("123testng@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("NHS");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("UK");
        driver.findElement(By.id("BillingNewAddress_StateProvinceId")).sendKeys("UK");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 map");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("AB3 8RT");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("01234567899");
        driver.findElement(By.name("save")).click();
        System.out.println("Successfully enter all information");
        Thread.sleep(1000);


     }
     @Test(priority = 9)

     void shippingMethod(){
         driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
         System.out.println("Successfully select the method");
     }
     @Test(priority = 10)
     void payMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("paymentmethod_1")).click();
         System.out.println("Payment successfully");
     }
     @Test(priority = 11)
     void paymentMethod(){

        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
         System.out.println("payment method successfully");

     }
     @Test(priority = 12)
     void paymentInformation() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("CardholderName")).sendKeys("abcd");
        driver.findElement(By.id("CardNumber")).sendKeys("1234567891011111111111");
        driver.findElement(By.name("ExpireMonth")).sendKeys("04");
        driver.findElement(By.name("ExpireYear")).sendKeys("2024");
        driver.findElement(By.id("CardCode")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
     }
     @Test(priority = 13)
     void confirmedOrder() throws InterruptedException {
        Thread.sleep(1000);
         driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
         System.out.println("Successfully confirmed the payment");
         String actualpageurl =driver.getCurrentUrl();
         String expactedpageurl = "https://demo.nopcommerce.com/checkout/completed";
         if (actualpageurl.equals(expactedpageurl)){
             System.out.println("Payment has done successfully and order has been confirmed");
         }
         else {
             System.out.println("Order has not been confirmed");
         }
     }
     @Test(priority = 14)
     void comeBackToHomepage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button")).click();
         System.out.println("successfully back to homepage");
     }

     }













