package commonLibs.implementation;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;

public class CommonAlertControl implements IAlert {

	private WebDriver driver;

	CommonAlertControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void acceptAlert() throws Exception {

		driver.switchTo().alert().accept();
	}

	@Override
	public void rejectAlert() throws Exception {
		driver.switchTo().alert().dismiss();
	}

	@Override
	public String getMessageFromAlert() throws Exception {

		return driver.switchTo().alert().getText();
	}

}