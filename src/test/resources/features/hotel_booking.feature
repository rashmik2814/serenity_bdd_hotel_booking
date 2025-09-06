Feature: Hotel Booking

  Scenario: Verify login functionality
    Given the user is on the login page
    When the user logs in with username "rashmikhedkar" and password "Rashmi@123"
    Then the user should be logged in successfully
    Then the user should click on logout button and verify the logout message

  Scenario: Verify hotel search functionality
    Given the user is on the login page
    When the user logs in with username "rashmikhedkar" and password "Rashmi@123"
    And the user searches for a hotel with:
      | location      | Sydney         |
      | hotelName     | Hotel Sunshine |
      | roomType      | Deluxe         |
      | numberOfRooms | 1 - One        |
      | checkInDate   | 06/12/2024     |
      | checkOutDate  | 11/12/2024     |
      | adults        | 1 - One        |
      | children      | 1 - One        |
    Then the hotel search results should display "Hotel Sunshineee"

  Scenario: Verify hotel booking functionality
    Given the user is on the login page
    When the user logs in with username "rashmikhedkar" and password "Rashmi@123"
    And the user searches for a hotel with:
      | location        | Sydney         |
      | hotelName       | Hotel Sunshine |
      | roomType        | Deluxe         |
      | numberOfRooms   | 1 - One        |
      | checkInDate     | 06/12/2024     |
      | checkOutDate    | 11/12/2024     |
      | adults          | 1 - One        |
      | children        | 1 - One        |
    And the user selects the first hotel
    And the user books the hotel with:
      | firstName        | Ram               |
      | lastName         | Shankar           |
      | billingAddress   | Sydney            |
      | creditCardNumber | 1234567890123456  |
      | creditCardType   | VISA              |
      | expiryMonth      | May               |
      | expiryYear       | 2030              |
      | cvv              | 23                |
    Then the booking should be successful