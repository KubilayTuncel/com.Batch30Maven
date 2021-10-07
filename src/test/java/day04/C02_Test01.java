package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun
        //2- https://www.walmart.com/ adresine gidin
        //3- Browseri tam sayfa yapin
        //4-Sayfayi “refresh” yapin
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        //7- URL in walmart.com icerdigini control edin
        //8-”Nutella” icin arama yapiniz
        //9- Kac sonuc bulundugunu yaziniz
        //10-Sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.walmart.com/");
        driver.navigate().refresh();
        String actualTitle=driver.getTitle();
        String arananKelime= "Save";
        if (actualTitle.contains(arananKelime)){
            System.out.println("title"+arananKelime+"kelimesi icerioyr, test PASS");
        }else{
            System.out.println("title"+arananKelime+"kelimesi icermiyor, test Failed");
        }

        String expectedTitle="Walmart.com | Save Money.Live Better";
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Sayfa title'i beklenen ile ayni, test PASS");
        }else{
            System.out.println("Sayfa title'i ile ayni degil, test Failed");
            System.out.println("actula title : "+actualTitle);
        }

        String actualURL=driver.getCurrentUrl();
        String urlArananKelime="walmart.com";
        if (actualURL.contains(urlArananKelime)){
            System.out.println("URL "+ urlArananKelime+"kelimesi iceriyor, test PASS");
        }else{
            System.out.println("URL "+urlArananKelime+ " kelimesi icermiyor, test Failed");
        }
        //8-”Nutella” icin arama yapiniz
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazisiElementi.getText());
        //10-Sayfayi kapatin
        driver.close();

    }
}
