package day01_Calisma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class_Work1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Yeni bir package olusturalim : day01
        2. Yeni bir class olusturalim : C03_GetMethods
      */
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        //4. Sayfa basligini(title) yazdirin
        driver.getTitle();
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        if (driver.getTitle().contains("Amazon")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");
        Thread.sleep(2000);
        // 6. Sayfa adresini(url) yazdirin
        driver.getCurrentUrl();
        // 7. Sayfa url’inin “amazon” icerdigini test edin.
        if (driver.getCurrentUrl().contains("amazon")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        Thread.sleep(2000);

        //8. Sayfa handle degerini yazdirin
        System.out.println("Handle degeri : "+ driver.getWindowHandle());
        //CDwindow-17C2387EE435B3A7E185E903090CB621

        Thread.sleep(2000);
        // 9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String htmlKodlari=driver.getPageSource();
        String arananKelime="alisveris";
        if (htmlKodlari.contains(arananKelime)){
            System.out.println("Kaynak kodu testi PASSED");
        }else{
            System.out.println("Kaynak kodlarinda " + arananKelime + " yok, test FAILED");
        }
        //10. Sayfayi kapatin.
        driver.close();
    }
}
