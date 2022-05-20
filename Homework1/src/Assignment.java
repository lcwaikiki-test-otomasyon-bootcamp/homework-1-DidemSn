import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment
{
    public static void sleep(int saniye)
    {
        try {
            Thread.sleep(saniye*100);
        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
   public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications","--disable-blink-features=AutomationControlled");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        sleep(5);

        driver.findElement(By.className("header-dropdown-toggle")).click();
        sleep(5);

        driver.findElement(By.name("email")).sendKeys("asdfg@gmail.com");
        driver.findElement(By.name("password")).sendKeys("sanane");

        sleep(1);
        driver.findElement(By.className("login-form__button--bg-blue")).click();
        sleep(3);

        WebElement output = driver.findElement(By.className("login-form__header-errors--p"));
        if( output.getText().equals("Lütfen e-posta ya da şifrenizi kontrol ediniz.") )
        {
            System.out.println("Elde ettik hatayi !");
        }

    }
}
