@test
@test2
Feature: Testing of arrow button functionality

Scenario: user opens https://en.wikipedia.org/wiki/Portal:Biography 
	Given user opens the Biography portal
	When user clicks the "selected biographies" left arrow
	Then user is redirected to the left
	