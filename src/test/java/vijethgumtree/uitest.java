package vijethgumtree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class uitest {

	@Test
	void uivalidate() throws InterruptedException{
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			String chromeDriverPath = prop.getProperty("chromedriver");
			String searchString = prop.getProperty("searchstring");
			String searchRegion = prop.getProperty("searchregion");

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.gumtree.com.au/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//wait = new WebDriverWait(driver, 10000);
			driver.findElement(By.id("search-query")).sendKeys(searchString);
			driver.findElement(By.id("search-area")).sendKeys(searchRegion);



			driver.findElement(By.id("categoryId-wrp")).click();

			WebElement category =  driver.findElement(By.xpath("//div[@id='categoryId-wrpwrapper']//li//div[@id='categoryId-wrp-option-20045']"));
			hoverAndClick(driver,category);


			driver.findElement(By.id("srch-radius-wrp")).click();

			WebElement radius =  driver.findElement(By.xpath("//div[@id='srch-radius-wrpwrapper']//li//div[@id='srch-radius-wrp-option-20']"));
			hoverAndClick(driver,radius);



			driver.findElement(By.className("header__search-button")).click();


			/*JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//Thread.sleep(3000);
			js.executeScript("window.scrollBy(100,1800)");
*/
			Thread.sleep(3000);
			List<WebElement> searchResult = driver.findElements(By.xpath("//section[@class='search-results-page__user-ad-collection']//div[@class='user-ad-collection-new-design']//div[@class='user-ad-collection-new-design__wrapper--row']//a"));
			Random rand = new Random();
			int randomElement = rand.nextInt(searchResult.size()-1);
			WebElement randomSelect = searchResult.get(randomElement);
			hoverAndClick(driver,randomSelect);

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(3000);
			String breadCrumbsAdId = driver.findElement(By.xpath("//div[@id='breadcrumbs__desktop-sentinel']//span[@class='breadcrumbs__summary']")).getText();

			if (breadCrumbsAdId.split(" ")[2].isBlank()) {
				System.out.println("Breadcrumbs not present");
			} else {
				if (isNumeric(breadCrumbsAdId.split(" ")[2]))
				{
					System.out.println("Breadcrumbs AD ID present and is a Numeric Value");
				}
			}

			/***********************************************************************************/

			List<WebElement> similarAds = driver.findElements(By.xpath("//div[contains(text(), 'Similar Ads')]/..//div[@class='panel-body vip-similar-ads__slider-container']//ul[@class='slider__item-wrapper']//li"));
			if (similarAds.size()> 0 )
			{
				System.out.println("Similar Ads present");
			}
			else {
				System.out.println("Similar Ads not present");
			}
			driver.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Long d = Long.parseLong(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private static void hoverAndClick(WebDriver driver, WebElement WebElement) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(WebElement);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		action.click().build().perform();

	}

		
	}
	


