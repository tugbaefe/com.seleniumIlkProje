package day03_Calisma_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TekrarTesti_Xpath {
    public static void main(String[] args) {

        /*
    2 https://www.amazon.com/ adresine gidin
    3 Browseri tam sayfa yapin
    4 Sayfayi “refresh” yapin
    5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6 Gift Cards sekmesine basin
    7 Birthday butonuna basin
    8 Best Seller bolumunden ilk urunu tiklayin
    9 Gift card details’den 25 $’i secin
    10 Urun ucretinin 25$ oldugunu test edin
    10 Sayfayi kapatin
         */
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2 https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        //3 Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4 Sayfayi “refresh” yapin
        driver.navigate().refresh();
        // 5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin

        String baslik=driver.getTitle();
        if (baslik.contains("Spend less")){
            System.out.println("Baslik testi PASSED");
        }else{
            System.out.println("Baslik testi FAILED");
        }

        // 6 Gift Cards sekmesine basin
        List<WebElement> giftCards=driver.findElements(By.linkText("Gift Cards"));
        WebElement giftCardsElementi=giftCards.get(0);
        giftCardsElementi.click();

        //7 Birthday butonuna basin
        WebElement birthdaySekmesi=driver.findElement(By.xpath("//a[@aria-label='Birthday gift cards']"));
        birthdaySekmesi.click();

        //8 Best Seller bolumunden ilk urunu tiklayin
        WebElement bestSeller= driver.findElement(By.xpath("(//span[@class='acswidget-carousel__title'])[1]"));

        WebElement bestSellerIlkUrun= driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]"));
        bestSellerIlkUrun.click();

        //9 Gift card details’den 25 $’i secin
        WebElement giftCard= driver.findElement(By.xpath("(//hr[@aria-hidden='true'])[1]"));
        WebElement giftCard25Dolar= driver.findElement(By.id("gc-mini-picker-amount-1"));
        giftCard25Dolar.click();
       // String expectedGiftCardFiyat="25$";
       // String actualGiftCardFiyat=giftCard25Dolar.getText();

        //10 Urun ucretinin 25$ oldugunu test edin

        if (giftCard25Dolar.equals("25$")){
            System.out.println("Urun ucreti testi PASSED");
        }else{
            System.out.println("Urun ucreti testi FAILED");
        }

        driver.close();







    }
}
