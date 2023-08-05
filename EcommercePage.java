package selenium;

import java.time.Duration;
import java.util.Arrays;

import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] itemsNeeded = { "Brocolli", "Beetroot", "Tomato", "Mushroom", "Musk Melon", "Walnuts" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		addedItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")))
				.sendKeys("rahulshettyacademy");

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoBtn"))).click();
		// driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".promoInfo"), "Code applied ..!Code applied ..!"));
    //    out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	}

	public static void addedItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;
		List<WebElement> Product = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < Product.size(); i++) {
			String[] name = Product.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName))

			{
				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}

		}
		System.out.println(driver.findElement(By.xpath("//div[@class='cart-info']  //table[1] //tr[1]")).getText());

	}
}
