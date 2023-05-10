Feature: Book different types of trips
  Scenario: Book a one way trip

    Given User is on homepage
    And check if we are in the right url
    When User clicks on 'One Way' menu option
    And check that the 'Exact Dates' radiobutton is selected
    And user selects 'Milan' as the 'origin' city
    And user selects 'Paris' as the 'destination' city
    And user selects 'Economy' on 'Cabin Preference'
    And user selects '2' on 'Adult'
    And user sets the date to 'June' '11' on the "departure" date
    And user clicks Advanced Settings
    And user sets "Lufthansa" as the preferred airline
    And user clicks Submit button
    And we check if flights showed are from preferred airline
    Then user clicks on the flight
    And user chooses the "first" price option
    Then user fills first passenger data with name: "Xhesi" lastname: "Brahimi" email: "xhesi@gmail.com" phone: "086888888" gender:"female" date:"2" month: "Jan" year:"2001"
    And user closes the "first" form
    And user goes to the "2" passenger
    Then user fills first passenger data with name: "Doni" lastname: "doni" email: "" phone: "" gender:"male" date:"2" month: "Jan" year:"2001"
    And user closes the "second" form
    Then user clicks seat selection button
    And user selects "22A" seat as the main one
    Then user clicks the "card" radiobutton
    And user fills the card information with card number:"5555341244441115" cvv:"737" month:"03" year:"2030" name:"John Doe" country:"United States of America" billing adress:"NY" city:"NY" state:"Alabama" zip:"1001"
    And user fills cvv field with "7367"
    And user checks rules and conditions checkbox
    And user clicks confirm booking
    Then user checks the booking confirmation message
    Then user saves the booking number to console
    And check the names from the final table with the actual names


    Scenario: Book a two way trip
      Given User is on homepage
      And check if we are in the right url
      When User clicks on 'Round Trip' menu option
      And check that the 'Exact Dates' radiobutton is selected
      And user selects 'Mexico' as the 'origin' city
      And user selects 'Cancun' as the 'destination' city
      Then the selected route should be "Mexico" to "Cancun"
      And user selects 'Economy' on 'Cabin Preference'
      And user sets the date to 'June' '10' on the "departure" date
      And user sets the date to 'July' '16' on the "return" date
      And user selects '2' on 'Adult'
      And user selects '1' on 'Infant'
      And user clicks Submit button
      Then user clicks on the flight
      And user chooses the "first" price option
      And user clicks add car
      And user sets the date to 'June' '10' on the "carDeparture" date
      And user sets the date to 'July' '16' on the "carReturn" date
      And user clicks Submit button
      Then user clicks on Car Book Now
      Then user fills first passenger data with name: "Xhesi" lastname: "Brahimi" email: "xhesi@gmail.com" phone: "086888888" gender:"female" date:"2" month: "Jan" year:"2001"
      And user closes the "first" form
      And user goes to the "2" passenger
      Then user fills first passenger data with name: "Doni" lastname: "doni" email: "" phone: "" gender:"male" date:"2" month: "Jan" year:"2001"
      And user closes the "second" form
      And user goes to the "3" passenger
      Then user fills first passenger data with name: "Yes" lastname: "Tes" email: "" phone: "" gender:"male" date:"2" month: "Jan" year:"2023"
      Then user clicks seat selection button
      And user selects "22A" seat as the main one
      And user goes to the "2" flight
      And user selects "22A" seat as the main one
      And user saves selected seats
      Then user clicks the "card" radiobutton
      And user fills the card information with card number:"5555341244441115" cvv:"737" month:"03" year:"2030" name:"John Doe" country:"United States of America" billing adress:"NY" city:"NY" state:"Alabama" zip:"1001"
      And user fills cvv field with "737"
      And user checks rules and conditions checkbox
      And user clicks confirm booking
      Then user checks the booking confirmation message
      Then user saves the booking number to console
      And check the names from the final table with the actual names



  Scenario: Multileg, non stop flights under Advanced options
    Given User is on homepage
    And check if we are in the right url
    When User clicks on 'Multi Destinations' menu option
    And check that the 'Exact Dates' radiobutton is selected
    And user selects 'Mexico' as the 'firstDeparture' city
    And user selects 'Cancun' as the 'firstDestination' city
    And user adds a "2" flight
    And user selects 'Mexico' as the 'secondDeparture' city
    And user selects 'Cancun' as the 'secondDestination' city
    And user adds a "3" flight
    And user selects 'Mexico' as the 'thirdDeparture' city
    And user selects 'Cancun' as the 'thirdDestination' city








