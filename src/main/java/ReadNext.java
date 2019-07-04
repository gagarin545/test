import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ReadNext extends Metod{
    ArrayList<String> str = new ArrayList<>();

    String stradd = "-status_value > div:nth-child(2) > span:nth-child(1)";


    String exec(WebDriver driver, String str, String command) throws InterruptedException {
        String s = "";
        if(driver.findElements(By.cssSelector(str + "status_value > div:nth-child(2) > span:nth-child(1)")).size() > 0) {
            Runccs(driver, str + "status_value > div:nth-child(2) > span:nth-child(1)", config.INTERVAL_L);
            TimeUnit.SECONDS.sleep(config.INTERVAL_L);
            OnInvisible onInvisible = new OnInvisible();
            s = onInvisible.OnClick(str, driver);
        }
        return s;
    }
}
