Feature: Booking

  Scenario Outline: Book a Flight row: "<row>"

    Given I load test data from "BookingFlight" "BookingSheet" "<row>"
    Given I navigate to Booking
    Then I navigate to flights page
    And I select flight class
    And I select number of adults
    And I add destination
    And I add departure date and return date
    Then I check direct flights only
    And I click search
    Then I choose stops and flight time
    Then I choose presentation
    Then I click to see flight
    Then I verify visibility of flights details
    Then I verify prices
    Then I select flight

    Then I choose type of tickets
    Then I verify final price
    Then I click next button

    Then I enter contact details
    Then I enter names of passengers and gender
    Then I click next

    Then I choose meal
    Then I click next page

    Then I select seats
    Then I click  last next button

    Then I verify flight destination

    Examples:
      | row |
      | 1   |
      | 2   |






