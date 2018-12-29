package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshots;

public class CommonScreenShotControl implements IScreenshots {

	WebDriver driver;

	public CommonScreenShotControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public String captureAndSaveScreenshot(String fileName) throws Exception {

		// fileName is complete path and name of screen shot file
		fileName = fileName.trim();

		File imgFile, tempFile;

		imgFile = new File(fileName);

		if (imgFile.exists()) {
			throw new Exception("File Already Exists..");
		}

		TakesScreenshot camera;

		camera = (TakesScreenshot) driver;
		tempFile = camera.getScreenshotAs(OutputType.FILE);

		FileUtils.moveFile(tempFile, imgFile);

		return imgFile.getAbsolutePath();
	}

}
