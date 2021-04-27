Feature: Adding eGift card to the basket
  As a: customer
  I want: to add eGift card to the basket
  So that: I can find required eGift card in the basket

  Scenario Outline: Adding eGift card to the basket
    Given Customer is on Home page
    When Customer chooses '<Gift Cards>'
    Then Customer chooses '<eGift>'
    And Customer fills in the form
    And eGift card is added to the cart
    And eGift card should be present in the cart

  Scenario Outline: Unhappy path of adding eGift card to the basket
    Given Customer is on Home page
    When Customer chooses '<Gift Cards>'
    Then Customer chooses '<eGift>'
    And Customer fills in the form using the wrong email
    And eGift card is added to the cart
    And error message is shown

