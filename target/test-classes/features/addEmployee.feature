Feature:To add multiple employees in syntax HRMS database

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    And then user click on pim Option
    And user clicks on AddEmployee option


Scenario Outline: Adding multiple employees from cucumber feature file
  When user enter "<firstName>" , "<middleName>" and "<lastName>" and click on save btn then verify the employee is added
  Examples:
    |firstName|middleName|lastName|
    |romid1    |MS        |zarif   |
    |rokan1   |MS        |elisa   |
    |mama1    |tarindi   |jamu    |


  Scenario Outline: Adding multiple employees from cucumber using a different approach
    When user enter "<firstName>" , "<middleName>" and "<lastName>"
    And click on save btn
    Then employee is added with "<firstName>" , "<middleName>" and "<lastName>"
    Examples:
      |firstName|middleName|lastName|
      |romid1    |MS        |zarif   |
      |rokan1   |MS        |elisa   |
      |mama1    |tarindi   |jamu    |



  Scenario: Adding multiple employees using data table
    When user adds the information of different employees and save them
      | FirstName | MiddleName | LastName |
      | yigit     | han        | ergun    |
      | selda     | sel        | ince     | 
