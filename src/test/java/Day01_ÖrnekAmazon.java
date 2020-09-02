import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_ÖrnekAmazon {
    // 1. amazon.com a gidecek
    // 2. arama kutusuna baby stroller yazacağız
    // 3. 2. sıradaki ürüne tıklayacağız
    // 4. ürün sayfasına gittikten sonra ürünün toplam fiyatını alacağız
    // 5. ürünün ortalama puanını alacağız


    @Test
    public void testAmazon(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement seachBox = driver.findElement(By.id("twotabsearchtextbox"));
        seachBox.sendKeys("baby stroller"+ Keys.ENTER);
        WebElement ikincisonuc = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikincisonuc.click();
        WebElement fiat = driver.findElement(By.xpath("//td[@class='a-span12']"));
        System.out.println("Ürün fiatı : "+ fiat.getText());
        WebElement yıldız = driver.findElement(By.xpath("//td[@class='a-size-base']"));
        System.out.println("Yıldız : "+yıldız.getText());



    }
    @Test
    public void test2(){
        // 1. google.com a geçiş yapalım navigate kullanalım
        // 2. kemal özden yazıp arma yapalım
        // 3. karşımıza çıkan sonuç sayısını ekrana yazdıralım
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("kemal özden",Keys.ENTER);
        WebElement sonuclar = driver.findElement(By.id("result-stats"));
        System.out.println(sonuclar.getText());


    }

}
