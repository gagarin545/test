import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class Metod {
    void Runccs(WebDriver dr, final String str, long tm)  {
        try {
            WebElement element = dr.findElement(By.cssSelector(str));
            (new WebDriverWait(dr, tm, 500)).withMessage("Элемент не найден.")
                    .until(ExpectedConditions.visibilityOf(element));
            dr.findElement(By.cssSelector(str)).click();
        }catch ( ElementNotInteractableException el) {
            StoreInquiry.Start = false;
            System.out.println("Элемент не найден. Состояние start = " + StoreInquiry.Start );
        }
    }
    void Runid(WebDriver dr, final String str, String val, int tm) {
        WebElement element = dr.findElement(By.id(str));
        (new WebDriverWait(dr, tm)).withMessage("Элемент не найден.")
                .until(ExpectedConditions.visibilityOf(element));
        if( val == null)
            dr.findElement(By.id(str)).click();
        else
            dr.findElement(By.id(str)).sendKeys(val);
    }
}
