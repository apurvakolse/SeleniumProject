package com.calculator.testng.maven.calculator.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calculator
{
  WebDriver driver;
@BeforeTest
public void launchBrowser()
{ 
	
                //
	            System.setProperty("webdriver.chrome.driver","C:/Users/APURVA/workspace/calculator.tng/ChromeDriver/chromedriver.exe");
                driver = new ChromeDriver(); 
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
                driver.get("https://www.calculator.net/");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


}

@Test
public void multiplication()
{
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[1]")));
	actions.click();
	actions.sendKeys("423*525");
	actions.build().perform();
/*	
WebElement calculatorTextBox = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[1]"));
		calculatorTextBox.sendKeys("423*525");*/
		
		//Click on equals
		WebElement AnswerButton = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/div/div[5]/span[4]"));
		AnswerButton.click();
		
		//Get result from calculator
		WebElement calculatorResultMult = driver.findElement(By.id("sciOutPut"));
		String result = calculatorResultMult.getText();
		result = result.replaceAll("\\s", "");		
		Assert.assertEquals(result, "222075");
}

@Test
public void division()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[1]")));
	actions.click();
	actions.sendKeys("4000/200");
	actions.build().perform();
		
		//Click on equals
		WebElement AnswerButton = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/div/div[5]/span[4]"));
		AnswerButton.click();
		
		//Get result from calculator
		WebElement calculatorResultdiv = driver.findElement(By.id("sciOutPut"));
		String result = calculatorResultdiv.getText();
		result = result.replaceAll("\\s", "");		
		
		Assert.assertEquals(result, "20");
}

@Test
public void addition()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[1]")));
	actions.click();
	actions.sendKeys("(-234234)+345345");
	actions.build().perform();
		
		//Click on equals
		WebElement AnswerButton = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/div/div[5]/span[4]"));
		AnswerButton.click();
		
		//Get result from calculator
		WebElement calculatorResultAdd = driver.findElement(By.id("sciOutPut"));
		String result = calculatorResultAdd.getText();
		result = result.replaceAll("\\s", "");	
		
		Assert.assertEquals(result, "111111");
}

@Test
public void subtraction()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/div[1]")));
	actions.click();
	actions.sendKeys("234823-(-23094823)");
	actions.build().perform();
		
		//Click on equals
		WebElement AnswerButton = driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/div/div[5]/span[4]"));
		AnswerButton.click();
		
		//Get result from calculator
		WebElement calculatorResultSub = driver.findElement(By.id("sciOutPut"));
		String result = calculatorResultSub.getText();
		result = result.replaceAll("\\s", "");	
		
		Assert.assertEquals(result, "23329646");
}

@AfterTest
public void closeBrowser()
{
    driver.quit();
}

}