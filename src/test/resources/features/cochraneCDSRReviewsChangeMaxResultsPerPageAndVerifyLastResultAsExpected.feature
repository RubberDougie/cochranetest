@test2
Feature: Testing the Max Search Results drop down list as if it were functional (using clicks now) and checking actual vs expected last results on search pages

Scenario: user opens https://www.cochranelibrary.com/cdsr/reviews and clicks the Max Search Results drop down list and selects a different selection, waits for page to refresh, then checks to see if the last result on each page is expected by number. In practice, just the first and last page are checked
	Given the user opens the Cochrane CDSR Reviews page
	When the user clicks the max search results per page list and selects a different selection
	Then the user is shown the results corresponding to the selection of max search results per page