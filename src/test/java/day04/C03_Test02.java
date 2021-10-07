package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {
    public static void main(String[] args) {
        //1. http://zero.webappsecurity.com sayfasina gidin
        //2. Signin buttonuna tiklayin
        //3. Login alanine  “username” yazdirin
        //4. Password alanine “password” yazdirin
        //5. Sign in buttonuna tiklayin
        //6. Pay Bills sayfasina gidin
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina “2020-09-10” yazdirin
        //9. Pay buttonuna tiklayin
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.xpath("//button[@class='signin btn btn-info']")).click();


        WebElement logInAlani= driver.findElement(By.xpath("//input[@id='user_login']"));
        logInAlani.sendKeys("username");
        WebElement password= driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@id='primary-button']")).click();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        WebElement basariliYazisi= driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (basariliYazisi.isDisplayed()){
            System.out.println("test PASS");
        }else{
            System.out.println("test Failed");
        }



    }
}
