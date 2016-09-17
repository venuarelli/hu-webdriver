package com.hu.webdriver.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MultiWindowHandle {
	
	@Test
	public void testMultiWindowHandle(){
		/*System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\binaries\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String mainWindow = driver.getWindowHandle();
		WebElement element = driver.findElement(By.xpath("(//a[@title = 'Facebook'])[1]"));
		element.click();
		Set<String> window  = driver.getWindowHandles();
		for( String s : window){
			driver.switchTo().window(s);
		}
		
		String title = driver.getTitle();
		System.out.println("TITLE is ==="+title);
		driver.close();
		driver.switchTo().defaultContent();
		String title1 = driver.getTitle();
		System.out.println("Main WINDOW TILTE ====="+title1);
		
		driver.close();
	}

	
}
