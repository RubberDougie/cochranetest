@test 
Feature: Testing of the Login page 

Scenario: Verification of the login to Expedia.com with valid credential 
	Given the user inputs valid username and password 
	When user clicks Submit button 
	Then the user is redirected to the flight page 
	
Scenario Outline:
Verification of login combinations for Expedia.com with valid credential 
	Given the user inputs valid "<username>" and "<password>" 
	When user clicks Submit button 
	Then the user is redirected to the flight page 
	
	
	Examples: 
		|username|password|
		|user| 123|
		|admin| syspass|
	
	@wip	
	Examples: 
		|username|password|
		|mike| pass12|
	
	Examples: 
		|username|password|
		|user3| 1234|
		|admin2| syspass2|

@test 		
Scenario:
Verification of flight listings for Expedia.com with valid departure AND arrival dates 
	Given the user inputs valid departure date departureDate and arrival date arrivalDate 
	When user clicks Submit button 
	Then the user is redirected to the flight page 

Scenario Outline:	
Verification of flight listings for Expedia.com with valid departure AND arrival dates 
	Given the user inputs valid departure date "<departureDate>" and arrival date "<arrivalDate>" 
	When user clicks Submit button 
	Then the user is redirected to the flight page 
		
	Examples: 
		|departureDate|arrivalDate|
		|user| 123|
		|admin| syspass|
	
	@wip	
	Examples: 
		|departureDate|arrivalDate|
		|mike| pass12|
	
	Examples: 
		|departureDate|arrivalDate|
		|user3| 1234|
		|admin2| syspass2|