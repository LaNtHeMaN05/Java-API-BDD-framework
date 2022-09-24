Feature: I want to test all ReqRes Apis
	@CreateUser
  Scenario: Create a new User
    Given CreateUser payload
    When User hits "CreateUser" with "Post" request
    Then Api is successful with status code "201"
    And "name" tag in response is "Lan"
	@UpdateUser
	Scenario: Update a existing user
		Given UpdateUser payload
		When User hits "UpdateUser" with "Put" request
		Then Api is successful with status code "200"
		And "name" tag in response is "Lan"