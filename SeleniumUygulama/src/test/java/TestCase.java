import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestCase {

    @Test
    public void doTestCase() {
        Locale.setDefault(new Locale("en", "EN"));
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\AAlsln\\Downloads\\geckodriver.exe");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.iett.istanbul/"); /*iett sayfası açılıyor*/

        WebElement searchBox = webDriver.findElement(By.id("select2-searchShortcutsLine-container"));
        searchBox.click(); /*durak arama inputu tıklanılıyor*/

        WebElement fillSearchBox = webDriver.findElement(By.className("select2-search__field"));
        fillSearchBox.sendKeys("522"); /*inputa 522 yazılır.*/

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 3); /*bekleme süresi*/
        webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("select2-results__option"),
                webDriver.findElement(By.className("select2-results__option")).getText()));

        List<WebElement> searchResults = webDriver.findElements(By.className("select2-results__option"));
        searchResults.get(0).click(); /*donen sonucların ilki seciliyor.*/

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button--success"))); /*acılan sayfadaki bu class ismindeki element gelene kadar bekle*/

        WebElement allinfos = webDriver.findElement(By.className("button--success"));
        allinfos.click();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement stations = webDriver.findElement(By.cssSelector("a[href*='#LineStation']"));
        stations.click();

        webDriver.quit();

    }
}
