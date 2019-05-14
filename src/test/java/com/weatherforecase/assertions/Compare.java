package com.weatherforecase.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {

	public static boolean validatePageURL(WebDriver driver, String expectedURL)
	{
		boolean result = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expectedURL))
		{
			result = true;
		}
		return result;
	}
	
	public static boolean validateElementExist(WebDriver driver, String elemntlocator)
	{
		boolean result = false;
		try
		{

			driver.findElement(By.id(elemntlocator));
			result = true;
		}
		catch(Exception e)
		{}
		return result;
	}
}
