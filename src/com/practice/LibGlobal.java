package com.practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	WebDriver driver;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Welcome\\eclipse-workspace\\SeleniumPractice\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public void getUrl(String URL) {
		driver.get(URL);

	}

	public String getUrlTitle() {
		String title = driver.getTitle();
		return title;

	}

	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void insert(WebElement element, String input) {
		element.sendKeys(input);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public void mouseHover(Actions acc, WebElement element) {
		acc.moveToElement(element);
	}

	public void dragDrop(Actions acc, WebElement elementS, WebElement elementD) {
		acc.dragAndDrop(elementS, elementD);
	}

	public void mouseRightClick(Actions acc, WebElement element) {
		Actions rightClick = acc.contextClick(element);
		rightClick.perform();
	}

	public void doubleClick(Actions acc, WebElement element) {
		Actions doubleClick = acc.doubleClick(element);
		doubleClick.perform();
	}

	public String getTheText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getAttributeValue(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	public void keyCtrl_A(Robot r) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	public void key_Up(Robot r) {
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public void key_Down(Robot r) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public void keyAlt_Tab(Robot r) {
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public void keyCtrl_C(Robot r) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public void keyCtrl_V(Robot r) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public void shiftKeyDown(Actions acc, WebElement element, String input) {
		acc.keyDown(element, Keys.SHIFT).sendKeys(element, input).keyUp(element, Keys.SHIFT).perform();
	}

	public void switchToAlert() {
		driver.switchTo().alert();
	}

	public void okButton(Alert al) {
		switchToAlert();
		al.accept();
	}

	public void cancelButton(Alert al) {
		switchToAlert();
		al.dismiss();
	}

	public String alertGetText(Alert al) {
		switchToAlert();
		String text = al.getText();
		return text;
	}

	public void alertInput(Alert al, String Input) {
		switchToAlert();
		al.sendKeys(Input);
	}

	public File captureScreenShot(TakesScreenshot ts) {
		File temp = ts.getScreenshotAs(OutputType.FILE);
		return temp;
	}

	public void moveScreenShot(File temp, File dest) throws IOException {
		FileUtils.copyFile(temp, dest);
	}

	public void javaScriptInputValue(JavascriptExecutor js, WebElement element, String input, String value) {
		js.executeScript("arguments[0].setAttribute(value,input)", element);
	}

	public String javaScriptFetchValue(JavascriptExecutor js, WebElement element, String value) {
		String attribute = (String) js.executeScript("arguments[0].getAttribute(value)", element);
		return attribute;
	}

	public void javaScriptClick(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	public void javaScriptScrollUp(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public void javaScriptScrollDown(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToWindow(String urlOrTitleOrWindowsId) {
		driver.switchTo().window(urlOrTitleOrWindowsId);
	}

	public String getParentWindowID() {
		String pWindow = driver.getWindowHandle();
		return pWindow;
	}

	public Set<String> getAllWindowId() {
		Set<String> allWindowId = driver.getWindowHandles();
		return allWindowId;
	}

	public void ddnSelectUsingIndex(Select sel, int index) {
		sel.selectByIndex(index);
	}

	public void ddnSelectUsingValue(Select sel, String value) {
		sel.selectByValue(value);
	}

	public void ddnSelectUsingVisibleText(Select sel, String vText) {
		sel.selectByVisibleText(vText);
	}

	public List<WebElement> ddnGetOptions(Select sel) {
		List<WebElement> options = sel.getOptions();
		return options;
	}

	public List<WebElement> ddnGetSelectedOptions(Select sel) {
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement ddnGetFirstSelectedOptions(Select sel) {
		WebElement selectedOption = sel.getFirstSelectedOption();
		return selectedOption;
	}

	public boolean ddnMultipleSelection(Select sel) {
		boolean multipleOptions = sel.isMultiple();
		return multipleOptions;
	}

	public void ddnDeselectUsingIndex(Select sel, int index) {
		sel.deselectByIndex(index);
	}

	public void ddnDeselectUsingValue(Select sel, String value) {
		sel.deselectByValue(value);
	}

	public void ddnDeselectUsingVisibleText(Select sel, String vText) {
		sel.deselectByVisibleText(vText);

	}

	public void ddnDeselectAll(Select sel) {
		sel.deselectAll();

	}
}
