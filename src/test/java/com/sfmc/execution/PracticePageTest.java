package com.sfmc.execution;

import org.testng.annotations.Test;

import com.sfmc.utility.AllWaits;

import Base.BaseDriver;
import pagescreen.Practicepage;

public class PracticePageTest  extends BaseDriver
{
	Practicepage ppobj;
	public PracticePageTest()
	{
		super();
		ppobj = new Practicepage();
		log.info("Browser Launched");
	}
	@Test(priority = 0)
	public void enterdata() throws InterruptedException
	{
		ppobj.Enterfirstname("Chandan");
		log.info("First name Entered");
		ppobj.Enterlastname("way2testing");
		log.info("Last name Entered");
		Thread.sleep(AllWaits.sleep);
	}
	
	@Test(priority = 1)
	public void clickbutton() throws InterruptedException
	{
		ppobj.clicksubmit();
		Thread.sleep(AllWaits.sleep);
		log.info("Submit button clicked");
	}
	
}
