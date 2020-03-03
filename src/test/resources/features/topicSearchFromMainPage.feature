@test2
Feature: Testing of topic search navigation buttons from homepage

Scenario: user opens https://www.cochranelibrary.com/ and hits the search button for Gastro
	Given the user opens the Cochrane Library page
	When the user clicks the Gastroenterology & hepatology button
	Then the user is redirected to the Gastroenterology & hepatology search page
	