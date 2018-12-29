package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindowHandels;

public class CommonWindowControl implements IWindowHandels {

	WebDriver driver;

	public CommonWindowControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {
		driver.switchTo().window(windowhandle);

	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		String childwindow = driver.getWindowHandles().toArray()[childWindowIndex].toString();

		driver.switchTo().window(childwindow);
	}

	@Override
	public String getWindowHandle() throws Exception {

		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {

		return driver.getWindowHandles();
	}

}
