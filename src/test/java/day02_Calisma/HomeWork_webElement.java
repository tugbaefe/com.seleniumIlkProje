package day02_Calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeWork_webElement {
    /*
    1. Bir class oluşturun : AmazonSearchTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. web sayfasına gidin. https://www. amazon.com/
    b. Search(ara) “city bike”
    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
    d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.google web sayfasına gidin. https://www. amazon.com/
        driver.get("https://www.amazon.com");

        // b. Search(ara) “city bike”
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> ilgiliSonuc= driver.findElements(By.className("sg-col-inner"));
        WebElement ilgiliSonucElementi=ilgiliSonuc.get(0);
        System.out.println(ilgiliSonucElementi.getText());

        // d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> ilkSonuc=driver.findElements(By.className("s-image"));
        WebElement ilkSonucElementi=ilkSonuc.get(0);
        ilkSonucElementi.click();

         /*
         Xpath ile Cozumu
        WebElement ilgiliSonucSayisi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(ilgiliSonucSayisi.getText());

        WebElement ilkResim= driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkResim.click();

          */


    }
}
