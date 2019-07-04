import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ReadToday extends Metod{
    String exec(WebDriver driver, String str, String command) throws InterruptedException {
        Runccs(driver, "#slcts-slct_acc-dsp_f-role_select_label", config.INTERVAL_L);
        Runccs(driver, "#slcts-slct_acc-dsp_f-role_select_" + command, config.INTERVAL_L);
        TimeUnit.SECONDS.sleep(config.INTERVAL_L);
        OnInvisible onInvisible = new OnInvisible();
        return onInvisible.OnClick(str, driver);
    }
}
