package day02_Calisma;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Tekrar_LoginTest {
    /*
    1. Bir class oluşturun: LoginTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. http://a.testaddressbook.com adresine gidiniz.
    b. Sign in butonuna basin
    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    i. Username : testtechproed@gmail.com
    ii. Password : Test1234!
    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    3. Sayfada kac tane link oldugunu bulun.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //b. Sign in butonuna basin

        WebElement signInButonu= driver.findElement(By.id("sign-in"));
        signInButonu.click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..

        WebElement emailTextbox= driver.findElement(By.name("session[email]"));
        WebElement passwordTextBox= driver.findElement(By.id("session_password"));
        WebElement sigInButton=driver.findElement(By.name("commit"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!

        emailTextbox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        sigInButton.click();

        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify)

        WebElement actualKullaniciAdiElementi= driver.findElement(By.className("navbar-text"));
      //  System.out.println(actualKullaniciAdiElementi.getText());

        String expectedUserId="testtechproed@gmail.com";


        if (expectedUserId.equals(actualKullaniciAdiElementi.getText())){
            System.out.println(" PASSED");
        }else{
            System.out.println("FAILED");
        }

        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        WebElement addresses=driver.findElement(By.linkText("Addresses"));
        WebElement signOut=driver.findElement(By.linkText("Sign out"));

        if (addresses.isDisplayed()){
            System.out.println("Adres goruntuleme PASSED");
        }else System.out.println("Adres goruntuleme FAILED");

        if (signOut.isDisplayed()){
            System.out.println("sifre goruntuleme PASSED");
        }else System.out.println("sire goruntuleme FAILED");

        // 3. Sayfada kac tane link oldugunu bulun.

        List<WebElement> linkListesi=driver.findElements(By.tagName("a"));
       // System.out.println("Link sayisi : "+linkListesi.size());
        System.out.println(linkListesi.stream().count());// lambda cozumu

        linkListesi.stream().forEach(t-> System.out.println(t.getText()));

        //driver.close();
    }



}
