package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsAssign {
	static int count=0,number=0;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Welcome\\eclipse-workspace\\SeleniumPractice\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement txtSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		txtSearch.sendKeys("indium");
		WebElement btnSearch = driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]"));
		btnSearch.click();
		List<WebElement> elements = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
		for (WebElement webElement : elements) {
			String text = webElement.getText();
			if(text.contains("Indium")) {
				count=count+1;
			}else {
				number = number+1;
			}
			}
		System.out.println("Count:"+count);
		System.out.println("Number:"+number);
			}
}
