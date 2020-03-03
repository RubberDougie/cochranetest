@test2
Feature: Testing the More button that shows previously hidden selections due to insufficient window size, then navigates to one of them

Scenario: user opens https://www.cochranelibrary.com/cdsr/reviews and hits the More button to see previously invisible tabs and clicks on one
	Given the user opens the Cochrane CDSR Reviews page
	When the user clicks the More button then the Clnical Answers button
	Then the user is shown the Clinical Answers data
	