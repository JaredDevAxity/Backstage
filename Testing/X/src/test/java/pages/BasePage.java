package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions actions;

	static {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); //Windows
		//System.setProperty("webdriver.chrome.driver", "/usr/src/app/chromedriver-docker"); //Docker
		ChromeOptions chromeOptions = new ChromeOptions();
		// open incognito browser
		chromeOptions.addArguments("--incognito");
		//chromeOptions.addArguments("--headless", "--disable-gpu", "--no-sandbox"); // Docker
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		chromeOptions.merge(cap);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);

	}

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	// Browser open
	public static void navigateTo(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}

	// Browser Close
	public static void closeBrowser() {
		driver.close();
	}

	// Explicit waiting in all the elements we occupy
	public static WebElement Find(String locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}

	// Click or elements
	public void clicElement(String locator) {
		Find(locator).click();
	}

	// Write text in fields
	public void write(String locator, String textToWrite) {
		Find(locator).clear();
		Find(locator).sendKeys(textToWrite);
	}

	// ComboBox selecting option by value
	public void SelectComboByValue(String locator, String valueToSelect) {
		Select combo = new Select(Find(locator));
		combo.selectByValue(valueToSelect);
	}

	//ComboBox selecting option by index (option position)
	public void SelectComboByIndex(String locator, int value) {
		Select combo = new Select(Find(locator));
		combo.selectByIndex(value);
	}

	// ComboBox selecting option by text (option text)
	public void SelectComboByText(String locator, String value) {
		Select combo = new Select(Find(locator));
		combo.selectByVisibleText(value);
	}

	// Move the mouse over an element
	public void hoverOverElement(String locator) {
		actions.moveToElement(Find(locator));

	}

	// Double click on element
	public void doubleClic(String locator) {
		actions.doubleClick(Find(locator));
	}

	// Right click on elements
	public void rigthClic(String locator) {
		actions.contextClick(Find(locator));
	}

	// Switch between one window and another
	public void switchToiFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}

	// Return to the main window
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	// Detect alert or pop up alert and reject it
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// Extract the text of an alert or pop up alert
	public void textAlert() {
		driver.switchTo().alert().getText();
	}

	// Extract the text of an element
	public String textFromElement(String locator) {
		return Find(locator).getText();

	}

	// Visible Element
	public boolean esVisible(String locator) {
		return Find(locator).isDisplayed();

	}

	// Press "Down" key
	public void downPress(String locator) {
		Find(locator).sendKeys(Keys.ARROW_DOWN);
	}

	// Press "Enter" key
	public void enterPress(String locator) {
		Find(locator).sendKeys(Keys.ENTER);
	}
}
