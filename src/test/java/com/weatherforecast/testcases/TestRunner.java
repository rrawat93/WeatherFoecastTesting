package com.weatherforecast.testcases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)	
@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber-report.json"},

monochrome = true
)


//@Cucumber.Options(format = {"pretty","html:target/cucumber-htmlreport","json-pretty:target/cucumber-report.json"})

public class TestRunner {

}
