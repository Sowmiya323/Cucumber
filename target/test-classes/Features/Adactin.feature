Feature: Verifying hotel booking

  Scenario: Verify adactin webpage with passenger details
    Given User is on adactin page
    When User enter username and password
      | userName | password |
      | MSowmiya | sowmiya  |
      | Priya    | priya123 |
      | Joshnika | joshni   |
    And User click the login button
    When User shuold enter all the details for search hotel
      | location  | hotels         | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Melbourne | Hotel Creek    | Deluxe       | 2 - Two   | 23/3/2020   | 25/3/2020    | 2 - Two       |
      | London    | Hotel Sunshine | Standard     | 3 - Three | 5/3/2020    | 7/3/2020     | 3 - Three     |
      | Newyork   | Hotal Hervey   | Double       | 4 - Four  | 10/3/2020   | 15/3/2020    | 1 - One       |
      | Paris     | Hotel Cornice  | Super Deluxe | 5 - Five  | 12/4/2020   | 15/4/2020    | 4 - Four      |
    And User should select any one of the available hotel
    When User should enter First name, Last name, Address and Payment details
      | creditCardType   |
      | American Express |
      | VISA             |
      | Master Card      |
    And User click Booknow button
    And User click My itinerary
    Then User select the order ID to Cancel and finally click Cancel Selected
