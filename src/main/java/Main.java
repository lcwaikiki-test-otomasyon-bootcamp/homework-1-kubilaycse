import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        String testLink = "https://www.lcwaikiki.com/tr-TR/TR";
        String getMailError = testSignup(testLink);
        System.out.println(getMailError);
    }

    public static String testSignup(String link) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(link); // used for getting link

        // Click login button
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement element1 = driver.findElement(By.cssSelector("a.header-dropdown-toggle"));
        element1.click();

        // Click sign up button
        WebElement element2 = driver.findElement(By.cssSelector("a.login-form__link"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        element2.click();


        WebElement element3 = driver.findElement(By.id("RegisterFormView_RegisterEmail"));
        element3.sendKeys("kubilay");
        element3.sendKeys(Keys.TAB);

        // Getting error comes from email
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebElement element4 = driver.findElement(By.id("RegisterFormView_RegisterEmail-error"));
        String mailError = element4.getText();

        // not related by the first homework, i just wanted to try
        List<WebElement> elementList = driver.findElements(By.className("input-checkbox"));
        for (WebElement elem : elementList) {
            if(elem.getText().equals("SMS")){
                elem.click();
                break;
            }
        }


        return mailError;
    }





}


