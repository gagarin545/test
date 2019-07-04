import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

class OnInvisible {
    public String OnClick(String str, WebDriver driver) throws InterruptedException {
        String script = "var element = arguments[0]; element.style.display='block';";
        WebElement element = driver.findElement(new By.ByCssSelector( str));
        ((JavascriptExecutor)driver).executeScript(script, element);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
        TimeUnit.SECONDS.sleep(config.INTERVAL);
        return driver.getPageSource();
    }
}
