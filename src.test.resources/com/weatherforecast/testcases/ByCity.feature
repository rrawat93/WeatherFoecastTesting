Feature: This feature file will test the weather forecast by city name for 5 days

 Scenario: 1.  Verify the weather forecast for 5 days for Glasgow
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Glasgow"
    Then it shows weather for five days as "Tue" "Wed" "Thu" "Fri" "Sat"
    And I close the application

    Scenario: 2. Verify the weather forecast for 5 days for Dundee
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Dundee"
    Then it shows weather for five days as "Tue" "Wed" "Thu" "Fri" "Sat"
    And I close the application
    
 Scenario: 3. Verify the weather forecast for 5 days for Edinburgh
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Edinburgh"
    Then it shows weather for five days as "Tue" "Wed" "Thu" "Fri" "Sat"
    And I close the application
    
 Scenario: 4. Verify the weather forecast for 5 days for Stirling
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Stirling"
    Then it shows weather for five days as "Tue" "Wed" "Thu" "Fri" "Sat"
    And I close the application
    
 Scenario: 5. Verify the weather forecast for 5 days for Aberdeen
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Aberdeen"
    Then it shows weather for five days as "Tue" "Wed" "Thu" "Fri" "Sat"
    And I close the application
    
 Scenario: 6. Verify the weather forecast for 5 days for Perth
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Perth"
    Then it shows weather for five days as "Tue" "Wed" "Thu" "Fri" "Sat"
    And I close the application
		
		
Scenario: 7. To verify that when user select any day from the list, user should get 3 hourly forecast
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Edinburgh"  
    And user select a day as "Tue"
    Then user should get 3 hourly forecast as for "1300" "1600" "1900" "2200"
    And I close the application



    
Scenario: 8. To verify that when user select any day 2 times from the list,then the 3 hourly forecast should be hide
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Edinburgh"  
    And user select a day as "Tue"
    And user select a day as "Tue"
    Then 3hourly forecast should be hide
    And I close the application	
 
    
    
 Scenario: 9. To verify that Daily forecast should summarize the 3 hour data
    Given I need to get the weather forecast for 5 days
    When I enter the city name as "Stirling"  
    And user select a day as "Tue"
    Then "MaxTemp" should be "12"
    And "MinTemp" should be "8"
    And "Wind" should be "1kph"
    And "Rain" should be "3mm"
    And I close the application