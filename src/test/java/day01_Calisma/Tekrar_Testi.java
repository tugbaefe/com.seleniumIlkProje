package day01_Calisma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tekrar_Testi {
    public static void main(String[] args) throws InterruptedException {

      //  1. Yeni bir class olusturun (TekrarTesti)

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");
        if (driver.getTitle().equals("youutube")){
            System.out.println("Actual Title youtube PASSED");

        }else{
            System.out.println("Actual Title : "+driver.getTitle());
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        //URL'yi yazdırın.

        if (driver.getCurrentUrl().contains("yooutube")){
            System.out.println("URL youtube iceriyor PASSED");
        }else{
            System.out.println("Sayfa URL : "+driver.getCurrentUrl());
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

        //5. Youtube sayfasina geri donun

        driver.navigate().back();

        //6. Sayfayi yenileyin

        driver.navigate().refresh();

        //7. Amazon sayfasina donun

        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
        //doğru başlığı(Actual Title) yazdırın.

        if (driver.getTitle().contains("Amazzon")){
            System.out.println("Actual title PASSED");
        }else{
            System.out.println("Actual title : "+driver.getTitle());
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
      if (driver.getCurrentUrl().equals("https://www.amazon.com/")){
          System.out.println("Url testi PASSED");
      }else{
          System.out.println("Dogru URL: "+ driver.getCurrentUrl());
      }

      //11.Sayfayi kapatin
       // driver.close(); WARNING: Connection reset
        //java.net.SocketException: Connection reset hata aliyorum sayafayi kapatirken



    }
}
