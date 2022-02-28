package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTest(){
        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL bulunamadi", expectedUrl,actualUrl);
    }
    @Test
    public void titleTest(){
        String istenmeyenKeime="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse("istenmeyen kelime title da var", actualTitle.contains(istenmeyenKeime));
    }

    @Test
    public void logoTest(){
        WebElement logotest= driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue("logo mevcut degil", logotest.isDisplayed());
    }

    @Test
    public void FrancaisLinkTest(){
        WebElement linkTest= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue("Fransizca link mevcut degil",linkTest.isDisplayed());
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
