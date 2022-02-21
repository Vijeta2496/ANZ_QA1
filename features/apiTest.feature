Feature:Test senario
  @APITEST1
  Scenario Outline: Senario one
    Given user prepares a post request <"BaseUrl">
    When user performs post request <"Endpoint">
    Then user validates the status code <StatusCode> and response

    Examples:
      | StatusCode | BaseUrl | Endpoint |
      |    401 |   http://api.openweathermap.org/data/3.0 |    /stations |

  @APITEST2
  Scenario Outline: Senario two
    Given user prepares a post request <"BaseUrl">
    When user performs post request <"Endpoint"> with appid <"appid">
    Then user validates the status code <StatusCode>

    Examples:
      | StatusCode | BaseUrl | Endpoint |appid|
      |    201 |   http://api.openweathermap.org/data/3.0 |    /stations |e82f71c3d6bdd80993102b7c67a58b66|
  @APITEST3
  Scenario Outline: Senario three
    Given user prepares a post request <"BaseUrl">
    When user performs get request <"Endpoint"> with appid <"appid">
    Then user validates the status code <StatusCode> and response given

    Examples:
      | StatusCode | BaseUrl | Endpoint |appid|
      |    201 |   http://api.openweathermap.org/data/3.0 |    /stations |e82f71c3d6bdd80993102b7c67a58b66|