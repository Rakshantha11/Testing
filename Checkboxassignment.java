package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxassignment {
	public static void main(String [] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 //Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
		 driver.findElement(By.id("checkBoxOption1")).click();
		 Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		 Thread.sleep(2000);
		 driver.findElement(By.id("checkBoxOption1")).click();
		 System.out.println( driver.findElement(By.id("checkBoxOption1")).isSelected());
		 
		 
		 //the Count of number of check boxes present in the page
		 System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}
}
		