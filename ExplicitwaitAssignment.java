package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitwaitAssignment {

	public static void main(String[] args)  {
		WebDriver driver = new ChromeDriver();
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        
       driver.findElement(By.xpath("//input[@value='user']")).click();
       w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();
       WebElement Staticdropdown= driver.findElement(By.xpath("//select[@class='form-control']"));
       Select dropdown= new Select(Staticdropdown);
       dropdown.selectByIndex(2);
       driver.findElement(By.cssSelector("input[id*='terms']")).click();      
       w.until(ExpectedConditions.elementToBeClickable(By.id("signInBtn"))).click();  
       w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
       List <WebElement> product = driver.findElements(By.cssSelector(".card-footer .btn-info"));
       for(int i=0;i<product.size();i++)
       {
    	   product.get(i).click();
    		   
    		   
    	   }
       driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
       }
     
     
	
}


