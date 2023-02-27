package com.mavenproject.assignment.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.pages.BasePage;
import com.pack.pages.defendentInfoPage;


public class defendentInfoPageTest extends TestBaseSetup{
	
	private WebDriver driver;
	private defendentInfoPage defendentInfoPage;
	private BasePage basePage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		TestBaseSetup.startTestCase();
		driver=getDriver();
	}
	
	@Test
	public void verifydefendentInfoPage() throws IOException {
		System.out.println("Plaintiff and Defendent Info page test");
		basePage = new BasePage(driver);
		System.out.println("entered basePage");
		AssertJUnit.assertTrue(basePage.verifyBasePageTitle());
		AssertJUnit.assertTrue(basePage.verifyRecentLawsuits());
		basePage.clickAccept();
		basePage.scrollToView();
		defendentInfoPage=basePage.clickPlaintiffName();
		AssertJUnit.assertTrue(defendentInfoPage.verifydefendentInfoPageTitle());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyPlaintiffName());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyPlaintifffilingdate());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyPlaintiffstateoffiling());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyDefendentName());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyDefendentWebsite());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyDefendentIndustry());
		AssertJUnit.assertTrue(defendentInfoPage.getAndVerifyDefendentSummary());
	}
	
	@AfterMethod
	public void TearDown() throws IOException {
		TestBaseSetup.endTestCase();
		
	}
	

}