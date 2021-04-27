Feature: jobs search
  As a: customer
  I want: to have job search
  So that: I can find required job by title

  Scenario Outline: Position Search
    Given Customer is on jobs page
    When Customer performs search for needed title
    Then Customer chooses needed location
    And Customer can see required jobs

  Scenario Outline: Wrong Position Search
    Given Customer is on jobs page
    When Customer performs search for wrong title
    Then Customer chooses needed location
    And Customer cannot see required jobs


