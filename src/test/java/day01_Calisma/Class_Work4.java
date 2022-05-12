package day01_Calisma;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class_Work4 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Yeni bir Class olusturalim.C07_ManageWindowSet
         */
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Amazon sayfa konum : "+driver.manage().window().getPosition());
        System.out.println("Amazon sayfa boyut : "+driver.manage().window().getSize());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(16,16));
        driver.manage().window().setSize(new Dimension(900,600));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin

        System.out.println("yeni konum : "+driver.manage().window().getPosition());
        System.out.println("yeni boyut : "+driver.manage().window().getSize());

        //8. Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();




    }
}
