package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScript;

public class CommonJavaScriptControl implements IJavaScript {

	WebDriver driver;

	public JavascriptExecutor getJsEngine() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		return js;
	}

	public CommonJavaScriptControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {

		getJsEngine().executeScript(scriptToExecute);

	}

	@Override
	public void scrollDown(int x, int y) throws Exception {

		String jst = String.format("windows.scrollBy(%d,%d)", x, y);

		getJsEngine().executeScript(jst);
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {

		return getJsEngine().executeScript(scriptToExecute).toString();
	}

}
