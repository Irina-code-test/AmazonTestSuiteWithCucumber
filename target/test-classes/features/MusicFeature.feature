Feature: music search
  As a customer
  I want: to have music search
  So that: I can find a required item

  Scenario Outline: Album Search
    Given Customer is on music page
    When Customer performs search for needed album
    Then Customer sees a required album

  Scenario Outline: Wrong Album Search
    Given Customer is on music page
    When Customer performs wrong search for needed album
    Then Customer cannot see a required album


