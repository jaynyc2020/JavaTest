Feature: Wikipedia Languages # Often this is connected to an epic that you write#
	
	# each scenario will connect to a user story#
	
	
	Scenario: Logging In 
		Given The Guest is on the login page
		When The Guest types username
		When The Guest types password
		When The Guest clicks employee radio button 
		When The Guest clicks log in button
		When The Guest types amount
		When The Guest types status
		When The Guest types note
		When The Guest clicks create reimburstment button
		Then The Guest should be on employee page
	
		Scenario: Logging In Manager
		Given The Guest is on the login page1
		When The Guest types username1
		When The Guest types password1
		When The Guest clicks manager radio button1
		When The Guest clicks log in button1
		When The Guest clicks approve button1
		When The Guest clicks ok button1
		Then The Guest should be on manager page1
	 

		
	