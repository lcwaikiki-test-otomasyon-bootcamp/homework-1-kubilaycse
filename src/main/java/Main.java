import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.lcwaikiki.com/tr-TR/TR");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement element1 = driver.findElement(By.cssSelector("a.header-dropdown-toggle"));
        element1.click();
        WebElement element2 = driver.findElement(By.cssSelector("a.login-form__link"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        element2.click();


        WebElement element3 = driver.findElement(By.id("RegisterFormView_RegisterEmail"));
        element3.sendKeys("deemed");
        element3.sendKeys(Keys.TAB);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebElement element4 = driver.findElement(By.id("RegisterFormView_RegisterEmail-error"));
        String s = element4.getText();
        System.out.println(s);
    }


}


