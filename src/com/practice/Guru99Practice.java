package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru99Practice {
	public void login() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Welcome\\eclipse-workspace\\SeleniumPractice\\driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement txtUserName = driver.findElement(By.xpath("//input[@name='uid']"));
		txtUserName.sendKeys("mngr285254");
		WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
		txtPassword.sendKeys("qUpedUd");
		WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		btnLogin.click();

	}
 public static void main(String[] args) throws InterruptedException {
	Guru99Practice gP=new Guru99Practice();
	gP.login();
}
}
