import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        //driverı kurmalıyız setup
        WebDriverManager.chromedriver().setup();
        //driver objemizi oluşturalım
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {

        // http://a.testaddressbook.com/ git

        driver.get("http://a.testaddressbook.com/");
        WebElement signin = driver.findElement(By.linkText("Sign in"));
        signin.click();

        // bu sayfadaki tümlinkleri alın

        Thread.sleep(2000);
        List<WebElement> linkler = driver.findElements(By.tagName("a"));

        // ekrana yazdırın
        //for loop ile
        for(int i=0; i< linkler.size();i++){
            System.out.println(linkler.get(i).getText());
        }
        // for each loop
        for(WebElement w: linkler){
           System.out.println(w.getText());
        }

        //sayfaya giriş yapalım
        WebElement email = driver.findElement(By.cssSelector(".form-control"));
        email.sendKeys("testtechproed@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#session_password"));
        password.sendKeys("Test1234!");
        WebElement signinButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signinButton.click();

        // bu sayfadaki tüm yazıları alalım
        // sayfada ki tüm webelement lerini bulmak için xpath ile //* yaparak aratılır.

        List<WebElement> elemanlar = driver.findElements(By.xpath("//*"));
        for(WebElement w: elemanlar){
            System.out.println(w.getText());
        }

        // eğer sadece textleri yazdıracaksak "body" tagını yazdırmalıyız

        WebElement textler = driver.findElement(By.tagName("body"));
        System.out.println("Tüm textler : "+textler.getText());
    }
    @AfterClass
    public static void tearDown(){

        driver.quit();
    }
}
