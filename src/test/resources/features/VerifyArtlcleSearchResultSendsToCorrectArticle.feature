@test2
Feature: Testing that the right URL data for an articles is given in search results by comparing title strings

Scenario: user opens https://www.cochranelibrary.com/cdsr/reviews and clicks the title of the first article in the search results, making sure the names match both in the search screen and the article page
	Given the user opens the Cochrane CDSR Reviews page
	When the user clicks the first article title
	Then the user is shown an article page with the same article title as the clicked link