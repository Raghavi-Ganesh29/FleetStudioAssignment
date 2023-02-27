package com.pack.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.base.Extend;
import com.pack.base.TestBaseSetup;


public class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public defendentInfoPage clickAccept() throws IOException {
		try {
				WebElement accept=driver.findElement(By.xpath("//a[normalize-space(text())='Accept']"));
				if(accept.isDisplayed()) {
					accept.click();
					Extend.info("accept is clicked successfully");
					return new defendentInfoPage(driver);
				}
				else { 
					System.out.println("Element not found");
					Extend.takeScreenshot("Unable to click accept: " , TestBaseSetup.errorPath());
				
				}
		}
			catch(Exception e) {
				Extend.takeScreenshot("Click Failed in clickPlaintiffName: " + e, TestBaseSetup.errorPath());
			}
		return new defendentInfoPage(driver);
		}
	
	public void scrollToView() throws IOException {
		try {
			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(By.xpath("//a[normalize-space(text())='ANDREW TORO v. Atwood Distributing, L.P.']"));
				js.executeScript("arguments[0].scrollIntoView(true)", element);
				Extend.info("Scroll to Element : ANDREW TORO v. Atwood Distributing, L.P.");
			
		} catch (Exception e) {
			Extend.error(e.getMessage(), TestBaseSetup.errorPath());
		}
	}
	 
	
	public defendentInfoPage clickPlaintiffName() throws IOException {

		WebElement plaintiff=driver.findElement(By.xpath("//a[normalize-space(text())='ANDREW TORO v. Atwood Distributing, L.P.']"));
		if(plaintiff.isDisplayed()) {
			plaintiff.click();
			Extend.info("plaintiff is clicked successfully");		
		}
		else { 
			Extend.error("plaintiff is click failed");
			System.out.println("Element not found");
			Extend.takeScreenshot("Unable to click: " , TestBaseSetup.errorPath());
		
		}
		return new defendentInfoPage(driver);

}
	

	public String getPageTitle(){
		String title = driver.getTitle();
		//System.out.println("title"+title);
		return title;
	}
	
	public Boolean verifyBasePageTitle() throws IOException {
		try {
		String expectedPageTitle="Digital Accessibility Lawsuits";
		if(getPageTitle().contains(expectedPageTitle)) {
			Extend.info("Digital Accessibility Lawsuits display : True ");
			//System.out.println("\"Assertion using locator : True \"");
			return true;
		}
		else
		{
			Extend.error("Assertion using locator : False ");
			return false;
			
			}
		}
		catch(Exception e) {
			Extend.error("verification failed");
			Extend.takeScreenshot("Assertion Failed: " + e, TestBaseSetup.errorPath());
			return false;
		}
		 
	}
	
	public Boolean verifyRecentLawsuits() throws IOException{
		try {
		Boolean recentlawsuitsassert=driver.findElement(By.xpath("//h2[text()='Recent Lawsuits']")).isDisplayed();
		Extend.info("Recent Lawsuits display : True ");
		return recentlawsuitsassert;
		}
		catch(Exception e) {
			Extend.error("verifyRecentLawsuits failed");
			Extend.takeScreenshot("Assertion Failed: " + e, TestBaseSetup.errorPath());
			return false;
		}
	}
	
	
	
}