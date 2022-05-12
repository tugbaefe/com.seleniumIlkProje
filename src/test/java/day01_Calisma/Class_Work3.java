package day01_Calisma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class_Work3 {
    public static void main(String[] args) throws InterruptedException {

       // 1. Yeni bir Class olusturalim.C06_ManageWindow
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        // 3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Amazon sayfa boyut : "+driver.manage().window().getSize());
        System.out.println("Amazon sayfa konum : "+driver.manage().window().getPosition());

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        Thread.sleep(3000);
        System.out.println("Amazon sayfa boyut maximize sonrasi : "+driver.manage().window().getSize());
        System.out.println("Amazon sayfa konum maximize sonrasi : "+driver.manage().window().getPosition());

        //7. Sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Amazon sayfa boyut fullscreen sonrasi : "+driver.manage().window().getSize());
        System.out.println("Amazon sayfa konum fullscreen sonrasi : "+driver.manage().window().getPosition());

        //9. Sayfayi kapatin
        driver.close();


    }
}
