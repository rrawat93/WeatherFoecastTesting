package com.weatherforecast.testControler;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.weatherforecase.assertions.Compare;
import com.weatherforecast.automation.pages.WeatherForecastByCity;
import com.weatherforecast.base.CreateDriverInstance;

import cucumber.api.java.en.*;
import junit.framework.Assert;


public class StepDefinitions {
	
	WebDriver driver;
	WeatherForecastByCity cityN; // made it as global since it will be used
	CreateDriverInstance driverInstance; // made it as global to be used in quitting application
	
	@Given("^I need to get the weather forecast for (\\d+) days$")
	public void i_need_to_get_the_weather_forecast_for_days(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driverInstance = new CreateDriverInstance();
		driver = driverInstance.generateDriverInstance();
	    
	}


	@SuppressWarnings("deprecation")
	@Then("^I get the information of weather forecast for (\\d+) days$")
	public void i_get_the_information_of_weather_forecast_for_days(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(Compare.validatePageURL(driver, "http://localhost:3000/"));
		

	}
	
	//Asserting the 5 available days for forecast
	@Then("^it shows weather for five days as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void and_it_shows_weather_for_five_days_as(String day1, String day2, String day3, String day4, String day5) throws Throwable {
		//Asserting the 5 available days for forecast
		cityN = new WeatherForecastByCity(driver);
		String text1= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]/span[1]/span[1]")).getText();
	    Assert.assertEquals(day1, text1);
	    String text2= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[2]/div[1]/span[1]/span[1]")).getText();
	    Assert.assertEquals(day2, text2);
	    
	    String text3= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[3]/div[1]/span[1]/span[1]")).getText();
		Assert.assertEquals(day3, text3);
		
		String text4= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[4]/div[1]/span[1]/span[1]")).getText();
		Assert.assertEquals(day4, text4);
		    
	    String text5= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[5]/div[1]/span[1]/span[1]")).getText();
	    Assert.assertEquals(day5, text5);
			    
	    
	}
	
	
	//Selecting a Day
	@When("^user select a day as \"([^\"]*)\"$")
	public void user_select_a_day_as(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]/span[1]/span[1]")).click();
	}

	//Assreting the 3 hourly forecast
	@Then("^user should get (\\d+) hourly forecast as for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_should_get_hourly_forecast_as_for(int arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	   String fhr= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[2]/div[1]/span[1]/span")).getText();
	   Assert.assertEquals(arg2,fhr);
	   String shr= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[2]/div[2]/span[1]/span")).getText();
	   Assert.assertEquals(arg3,shr);
	   String thr= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[2]/div[3]/span[1]/span")).getText();
	   Assert.assertEquals(arg4,thr);
	   String fohr= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[2]/div[4]/span[1]/span")).getText();
	   Assert.assertEquals(arg5,fohr);
	}
	
	@Then("^(\\d+)hourly forecast should be hide$")
	public void hourly_forecast_should_be_hide(int arg1) throws Throwable {
		boolean present= isPresent();
		Assert.assertEquals(false, present);
	}
	
	boolean isPresent() {
		Boolean pr= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[2]/div[1]/span[1]/span")).isDisplayed();
		
		return pr;
	}
	
	@Then("^\"([^\"]*)\" should be \"([^\"]*)\"$")
	public void should_be(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String arg=null;
	    if (arg1== "MaxTemp")
	    {
	    	arg= driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[1]/span[3]/span[1]")).getText();
	    	 Assert.assertEquals(arg2, arg);
	    }
	    
	    if (arg1== "MinTemp")
	    {
	    	arg= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]/span[3]/span[2]")).getText();
	    	 Assert.assertEquals(arg2, arg);
	    }
	    
	    if (arg1== "Wind")
	    {
	    	arg= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]/span[4]/span[1]")).getText();
	    	 Assert.assertEquals(arg2, arg);
	    }
	    
	    if (arg1== "Rain")
	    {
	    	arg= driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]/div[1]/span[5]/span[1]")).getText();
	    	 Assert.assertEquals(arg2, arg);
	    }
	    
	   
	    
	}
	
	
	@Then("^I validate the details for first day$")
	public void i_validate_the_details_for_first_day() throws Throwable {
		cityN = new WeatherForecastByCity(driver);
		String text1= driver.findElement(By.xpath("//*[@id=\'root\']/div/h1")).getText();
		String text2= driver.findElement(By.xpath("//*[@id=\'city\']")).getText();
		text1=text1+text2;
	Assert.assertEquals("Five Day Weather Forecast for Glasgow", text1);
		
	}
	


	@When("^I enter the city name as \"([^\"]*)\"$")
	public void i_enter_the_city_name_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
		cityN = new WeatherForecastByCity(driver);
		
		cityN.enterCityName(arg1);
		Thread.sleep(3000);
		cityN.clickAfterCity();
	}
	
	
	@Then("^I close the application$")
	public void i_close_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driverInstance = new CreateDriverInstance();
		driver = driverInstance.closeDriverInstance(driver);
		

	}

	
	
	
	
}
