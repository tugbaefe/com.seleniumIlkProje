package day02_Calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locator {
     /*
    Main method oluşturun ve aşağıdaki görevi tamamlayın.
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

         // a. http://a.testaddressbook.com adresine gidiniz.
     driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
         WebElement signLink= driver.findElement(By.linkText("Sign in"));
         signLink.click();

         //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
         WebElement emailTextBox= driver.findElement(By.id("session_email"));
         WebElement passwordTextBox= driver.findElement(By.name("session[password]"));
         WebElement signInButton= driver.findElement(By.name("commit"));

         // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
         //        i. Username : testtechproed@gmail.com
         //        ii. Password : Test1234!

         emailTextBox.sendKeys("testtechproed@gmail.com");
         passwordTextBox.sendKeys("Test1234!");
         signInButton.click();

         // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).

         WebElement actualKullaniciAdiElementi=driver.findElement(By.className("navbar-text"));
         System.out.println(actualKullaniciAdiElementi.getText());
         //webelementin uzerinde ne yazdigini gormek icin getText()kullandik

         String expectedUserId="testtechproed@gmail.com";
         if (expectedUserId.equals(actualKullaniciAdiElementi.getText())){
             System.out.println("Expected user ID PASSED");
         }else System.out.println("Expected user ID FAILED");

         //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
         WebElement addressesElementi=driver.findElement(By.linkText("Addresses"));
         WebElement signOutElementi=driver.findElement(By.linkText("Sign out"));
         if (addressesElementi.isDisplayed()){
             System.out.println("Adress testi PASSED");
         }else{
             System.out.println("Adress testi FAILED");
         }

         if (signOutElementi.isDisplayed()){
             System.out.println("Sign testi PASSED");
         }else{
             System.out.println("Sign testi FAILED");
         }

         // 3. Sayfada kac tane link oldugunu bulun.

         List<WebElement> linklerListesi=driver.findElements(By.tagName("a"));
         System.out.println("Sayfadaki link sayisi : " + linklerListesi.size());

         for (WebElement each:linklerListesi) {
             System.out.println(each.getText());

         }

       //  linklerListesi.stream().forEach(t-> System.out.println(t.getText()));
         // lambda ile cozumu

        //driver.close(); WARNING: Connection reset
         //java.net.SocketException: Connection reset hatasi aliyorum


     }
}
