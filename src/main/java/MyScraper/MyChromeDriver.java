package MyScraper;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyChromeDriver {
	
	private static ChromeDriver chromeDriver;
	private static final int timeout = 10;
	
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
		chromeDriver = new ChromeDriver(chromeOptions);
	}
	
	public static ChromeDriver getDriver() {
		return chromeDriver;
	}
	
	public static void quit() {
		chromeDriver.quit();
	}
	
	public static void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(chromeDriver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	
}
