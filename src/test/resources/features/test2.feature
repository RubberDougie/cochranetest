@test
Feature: Testing of search functionality

Scenario: user opens https://en.wikipedia.org/wiki/Main_Page and searches a term in the search box
	Given user inputs in the search box the search term "<searchTerm>"
	When user clicks the search button
	Then user is redirected to page matching "<searchTerm>"
	
Scenario Outline: user opens https://en.wikipedia.org/wiki/Main_Page and searches a term in the search box
	Given user inputs in the search box the search term "<searchTerm>"
	When user clicks the search button
	Then user is redirected to page matching "<searchTerm>"
	
	Examples: 
		|searchTerm|
		|Bangkok|
		|UNIX|
		|POSIX|