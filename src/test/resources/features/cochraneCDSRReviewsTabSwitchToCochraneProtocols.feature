@test2
Feature: Testing of switching to a visible search tab

Scenario: user opens https://www.cochranelibrary.com/cdsr/reviews and clicks a visible search tab
	Given the user opens the Cochrane CDSR Reviews page
	When the user clicks the Cochrane Protocols tab
	Then the user is shown the subset of reviews for that visible tab
	