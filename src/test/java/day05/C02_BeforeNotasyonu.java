package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeNotasyonu {

    //amazon sayfasina gidip 3 farkli methodu hazirlayin
    //her method'da farki aramalar yapalim
    static WebDriver driver;
    WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void Test1 (){
        searchBox.clear();
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
    }
    @Test
    public void Test2 (){
        searchBox.clear();
        searchBox.sendKeys("Bycicle"+ Keys.ENTER);
    }
    @Test
    public void Test3 (){
        searchBox.clear();
        searchBox.sendKeys("Java"+ Keys.ENTER);
    }

    @AfterClass
    public static void tearDown(){
    driver.close();
    }
}
