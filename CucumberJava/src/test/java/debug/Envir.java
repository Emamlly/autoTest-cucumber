package debug;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Envir {

	WebDriver driver ;
	WebDriverWait driverWait;

	public WebDriver setupDriver( String browserName) {

		if ("chrome".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		} else if ("firefox".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		} else if ("ie".equalsIgnoreCase(browserName)) {
			// 忽略掉保护模式
			// DesiredCapabilities-->赋予给浏览器一个额外的能力
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			// 忽略掉浏览器缩放
			desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", "./src/test/resources/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver(desiredCapabilities);
			return driver;
		} else {
			return driver;
		}

	}

	public void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

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

	public WebElement waitElementVisible(By locator) {
		driverWait = new WebDriverWait(driver, 5);
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public String getText(WebElement element) {
		String result=element.getText();
		return result;
	}
	
	
	public void sendValues(WebElement element, String key) {
		element.clear();
		element.sendKeys(key);
	}

	public void clickButton(WebElement element) {
		element.click();
	}

	public void closedriver() {
		driver.close();
	}

	public void quitdriver() {
		driver.quit();
	}
	
	
	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver" ,"./resource/geckodriver.exe");
//		FirefoxDriver driver=new FirefoxDriver();
		// 忽略掉保护模式
		// DesiredCapabilities-->赋予给浏览器一个额外的能力
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//				true);
//		// 忽略掉浏览器缩放
//		desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//		System.setProperty("webdriver.ie.driver", "./resource/IEDriverServer.exe");
//		InternetExplorerDriver driver = new InternetExplorerDriver(desiredCapabilities);

		driver.get(url);
		driver.manage().window().maximize();
		driver.findElementByCssSelector("#kw").sendKeys("selenium");
		driver.findElementByCssSelector("#su").click();
	}

}
