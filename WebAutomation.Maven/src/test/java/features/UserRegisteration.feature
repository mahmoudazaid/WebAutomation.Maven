Feature: User Registration

  I want to check that user can register in our e-commerce website


  Scenario: User Registration
    Given I am on home page
    When I click on register
    And I entered registration data
    Then The user has been registered successfully