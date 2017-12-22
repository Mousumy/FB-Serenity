Feature:	I need to check all Headers
			After logging in Profile Page 
      
Background: 
	Given User can log in to facebook using userid as "asmenterprise.llc@gmail.com" and password as "ctg310306"
	And User profile has been loaded successfully 

#@regression       
#Scenario: profilepage header verification
#	Then Verify this header "Photos" is present
#
#@regression
#Scenario: Timeline functionality verification
#	When Navigate to "Timeline"	
#	And Verify header "Life Event" is present
#	Then Verify "Work & Education" funtionality should work
#	
#@regression
#Scenario: More functionality verification
#	And Navigate to "more"
#	Then verify more functionality is working
#	
#@regression
#Scenario: Friends functionality verification
#	And Navigate to "Friends"
#	And User will search for "Sunil C Patel"
#	
#@quick
#Scenario: EditPost functionality verification
#	When User will randomly select post
#	Then "Hide From TimeLine" functionality should work
#	And "ChangeDate" functionality should work
#	And "Hide from timeline" functionality should work	
#	
#@regression
#Scenario:	MakePost functionality verification
#		When User will make new post
#		Then It wil be visible in timeline

@quick @profile	
Scenario: About Functionality verification
	When Navigate to "About"
	Then About tab has this feature option "Work and Education"
	

		




