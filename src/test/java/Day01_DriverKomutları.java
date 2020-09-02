import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutları {
    @Test
    public void test1(){

        // önce bize driver lazım maven kütüphanemizde WebDriverManager var zaten. önce setup ile driverı kuralım

        WebDriverManager.chromedriver().setup();
        // driver objesi oluşturalım
        // eğer WebDriver driver = new WebDriver(); yazsaydım hata alırım çünkü WebDriver class değil
        WebDriver driver = new ChromeDriver();
        // tam ekran yapalım

        driver.manage().window().maximize();

        // bir implisitly wait yapalım 10 sn ye kadar
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://google.com");
        // navigate ileri geri yenileme ve yeni sayfaya atlama fonksiyonları yapılabilir
        // herhangi bir sayfaya girmek için navigate kullanılabilir.
        driver.navigate().to("http://amazon.com");
        driver.navigate().back();
        driver.navigate().forward();


        driver.navigate().back(); // bu şekilde geri yaparak bir önceki sayfaya gelir.

        //quit ile close un farkı close açık olan sekmeyi kapatır quit tamamını kapatır.
        driver.quit();
    }
}
