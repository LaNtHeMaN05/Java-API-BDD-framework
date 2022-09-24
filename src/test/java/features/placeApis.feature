Feature: Validating Place APis
	@Addplace
  Scenario: Verify if Place is successfully added	using AddPlaceApi
    Given AddPlace Payload
    When User calls "AddPlaceAPi" with "Post" request
    Then The Api call is successful with status code 200
    And "status" in response is "OK"

