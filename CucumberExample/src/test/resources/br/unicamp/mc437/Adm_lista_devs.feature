# encoding: UTF-8
Feature: This is a sample feature 

  #  Scenario Tag ID is the test case id in TestRail,TestLink,ALM. multiple cases separated with blank space
  #  1. if the tag id is empty then it will create this scenario test case in your testRail,TestLink or ALM,
  #  2. but if you specified the scenario tag id as the test case id,then it will just update the existing test case .
  #  Scenario title is the Test Case name in TestRail,TestLink,ALM
  #  Step sentence is the 'cucumber' field value in TestRail,TestLink,ALM

  @caseid1 @caseid2
  Scenario: sample scenario title,you can put any title for it
     Given I open the url
     When I input my user name and password with "Alter" and "password"
     Then I should go to the home page