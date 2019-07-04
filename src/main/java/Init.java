import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

class Init extends Metod{
    WebDriver driver;
    WebDriver exec() throws InterruptedException {
        int interval = 3;
        String url_name = "http://argusweb.ur.rt.ru:8080/argus";
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty("webdriver.gecko.driver", config.FIREFOX);
        driver =new FirefoxDriver();
        driver.get(url_name);
        Runid(driver,"login_form-username", config.LOGIN, config.INTERVAL_L);
        Runid(driver,"login_form-password", config.PASSWORD, config.INTERVAL_L);
        Runid(driver,"login_form-submit",null, config.INTERVAL_L);
        TimeUnit.SECONDS.sleep(interval);
        Runccs(driver,"li.ui-menu-parent:nth-child(2)", config.INTERVAL_L);
        out.println("Задачи");
        TimeUnit.SECONDS.sleep(interval);
        Runccs(driver,"li.ui-menu-parent:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)", config.INTERVAL_L);
        out.println("список задач");
        TimeUnit.SECONDS.sleep(interval);
        Runccs(driver,"#slcts-slct_acc-dsp_f_title > span:nth-child(1)", config.INTERVAL_L);
        out.println("участки");
        TimeUnit.SECONDS.sleep(interval);
        StoreInquiry.Start = true;
        return driver;
    }

}
