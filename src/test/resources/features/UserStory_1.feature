@US_1
Feature: I want employee information are stored in MySQL DB correctly in Employee table

  Background:
    Given Establish database connection

  Scenario: verify Employees has unique IDs
    When Execute query to get all IDs from Employees
    Then Verify all employees has unique ID.

  Scenario: verify Employee Table columns
    When execute query to get all columns
    Then verify the below columns are listed
      | id     |
      | Name   |
      | Salary |
      | Gender |
      | Title  |
      | DOB    |