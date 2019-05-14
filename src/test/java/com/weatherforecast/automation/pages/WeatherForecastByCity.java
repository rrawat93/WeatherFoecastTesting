package com.weatherforecast.automation.pages;

import java.sql.Driver;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherForecastByCity {
	
	ResourceBundle element;
	WebDriver driver;
	
	public WeatherForecastByCity(WebDriver driver) 
	{
		this.driver = driver;
		element = ResourceBundle.getBundle("Elements");
	}
		
	public void enterCityName(String city)
	{		
		driver.findElement(By.id(element.getString("enter_city_name_id"))).clear();
		driver.findElement(By.id(element.getString("enter_city_name_id"))).sendKeys(city);
		driver.findElement(By.id(element.getString("enter_city_name_id"))).submit();
	}
	
	public void clickAfterCity()
	{
		driver.findElement(By.id(element.getString("enter_city_name_id") )).click();
	}
	
	public void validateFirstDay()
	{
		driver.findElement(By.xpath("//span[@data-test='day-1']"));
	}
}
