package SeleniumGridTest.SeleniumGridTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class GridTest {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException {
		if (browser.equalsIgnoreCase("chrome")) {
			String Node = "http://51.132.239.199:4444/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.LINUX);

			// Chrome option
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);

			driver = new RemoteWebDriver(new URL(Node), cap);
		} else if (browser.equalsIgnoreCase("firefox")) {
			String Node = "http://51.132.239.199:4444/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.LINUX);

			// Chrome option

			FirefoxOptions options = new FirefoxOptions();
			options.merge(cap);

			driver = new RemoteWebDriver(new URL(Node), cap);

		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() throws InterruptedException {
		System.out.println("Opening a url");
		Thread.sleep(5000);
		driver.navigate().to("https://www.google.com");
		Thread.sleep(5000);
	}

	@AfterTest
	public void closeBrowser() {
		// driver.quit();
	}

}
