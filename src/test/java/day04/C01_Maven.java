package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //class in basinda implicitlyWait komutu yazilirsa bu test boyunca
        //her locater icin driver maximum yazilan zaman kadar bekler
        driver.get("https://www.amazon.com/");
        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //<div class="a-section a-spacing-small a-spacing-top-small">
        //                <span dir="auto">1-16 of over 1,000 results for</span><span dir="auto"> </span><span class="a-color-state a-text-bold" dir="auto">"samsung headphones"</span>
        //            </div>
        //WebElement sonucYazisiElementi= driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        //By.className ile locate ettigimiz webElemntinde class attribute nin degeri
        //bosluk varsa locater saglikli calismayabilir
        //System.out.println(sonucYazisiElementi.getText());
        WebElement sonucYazisiElementi1= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi1.getText());
        //<span class="a-size-medium a-color-base a-text-normal">SAMSUNG Galaxy Buds 2 True Wireless Earbuds Noise Cancelling Ambient Sound Bluetooth Lightweight Comfort Fit Touch Control US Version, White</span>
        //WebElement ilkUrunElementi= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal])[1]"));
        //ilkUrunElementi.click();
        //eger sadece click yapcaksak
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        driver.navigate().back();
        List<WebElement>  urunlerListesi=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for  (WebElement each:urunlerListesi
             ) {
            System.out.println(each.getText());
        }

    }
}
