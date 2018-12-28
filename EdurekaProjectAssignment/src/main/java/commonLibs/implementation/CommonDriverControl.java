package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import commonLibs.contracts.Idriver;

public class CommonDriverControl implements Idriver {

	private WebDriver driver;
	private int pageloadTimeOut;
	private int elementDetectionTimeOut;

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageloadTimeOut(int pageloadTimeOut) {
		this.pageloadTimeOut = pageloadTimeOut;
	}

	public void setElementDetectionTimeOut(int elementDetectionTimeOut) {
		this.elementDetectionTimeOut = elementDetectionTimeOut;
	}

	CommonDriverControl(String browserType) throws Exception {

		pageloadTimeOut = 30;
		elementDetectionTimeOut = 10;
		browserType = browserType.trim(); // it will remove the white spaces from start and end if there is any

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vp192x\\workspace\\Jar Files\\libs\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\vp192x\\workspace\\Jar Files\\libs\\geckodriver.exe");

			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\vp192x\\workspace\\Jar Files\\libs\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		} else {
			throw new Exception("Invalid Browser Type : " + browserType);
		}

	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {

		url = url.trim();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(pageloadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeOut, TimeUnit.SECONDS);

		driver.get(url);

	}

	@Override
	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {

		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {

		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {

		url = url.trim();
		driver.navigate().to(url);

	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	@Override
	public void navigateBackward() throws Exception {

		driver.navigate().back();
	}

	@Override
	public void refresh() throws Exception {

		driver.navigate().refresh();
	}

	@Override
	public void closeBrowser() throws Exception {
		if (driver != null) {
			driver.close();
		}

	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}
