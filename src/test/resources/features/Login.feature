Feature: Amazon Login Functionality

  Scenario: Login with valid credentials
    Given User navigate to login page
    When User enters valid email address "chougulesantosh95@gmail.com" into email field
    And click on continue button
    And User enters valid password "San*416526#" into password field
    And click on sign in button
    Then User should get successfully logged in

  Scenario: Login with Invalid email address
    Given User navigate to login page
    When User enters Invalid email address "chougulesantosh951213@gmail.com" into email field
    And click on continue button
    Then User should get warning message about credentials mismatch

  Scenario: Login with valid email address with Invalid Password
    Given User navigate to login page
    When User enters valid email address "chougulesantosh95@gmail.com" into email field
    And click on continue button
    And User enters Invalid password "San*416526123#" into password field
    And click on sign in button
    Then User should get warning message about password mismatch

  Scenario: Login without providing any credentails
    Given User navigate to login page
    When User dont enter email address into email field
    And click on continue button
    Then User should get warning message about credentials
