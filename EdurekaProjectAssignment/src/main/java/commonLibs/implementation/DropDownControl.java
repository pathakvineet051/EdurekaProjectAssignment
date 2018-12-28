package commonLibs.implementation;

import java.util.List;

import javax.crypto.SealedObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropdown;

public class DropDownControl implements IDropdown {

	private Select getDropDown(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	@Override
	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {

		getDropDown(element).selectByVisibleText(visibleText);

	}

	@Override
	public void selectViaValue(WebElement element, String value) throws Exception {

		getDropDown(element).selectByValue(value);
	}

	@Override
	public void selectViaIndex(WebElement element, int index) throws Exception {

		getDropDown(element).selectByIndex(index);

	}

	@Override
	public boolean isMultiple(WebElement element) throws Exception {

		return getDropDown(element).isMultiple();
	}

	@Override
	public List<WebElement> getAllOptions(WebElement element) throws Exception {

		return getDropDown(element).getOptions();
	}

	@Override
	public List<WebElement> getAllSelectedOptions(WebElement element) throws Exception {

		return getDropDown(element).getAllSelectedOptions();
	}

	@Override
	public WebElement getFirstSectedOption(WebElement element) throws Exception {

		return getDropDown(element).getFirstSelectedOption();
	}

}
