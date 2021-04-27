Feature:  hub form
  As a customer
  I want: to fill in the form
  So that: I can become an Amazon partner

  Scenario Outline: submitting an empty form
    Given Customer is on hub page
    When Customer submits a form
    Then Customer receives a list of error messages

  Scenario Outline: submitting a form
    Given Customer is on hub page
    When Customer completes the form
    Then Customer submits a form
     And Customer receives a Thank you message

