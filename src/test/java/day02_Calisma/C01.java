package day02_Calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        //istedigimiz webElementi bize dondurdu

       /* WebElement aramaKutusu= driver.findElement(By.className("nav-search-field "));
       Bu Locator calismadi hepsi calismak
        zorunda degil calisani bulacagiz
        */

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder=""
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
         */

       /* WebElement aramaKutusu= driver.findElement(By.name("field-keywords"));
          bu locator calisti

        */
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

    }
}
