package testCommon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
	WebDriverWait driverWait;
	
	
	public By ElementWays(String type, String by) {
		if ("name".equalsIgnoreCase(type)) {
			return By.name(by);
		} else if ("id".equalsIgnoreCase(type)) {
			return By.id(by);
		} else if ("classname".equalsIgnoreCase(type)) {
			return By.className(by);
		} else if ("tagname".equalsIgnoreCase(type)) {
			return By.tagName(by);
		} else if ("linktext".equalsIgnoreCase(type)) {
			return By.linkText(by);
		} else if ("partialLinktext".equalsIgnoreCase(type)) {
			return By.partialLinkText(by);
		} else if ("css".equalsIgnoreCase(type)) {
			return By.cssSelector(by);
		} else if ("xpath".equalsIgnoreCase(type)) {
			return By.xpath(by);
		} else {
			return null;
		}

	}
//	显示等待元素可见
	public WebElement waitElementVisible(By locator) {
		driverWait = new WebDriverWait(baseCase.driver, 5);
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
//获取标签文本
	public String getText(WebElement element) {
		String result=element.getText();
		return result;
	}
	
//	向文本框输入内容
	public void sendValues(WebElement element, String key) {
		element.clear();
		element.sendKeys(key);
	}
//点击按钮
	public void clickButton(WebElement element) {
		element.click();
	}
}
