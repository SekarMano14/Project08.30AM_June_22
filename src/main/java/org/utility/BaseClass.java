package org.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static final String AUTOMATE_USERNAME = "manojkumar224";
	public static final String AUTOMATE_ACCESS_KEY = "pRTuFn1M8yEpYKqPM6sA";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	
//	public static void launchBrowserStackBrowser() throws MalformedURLException {
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("os_version", "11");
//		caps.setCapability("resolution", "1920x1080");
//		caps.setCapability("browser", "Chrome");
//		caps.setCapability("browser_version", "100");
//		caps.setCapability("os", "Windows");
//		caps.setCapability("name", "Project 08.30AM"); // test name
//		caps.setCapability("build", "First Build"); // CI/CD job or build name
//		 driver = new RemoteWebDriver(new URL(URL), caps);
//
//	}

	// public static WebDriver launchBrowser(String browsername) {
	// switch (browsername) {
	// case "Chrome":
	// WebDriverManager.chromedriver().setup();
	// driver = new ChromeDriver();
	// break;
	// case "Firefox":
	// WebDriverManager.firefoxdriver().setup();
	// driver = new FirefoxDriver();
	// break;
	// case "Edge":
	// WebDriverManager.edgedriver().setup();
	// driver = new EdgeDriver();
	// break;
	//
	// default:
	// System.err.println("Invalid BrowSer Name");
	// break;
	// }
	//
	// return driver;
	// }
	//
	public void launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.err.println("Invalid Browser name");
		}
	}
	
	

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void btnClick(WebElement e) {
		e.click();
	}

	public static void quit() {
		driver.quit();

	}

	public static String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	public static String getTitle() {
		return driver.getTitle();

	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");

	}

	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static WebElement findElement(String locatorName, String locValue) {
		WebElement e = null;
		if (locatorName.equals("id")) {
			e = driver.findElement(By.id(locValue));
		} else if (locatorName.equals("name")) {
			e = driver.findElement(By.name(locValue));
		} else if (locatorName.equals("xpath")) {
			e = driver.findElement(By.xpath(locValue));
		}
		return e;

	}

	public static void takeScreenShot(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShots\\" + imagename + ".png");
		FileUtils.copyFile(src, des);

	}

	public static void jsSendKeys(WebElement e, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", e);

	}
	
	public static boolean waitforUrl(String url) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		return w.until(ExpectedConditions.urlContains(url));

	}

	// public static String getExcelData(String file, String sheetname, int rowno,
	// int cellno) throws IOException {
	// File loc = new
	// File(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\"
	// + file + ".xlsx");
	// FileInputStream st = new FileInputStream(loc);
	// Workbook w = new XSSFWorkbook(st);
	// Sheet sheet = w.getSheet(sheetname);
	// Row row = sheet.getRow(rowno);
	// Cell cell = row.getCell(cellno);
	//
	// int type = cell.getCellType();
	// // type--0-->Date,number
	// // type--1--->String
	// String value = null;
	// if (type == 1) {
	// value = cell.getStringCellValue();
	// } else {
	// if (DateUtil.isCellDateFormatted(cell)) {
	// value = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
	// } else {
	// value = String.valueOf((long) cell.getNumericCellValue());
	// }
	// }
	// return value; }
}
