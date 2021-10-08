package day05;

import org.junit.Test;

public class C01_Notasyon {
    //Java daki gibi Selenium'da da belirli islevleri yapan method'lar olusturabiliriz
    //ancak bu methodlar cagrilmadikca calismazlar

    public void ilkTestMethodu(){
        System.out.println("Ilk test methodu");
    }
    //JUnit ile notasyon kullanarak siradan method'lari test method'una donusturebiliriz
    //Bir Test method'u bagimsiz olarak calisabilen test yapmamiza imkan verir
    //Test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    @Test
    public void notasyonluIlkTestMethodu(){
        System.out.println("notasyonlu ilk test methodumuz");
    }
}
