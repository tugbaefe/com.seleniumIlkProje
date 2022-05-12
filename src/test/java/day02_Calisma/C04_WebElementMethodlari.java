package day02_Calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElementMethodlari {
    public static void main(String[] args) {
 /*
    1-amazon.com'a gidip arama kutusunu locate edin
    2-arama kutusunun tagName'nin input oldugunu test edin
    3-arama kutusunun name attribute'nun degerinin .... oldugunu test edin
     */
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-amazon.com'a gidip arama kutusunu locate edin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        // 2-arama kutusunun tagName'nin input oldugunu test edin
        String expectedTagname="input";
        String actualTagName= aramaKutusu.getTagName();

        if (expectedTagname.equals(actualTagName)){
            System.out.println("Tagname testi PASSED");
        }else System.out.println("Tagname testi FAILED");

        //3-arama kutusunun name attribute'nun degerinin .... oldugunu test edin

        String expectedNameDegeri="field-keywords";
        String actualNameDegeri=aramaKutusu.getAttribute("name");

        if (expectedNameDegeri.equals(actualNameDegeri)){
            System.out.println("Name attribute testi PASSED");
        }else {
            System.out.println("Name attribute testi FAILED");

        }

        System.out.println("konum : "+ aramaKutusu.getLocation());
        System.out.println("yuksekligi : " +aramaKutusu.getSize().height);

        driver.close();
    }
}
