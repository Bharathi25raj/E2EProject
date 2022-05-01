Feature: Login to Application

Scenario Outline: Positive Test, Validating Login
Given Initialize the browser with chrome
And navigate to "https://qaclickacademy.com/" site
And Click on login home page to land on secure sign in page
When user enters <username> and <password> and logs in
Then verify that user is logged in successfully
And close the browser


Examples:
|username			|password
|test					|123445
|test1				|344657