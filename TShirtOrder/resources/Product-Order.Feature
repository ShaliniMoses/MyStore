#Author: mastershalini.pandian@gmail.com
#Feature: Tshirt-Positive Scenario, Order Fail
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Online Product Order
  
  @Order-Tshirt
  Scenario Outline: Order Success
    Given I open the browser
    And  automation website exist 
    Then I click on signin button
    When I enter the username '<username>'
    And I enter the password '<password>'
    And Click on Login button
    Then I validate the logged in page
    Then I click T-Shirts
    Then I select T-Shirts properties '<size>','<color>'
    Then I Validate the order History
    Then I click on signout button
    Then I close the browser
    
    Examples: 
      | username                | password       | size | color|
      | someone@example.com     | Password123    | small|Orange|

 @UpdatePersonalInformation
  Scenario : Update Personal Information
    Given I open the browser
    And  automation website exist 
    Then I click on signin button
    When I enter the username
    And I enter the password
    And Click on Login button
    Then I validate the logged in page
    Then I click on Personal Information
    Then Update Personal Information
    Then Click save button
    Then I click on signout button
    Then I close the browser
      
