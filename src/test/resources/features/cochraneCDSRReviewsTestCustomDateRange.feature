@test2
Feature: Testing of custom date range search

Scenario: user opens https://www.cochranelibrary.com/cdsr/reviews and enters start date, end date, and then clciks the applyCustomRangeButton
	Given the user opens the Cochrane CDSR Reviews page
	When the user enters the start date, end date, then clicks the button
	Then the user is shown data appropriate to the date range
	