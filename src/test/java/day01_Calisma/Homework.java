package day01_Calisma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {
    public static void main(String[] args) throws InterruptedException {


      //  1.Yeni bir class olusturalim (day01_Calisma.Homework)

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");

        String baslik= driver.getTitle();
        String dogrulanacakKelime="faacebook";
        if (baslik.equals(dogrulanacakKelime)){
            System.out.println("Sayfa basligi facebook");
        }else{
            System.out.println("actual title : "+ driver.getTitle());

        }
        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.

        if (driver.getCurrentUrl().contains("faccebook")){
            System.out.println("URL facebook iceriyor PASSED");

        }else{
            System.out.println("actual URL : "+ driver.getCurrentUrl());
        }

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        Thread.sleep(2000);

        //6. Tekrar “facebook” sayfasina donun

        driver.navigate().back();

        //7. Sayfayi yenileyin

        Thread.sleep(2000);

        driver.navigate().refresh();

        //8. Sayfayi tam sayfa (maximize) yapin

        driver.manage().window().maximize();

        //9.Browser’i kapatin
        Thread.sleep(2000);
        driver.close();

    }
}
