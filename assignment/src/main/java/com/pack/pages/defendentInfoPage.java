package com.pack.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.base.Extend;
import com.pack.base.TestBaseSetup;

public class defendentInfoPage {

	private WebDriver driver;

	public defendentInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getdefendentInfoPageTitle() throws IOException {
		try {
		String pageTitle = driver.getTitle();
		Extend.info("Get PageTitle Success ");
		System.out.println("pageTitle"+pageTitle);
		return pageTitle;
		
	} catch (Exception e) {
		Extend.error("Get PageTitle Failed ");
		Extend.takeScreenshot("Assertion Failed in getdefendentInfoPageTitle: " + e, TestBaseSetup.errorPath());
		return "";
	}
	}

	public boolean verifydefendentInfoPageTitle() throws IOException {
		try {
			String expectedTitle = "ANDREW TORO v. Atwood Distributing, L.P.";
		
			if (getdefendentInfoPageTitle().contains(expectedTitle)) {
				Extend.info("Expected PageTitle matched with Actual PageTitle : True ");
				return true;
			} else {
				Extend.takeScreenshot("Assertion Failed: ", TestBaseSetup.errorPath());
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in verifydefendentInfoPageTitle: " + e, TestBaseSetup.errorPath());
			return false;
		}

	}

	public boolean getAndVerifyPlaintiffName() throws IOException {
		try {	String plaintiffname = driver.findElement(By.xpath("(//div[@class='plaintiff_content']//li)[1]")).getText();
	
			if (plaintiffname.contains("ANDREW TORO")) {
				Extend.info("Expected plaintiffname matched with Actual plaintiffname : True ");
				return true;
			}

			else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in getAndVerifyPlaintiffName: " + e, TestBaseSetup.errorPath());
			
			return false;
		}
	}

	public boolean getAndVerifyPlaintifffilingdate() throws IOException {
		try {String filingdate = driver.findElement(By.xpath("(//div[@class='plaintiff_content']//li)[2]")).getText();
		
			if (filingdate.contains("January 31, 2023")) {
				Extend.info("Expected filingdate matched with Actual filingdate : True ");
				
				return true;
			} else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in getAndVerifyPlaintifffilingdate: " + e, TestBaseSetup.errorPath());
			
			return false;
		}
	}

	public boolean getAndVerifyPlaintiffstateoffiling() throws IOException {
		try {	String stateoffiling = driver.findElement(By.xpath("(//div[@class='plaintiff_content']//li)[3]")).getText();
		
			if (stateoffiling.contains("New York")) {
				Extend.info("Expected stateoffiling matched with Actual stateoffiling : True ");
				return true;
			} else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in getAndVerifyPlaintiffstateoffiling: " + e, TestBaseSetup.errorPath());
			
			return false;
		}
	}

	public boolean getAndVerifyDefendentName() throws IOException {
		try {
			String defendentname = driver.findElement(By.xpath("(//div[@class='defendant_content']//li)[1]")).getText();
		
			if (defendentname.contains("Atwood Distributing, L.P.")) {
				Extend.info("Expected defendentname matched with Actual defendentname : True ");
				return true;
			} else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in getAndVerifyDefendentName: " + e, TestBaseSetup.errorPath());
			return false;
		}
	}

	public boolean getAndVerifyDefendentWebsite() throws IOException {
		try {
			String defendentWebsite = driver.findElement(By.xpath("(//div[@class='defendant_content']//li)[2]")).getText();
		
			if (defendentWebsite.contains("www.atwoods.com")) {
				Extend.info("Expected defendentWebsite matched with Actual defendentWebsite : True ");
				return true;
			} else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in getAndVerifyDefendentWebsite: " + e, TestBaseSetup.errorPath());
			return false;
		}
	}

	public boolean getAndVerifyDefendentIndustry() throws IOException {
		try {String defendentIndustry = driver.findElement(By.xpath("(//div[@class='defendant_content']//li)[3]")).getText();
		
			if (defendentIndustry.contains("Consumer Discretionary")) {
				Extend.info("Expected defendentIndustry matched with Actual defendentIndustry : True ");
				return true;
			} else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in getAndVerifyDefendentIndustry: " + e, TestBaseSetup.errorPath());
			return false;
		}

	}

	public boolean getAndVerifyDefendentSummary() throws IOException {
		String defendentSummary = driver.findElement(By.xpath("(//div[@class='defendant_content']//li)[4]")).getText();
		try {
			if (defendentSummary.contains(
					"Atwoods Ranch & Home is a home store serving you with 72 stores in Oklahoma, Arkansas, Missouri, Texas, & Kansas.")) {
				Extend.info("Expected defendentSummary matched with Actual defendentSummary : True ");
				return true;
			} else {
				System.out.println("Element not found");
				Extend.error("Match Failed : False ");
				return false;
			}
		} catch (Exception e) {
			Extend.error("Match Failed : False ");
			Extend.takeScreenshot("Assertion Failed in : getAndVerifyDefendentSummary " + e, TestBaseSetup.errorPath());
			return false;
		}
	}
}
